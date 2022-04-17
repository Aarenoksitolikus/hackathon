<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Чаты</title>
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.0.13/css/all.css'>
    <link href="https://netdna.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/style.css">
    <link rel="shortcut icon"
          href="https://avatars.mds.yandex.net/get-images-cbir/1780765/YsrctO5AJ50pc5CFxhgIJw546/ocr"
          type="image/x-icon">

    <#assign username = user.username>
    <#assign id = user.id>
</head>
<body>

<div class="container">
    <div class="chatbox" id="chat-partial"></div>

    <div class="messages"></div>

    <div class="profile">
        <div class="avatar"><p>${username?substring(0,1)}</p></div>
        <div class="name2">${username}<p class="email">${profile.firstName + " " + profile.lastName}</p></div>
    </div>

    <ul class="people">
        <#if chats??>
            <#list chats as contact>
                <#if user.id == contact.senderId>
                    <#assign userId = contact.recipientId>
                    <#assign userUsername = contact.recipientUsername>
                <#else>
                    <#assign userId = contact.senderId>
                    <#assign userUsername = contact.senderUsername>
                </#if>
                <li class="person" id="contact-${userId}">
                    <span class="title"><#if contact.senderId = id>${contact.recipientUsername}<#else>${contact.senderUsername}</#if></span>
                </li>
            </#list>
        </#if>
    </ul>
</div>

<div id="current-user-id" class="d-none">${id}</div>
<div id="current-user-username" class="d-none">${username}</div>
<div id="current-user-avatar" class="d-none">${user.avatar}</div>
<!-- partial -->
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
<script src="/script.js"></script>
<script src="/chats.js"></script>

</body>
</html>
