// $(document).ready(function() {
//     // Function to handle form submission
//     function submitForm(event) {
//         event.preventDefault(); // Prevent the default form submission
//
//         // Get form data
//         var formData = {
//             username: $("#name").val(),
//             email: $("#path").val(),
//             password: $("#ext").val()
//         };
//
//         // Send an AJAX POST request to the server
//         $.ajax({
//             type: "GET",
//             url: "http://localhost:8081/image/download/" + id, // Replace with your endpoint URL
//             contentType: "application/json",
//             data: JSON.stringify(formData),
//             success: function(response) {
//                 if (response.success) {
//                     // Redirect to a success page or display a success message
//                     alert("Image downloaded successfully!");
//                     let id = response.data.id;
//                     $.cookie("id", id);
//                     // You can perform other actions with the response data here
//                 } else {
//                     alert("Image downloading failed: " + response.message);
//                 }
//             },
//             error: function(xhr, status, error) {
//                 console.error("AJAX request failed: " + error);
//             }
//         });
//     }
//
//     // Attach the submitForm function to the form's submit event
//     $("#registrationForm").submit(submitForm);
// });
//
//
// $(document).ready(function () {
//     // Fetch product details
//     function fetchProductDetails() {
//         // Replace with your actual API endpoint
//         $.ajax({
//             type: "GET",
//             url: "http://localhost:8081/product/get/" + 1, // Endpoint to fetch product details
//             success: function (product) {
//                 let id = product.data.id;
//                 $.cookie("id", id);
//                 // Assuming 'product' is an object with name, description, price, and image properties
//                 updateProductCard(product);
//             },
//             error: function () {
//                 console.error("Failed to fetch product details.");
//                 // Handle errors here
//             }
//         });
//     }
//
//     function updateProductCard(product) {
//         // Update image
//         // $(".product-image").attr("src", product.imageUrl); // Make sure 'imageUrl' is the key in the response
//         // $(".product-image").attr("alt", product.name);
//
//         // Update text details
//         $(".product-name").text(product.name);
//         $(".product-description").text(product.description);
//         $(".product-price").text("$" + product.price);
//     }
//
//     // Fetch and display product details
//     fetchProductDetails();
// });
//


