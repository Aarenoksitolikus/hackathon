<html>

<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <meta name="description" content="Login - Register Template">
    <meta name="author" content="Lorenzo Angelino aka MrLolok">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/assets/main.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <style>
        body {
            background-color: #F2F2F2;
        }
    </style>
</head>

<body>
<div id="container-login">
    <div id="title">
        <a href="chat_page.ftlh">
            <button id="register-link">Авторизация</button>
        </a>
    </div>

    <form method="post" action="/login">
        <div class="input">
            <div class="input-addon">
                <i class="material-icons">face</i>
            </div>
            <input id="username" name="username" placeholder="Кулланучының исеме" type="text" required class="validate"
                   autocomplete="off">
        </div>

        <div class="clearfix"></div>

        <div class="input">
            <div class="input-addon">
                <i class="material-icons">vpn_key</i>
            </div>
            <input id="password" name="password" placeholder="Пароль" type="password" required class="validate"
                   autocomplete="off">
        </div>

        <div class="remember-me">
            <input type="checkbox" id="remember_me" name="remember_me">
            <span style="color: #757575">Истә калдырырга</span>
        </div>

        <input id="register-link" type="submit" class="btn btn-outline-primary px-4" value="Авторизация">
    </form>

    <div class="register">
        <span style="color: #657575">Сезнең аккаунтыгыз юкмы әле?</span>
        <a href="/signup">
            <button id="register-link">Регистрация</button>
        </a>
    </div>
</div>
</body>

</html>
