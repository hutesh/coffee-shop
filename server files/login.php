<?php
$con =mysqli_connect("localhost","id1027806_115cs0209","hack123","id1027806_coustmer");
$username=$_POST["username"];
$password=$_POST["password"];
$query="SELECT * FROM user WHERE username='{$username}' AND password='{$password}' ";
$run = mysqli_query($con,$query);

if(mysqli_num_rows($run)>0){
echo "1";
}else{
echo "0";
}




?>