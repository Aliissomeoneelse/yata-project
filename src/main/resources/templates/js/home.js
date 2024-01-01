$(document).ready(function() {
    // Function to handle form submission
    function submitForm(event) {
        event.preventDefault(); // Prevent the default form submission

        // Get form data
        var formData = {
            username: $("#username").val(),
            email: $("#email").val(),
            password: $("#password").val()
        };

        // Send an AJAX POST request to the server
        $.ajax({
            type: "POST",
            url: "http://localhost:8081/users/create", // Replace with your endpoint URL
            contentType: "application/json",
            data: JSON.stringify(formData),
            success: function(response) {

                if (response.success) {
                    // Redirect to a success page or display a success message
                    alert("User created successfully!");
                    let id = response.data.id
                    $.cookie("id", id);
                    // window.location.href="get.html"
                    // You can add a redirection here if needed
                } else {
                    alert("User creation failed: " + response.message);
                }
            },
            error: function(xhr, status, error) {
                console.error("AJAX request failed: " + error);
            }
        });
    }

    // Attach the submitForm function to the form's submit event
    $("#registrationForm").submit(submitForm);
});