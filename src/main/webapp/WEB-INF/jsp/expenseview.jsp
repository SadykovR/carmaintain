<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
    <head>
        <title>All the my classy incredible truly amazing sportscars</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
        <script th:src="@{/webjars/jquery/jquery.min.js}"></script>
    </head>
    <body>
<jsp:include page="header.jsp" />


<div class="container">
	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
                                aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>Expense Information</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${exp.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Машина</label>
		<div class="col-sm-10">${exp.car.name}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Статья расхода</label>
		<div class="col-sm-10">${exp.expenseDict.name}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Комментарий</label>
		<div class="col-sm-10">${exp.comment}</div>
	</div>

</div>

</body>
</html>



