// Function to update the cart via Fetch API
function updateCart(bookId, action) {
    fetch("UpdateCartServlet", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: `bookId=${encodeURIComponent(bookId)}&action=${encodeURIComponent(action)}`
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            if (action === "delete") {
                // Remove the cart item from the table
                document.getElementById(`cart-item-${bookId}`).remove();
            } else {
                // Update the quantity and total price
                document.getElementById(`quantity-${bookId}`).textContent = data.newQuantity;
            }
            // Update total price
            document.getElementById("total-price").textContent = `$ ${data.totalPrice.toFixed(2)}`;
        } else {
            alert("Failed to update cart: " + data.message);
        }
    })
    .catch(error => {
        console.error("Error:", error);
        alert("An error occurred while updating the cart.");
    });
}


document.addEventListener("DOMContentLoaded", function () {
    // For quantity increment and decrement buttons
    document.querySelectorAll(".quantity-btn").forEach(button => {
        button.addEventListener("click", function () {
            const bookId = this.getAttribute("data-book-id");
            const action = this.getAttribute("data-action");
            updateCart(bookId, action);
        });
    });


    document.querySelectorAll(".delete-btn").forEach(button => {
        button.addEventListener("click", function () {
            const bookId = this.getAttribute("data-book-id");
            updateCart(bookId, "delete");
        });
    });
});


document.getElementById("undo-btn").addEventListener("click", function () {
    fetch("UpdateCartServlet?action=undo", {
        method: "POST"
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert("Undo successful! Item restored.");
            location.reload(); 
        } else {
            alert("No actions to undo.");
        }
    })
    .catch(error => {
        console.error("Error:", error);
        alert("An error occurred while undoing.");
    });
});


