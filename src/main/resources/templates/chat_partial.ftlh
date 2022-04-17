<#if !nullable??>
    <div id="other-user-id" class="d-none">${otherUser.id}</div>
    <div id="other-user-avatar" class="d-none">${otherUser.avatar}</div>
    <div class="top-bar">
        <div class="avatar"><p>${otherUser.username?substring(0,1)}</p></div>
        <div class="name">${otherUser.username}</div>
        <div class="menu">
            <div class="dots"></div>
        </div>
    </div>
    <div class="middle">
        <div class="voldemort p-4" id="chat-messages">
            <#list messages as message>
                <#if message.senderId == currentUser.id>
                    <div class="bubble outgoing pb-3">${message.content}</div>
                <#else>
                    <div class="bubble incoming pb-3">${message.content}</div>
                </#if>
            </#list>
        </div>
    </div>
    <div class="bottom-bar">
        <div class="chat">
            <input type="text" id="send-message" placeholder="Type a message..."/>
            <button id="send-button" type="submit" onclick="send(${otherUserId + ", \"" + otherUser.username + "\""})">
                <i
                        class="fas fa-paper-plane"></i></button>
        </div>
    </div>

    <script src="/js/chats.js"></script>
<#else>
    There is no such user
</#if>

