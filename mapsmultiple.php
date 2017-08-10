<?php
require_once('dbbconn.php');
$sql = "SELECT * FROM busdriverregistration";
$res =mysqli_query($connectdb,$sql);
 $result = array();
while($row = mysqli_fetch_array($res)){
array_push($result,
array(
/*'BusNo'=>$row['busno'],*/
'latitude'=>$row['latitude'],
'longitude'=>$row['longitude'],
));
}
 
echo json_encode(array("results"=>$result));
 
mysqli_close($con);
?>