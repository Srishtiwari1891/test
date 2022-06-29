<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management</title>
</head>
<body>
<h3>Student Directory</h3>
<a href="showFormForAdd">Add new Student</a>

<table class="table table-bordered table-stripped">
        <thead class="thead-dark">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Department</th>
                <th>Country</th>
                <th>Action</th>
            </tr>
        </thead>
<tbody>
          <c:forEach items="${students}" var="students" >
			<tr>
                <td>${students.fname}</td>
                <td>${students.lname}</td>
                <td>${students.course}</td>
                <td>${students.country}</td>
                <td><a href="showFormForUpdate?studentid=${students.studentid}">Update</a>
                    <a href="delete?studentid=${students.studentid}" onclick="if (!(confirm('Are you sure you want to delete this Student?'))) 
                    	return false">Delete</a></td>
            </tr>
          </c:forEach>
        </tbody>
        
    </table>
</body>
</html>