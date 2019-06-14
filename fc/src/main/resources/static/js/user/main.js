$().ready(function(){
    $(".list-group a").click(function(){
    //通过 .index()方法获取元素下标，从0开始，赋值给某个变量
        var _index = $(this).index();
    //让内容框的第 _index 个显示出来，其他的被隐藏
        $(".jumbotron").eq(_index).show().siblings().hide();
    //改变选中时候的选项框的样式，移除其他几个选项的样式
    $(this).addClass("active").siblings().removeClass("active");
    });
});