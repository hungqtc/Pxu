<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI</title>
</head>
<body>
	<h2>Tính BMI</h2>
	<form method = "POST" action="doBmi">
		<label for="fname">Cân nặng: </label> <br> 
		<input type="text" name="weight" placeholder="tinh theo Kg" ><br> 
		<label for="lname">Chiều cao:</label> <br> 
		<input type="text" name="height" placeholder="tinh theo m"><br>
		<br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>