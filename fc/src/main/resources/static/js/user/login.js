function login(event) {
    event.preventDefault();
    var username = $("#username").val();
    var password = $("#password").val();
    var type=$('#select').val();

    var data = {
        "username": username,
        "password": password,
        "type":type
    }
    // $.cookie("username",username,{expires:1});
    // $.cookie("password",password,{expires:1});
    data = JSON.stringify(data);
    if (username != '' && password != '') {
        var xmlhttp;
        if (window.XMLHttpRequest) {
            //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
            xmlhttp = new XMLHttpRequest();
        } else {
            // IE6, IE5 浏览器执行代码
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                console.log(xmlhttp.responseText);


                if (xmlhttp.responseText == "NOREGISTER") {
                    alert("您没有注册,请注册！");

                    window.location.href = "index.html";
                } else {
                    // if(xmlhttp.responseText == "SUCCESS"){
                    //     alert("账号密码错误！")
                    // }
                    var result = xmlhttp.responseText;

                    console.log(result);
                    if (result == 'admin') {
                        alert("登陆成功!");
                        sessionStorage.setItem('username',username);
                        window.location.href = "main.html";
                    } else if(result=="user"){
                        sessionStorage.setItem('username',username);
                        window.location.href="user.html"
                    } if (result == 'no') {
                        alert("登录失败!");
                        window.location.href = "index.html";

                    }
                }
            }

        }

        xmlhttp.open("POST", "/log/login", true);
        xmlhttp.setRequestHeader("Content-type", "application/json; charset=utf-8");
        xmlhttp.send(data);
    } else {
        alert("请输入用户名和密码");
    }
}