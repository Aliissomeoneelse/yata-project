$(document).ready(function () {
    // Function to handle login form submission
    function submitLoginForm(event) {
        event.preventDefault(); // Prevent the default form submission

        // Get form data
        var loginData = {
            email: $("#loginEmail").val(),
            password: $("#loginPassword").val()
        };

        // Send an AJAX POST request to the server for login
        $.ajax({
            type: "POST",
            url: "http://localhost:8081/users/login", // Replace with your login endpoint URL
            contentType: "application/json",
            data: JSON.stringify(loginData),
            success: function (response) {
                if (response.success) {
                    // Successful login, perform actions like redirecting or showing a success message
                    alert("Login successful!");
                    // Redirect to the user dashboard or another page
                    // window.location.href = "dashboard.html";
                } else {
                    alert("Login failed: " + response.message);
                }
            },
            error: function (xhr, status, error) {
                console.error("AJAX request failed: " + error);
            }
        });
    }

    // Attach the submitLoginForm function to the login form's submit event
    $("#loginForm").submit(submitLoginForm);
});
