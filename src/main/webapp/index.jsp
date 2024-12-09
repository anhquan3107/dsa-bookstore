<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>BookSaw - Free Book Store HTML CSS Template</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="format-detection" content="telephone=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="author" content="">
	<meta name="keywords" content="">
	<meta name="description" content="">

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

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
							<ul>
							
								<li>
									<a href="#"><i class="icon icon-facebook"></i></a>
								</li>
								<li>
									<a href="#"><i class="icon icon-twitter"></i></a>
								</li>
								<li>
									<a href="#"><i class="icon icon-youtube-play"></i></a>
								</li>
								<li>
									<a href="#"><i class="icon icon-behance-square"></i></a>
								</li>
							</ul>
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
					
					        <a href="checkout.jsp" class="cart for-buy">
					            <i class="icon icon-clipboard"></i>
					            <span>Cart: (0 $)</span>
					        </a>
					
					        <div class="action-menu">
					            <div class="search-bar">
					                <a href="#" class="search-button search-toggle" data-selector="#header-wrap">
					                    <i class="icon icon-search"></i>
					                </a>
					                <form role="search" method="get" class="search-box">
					                    <input class="search-field text search-input" placeholder="Search" type="search">
					                </form>
					            </div>
					        </div>
					    </div><!--top-right-->
</div>

					</div>

				</div>
			</div>
		</div><!--top-content-->

		<header id="header">
			<div class="container-fluid">
				<div class="row">

					<div class="col-md-2">
						<div class="main-logo">
							<a href="index.html"><img src="images/main-logo.png" alt="logo"></a>
						</div>

					</div>

					<div class="col-md-10">

						<nav id="navbar">
							<div class="main-menu stellarnav">
								<ul class="menu-list">
									<li class="menu-item active"><a href="#home">Home</a></li>
									<li class="menu-item has-sub">
										<a href="#pages" class="nav-link">Pages</a>

										<ul>
											<li class="active"><a href="index.html">Home</a></li>
											<li><a href="index.html">About</a></li>
											<li><a href="index.html">Styles</a></li>
											<li><a href="index.html">Blog</a></li>
											<li><a href="index.html">Post Single</a></li>
											<li><a href="index.html">Our Store</a></li>
											<li><a href="index.html">Product Single</a></li>
											<li><a href="index.html">Contact</a></li>
											<li><a href="index.html">Thank You</a></li>
										</ul>

									</li>
									<li class="menu-item"><a href="#featured-books" class="nav-link">Featured</a></li>
									<li class="menu-item"><a href="#popular-books" class="nav-link">Popular</a></li>
									<li class="menu-item"><a href="#special-offer" class="nav-link">Offer</a></li>
									<li class="menu-item"><a href="#latest-blog" class="nav-link">Articles</a></li>
									<li class="menu-item"><a href="#download-app" class="nav-link">Download App</a></li>
								</ul>

								<div class="hamburger">
									<span class="bar"></span>
									<span class="bar"></span>
									<span class="bar"></span>
								</div>

							</div>
						</nav>

					</div>

				</div>
			</div>
		</header>

	</div><!--header-wrap-->


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
                                        <a href="#" class="btn btn-outline-accent btn-accent-arrow">Read More
                                            <i class="icon icon-ns-arrow-right"></i>
                                        </a>
                                    </div>
                                </div><!--banner-content-->
                                <img src="${book.bookImage}" alt="banner" class="banner-image">
                            </div><!--slider-item-->
                        </c:forEach>
                    </div><!--slider-->

                    <button class="next slick-arrow">
                        <i class="icon icon-arrow-right"></i>
                    </button>
                </div>
            </div>
        </div>
    </section>



	<section id="client-holder" data-aos="fade-up">
		<div class="container">
			<div class="row">
				<div class="inner-content">
					<div class="logo-wrap">
						<div class="grid">
							<a href="#"><img src="images/client-image1.png" alt="client"></a>
							<a href="#"><img src="images/client-image2.png" alt="client"></a>
							<a href="#"><img src="images/client-image3.png" alt="client"></a>
							<a href="#"><img src="images/client-image4.png" alt="client"></a>
							<a href="#"><img src="images/client-image5.png" alt="client"></a>
						</div>
					</div><!--image-holder-->
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
                                        <img src="${book.bookImage}" alt="${book.title}" class="product-item">
                                        <button type="button" class="add-to-cart" data-product-tile="add-to-cart">
                                            Add to Cart
                                        </button>
                                    </figure>
                                    <figcaption>
                                        <h3>${book.title}</h3>
                                        <span>${book.author}</span>
                                        <div class="item-price">$ ${book.price}</div>
                                    </figcaption>
                                </div>
                            </div>
                        </c:forEach>

						</div><!--ft-books-slider-->
					</div><!--grid-->


				</div><!--inner-content-->
			</div>

			<div class="row">
				<div class="col-md-12">

					<div class="btn-wrap align-right">
						<a href="#" class="btn-accent-arrow">View all products <i
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
                            <img src="${book.bookImage}" alt="${book.title}" class="single-image">
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
                                        <button type="button" class="add-to-cart" data-product-tile="add-to-cart">Add to Cart</button>
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

	<section id="quotation" class="align-center pb-5 mb-5">
		<div class="inner-content">
			<h2 class="section-title divider">Quote of the day</h2>
			<blockquote data-aos="fade-up">
				<q>“The more that you read, the more things you will know. The more that you learn, the more places
					you’ll go.”</q>
				<div class="author-name">Dr. Seuss</div>
			</blockquote>
		</div>
	</section>

	<section id="special-offer" class="bookshelf pb-5 mb-5">

		<div class="section-header align-center">
			<div class="title">
				<span>Grab your opportunity</span>
			</div>
			<h2 class="section-title">Books with offer</h2>
		</div>

		<div class="container">
			<div class="row">
				<div class="inner-content">
					<div class="product-list" data-aos="fade-up">
						<div class="grid product-grid">
							<div class="product-item">
								<figure class="product-style">
									<img src="images/product-item5.jpg" alt="Books" class="product-item">
									<button type="button" class="add-to-cart" data-product-tile="add-to-cart">Add to
										Cart</button>
								</figure>
								<figcaption>
									<h3>Simple way of piece life</h3>
									<span>Armor Ramsey</span>
									<div class="item-price">
										<span class="prev-price">$ 50.00</span>$ 40.00
									</div>
								</div>
							</figcaption>

							<div class="product-item">
								<figure class="product-style">
									<img src="images/product-item6.jpg" alt="Books" class="product-item">
									<button type="button" class="add-to-cart" data-product-tile="add-to-cart">Add to
										Cart</button>
								</figure>
								<figcaption>
									<h3>Great travel at desert</h3>
									<span>Sanchit Howdy</span>
									<div class="item-price">
										<span class="prev-price">$ 30.00</span>$ 38.00
									</div>
								</div>
							</figcaption>

							<div class="product-item">
								<figure class="product-style">
									<img src="images/product-item7.jpg" alt="Books" class="product-item">
									<button type="button" class="add-to-cart" data-product-tile="add-to-cart">Add to
										Cart</button>
								</figure>
								<figcaption>
									<h3>The lady beauty Scarlett</h3>
									<span>Arthur Doyle</span>
									<div class="item-price">
										<span class="prev-price">$ 35.00</span>$ 45.00
									</div>
								</div>
							</figcaption>

							<div class="product-item">
								<figure class="product-style">
									<img src="images/product-item8.jpg" alt="Books" class="product-item">
									<button type="button" class="add-to-cart" data-product-tile="add-to-cart">Add to
										Cart</button>
								</figure>
								<figcaption>
									<h3>Once upon a time</h3>
									<span>Klien Marry</span>
									<div class="item-price">
										<span class="prev-price">$ 25.00</span>$ 35.00
									</div>
								</div>
							</figcaption>

							<div class="product-item">
								<figure class="product-style">
									<img src="images/product-item2.jpg" alt="Books" class="product-item">
									<button type="button" class="add-to-cart" data-product-tile="add-to-cart">Add to
										Cart</button>
								</figure>
								<figcaption>
									<h3>Simple way of piece life</h3>
									<span>Armor Ramsey</span>
									<div class="item-price">$ 40.00</div>
								</figcaption>
							</div>
						</div><!--grid-->
					</div>
				</div><!--inner-content-->
			</div>
		</div>
	</section>

	<section id="subscribe">
		<div class="container">
			<div class="row justify-content-center">

				<div class="col-md-8">
					<div class="row">

						<div class="col-md-6">

							<div class="title-element">
								<h2 class="section-title divider">Subscribe to our newsletter</h2>
							</div>

						</div>
						<div class="col-md-6">

							<div class="subscribe-content" data-aos="fade-up">
								<p>Sed eu feugiat amet, libero ipsum enim pharetra hac dolor sit amet, consectetur. Elit
									adipiscing enim pharetra hac.</p>
								<form id="form">
									<input type="text" name="email" placeholder="Enter your email addresss here">
									<button class="btn-subscribe">
										<span>send</span>
										<i class="icon icon-send"></i>
									</button>
								</form>
							</div>

						</div>

					</div>
				</div>

			</div>
		</div>
	</section>

	<section id="latest-blog" class="py-5 my-5">
		<div class="container">
			<div class="row">
				<div class="col-md-12">

					<div class="section-header align-center">
						<div class="title">
							<span>Read our articles</span>
						</div>
						<h2 class="section-title">Latest Articles</h2>
					</div>

					<div class="row">

						<div class="col-md-4">

							<article class="column" data-aos="fade-up">

								<figure>
									<a href="#" class="image-hvr-effect">
										<img src="images/post-img1.jpg" alt="post" class="post-image">
									</a>
								</figure>

								<div class="post-item">
									<div class="meta-date">Mar 30, 2021</div>
									<h3><a href="#">Reading books always makes the moments happy</a></h3>

									<div class="links-element">
										<div class="categories">inspiration</div>
										<div class="social-links">
											<ul>
												<li>
													<a href="#"><i class="icon icon-facebook"></i></a>
												</li>
												<li>
													<a href="#"><i class="icon icon-twitter"></i></a>
												</li>
												<li>
													<a href="#"><i class="icon icon-behance-square"></i></a>
												</li>
											</ul>
										</div>
									</div><!--links-element-->

								</div>
							</article>

						</div>
						<div class="col-md-4">

							<article class="column" data-aos="fade-up" data-aos-delay="200">
								<figure>
									<a href="#" class="image-hvr-effect">
										<img src="images/post-img2.jpg" alt="post" class="post-image">
									</a>
								</figure>
								<div class="post-item">
									<div class="meta-date">Mar 29, 2021</div>
									<h3><a href="#">Reading books always makes the moments happy</a></h3>

									<div class="links-element">
										<div class="categories">inspiration</div>
										<div class="social-links">
											<ul>
												<li>
													<a href="#"><i class="icon icon-facebook"></i></a>
												</li>
												<li>
													<a href="#"><i class="icon icon-twitter"></i></a>
												</li>
												<li>
													<a href="#"><i class="icon icon-behance-square"></i></a>
												</li>
											</ul>
										</div>
									</div><!--links-element-->

								</div>
							</article>

						</div>
						<div class="col-md-4">

							<article class="column" data-aos="fade-up" data-aos-delay="400">
								<figure>
									<a href="#" class="image-hvr-effect">
										<img src="images/post-img3.jpg" alt="post" class="post-image">
									</a>
								</figure>
								<div class="post-item">
									<div class="meta-date">Feb 27, 2021</div>
									<h3><a href="#">Reading books always makes the moments happy</a></h3>

									<div class="links-element">
										<div class="categories">inspiration</div>
										<div class="social-links">
											<ul>
												<li>
													<a href="#"><i class="icon icon-facebook"></i></a>
												</li>
												<li>
													<a href="#"><i class="icon icon-twitter"></i></a>
												</li>
												<li>
													<a href="#"><i class="icon icon-behance-square"></i></a>
												</li>
											</ul>
										</div>
									</div><!--links-element-->

								</div>
							</article>

						</div>

					</div>

					<div class="row">

						<div class="btn-wrap align-center">
							<a href="#" class="btn btn-outline-accent btn-accent-arrow" tabindex="0">Read All Articles<i
									class="icon icon-ns-arrow-right"></i></a>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>

	<section id="download-app" class="leaf-pattern-overlay">
		<div class="corner-pattern-overlay"></div>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="row">

						<div class="col-md-5">
							<figure>
								<img src="images/device.png" alt="phone" class="single-image">
							</figure>
						</div>

						<div class="col-md-7">
							<div class="app-info">
								<h2 class="section-title divider">Download our app now !</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sagittis sed ptibus
									liberolectus nonet psryroin. Amet sed lorem posuere sit iaculis amet, ac urna.
									Adipiscing fames semper erat ac in suspendisse iaculis.</p>
								<div class="google-app">
									<img src="images/google-play.jpg" alt="google play">
									<img src="images/app-store.jpg" alt="app store">
								</div>
							</div>
						</div>

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
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sagittis sed ptibus liberolectus
								nonet psryroin. Amet sed lorem posuere sit iaculis amet, ac urna. Adipiscing fames
								semper erat ac in suspendisse iaculis.</p>
						</div>
					</div>

				</div>

				<div class="col-md-2">

					<div class="footer-menu">
						<h5>About Us</h5>
						<ul class="menu-list">
							<li class="menu-item">
								<a href="#">vision</a>
							</li>
							<li class="menu-item">
								<a href="#">articles </a>
							</li>
							<li class="menu-item">
								<a href="#">careers</a>
							</li>
							<li class="menu-item">
								<a href="#">service terms</a>
							</li>
							<li class="menu-item">
								<a href="#">donate</a>
							</li>
						</ul>
					</div>

				</div>
				<div class="col-md-2">

					<div class="footer-menu">
						<h5>Discover</h5>
						<ul class="menu-list">
							<li class="menu-item">
								<a href="#">Home</a>
							</li>
							<li class="menu-item">
								<a href="#">Books</a>
							</li>
							<li class="menu-item">
								<a href="#">Authors</a>
							</li>
							<li class="menu-item">
								<a href="#">Subjects</a>
							</li>
							<li class="menu-item">
								<a href="#">Advanced Search</a>
							</li>
						</ul>
					</div>

				</div>
				<div class="col-md-2">

					<div class="footer-menu">
						<h5>My account</h5>
						<ul class="menu-list">
							<li class="menu-item">
								<a href="#">Sign In</a>
							</li>
							<li class="menu-item">
								<a href="#">View Cart</a>
							</li>
							<li class="menu-item">
								<a href="#">My Wishtlist</a>
							</li>
							<li class="menu-item">
								<a href="#">Track My Order</a>
							</li>
						</ul>
					</div>

				</div>
				<div class="col-md-2">

					<div class="footer-menu">
						<h5>Help</h5>
						<ul class="menu-list">
							<li class="menu-item">
								<a href="#">Help center</a>
							</li>
							<li class="menu-item">
								<a href="#">Report a problem</a>
							</li>
							<li class="menu-item">
								<a href="#">Suggesting edits</a>
							</li>
							<li class="menu-item">
								<a href="#">Contact us</a>
							</li>
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
								<p>© 2022 All rights reserved. Free HTML Template by <a
										href="https://www.templatesjungle.com/" target="_blank">TemplatesJungle</a></p>
							</div>

							<div class="col-md-6">
								<div class="social-links align-right">
									<ul>
										<li>
											<a href="#"><i class="icon icon-facebook"></i></a>
										</li>
										<li>
											<a href="#"><i class="icon icon-twitter"></i></a>
										</li>
										<li>
											<a href="#"><i class="icon icon-youtube-play"></i></a>
										</li>
										<li>
											<a href="#"><i class="icon icon-behance-square"></i></a>
										</li>
									</ul>
								</div>
							</div>

						</div>
					</div><!--grid-->

				</div><!--footer-bottom-content-->
			</div>
		</div>
	</div>

	<script src="js/jquery-1.11.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
	<script src="js/plugins.js"></script>
	<script src="js/script.js"></script>

</body>

</html>