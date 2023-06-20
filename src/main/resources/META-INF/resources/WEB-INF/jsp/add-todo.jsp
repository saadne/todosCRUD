
	<%@ include file="common/header.jspf" %>
	<body>
		
		<div class="container">
		<%@ include file="common/navigation.jspf" %>
		<h1>Add Todo</h1>
		<form:form method="post" modelAttribute="todo">	
			<fieldset>
				<label path="description" class="mt-3">Description:</label>
				<form:input type="text" class="form-control " path="description" required="required"/>
				<form:errors cssClass="text-warning"  path="description"/>
			</fieldset>
			<fieldset>
				<label path="targetDate" class="mt-3">Target Date:</label>
				<form:input type="text" id="targetDate" class="form-control " path="targetDate" required="required"/>
				
			</fieldset>
			<form:input type="hidden" class="form-control " path="id"/>
			<form:input type="hidden" class="form-control " path="done"/>
			
			<br>
			<button class="btn btn-success mt-4" type="submit">Add Todo</button>
		</form:form>
		</div>
		<%@ include file="common/footer.jspf" %>
		