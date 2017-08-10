<?php
error_reporting(0);
$name = $_POST['name'];
$username =$_POST['username'];
$password = $_POST['password'];
$email = $_POST['email'];
$college = $_POST['college'];
require_once('dbbconn.php');
$sql = "insert into studentregisteration( `Name`, `Username`, `Password`, `Email`, `College`) values ('$name','$username','$password','$email','$college')";
$check = mysqli_query($connectdb,$sql);
if($check){
echo " insert success";
}
else{
echo " not inserted";
}
?>