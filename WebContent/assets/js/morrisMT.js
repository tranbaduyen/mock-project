$(function () {
 
    getMorris('donut', 'donut_chart');
});

function getMorris(type, element) {
     if (type === 'donut') {
        Morris.Donut({
            element: element,
            data: [{
                label: 'Sự Kiện',
                value: 50
            }, {
                    label: 'Nhân Vật',
                    value: 40
                }, {
                    label: 'Địa Danh',
                    value: 5
                }, {
                    label: 'Câu Chuyện',
                    value: 5
                }],
            colors: ['rgb(233, 30, 99)', 'rgb(0, 188, 212)', 'rgb(255, 152, 0)', 'rgb(0, 150, 136)'],
            formatter: function (y) {
                return y + '%'
            }
        });
    }
}