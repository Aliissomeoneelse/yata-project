document.addEventListener("DOMContentLoaded", function () {
    var searchInput = document.querySelector('.search-input');
    var searchButton = document.querySelector('.search-button');
    var searchHeaderButton = document.querySelector('.search-header-button'); // Add this line to select the header search button

    // Add an event listener to the header search button
    searchHeaderButton.addEventListener('click', function () {
        var searchTerm = searchInput.value;
        alert('You searched for: ' + searchTerm);
        // You can add more code here to perform the actual search action.
        // For example, you can redirect the user to a search results page.
    });

    // The existing event listener for the main search button remains unchanged.
    searchButton.addEventListener('click', function () {
        var searchTerm = searchInput.value;
        alert('You searched for: ' + searchTerm);
    });
});

document.addEventListener("DOMContentLoaded", function () {
    var userId = sessionStorage.getItem('userId');
    if (userId) {
        // Fetch the user's data based on their ID and update the username in the header
        $.ajax({
            type: "GET",
            url: "http://localhost:8081/users/" + userId, // Replace with your endpoint URL
            success: function (response) {
                if (response.success) {
                    var userUsername = response.data.username;
                    $("#userUsername").text(userUsername);
                } else {
                    console.error("Failed to fetch user data: " + response.message);
                }
            },
            error: function (xhr, status, error) {
                console.error("AJAX request failed: " + error);
            }
        });
    }
});