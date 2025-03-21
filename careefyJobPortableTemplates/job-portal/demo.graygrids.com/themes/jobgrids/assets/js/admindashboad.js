$(document).ready(function () {
    // Fetch users from backend
    $.ajax({
        url: 'http://localhost:8090/users/getAll',
        type: 'GET',
        success: function (response) {
            let users = response; // Assuming the response is an array of users
            let tableBody = $('#userTable tbody');
            tableBody.empty(); // Clear any existing rows

            users.forEach(function (user, index) {
                let row = `
            <tr>
              <td>${index + 1}</td>
              <td>${user.username}</td>
              <td>${user.email}</td>
              <td>${user.accountType}</td>
            </tr>
          `;
                tableBody.append(row);
            });
        },
        error: function (error) {
            console.error('Error fetching users:', error);
        }
    });
});


$(document).ready(function () {
    // Fetch total user count from backend
    $.ajax({
        url: 'http://localhost:8090/users/totalUsers', // Backend API to get count
        type: 'GET',
        success: function (count) {
            $('#totalUsers').text(count.toLocaleString()); // Format with commas
        },
        error: function (error) {
            console.error('Error fetching total users:', error);
            $('#totalUsers').text('N/A'); // Show "N/A" if there's an error
        }
    });
});