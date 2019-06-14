function register() {

    var username=$("#reg_username").val();
    var password=$("#reg_password").val();
    var repassword=$("#repassword").val();
    var data={
        "username":username,
        "password":password,
        "repassword":repassword
    }
    console.log(data)
    if (password != '' && username != '' && repassword!='') {
        $.ajax({

            type: "POST",//方法类型
            url: "/log/register",
            contentType: "application/json; charset=utf-8",
            // dataType: "json",
            async: false,
            data: JSON.stringify(data),
            success: function (result) {
                console.log(result)
                if (result == "yes") {
                    alert("注册成功请登录！");
                    window.location.href = "index.html";
                } else if (result == "no") {
                    alert("注册失败！");
                    window.location.href = "index.html";
                }

            },
            error: function () {
                alert("注册失败");
            }
        });

    }
    else {
        alert("账号密码不能为空！！！");
    }

}
