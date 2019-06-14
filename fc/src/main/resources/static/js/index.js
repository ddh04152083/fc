$.ajax({
    url: '/picture/getPath',
    type: 'get',
    datatype: 'json',
    success: function (res) {
        // console.log("11111111111111111111111111")
        // console.log(res)
        var str = `<div class="col-md-12">
                               <div id="carouselMenu" class="carousel slide">
                                   <ol class="carousel-indicators">`;
       str = str + `<li data-target="#carouselMenu" data-slide-to="${0}" class="active"></li>`;
        for (var i = 1; i < res.length; i++) {
            str = str + `<li data-target="#carouselMenu" data-slide-to="${i}"></li>`;
            // console.log(222222)
            // console.log(res[i])
        }
        str = str + `</ol>
                        <div id="inner" class="carousel-inner">`;
       str = str + `<div class="item active"><img style="width: 100%;height: 340px;" src="${res[0]}"
                                                         /     alt=""/>
                                                             </div>`;
        for (var i = 1; i < res.length; i++) {
            str = str + `<div class="item"><img style="width: 100%;height: 340px;" src="${res[i]}"
                                                              alt=""/>
                                                              </div>`;
            // console.log(33333)
            // console.log(res[i])
        }


        str = str + ` </div>
                                   <a class="carousel-control left" href="#carouselMenu" data-slide="prev">‹</a>
                                   <a class="carousel-control right" href="#carouselMenu" data-slide="next">›</a>
                               </div>
                           </div>
                       </div>`;
         // console.log(str)
        $("#row").html(str);
    }
})
// $("ol li:first-child").addClass("active")
// $("#inner div:first").addClass("active")
$(function () {
    /*
    * interval为每个轮播项之间的切换时间
    * wrap定义是否循环轮播
    *
    * */
    $("#carouselMenu").carousel({
        interval: 3000,
        wrap: true
    });
})

