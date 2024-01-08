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
                    $("#created-at").text(response.data.createdAt);
                    $("#updated-at").text(response.data.updatedAt);
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