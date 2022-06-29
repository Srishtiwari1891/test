<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration Form</title>
</head>
<body>
<h3>Student Form for ${mode}</h3>

<form action="save" method="POST">
                <input type="hidden" name="studentid" value="${students.studentid}" />
                <input type="text" name="fname" value="${students.fname}" placeholder="First Name">
                <input type="text" name="lname" value="${students.lname}" placeholder="Last Name">
                <input type="text" name="department" value="${students.course}" placeholder="Department">
                <input type="text" name="country" value="${students.country}" placeholder="Country">
                <button type="submit" >SAVE</button>
            </form>
            <a href="list">Back to Students List</a>

</body>
</html>