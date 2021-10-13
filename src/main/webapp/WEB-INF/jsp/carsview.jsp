<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>All the my classy incredible truly amazing sportscars</title>
        <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cars}" var="car">
                    <tr>
                        <td>${car.id}</td>
                        <td>${car.name}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>