//输出6
var a = 5 && 6;
console.log(a);
//输出false
var b = false && 6;
console.log(b);
//输出6
var c = false || 6;
console.log(c);
//输出true
var d = true || 6;
console.log(d);

//输出undefined
var e;
var f = e && 6;
console.log(f);

//输出6
var g;
var h = g || 6;
console.log(h);

//输出undefined
var i, j;
var k = i || j;
console.log(k);

document.getElementById("input1").onblur=function () {
    alert(isNaN(document.getElementById("input1").value))
};

var app = new Vue({
    el:'#app',
});