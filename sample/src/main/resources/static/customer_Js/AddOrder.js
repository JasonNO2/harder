var date = new Date();
var template = '<div class="row" style="margin: 10px 0px 10px 0px">' +
    '<div class="col-lg-3"><input type="text" name="goodid" class="form-control"/></div>' +
    '<div class="col-lg-3"><input type="text" name="goodname" class="form-control"/></div>' +
    '<div class="col-lg-3"><input type="number" name="goodprice" class="form-control"/></div>' +
    '<div class="col-lg-3"><input type="number" name="quantity" class="form-control"/></div>' +
    '</div>';
var billid = date.getFullYear().toString() + date.getMonth().toString() + date.getDate().toString() + date.getHours().toString() + date.getMinutes().toString() + date.getSeconds().toString();
Vue.component('detail', {
    template: template
});
var app = new Vue({
    el: "#app",
    data: {
        order: {
            billid: billid,
            total: 0,
            maker: ''
        },
        counter: 2
    },
    methods: {
        fun_submit: function () {
            var goodids = document.getElementsByName("goodid");
            var goodnames = document.getElementsByName("goodname");
            var goodprices = document.getElementsByName("goodprice");
            var quantities = document.getElementsByName("quantity");
            var order_details = [];
            for (var i = 0; i < goodids.length; i++) {
                var o = {
                    billid: this.order.billid,
                    goodid: goodids[i].value,
                    goodname: goodnames[i].value,
                    goodprice: goodprices[i].value,
                    quantity: quantities[i].value
                };
                order_details.push(o);
            }
            var data = {o: this.order, os: order_details};
            $.ajax({
                url: 'create',
                type: 'POST',
                data: JSON.stringify(data),
                contentType: "application/json;charset=UTF-8",
                dataType: 'json',
                success: function (data) {
                    if (true === data) {
                        window.location = "show";
                    } else {
                        alert("oops");
                    }
                }
            })
        },
        fun_counter: function () {
            this.counter += 1;
        }
    }
});