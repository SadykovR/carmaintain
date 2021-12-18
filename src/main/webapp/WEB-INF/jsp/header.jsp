<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Spring MVC Form Handling Example</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/allcars" var="urlHome" />
<spring:url value="/allexpenses" var="urlGetExpenses" />
<spring:url value="/allexpenses/add" var="urlAddExpense" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">All cars</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${urlGetExpenses}">All expenses</a></li>
			</ul>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddExpense}">Add expense</a></li>
			</ul>
		</div>
	</div>
</nav>