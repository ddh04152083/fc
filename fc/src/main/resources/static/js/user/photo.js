var username=sessionStorage.getItem("username");
var id=null;
$.ajax({
    url: "/photo/get/"+username,
    type: "get",//方法类型
    async: false,
    success: function (result) {
        id=result.id;
    },
    error: function () {

    }
});
if (id!=null) {
// console.log(username)
    $.ajax({
        url: "/photo/getPath/" + username,
        type: "get",//方法类型
        async: false,
        success: function (result) {
            if (result != null) {
                var showImg = document.getElementById('pic');
                showImg.src = result;
            }
        },
        error: function () {
            // alert("注册失败");
        }
    });
}

