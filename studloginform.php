<?php
error_reporting(0);
$username =$_POST['username'];
$password = $_POST['password'];
require_once('dbbconn.php');
$sql = "select username,password from studentregisteration where username = '$username' and password = '$password'";
$check = mysqli_query($connectdb,$sql);
if($check){
echo "already exist";
}
else{
echo " new one ";
}
?>