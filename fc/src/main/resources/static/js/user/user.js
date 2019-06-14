listAll(1)

function listAll(page) {
    $.ajax({
        url: '/data/listAll/' + page + "/" + 10,
        type: 'get',
        datatype: 'json',
        success: function (data) {
            var totalPages = data.totalPages;
            var res = data.content;
            var str = `  <thead>
        <tr>
                <th>序号</th>
            <th>user_id</th>
            <th>product_id</th>
            <th>user_review_count</th>
            <th>rating</th>
            <th>year</th>
            <th>month</th>
            <th>day</th>
            <th>label</th>
        </tr>
        </thead>
        <tbody>`;
            for (var i = 0; i < res.length; i++) {
                str = str + ` <tr>
               <td >${i + 1}</td>
            <td >${res[i].user_id}</td>
            <td >${res[i].product_id}</td>
            <td>${res[i].user_review_count}</td>
            <td>${res[i].rating}</td>
            <td >${res[i].year}</td>
            <td >${res[i].month}</td>
            <td >${res[i].day}</td>
            <td >${res[i].label}</td>
           `;
            }
            str = str + `<tbody>`;

            $("#table").html(str);
            $("#pageLimit").bootstrapPaginator({
                bootstrapMajorVersion: 3, //对应的bootstrap版本
                currentPage: page, //当前页数
                numberOfPages: 10, //每次显示页数
                totalPages: totalPages, //总页数
                shouldShowPage: true, //是否显示该按钮
                useBootstrapTooltip: true,
                onPageClicked: function (event, originalEvent, type, page) {
                    listAll(page);
                    // console.log(page);
                }
            });
        }
    })
}