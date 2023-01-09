$(function(){
    let getMessageElement = function(message) {
        let item = $('<div class="message-item"></div>');
        let header = $('<div class="message-header"></div>');
        header.append($('<div class="datetime">' + message.datetime + '</div>'));
        header.append($('<div class="username">' + message.username + '</div>'));
        let textElement = $('<div class="message-text"></div>');
        textElement.text(message.text);
        item.append(header, textElement);
        return item;
    };

    let updateMessages = function() {
        $('.messages-list').html('<i>Сообщений нет</i>');
        $.get('/message', {}, function(responce) {
            if(responce.length == 0) {
                return;
            }
            $('.messages-list').html('');
            for (i in responce) {
                let element = getMessageElement(responce[i]);
                $('.messages-list').append(element);
            }
        });
    };

    let initApplication = function() {
        $('.messages-and-users').css({display: 'flex'});
        $('.controls').css({display: 'flex'});

        $('.send-message').on('click', function(){
            let message = $('.new-message').val();
            $.post('/message', {message: message}, function(responce){
                if(responce.result) {
                    $('.new-message').val('');
                } else {
                    alert('Ошибка, повторите попытку позже.');
                }
            });
        });
        setInterval(updateMessages, 1000);
    };

    let registerUser = function(name) {
        $.post('/auth', {name: name}, function(responce) {
            if(responce.result) {
                initApplication();
            }
        });
    };

    $.get('/init', {}, function(responce){
        if(!responce.result) {
            let name = prompt('Введите ваше имя: ');
            registerUser(name);
            return;
        }
        initApplication();
    });
});