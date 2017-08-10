<?php
require_once('dbbconn.php');
$busno = $_POST['busno'];
$sql = "SELECT * FROM busdriverregistration where busno = '$busno'";
$res =mysqli_query($connectdb,$sql);
 $result = array();
while($row = mysqli_fetch_array($res)){
array_push($result,
array(
'latitude'=>$row['latitude'],
'longitude'=>$row['longitude'],
));
}
 
echo json_encode(array("results"=>$result));
 
mysqli_close($con);
?>