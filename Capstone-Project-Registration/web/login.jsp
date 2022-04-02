<%-- 
    Document   : login
    Created on : Apr 2, 2022, 11:20:07 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

    <head>
        <meta charset="utf-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="css/login.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v3.0.6/css/line.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer"
              />
    </head>

    <body>

        <!-- ---------------login-------------------- -->


        <div class="container">

            <!-- <div class="logo">
                <img src="logo.jpg" alt="LogoApp">
            </div> -->


            <header>Login</header>



            <div class="row">
                <button class="google">
                    <span>
                        <i class="fab fa-google-plus"></i>
                    </span>
                    Login with Google
                </button>
            </div>

            <div class="student">
                <a type="button" class="google" href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/Capstone-Project-Registration/LoginGoogleController&response_type=code
                   &client_id=90676323264-m344qcc3bv607iu3jttu76l9ec5g0ekt.apps.googleusercontent.com&approval_prompt=force">
                    <i class="fab fa-google-plus-square"><span>Student</span></i></a></br>  
                <h4>${requestScope.ERROR_LOGIN}</h4>
            </div>

        </div>
        <!-- ---------------------- -->

        <!-- Detect Internet Connection -->
        <!--        <div class="wrapper">
                    <div class="toast">
                        <div class="content">
                            <div class="icon"><i class="uil uil-wifi"></i></div>
                            <div class="details">
                                <span>You're online now</span>
                                <p>Hurray! Internet is connected.</p>
                            </div>
                        </div>
                        <div class="close-icon"><i class="uil uil-times"></i></div>
                    </div>
                </div>-->
        <script src="script.js"></script>
        <!-- ---------------------- -->


        <!-- -------------------------------- Logo ------------------- -->

        <div class="logo">
            <img src="img/logo.jpg" alt="LogoApp">
        </div>

        <!-- --------------------------------------------------------- -->

        <script>
            var input = document.querySelector('.pswrd');
            var show = document.querySelector('.show');
            show.addEventListener('click', active);

            function active() {
                if (input.type === "password") {
                    input.type = "text";
                    show.style.color = "#1DA1F2";
                    show.textContent = "HIDE";
                } else {
                    input.type = "password";
                    show.textContent = "SHOW";
                    show.style.color = "#111";
                }
            }
        </script>
    </body>

</html>
