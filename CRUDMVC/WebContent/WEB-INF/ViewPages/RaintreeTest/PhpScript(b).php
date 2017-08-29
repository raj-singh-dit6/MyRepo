<?php
$myConn = new myConnection();
$conn=$myConn->getMyConnection();
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
$names="";
$sql = "SELECT first,last  FROM patient";
$result = $conn->query($sql);

if ($result->num_rows > 0) 
{
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $names .=$row["first"] . $row["last"];
    }
	
	$totalAlphabetCount=strlen($names);

	$namesAssocArr=count_chars($names,1); // Converts into an associative array : key-> Ascii value of alphabet and value-> count
	$namesSortedAssoArr=ksort($namesAssocArr,1) ; // Sorting by key for ASCII values 1= For Numeric
	$TempnamesSortedAssoArr=$namesSortedAssoArr; // Temp sorted key to check for same index.
	$namesCharAssArr=array();
	$namesSortedCharAssArr=array();
	foreach($namesSortedAssoArr as $x => $x_value) 
	{
		
		if(isset($TempnamesSortedAssoArr[$x+32]) && $TempnamesSortedAssoArr[$x+32]!=0 )
		{
			$namesCharAssArr[chr($x)]=($x_value + $TempnamesSortedAssoArr[$x+32]);
			$TempnamesSortedAssoArr[$x+32]=0;
		}else if(isset($TempnamesSortedAssoArr[$x]) && $TempnamesSortedAssoArr[$x]!=0)
		{
			$namesCharAssArr[chr($x)]=$x_value;
			$TempnamesSortedAssoArr[$x]=0;
		}	
	}

	$namesSortedCharAssArr=ksort($namesCharAssArr,2);// Sorting by key for character value 2= For String
	
	foreach($namesSortedCharAssArr as $x => $x_value)
	{
		$percentage=round((($x_value\$totalAlphabetCount)*100),2); // Percentage with two decimal precision.
		echo $x."\t".$x_value."\t".$percentage."%";	
	}
} else 
{
    echo "No result found";
}


$conn->close();
?>