<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>DSA Bookstore</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="format-detection" content="telephone=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="author" content="">
	<meta name="keywords" content="">
	<meta name="description" content="">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="css/normalize.css">
<link rel="stylesheet" type="text/css" href="icomoon/icomoon.css">
<link rel="stylesheet" type="text/css" href="css/vendor.css">
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>

<body data-bs-spy="scroll" data-bs-target="#header" tabindex="0">

	<div id="header-wrap">

		<div class="top-content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-6">
						<div class="social-links">

						</div><!--social-links-->
					</div>
					<div class="col-md-6">
					    <div class="right-element">
					        <!-- Check if the user is logged in -->
							<c:choose>
							    <c:when test="${sessionScope.userinfo != null}">
							        <!-- User is logged in -->
							        <a href="userProfile.jsp" class="user-account for-buy">
							            <i class="icon icon-user"></i>
							            <span>Account</span>
							        </a>
							    </c:when>
							    <c:otherwise>
							        <!-- User is not logged in -->
							        <a href="login.jsp" class="user-account for-buy">
							            <i class="icon icon-user"></i>
							            <span>Account</span>
							        </a>
							    </c:otherwise>
							</c:choose>
					<c:choose>
                <c:when test="${not empty sessionScope.userinfo}">
                    <!-- User is logged in, show cart -->
                    <a href="ViewCartServlet" class="cart for-buy">
                        <i class="icon icon-clipboard"></i>
                        <span id="cartInfo">
                            Cart: 
                            <c:if test="${not empty sessionScope.cartTotalItems}">
                                (${sessionScope.cartTotalItems} items - 
                                <fmt:formatNumber value="${sessionScope.cartTotalPrice}" type="currency" />
                                )
                            </c:if>
                            <c:if test="${empty sessionScope.cartTotalItems}">
                                (0 items - $0.00)
                            </c:if>
                        </span>
                    </a>
                </c:when>
                <c:otherwise>
                    <!-- User is not logged in -->
                    <a href="login.jsp" class="cart for-buy">
                        <i class="icon icon-clipboard"></i>
                        <span>Please log in to view your cart.</span>
                    </a>
                </c:otherwise>
            </c:choose>							
					
			<div class="action-menu">
				<div class="search-bar">
					<!-- Update the search button to link to search.jsp -->
					<a href="search.jsp" class="search-button">
						<i class="icon icon-search"></i>
					</a>
				</div>
			</div>
			
		 </div><!--top-right-->
</div>

				</div>

			</div>
		</div>
	</div>
	<!--top-content-->

	<header id="header">
		<div class="container-fluid">
			<div class="row">

				<div class="col-md-2">
					<div class="main-logo">
						<a href="index.html"><img src="images/main-logo.png"
							alt="logo"></a>
					</div>

				</div>

				<div class="col-md-10">

						<nav id="navbar">
							<div class="main-menu stellarnav">
								<ul class="menu-list">
									<li class="menu-item active"><a href="#home">Home</a></li>
									<li class="menu-item"><a href="#featured-books" class="nav-link">Featured</a></li>
									<li class="menu-item"><a href="#popular-books" class="nav-link">Popular</a></li>
									<li class="menu-item"><a href="#special-offer" class="nav-link">Offer</a></li>
								</ul>

							<div class="hamburger">
								<span class="bar"></span> <span class="bar"></span> <span
									class="bar"></span>
							</div>

						</div>
					</nav>

				</div>

			</div>
		</div>
	</header>

	</div>
	<!--header-wrap-->


	<section id="billboard">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<button class="prev slick-arrow">
						<i class="icon icon-arrow-left"></i>
					</button>

					<div class="main-slider pattern-overlay">
						<c:forEach var="book" items="${randomBooks}">
							<div class="slider-item">
								<div class="banner-content">
									<h2 class="banner-title">${book.title}</h2>
									<p>${book.description}</p>
									<div class="btn-wrap">
										<a href="#" class="btn btn-outline-accent btn-accent-arrow">Read
											More <i class="icon icon-ns-arrow-right"></i>
										</a>
									</div>
								</div>
								<!--banner-content-->
								<img src="${pageContext.request.contextPath}/${book.bookImage}"
									alt="Book Cover" class="banner-image">
							</div>
							<!--slider-item-->
						</c:forEach>
					</div>
					<!--slider-->

					<button class="next slick-arrow">
						<i class="icon icon-arrow-right"></i>
					</button>
				</div>
			</div>
		</div>
	</section>


	<section id="featured-books" class="py-5 my-5">
		<div class="container">
			<div class="row">
				<div class="col-md-12">

					<div class="section-header align-center">
						<div class="title">
							<span>Some quality items</span>
						</div>
						<h2 class="section-title">Featured Books</h2>
					</div>

					<div class="product-list" data-aos="fade-up">
						<div class="row">

							<c:forEach var="book" items="${featuredBooks}">
								<div class="col-md-3">
									<div class="product-item">
										<figure class="product-style">
											<img src="${book.bookImage}" alt="${book.title}"
												class="product-item">
											<button type="button" class="add-to-cart"
											data-book-title="${book.title}"  data-book-price="${book.price}"
											data-book-id="${book.bookId}">Add to Cart</button>
										</figure>
										<figcaption>
											<h3>${book.title}</h3>
											<span>${book.author}</span>
											<div class="item-price">$ ${book.price}</div>
										</figcaption>
									</div>
								</div>
							</c:forEach>

						</div>
						<!--ft-books-slider-->
					</div>
					<!--grid-->


				</div>
				<!--inner-content-->
			</div>

			<div class="row">
				<div class="col-md-12">

					<div class="btn-wrap align-right">
						<a href="#popular-books" class="btn-accent-arrow">View all products <i
								class="icon icon-ns-arrow-right"></i></a>
					</div>

				</div>
			</div>
		</div>
	</section>

	<section id="best-selling" class="leaf-pattern-overlay">
		<div class="corner-pattern-overlay"></div>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="row">
						<c:forEach var="book" items="${bestSellingBook}">
							<div class="col-md-6">
								<figure class="products-thumb">
									<img src="${book.bookImage}" alt="${book.title}"
										class="single-image">
								</figure>
							</div>
							<div class="col-md-6">
								<div class="product-entry">
									<h2 class="section-title divider">Best Selling Book</h2>
									<div class="products-content">
										<div class="author-name">By ${book.author}</div>
										<h3 class="item-title">${book.title}</h3>
										<p>${book.description}</p>
										<div class="item-price">$ ${book.price}</div>
										<div class="btn-wrap">
											<a href="#" class="btn-accent-arrow">shop it now <i
												class="icon icon-ns-arrow-right"></i></a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<!-- / row -->
				</div>
			</div>
		</div>
	</section>


	<section id="popular-books" class="bookshelf py-5 my-5">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="section-header align-center">
                        <div class="title">
                            <span>All quality items</span>
                        </div>
                        <h2 class="section-title">All Books</h2>
                    </div>
                    <div class="row">
                        <c:forEach var="book" items="${allBooks}">
                            <div class="col-md-3">
                                <div class="product-item">
                                    <figure class="product-style">
                                        <img src="${book.bookImage}" alt="Books" class="product-item">
                                        <button type="button" class="add-to-cart" data-book-title="${book.title}"  data-book-price="${book.price}"
                                        data-book-id="${book.bookId}">>Add to Cart</button>
                                    </figure>
                                    <figcaption>
                                        <h3>${book.title}</h3>
                                        <span>${book.author}</span>
                                        <div class="item-price">$ ${book.price}</div>
                                    </figcaption>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </section>





	<footer id="footer">
		<div class="container">
			<div class="row">

				<div class="col-md-4">

					<div class="footer-item">
						<div class="company-brand">
							<img src="images/main-logo.png" alt="logo" class="footer-logo">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Sagittis sed ptibus liberolectus nonet psryroin. Amet sed lorem
								posuere sit iaculis amet, ac urna. Adipiscing fames semper erat
								ac in suspendisse iaculis.</p>
						</div>
					</div>

				</div>

				<div class="col-md-2">

					<div class="footer-menu">
						<h5>About Us</h5>
						<ul class="menu-list">
							<li class="menu-item"><a href="#">vision</a></li>
							<li class="menu-item"><a href="#">articles </a></li>
							<li class="menu-item"><a href="#">careers</a></li>
							<li class="menu-item"><a href="#">service terms</a></li>
							<li class="menu-item"><a href="#">donate</a></li>
						</ul>
					</div>

				</div>
				<div class="col-md-2">

					<div class="footer-menu">
						<h5>Discover</h5>
						<ul class="menu-list">
							<li class="menu-item"><a href="#">Home</a></li>
							<li class="menu-item"><a href="#">Books</a></li>
							<li class="menu-item"><a href="#">Authors</a></li>
							<li class="menu-item"><a href="#">Subjects</a></li>
							<li class="menu-item"><a href="#">Advanced Search</a></li>
						</ul>
					</div>

				</div>
				<div class="col-md-2">

					<div class="footer-menu">
						<h5>My account</h5>
						<ul class="menu-list">
							<li class="menu-item"><a href="#">Sign In</a></li>
							<li class="menu-item"><a href="#">View Cart</a></li>
							<li class="menu-item"><a href="#">My Wishtlist</a></li>
							<li class="menu-item"><a href="#">Track My Order</a></li>
						</ul>
					</div>

				</div>
				<div class="col-md-2">

					<div class="footer-menu">
						<h5>Help</h5>
						<ul class="menu-list">
							<li class="menu-item"><a href="#">Help center</a></li>
							<li class="menu-item"><a href="#">Report a problem</a></li>
							<li class="menu-item"><a href="#">Suggesting edits</a></li>
							<li class="menu-item"><a href="#">Contact us</a></li>
						</ul>
					</div>

				</div>

			</div>
			<!-- / row -->

		</div>
	</footer>

	<div id="footer-bottom">
		<div class="container">
			<div class="row">
				<div class="col-md-12">

					<div class="copyright">
						<div class="row">

							<div class="col-md-6">
								<p>
									© 2022 All rights reserved. Free HTML Template by <a
										href="https://www.templatesjungle.com/" target="_blank">TemplatesJungle</a>
								</p>
							</div>

							<div class="col-md-6">
								<div class="social-links align-right">
									<ul>
										<li><a href="#"><i class="icon icon-facebook"></i></a></li>
										<li><a href="#"><i class="icon icon-twitter"></i></a></li>
										<li><a href="#"><i class="icon icon-youtube-play"></i></a>
										</li>
										<li><a href="#"><i class="icon icon-behance-square"></i></a>
										</li>
									</ul>
								</div>
							</div>

						</div>
					</div>
					<!--grid-->

				</div>
				<!--footer-bottom-content-->
			</div>
		</div>
	</div>

	<script src="js/jquery-1.11.0.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
	<script src="js/plugins.js"></script>
	<script src="js/script.js"></script>
	<script src = "js/addToCart.js"></script>

</body>

</html>