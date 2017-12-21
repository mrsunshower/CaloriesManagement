<%@ page import="com.logivations.calories_management.model.MealWithExceed" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<% List<MealWithExceed> meals = (ArrayList<MealWithExceed>) request.getAttribute("meals"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h1>Meals List</h1>
<table border="1">
    <th>date</th>
    <th>description</th>
    <th>calories</th>
    <th>exceed</th>

    <c:forEach var="meal" items="${meals}">
        <tr bgcolor="${meal.exceed ? 'red' : 'green'}">
            <td>${fn:replace(meal.meal.dateTime, 'T', ' ')}</td>
            <td>${meal.meal.description}</td>
            <td>${meal.meal.calories}</td>
            <td>${meal.meal.isExceed}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>