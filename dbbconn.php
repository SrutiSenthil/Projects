<?php
error_reporting(0);
define (HOST,"localhost");
define (USER,"root");
define (PASS,"");
define (DB,"bustracking");
$connectdb = mysqli_connect(HOST,USER,PASS,DB);
if($connectdb)
{

}
else
{
echo "connection failed";
}
?>