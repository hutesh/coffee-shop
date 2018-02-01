<?php

$con =mysqli_connect("localhost","id1027806_115cs0209","hack123","id1027806_coustmer");

$username=$_POST["username"];
$password=$_POST["password"];
$email=$_POST["email"];

$query="INSERT INTO `user`(`username`, `password`, `email`) VALUES ('{$username}','{$password}','{$email}')";
$run=mysqli_query($con,$query);
echo "1";
?>