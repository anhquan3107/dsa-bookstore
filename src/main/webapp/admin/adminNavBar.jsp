<div class="container-fluid p-3">
	<div class="row">
		<div class="col-md-3 text-sucess">

			<h3>
				<i class="fa-solid fa-book"></i> BookSaw
			</h3>

		</div>

		<div class="col-md-6">
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
			</form>

		</div>

		<div class="col-md-3">
			<a href="" class="btn btn-success">LogIn</a> <a href=""
				class="btn btn-primary">Register</a>
		</div>

	</div>


</div>

<%--change color here: navbar-.... bg-.... --%>
<%--chinh bg color cua navigation bar --%>
<nav class="navbar navbar-expand-lg navbar-light bg-taocustom">
	<a class="navbar-brand" href="#"><i class="fa-solid fa-house"></i></a>
	<%--home icon--%>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			


			<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}/index.jsp">Home <span
					class="sr-only">(current)</span>
			</a></li>


			<li class="nav-item active"><a class="nav-link" href="#"><i
					class="fa-solid fa-book-open"> </i> Old Book</a></li>
			<li class="nav-item active"><a class="nav-link" href="#"><i
					class="fa-solid fa-book-open"> </i> New Book</a></li>



		</ul>
		<form class="form-inline my-2 my-lg-0">
			<button class="btn btn-light my-2 my-sm-0" type="submit">
				<i class="fa-solid fa-gears"></i> Setting
			</button>

			<button class="btn btn-light my-2 my-sm-0 ml-1" type="submit">
				<i class="fa-solid fa-phone"></i> Contact Us
			</button>
		</form>
	</div>
</nav>