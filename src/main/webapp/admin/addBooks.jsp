<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BS Admin: Add Books</title>
<%@include file="admin.jsp"%>
</head>
<body style="background-color: #F3F2EC;">
	<%@include file="adminNavBar.jsp"%>

<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="cord">
					<div class="card-body"></div>
					
					<h4 class = "text-center">Add Books</h4>

					<form action="../AdminAddBookServlet" method="post"
						enctype="multipart/form-data">
						
						<div class="form-group">
							<label for="exampleInputEmail1">Book Name*</label> <input
								name="bname" type="text" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp">
						</div>
				
						<div class="form-group">
							<label for="exampleInputEmail1">Author Name*</label> <input
								name="author" type="text" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Price*</label> <input
								name="price" type="number" class="form-control"
								id="exampleInputPassword1">
						</div>
						<div class="form-group">
							<label for="inputState">Book Categories</label> <select
								id="inputState" name="btype" class="form-control">
								<option selected>--select--</option>
								<option value="New">New Book</option>
							</select>
						</div>
						
						<div class="form-group">
							<label for="inputState">Book Status</label> <select
								id="inputState" name="bstatus" class="form-control">
								<option selected>--select--</option>
								<option value="Active">Active</option>
								<option value="Inactive">Inactive</option>
							</select>
						</div>
						
						<div class="form-group">
							<label for="exampleFormControlFile1">Upload Photo</label> <input
								name="bimg" type="file" class="form-control-file"
								id="exampleFormControlFile1">
						</div>
						<button type="submit" class="btn btn-primary">Add</button>
					</form>

				</div>
			</div>
		</div>
	</div>

</body>
</html>