<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
    <head>
        <title>All the my classy incredible truly amazing sportscars</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script th:src="@{/webjars/jquery/jquery.min.js}"></script>
    </head>
    <body>
    <jsp:include page="header.jsp" />

        <div class="container">
        		<c:if test="${not empty msg}">
        			<div class="alert alert-${css} alert-dismissible" role="alert">
        				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
        					<span aria-hidden="true">&times;</span>
        				</button>
        				<strong>${msg}</strong>
        			</div>
        		</c:if>
             <h2>Бортжурнал</h2>
                 <table class="table table-striped">
                    <thead>
                       <tr>
                        <th>ID</th>
                        <th>Автомобиль</th>
                        <th>Статья расхода</th>
                        <th>Комментарий</th>
                       </tr>
                   </thead>
                    <tbody>
                        <c:forEach items="${expenses}" var="exp">
                            <tr>
                                <td>${exp.id}</td>
                                <td>${exp.car.name}</td>
                                <td>${exp.expenseDict.name}</td>
                                <td>${exp.comment}</td>
                                <%--td><a href="/getcar?id=${exp.car.id}">просмотр</a></td--%>
                                <%--td><a href="/getexpense?id=${exp.id}">просмотр</a></td--%>
                                <%--td><a href="/getexpense/edit?id=${exp.id}">ред</a></td--%>

                                <td>
                                    <button class="btn btn-info" onclick="location.href='/getexpense?id=${exp.id}'">просм</button>
                                    <button class="btn btn-primary" onclick="location.href='/getexpense/edit?id=${exp.id}'">ред</button>
                                    <button class="btn btn-danger" onclick="this.disabled=true;post('/getexpense/delete?id=${exp.id}')">удал</button>
                                </td>
                           </tr>
                        </c:forEach>
                   </tbody>
            </table>
        </div>

      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
      <spring:url value="/resources/static/hello.js" var="coreJs" />
      <script src="${coreJs}"></script>
          <jsp:include page="footer.jsp" />
    </body>
</html>


