<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

    <title>Bootstrap 5 Order Form</title>
  </head>
  <body class="bg-light">
    
    <div class"container">
      <div class="py-5 text-center">
       
        <h1>Checkout Form</h1>
      </div>
    </div>
    
    <div class="container">
      <div class="row">
        
        <div class="col-md-4 order-2">
          <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class=text-muted>Your Cart</span>
            <span class="badge rounded-pill bg-secondary">3</span>
          </h4>
          
          <div class="card" style="">
            <li class="list-group-item d-flex justify-content-between lh-condensed">
              <div>
                <h6 class="my-0">Product name</h6>
                <small class="text-muted">Brief description</small>
              </div>
              <span class="text-muted">$12</span>
            </li>
          </div>
          
          <li class="list-group-item d-flex justify-content-between lh-condensed">
            <div>
              <h6 class="my-0">Second product</h6>
              <small class="text-muted">Brief description</small>
            </div>
            <span class="text-muted">$8</span>
          </li>
          
          <li class="list-group-item d-flex justify-content-between lh-condensed">
            <div>
              <h6 class="my-0">Third item</h6>
              <small class="text-muted">Brief description</small>
            </div>
            <span class="text-muted">$5</span>
          </li>
          
          <li class="list-group-item d-flex justify-content-between bg-light">
            <div class="text-success">
              <h6 class="my-0">Promo code</h6>
              <small>EXAMPLECODE</small>
            </div>
            <span class="text-success">-$5</span>
          </li>
          
          
          <div class="card-footer d-flex justify-content-between">
            <span>Total (USD)</span>
            <strong>$20</strong>
          </div>
          
          <form class="card p-2">
            <div class="input-group">
              <input type="text" class="form-control" placeholder="Promo code">
              <div class="input-group-append">
                <button type="submit" class="btn btn-secondary">
                  Redeem
                </button>
              </div>
            </div>
          </form>
          
        </div>
         
        <div class="col-md-8 order-1">
          <h4 class="mb-3">Billing Address</h4>
          <div class="row">
            <div class="col mb-4">
              <label for="First name"> First Name </label>
              <input type="text" class="form-control" placeholder="First name" aria-label="First name">
            </div>
            <div class="col mb-4">
              <label for="La\st name"> Last Name </label>
              <input type="text" class="form-control" placeholder="Last name" aria-label="Last name">
            </div>
          </div>
          
          <div class="input-group col mb-4">
            <div class="input-group-text">@</div>
            <input type="text" class="form-control" placeholder="Username">
          </div>
          
          <div class="mb-4">
            <label for="email">Email (optional)</label>
            <input type="text" class="form-control" placeholder="you@example.com" aria-label="email">
        </div>
          
          <div class="mb-4">
            <label for="Address">Address</label>
            <input type="text" class="form-control" placeholder="1234 Main St" aria-label="Address">
          </div>
          
          <div class="mb-4">
            <label for="Address2">Address 2 (optional)</label>
            <input type="text" class="form-control" placeholder="Appartment or suite" aria-label="Address2">
          </div>
          
          <div class="row">
             <div class="col">
              <label for="country">Country</label>
              <select class="form-select">
      <option selected>Choose...</option>
      <option value="1">One</option>
      <option value="2">Two</option>
      <option value="3">Three</option>
    </select>
            </div>
             <div class="col">
              <label for="state">State</label>
              <select class="form-select">
      <option selected>Choose...</option>
      <option value="1">One</option>
      <option value="2">Two</option>
      <option value="3">Three</option>
    </select>
            </div>
             <div class="col mb-4">
              <label for="zip">Zip Code</label>
              <input type="text" class="form-control" aria-label="zip">
            </div>
            
            <hr class="mb-4">
            
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
              <label class="form-check-label" for="flexCheckDefault">
                Shipping address is the same as my billing address
              </label>
            </div>
            
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked">
              <label class="form-check-label" for="flexCheckChecked">
                Save this information for next time
              </label>
            </div>
            
            <hr class="mb-4">
            
            <div class="form-check">
              <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" checked>
              <label class="form-check-label" for="flexRadioDefault1">
                Credit card (Default)
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2">
              <label class="form-check-label" for="flexRadioDefault2">
                Debit card
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault3">
              <label class="form-check-label" for="flexRadioDefault3">
                Paypal
              </label>
            </div>
            
            <div class="row">
              <div class="col mb-4">
                <label for="Card1">
                  Name on card
                </label>
                <input type="text" class="form-control"aria-label="card1">
                <small class="text-muted">
                  Full name, as displayed on the card
                </small>
              </div>
              
              <div class="col mb-4">
                <label for="Card2">
                  Credit card Nummber
                </label>
                <input type="text" class="form-control" placeholder"1234-5678-9012" aria-label="Card2">
              </div>
            </div>
            
            <<div class="row">
              <div class="col mb-3">
                <label for="Card3">
                  Expiry Date
                </label>
                <input type="text" class="form-control"aria-label="card3">
              </div>
              
              <div class="col mb-3">
                <label for="Card4">
                  CVV
                </label>
                <input type="text" class="form-control"  aria-label="Card4">
              </div>
            </div>
            
          </div>
        
        <hr class="mb-4">
        
        <div class="d-grid gap-2">
          <button class="btn btn-primary btn-lg" type="button">
            Continue to Checkout
          </button>
        </div>
        
      </div>
    </div>
  </div>
    
    
    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>

    
  </body>
</html>