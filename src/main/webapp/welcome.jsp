<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
<%--<%
    String user = request.getParameter("user");
%>


Hello, <% out.println(user); %>--%>

<%--<%= (2*5) %> --%><%-- Never end an expression with semicolon inside Expression Tag--%>

<%-- SOME SWEARING COMMENT YOU DON'T WANT SOMEONE TO SEE --%>


<%--<hr>
<table border = 1>
    <%
        for ( int i = 1; i <= 5; i++ ) {
    %>
    <tr>
        <td>Number</td>
        <td><%= i %></td>
    </tr>
    <%
        }
    %>
</table>--%>


<%--<hr>
<%
    if (user.equals("admin")) {
%>
<p>Hello, world</p>
<%
} else {
%>
<p>Goodbye, world</p>
<%
    }
%>--%>


<%--<%!
    private int count = 0;
%>
Page count is:
<% out.println(++count); %>--%>

<%!
    int count = 0;
    int getCount() {
        System.out.println( "In getCount() method" );
        return count;
    }
%>

Page count is:
<% out.println(getCount()); %>


<jsp:useBean id="" class="" scope="request" />
<jsp:setProperty name="" property="" value="" />
Meal is : <jsp:getProperty name="" property="" />


<%@ include file="header.jsp" %>


<c:if test="${param.name == 'studytonight'}">
    <p>Welcome to ${param.name} </p>
</c:if>


<c:out value="${param.name}" default="StudyTonight" />



<c:forEach var="message" items="${errorMsgs}" >
    <li>${message}</li>
</c:forEach>

<c:choose>

    <c:when test="${status.count %2 == 0 }">
        <p> Divisible by 2 : ${tutorial.key} </p>
        <br/>
    </c:when>

    <c:when test="${status.count %5 == 0 }">
        <p > Divisible by 5 : ${tutorial.key} </p>
        <br/>
    </c:when>

    <c:otherwise>
        <p> Neither divisible by 2 nor 5 : ${tutorial.key} </p><br/>
    </c:otherwise>

</c:choose>


<c:import url="http://www.example.com/hello.html">>
    <c:param name="showproducts" value="true"/>
</c:import>


<a href='<c:url value="/home.jsp"/>' > Go Home </a>


<%--used to store a variable in specified scope or update the property of JavaBean instance--%>
<c:set target="student" property="name" value="${param.name}" />


<%--used to handle exception and doesn't forward the page to the error page--%>
<c:catch>
    <% int a = 0;
        int b = 10;
        int c = b/a;
    %>
</c:catch>

</body>
</html>