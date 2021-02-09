<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<jsp:include page="links.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div style="height: 90vh; margin-top: 10rem;">
		<div class=" row justify-content-md-center h-100">
			<div class="col-md-8 h-100">
				<div class="align-middle card">
					<div class="card-header bg-primary">
						<h3 class="text-center">Registration</h3>
					</div>
					<div class="card-body border-primary">
						<form method="post">
							<div class="form-group row">
								<label for="fname" class="col-md-2 col-form-label">Name</label>
								<div class="col-sm-10 row">
									<div class="col">
										<input type="text" class="form-control" id="fname" name="fname" placeholder="Enter First name"/>
									</div>
									<div class="col">
										<input type="text" class="form-control" id="lname" name="lname" placeholder="Enter Last name" />
									</div>
								</div>
							</div>
							<div class="form-group row">
								<label for="address" class="col-md-2 col-form-label">Address</label>
								<div class="col-sm-10">
									<textarea class="form-control" rows="3" id="address" name="address" placeholder="Enter Address"></textarea>
								</div>
							</div>
							<div class="form-group row">
								<label for="mobile" class="col-md-2 col-form-label">Mobile</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="mobile" name="mobile" placeholder="Enter mobile"/>
								</div>
							</div>
							<div class="form-group row">
								<label for="email" class="col-md-2 col-form-label">Email</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="email" name="email" placeholder="Enter Email"/>
								</div>
							</div>
							<div class="form-group row">
								<label for="password" class="col-md-2 col-form-label">Password</label>
								<div class="col-sm-10">
								 <input type="password" class="form-control" id="password" name="password" placeholder="Enter password"/>
								 </div>
							</div>
							<div class="form-group row">
								<label for="role" class="col-md-2 col-form-label">Role</label>
								<div class="col-sm-10">
								 <input type="text" class="form-control" id="role" name="role" placeholder="Enter role"/>
								 </div>
							</div>

							<button type="submit" class="btn btn-success btn-block">Register</button>
							<a href="login">Login</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>