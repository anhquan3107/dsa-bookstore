const form = document.querySelector("form"),
  nameField = form.querySelector(".name-field"),
  nameInput = nameField.querySelector(".fullName"),
  usernameField = form.querySelector(".username-field"),
  usernameInput = usernameField.querySelector(".username"),
  phoneField = form.querySelector(".phone-field"),
  phoneInput = phoneField.querySelector(".phone"),
  addressField = form.querySelector(".address-field"),
  addressInput = addressField.querySelector(".address"),
  emailField = form.querySelector(".email-field"),
  emailInput = emailField.querySelector(".email"),
  passField = form.querySelector(".create-password"),
  passInput = passField.querySelector(".password"),
  cPassField = form.querySelector(".confirm-password"),
  cPassInput = cPassField.querySelector(".cPassword");


function checkName() {
  if (nameInput.value.trim() === "") {
    return nameField.classList.add("invalid");
  }
  nameField.classList.remove("invalid");
}


function checkUsername() {
  if (usernameInput.value.trim().length < 5) {
    return usernameField.classList.add("invalid");
  }
  usernameField.classList.remove("invalid");
}


function checkPhone() {
  const phonePattern = /^[0-9]{10}$/; 
  if (!phoneInput.value.match(phonePattern)) {
    return phoneField.classList.add("invalid");
  }
  phoneField.classList.remove("invalid");
}


function checkAddress() {
  if (addressInput.value.trim() === "") {
    return addressField.classList.add("invalid");
  }
  addressField.classList.remove("invalid");
}


function checkEmail() {
  const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
  if (!emailInput.value.match(emailPattern)) {
    return emailField.classList.add("invalid");
  }
  emailField.classList.remove("invalid");
}


const eyeIcons = document.querySelectorAll(".show-hide");

eyeIcons.forEach((eyeIcon) => {
  eyeIcon.addEventListener("click", () => {
    const pInput = eyeIcon.parentElement.querySelector("input");
    if (pInput.type === "password") {
      eyeIcon.classList.replace("bx-hide", "bx-show");
      return (pInput.type = "text");
    }
    eyeIcon.classList.replace("bx-show", "bx-hide");
    pInput.type = "password";
  });
});


function createPass() {
  const passPattern =
    /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

  if (!passInput.value.match(passPattern)) {
    return passField.classList.add("invalid");
  }
  passField.classList.remove("invalid");
}


function confirmPass() {
  if (passInput.value !== cPassInput.value || cPassInput.value === "") {
    return cPassField.classList.add("invalid");
  }
  cPassField.classList.remove("invalid");
}


  nameInput.addEventListener("keyup", checkName);
  usernameInput.addEventListener("keyup", checkUsername);
  phoneInput.addEventListener("keyup", checkPhone);
  addressInput.addEventListener("keyup", checkAddress);
  emailInput.addEventListener("keyup", checkEmail);
  passInput.addEventListener("keyup", createPass);
  cPassInput.addEventListener("keyup", confirmPass);
  
form.addEventListener("submit", (e) => {
  e.preventDefault();
  checkName();
  checkUsername();
  checkPhone();
  checkAddress();
  checkEmail();
  createPass();
  confirmPass();

  // If all fields are valid, submit form
  if (
    !nameField.classList.contains("invalid") &&
    !usernameField.classList.contains("invalid") &&
    !phoneField.classList.contains("invalid") &&
    !addressField.classList.contains("invalid") &&
    !emailField.classList.contains("invalid") &&
    !passField.classList.contains("invalid") &&
    !cPassField.classList.contains("invalid")
  ) {
	form.submit();
  }
});
