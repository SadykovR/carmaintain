<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <title>All the my classy incredible truly amazing sportscars</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script th:src="@{/webjars/jquery/jquery.min.js}"></script>
    </head>
    <body>
<jsp:include page="header.jsp" />

    <div class="container">

	<c:choose>
		<c:when test="${exp['new']}">
			<h1>Add expense</h1>
		</c:when>
		<c:otherwise>
			<h1>Update expense</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/allexpenses" var="allexpensesUrl" />

	<form:form class="form-horizontal" method="post" modelAttribute="exp" action="${allexpensesUrl}">

		<form:hidden path="id" />

		<spring:bind path="car">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Машина</label>
				<div class="col-sm-5">
					<form:select path="car" items="${carList}" size="5" class="form-control" itemLabel="name" itemValue="id"/>
					<form:errors path="car" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>

        <spring:bind path="expenseDict">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Статья расхода</label>
                <div class="col-sm-5">
                    <form:select path="expenseDict" class="form-control">
                        <form:options items="${expensesDictList}" itemLabel="name" itemValue="id"/>
                    </form:select>
                    <form:errors path="expenseDict" class="control-label" />
                </div>
            </div>
        </spring:bind>



		<spring:bind path="comment">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">comment</label>
				<div class="col-sm-10">
					<form:input path="comment" type="text" class="form-control " id="comment" placeholder="comment" />
					<form:errors path="comment" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${exp['new']}">
						<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right">Update</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>

</div>

      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
</body>
</html>