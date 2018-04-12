<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rest Send Message By JSON Home Page</title>
</head>
<body bgcolor="pink">>
	<div align="center">
	<h1><font color="green">Rest full SMS Service Send Message By JSON Home Page</font></h1>
	<h2><font color="red">${JsonMessage}</font></h2>
	<form action="${pageContext.request.contextPath}/sendMessageByJSON" method="post">
		<table>
			<tr>
				<td><font color="blue">Mobile Number : </font></td>
				<td><input type="text" name="mobileNumber"/></td>
			</tr>
			<tr>
				<td><font color="blue">Text Message : </font></td>
				<td><textarea rows="5" cols="50" name="textMessage"></textarea></td>
			</tr>
			<tr align="right">
				<td><input type="submit" value="Send Message By JSON"/></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/Jsps/Home.jsp">Home Page</a></td>
				<td><a href="${pageContext.request.contextPath}/Jsps/SendMessage.jsp">Send Message Page</a></td>			
			</tr>
		</table>
	</form>
	</div>
</body>
</html>