<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>RestSMS_Service Home Page</title>
	</head>
	<body bgcolor="skyblue">>
		<div align="center">
			<h1><font color="green">Rest full SMS Service Home Page</font></h1>
			<form action="${pageContext.request.contextPath}/sendMessageButton">
				<table>
					<tr><td><input type="submit" value="Send Message"/></td></tr>
				</table>
			</form>
			<form action="${pageContext.request.contextPath}/sendMessageByJSONButton">
				<table>
					<tr><td><input type="submit" value="Send Message By JSON"/></tr>
				</table>
			</form>
		</div>
	</body>
</html>