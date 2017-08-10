<?php

error_reporting(0);

$name = $_POST['name'];
$busno = $_POST['busno'];
$username = $_POST['username'];
$password = $_POST['password'];
$from = $_POST['from'];
$to = $_POST['to'];
$bs1 = $_POST['bs1'];
$bs2 = $_POST['bs2'];
$bs3 = $_POST['bs3'];
$bs4 = $_POST['bs4'];
$bs5 = $_POST['bs5'];
$bs6 = $_POST['bs6'];

require_once('dbbconn.php');
$sql = "insert into busdriverregistration(  `Name`, `Username`, `Password`, `From`, `To`, `busno`, `busstop1`, `busstop2`, `busstop3`, `busstop4`, `busstop5`, `busstop6`) values ('$name','$busno','$username','$password','$from','$to','$bs1','$bs2','$bs3','$bs4','$bs5','$bs6')";
$check = mysqli_query($connectdb,$sql);

if($check){
echo " insert success";
}

else{
echo " not inserted";
}

?>