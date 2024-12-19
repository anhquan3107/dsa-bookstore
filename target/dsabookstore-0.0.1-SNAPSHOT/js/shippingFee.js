document.getElementById('district').addEventListener('change', function() {
  const district = this.value;

  if (!district) {
      document.getElementById('shipping-fee').textContent = '0';
      document.getElementById('total').textContent = '0';
      return;
  }
  fetch(`ShippingServlet?district=${encodeURIComponent(district)}`)
      .then(response => response.json())  
      .then(data => {
          if (data.shippingFee !== undefined && data.finalPrice !== undefined) {
              
              document.getElementById('shipping-fee').textContent = `$${data.shippingFee.toFixed(2)}`;
              document.getElementById('total').textContent = `$${data.finalPrice.toFixed(2)}`;
          } else {
              console.error('Invalid response format');
          }
      })
      .catch(error => {
          console.error('Error fetching shipping fee:', error);
      });
});
