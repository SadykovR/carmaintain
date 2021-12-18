<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>All the my classy incredible truly amazing sportscars</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
        <script th:src="@{/webjars/jquery/jquery.min.js}"></script>
        <spring:url value="/resources/scripts/jquery-1.12.4.js"
        var="jquery_url" />
        <spring:url value="/resources/scripts/jquery-ui.min.js"
        var="jquery_ui_url" />
        <spring:url value="/resources/styles/custom-theme
        /jquery-ui.theme.min.css"
        var="jquery_ui_theme css" />
        <link rel="stylesheet" type="text/css" media="screen"
        href="${jquery_ui_theme_css}" />
        <script src="${jquery_url}" type="text/javascript">
        <jsp:text/></script>
        <script src="${jquery_ui_url}" type="text/javascript">
        <jsp:text/></script>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="container">
             <h2>All the my classy incredible truly amazing sportscars</h2>
                 <table class="table table-striped">
                    <thead>
                       <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <%--th>Статья расхода</th>
                        <th>Комментарий</th--%>
                       </tr>
                   </thead>
                    <tbody>
                        <c:forEach items="${cars}" var="car">
                            <tr>
                                <td>${car.id}</td>
                                <td>${car.name}</td>
                                <%--c:forEach items="${car.expenses}" var="exp">
                                   <td>${exp.id}</td>
                                   <td>${exp.comment}</td>
                                </c:forEach--%>
                           </tr>
                        </c:forEach>
                     </tbody>
            </table>
        </div>



      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    </body>
</html>


