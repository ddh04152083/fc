if (sessionStorage.getItem("username") == null) {
    alert("对不起，您已退出，请重新登录");
    window.location.href="index.html";
}