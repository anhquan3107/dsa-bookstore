document.addEventListener("DOMContentLoaded", function () {
        const cartInfo = document.getElementById("cartInfo");

        const addToCartButtons = document.querySelectorAll(".add-to-cart");
        addToCartButtons.forEach((button) => {
            button.addEventListener("click", function () {

				const bookId = button.getAttribute("data-book-id");
                const bookPrice = button.getAttribute("data-book-price");
				console.log("Book ID:", bookId);
				console.log("Book Price:", bookPrice)

                fetch("AddToCartServlet", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/x-www-form-urlencoded",
                    },
                    body: `bookId=${encodeURIComponent(bookId)}&bookPrice=${encodeURIComponent(bookPrice)}`,
                })
                .then((response) => response.json())
                .then((data) => {
                    cartInfo.textContent = `Cart: (${data.totalItems} items - $${data.totalPrice.toFixed(2)})`;
                })
                .catch((error) => console.error("Error:", error));
            });
        });
    });