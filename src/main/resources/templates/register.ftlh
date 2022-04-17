<!DOCTYPE html>
<html>
<#import "/spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <meta name="description" content="Login - Register Template">
    <meta name="author" content="Lorenzo Angelino aka MrLolok">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/assets/main.css">
    <link rel="stylesheet" href="/templates/assets/main.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <style>
        body {
            background-color: #F2F2F2;
        }
    </style>
</head>

<body>
    <div id="container-register">
        <div id="title">
            <i class="material-icons lock">lock</i> Регистрация
        </div>

        <@spring.bind "userForm"/>
        <form method="post" action="/signup">
            <div class="input">
                <div class="input-addon">
                    <i class="material-icons">email</i>
                </div>
                <@spring.formInput "userForm.email" "class='validate' placeholder='Email' required autocomplete='off'"/>
            </div>

            <div class="clearfix"></div>

            <div class="input">
                <div class="input-addon">
                    <i class="material-icons">face</i>
                </div>
                <@spring.formInput "userForm.username" "class='validate' placeholder='Кулланучының исеме' required autocomplete='off'"/>
            </div>

            <div class="clearfix"></div>

            <div class="input">
                <div class="input-addon">
                    <i class="material-icons">vpn_key</i>
                </div>
                <@spring.formPasswordInput "userForm.password" "class='validate' placeholder='Пароль' reqiured"/>
            </div>

            <div class="input">
                <div class="input-addon">
                    <i class="material-icons">vpn_key</i>
                </div>
                <@spring.formPasswordInput "userForm.passwordCheck" "class='validate' placeholder='Тагын бер тапкыр пароль' required"/>
            </div>

            <div class="remember-me">
                <input type="checkbox" id="remember_me" name="remember_me">
                <span style="color: #757575">Истә калдырырга</span>
            </div>

            <input type="submit" value="Register" />
        </form>

        <div class="register">
            <span style="color: #657575">Сезнең аккаунтыгыз бармы инде?</span>
            <a href="/login"><button id="register-link">Авторизация</button></a>
        </div>
    </div>
</body>

</html>
