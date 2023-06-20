	
	<%@ include file="common/header.jspf" %>
	
	<body>
		<div class="container">
		<h1>Login</h1>
		<form method="post">
			<label >Name:</label>
			<input class="form-control mb-3" type="text" name="name"/>
			<label>Password:</label>
			<input class="form-control " type="password" name="password"/>
			<button class="btn btn-info mt-3" type="submit">Login</button>
		</form>
		</div>
		<script  src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.js.map"></script>
		<script  src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
	<%@ include file="common/footer.jspf" %>