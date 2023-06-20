	<%@ include file="common/header.jspf" %>
	<body>
		<div class="container">
		<%@ include file="common/navigation.jspf" %>
			<h1>Welcome ${name}</h1>
		<a href="/todo-list">Manage Todo</a>
		</div>
		
		<script  src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.js.map"></script>
		<script  src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
	<%@ include file="common/footer.jspf" %>