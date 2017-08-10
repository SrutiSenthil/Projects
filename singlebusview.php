<?php
require_once('dbbconn.php');
$busno = $_POST['busno'];
$sql = "SELECT * FROM busdriverregistration where busno = '$busno'";
$res =mysqli_query($connectdb,$sql);
 $result = array();
while($row = mysqli_fetch_array($res)){
array_push($result,
array(
'BusNo'=>$row['busno'],
'Name'=>$row['Name'],
'From'=>$row['From'],
'To'=>$row['To'],
'BusStop1'=>$row['busstop1'],
'BusStop2'=>$row['busstop2'],
'BusStop3'=>$row['busstop3'],
'BusStop4'=>$row['busstop4'],
'BusStop5'=>$row['busstop5'],
'BusStop6'=>$row['busstop6'],
));
}
 
echo json_encode(array("results"=>$result));
 
mysqli_close($con);
?>