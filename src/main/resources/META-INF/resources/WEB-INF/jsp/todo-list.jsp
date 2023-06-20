	<%@ include file="common/header.jspf" %>
	<body>
	
	<div class="container">
		<%@ include file="common/navigation.jspf" %>
		<h1>Welcome ${name }</h1>
		<hr></hr>
		<h1>Your todos</h1>
		<div>
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Done</th>
						<th>Actions</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
							<td>
								<a class="btn btn-danger" href="delete-todo?id=${todo.id}">Delete</a>
								<a class="btn btn-success" href="update-todo?id=${todo.id}">Update</a>
							</td>
							<td>
								
							</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
		<a href="/add-todo" class="btn btn-info">Add Todo</a>
		
		</div>
		</div>
		<%@ include file="common/footer.jspf" %>