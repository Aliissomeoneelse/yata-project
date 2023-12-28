function validateForm(event) {
    event.preventDefault();

    // Get form values
    var username = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    // Simple validation example (you can add more complex validation as needed)
    if (username === "" || email === "" || password === "") {
        alert("Please fill in all fields");
        return;
    }

    // Perform additional validation if needed

    // If all validations pass, you can submit the form or perform other actions
    alert("Form submitted successfully!");
    // You can also use AJAX to submit the form data to a server if needed
}
