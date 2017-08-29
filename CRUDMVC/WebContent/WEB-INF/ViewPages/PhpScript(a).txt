<?php
$myConn = new myConnection();
$conn=$myConn->getMyConnection();
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT p.pn as PatientNumber,p.last as PatientLastName, p.first as PatientFirstName,i.iname as InsuranceName,i.from_date as InsuranceFromDate,i.to_date as InsuranceToDate FROM patient as p INNER JOIN insurance as i on p.patient_id=i.patient_id ORDER BY i.from_date ASC,p.last ASC";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo $row["PatientNumber"]. ", " . $row["PatientLastName"]. ", " . $row["PatientFirstName"].", " . $row["InsuranceName"].", " . $row["InsuranceFromDate"].", " . $row["InsuranceToDate"]. "<br>";
    }
} else {
    echo "No result found";
}
$conn->close();
?>