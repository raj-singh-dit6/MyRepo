<?php
 
 interface PatientRecord
 {
	public function getRecordID();
	public function getPatientNumber();
 }
 
 class Patient implements  PatientRecord
 {
 
	 private $id;
	 private $patientNumber;
	 private $firstName;
	 private $lastName;
	 private $dob;
	 private $insurances=array();
	 
	 public function __constructor($pn,$first,$last,$db,$insu)
	 {	
		$this->$patientNumber=$pn;
		$this->$firstName=$first;
		$this->$lastName=$last;
		$this->$dob=$db;
		$this->$insurances=$insu;
	 }
	 
	 public function getPatientID()
	 {
		return $this->$id;
	 }
	 
	 public function getPatientNumber()
	 {
		return $this->$patientNumber;
	 }
	 
	  public function getPatientName()
	 {
		$name=$this->firstName ." ". $this->lastName;
		return $name;
	 }
	 
	 public function getPatientInsurances()
	 {
		return 	$this->$insurances;
	 }
	 
	 public showByDate($USFormatDate)
	 {
		$result="Patient Number, First Last, Insurance Name, Is Valid \n";
		echo $result;
		for($this->$insurances as $object)
		{	
				$result  =$this->$patientNumber.", ";
				$result .=$this->$lastName." ";
				$result .=$this->$firstName.", ";
				$result .=$object->$insuranceName.", ";
				$result .=$object->checkInsuranceDate($USFormatDate)."\n";		
				
				echo $result;
		}
	 }
 }
 
 class Insurance implements  PatientRecord
 {
 
	 private static $id=0;
	 private $patientNumbers=array();
	 private $insuranceName;
	 private $fromDate;
	 private $toDate;
	 
	 public function __constructor($iName,$from,$to)
	 {
		 
		$this->$insuranceName=$iName;
		$this->$fromDate=date_format($date_create($from),"");
		$this->$toDate=date_format($date_create($to));
		self::$id++;
	 }
	 
	 public function getInsuranceID()
	 {
		return self::$id>$id;
	 }
	 
	 public function getPatientNumbers()
	 {
		return $this->$patientNumbers;
	 }
	 
	 public function checkInsuranceDate($USFormatDate)
	 {
 
		if($USFormatDate>=$this->fromDate)
		{	
			if( isset($$this->toDate) &&  $$this->toDate!==null && $USFormatDate<=$this->toDate)
			{	
				return TRUE;
			}
			else
			{
				return "validity infinite";
			}
		}else
		{
			return FALSE;
		}		
	 }
 }
 
 ?>
