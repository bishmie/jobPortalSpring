$(document).ready(function () {
    $('#signupForm').submit(function (e) {
        e.preventDefault();

        var username = $('#registerUsername').val();
        var email = $('#registerEmail').val();
        var password = $('#registerPassword').val();
        var accountType = $("input[name='accountType']:checked").val();

        var userData = {
            username: username,
            email: email,
            password: password,
            accountType: accountType
        };

        $.ajax({
            url: 'http://localhost:8090/users/register',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(userData),
            success: function (response) {
                // Show SweetAlert on success
                Swal.fire({
                    title: 'Success!',
                    text: 'User registered successfully!',
                    icon: 'success',
                    confirmButtonText: 'OK'
                });
            },
            error: function (xhr, status, error) {
                // Show SweetAlert on error
                Swal.fire({
                    title: 'Error!',
                    text: 'There was an error: ' + xhr.responseText,
                    icon: 'error',
                    confirmButtonText: 'Try Again'
                });
            }
        });
    });
});






$(document).ready(function () {
    $("#loginForm").submit(function (event) {
        event.preventDefault();

        let email = $("#loginEmail").val().trim();
        let password = $("#loginPassword").val().trim();

        if (!email || !password) {
            Swal.fire("Oops...", "Please fill all fields!", "warning");
            return;
        }
        if (!validateEmail(email)) {
            Swal.fire("Invalid Email", "Enter a valid email address.", "error");
            return;
        }
        if (password.length < 6) {
            Swal.fire("Weak Password", "Password must be at least 6 characters.", "error");
            return;
        }

        console.log("Sending:", { email, password });

        $.ajax({
            url: "http://localhost:8090/users/login",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({ email, password }),
            success: function (response) {
                console.log("Response:", response);
                if (response.code === 201) {
                    Swal.fire({
                        icon: "success",
                        title: "Login Successful",
                        text: "Redirecting...",
                        showConfirmButton: false,
                        timer: 2000
                    }).then(() => {
                        window.location.href = "dashboard.html";
                    });
                } else {
                    Swal.fire("Login Failed", "Invalid email or password.", "error");
                }
            },
            error: function (xhr) {
                console.log("Error:", xhr.responseText);
                Swal.fire("Login Failed", "Check your email and password.", "error");
            }
        });
    });

    function validateEmail(email) {
        let regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return regex.test(email);
    }
});




