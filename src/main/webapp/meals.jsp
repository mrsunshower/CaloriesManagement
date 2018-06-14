<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Meals</title>
    <style>
        .normal {
            background-color: greenyellow
        }

        .exceeded {
            background-color: orangered
        }
    </style>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<section>
    <h1>Meals List</h1>
    <table border="1" cellpadding="8" cellspacing="0">

        <thead>
        <tr>
            <th>date</th>
            <th>description</th>
            <th>calories</th>
            <th>exceeded</th>
        </tr>
        </thead>

        <c:forEach var="meal" items="${requestScope.meals}">
            <jsp:useBean id="meal" type="com.fit.calories_management.model.MealWithExceeded"/>
            <tr class="${meal.exceeded ? 'exceeded' : 'normal'}">
                <td>
                        <%--${fn:replace(meal.meal.dateTime, 'T', ' ')}--%>
                    <%--<fmt:parseDate value="${meal.meal.dateTime}" pattern="y-M-dd'T'H:m" var = "parsedDate"/>
                    <fmt:formatDate value="${parsedDate}" pattern="yyyy.MM.dd HH:mm"/>--%>
                    <%=meal.getMeal().getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))%>
                </td>
                <td>${meal.meal.description}</td>
                <td>${meal.meal.calories}</td>
                <td>${meal.exceeded}</td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>