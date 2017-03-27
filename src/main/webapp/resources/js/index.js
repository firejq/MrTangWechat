$(document).ready(function(){
    $("#main_panel").load("page/main.jsp");
    $("#first_menu").click(function(){
        $("#main_panel").load("page/main.jsp");
    });
    $("#order_menu").click(function(){
        $("#main_panel").load("page/redirect.jsp");
    });
    $("#mine_menu").click(function(){
        $("#main_panel").load("page/mine.jsp");
    });
});
$(document).ready(function(e) {
    var counter = 0;
    if (window.history && window.history.pushState) {
        $(window).on('popstate', function () {
            window.history.go(1 - window.history.length);
        });
    }
});
function changeToMain()
{
    document.getElementById("first_menu").className="weui-tabbar__item weui-bar__item_on";
    document.getElementById("order_menu").className="weui-tabbar__item";
    document.getElementById("mine_menu").className="weui-tabbar__item";
}
function changeToOrder()
{
    document.getElementById("order_menu").className="weui-tabbar__item weui-bar__item_on";
    document.getElementById("mine_menu").className="weui-tabbar__item";
    document.getElementById("first_menu").className="weui-tabbar__item";
}
function changeToMine()
{
    document.getElementById("mine_menu").className="weui-tabbar__item weui-bar__item_on";
    document.getElementById("order_menu").className="weui-tabbar__item";
    document.getElementById("first_menu").className="weui-tabbar__item";
}

