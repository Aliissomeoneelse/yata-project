// cabinet.js

// $(document).ready(function() {
//     // Function to fetch user data and update the user information on the page
//     function fetchUserData() {
//         var userId = sessionStorage.getItem('id');
//
//         if (userId) {
//             // Make an AJAX GET request to fetch user data
//             $.ajax({
//                 type: "GET",
//                 url: "http://localhost:8081/get/" + userId, // Replace with your server endpoint
//                 success: function(response) {
//                     if (response.success) {
//                         var user = response.data;
//
//                         // Update the user information on the page
//                         $("#username").text(user.username);
//                         $("#email").text(user.email);
//                     } else {
//                         console.error("Failed to fetch user data: " + response.message);
//                     }
//                 },
//                 error: function(xhr, status, error) {
//                     console.error("AJAX request failed: " + error);
//                 }
//             });
//         }
//     }
//
//     // Call the fetchUserData function to populate user information on page load
//     fetchUserData();
// });


$(document).ready(function() {
    // Функция для отправки GET-запроса на сервер
    function getUserData() {
        let id = $.cookie('id');
        // Отправляем AJAX GET-запрос на сервер
        $.ajax({
            type: "GET",
            url: "http://localhost:8081/users/get/" + id, // Замените на ваш URL-адрес
            dataType: "json",
            success: function(response) {
                // Обработка успешного ответа от сервера
                if (response.success) {
                    // Вывод данных на странице
                    $("#username").text(response.data.username);
                    $("#email").text(response.data.email);
                    // Добавьте другие поля, если они есть
                } else {
                    alert("Failed to retrieve user data: " + response.message);
                }
            },
            error: function(xhr, status, error) {
                console.error("AJAX request failed: " + error);
            }
        });
    }

    // Вызываем функцию для получения данных при загрузке страницы
    getUserData();
});
