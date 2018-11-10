$(function () {
    //校验用户名
    $("#username").blur(checkName);
    //校验密码
    $("#password").blur(checkPassword);
    //校验验证码
    $("#check").keyup(checkCode);


    $("#login").click(function () {
        if (checkName() && checkPassword()) {
            $.post("userServlet/login",$("#loginForm").serialize(),function (data) {
                if(data.flag){
                    //登录成功
                    location.href="index.html";
                }else{
                    //登录失败
                    $("#errorMsg").html(data.errorMsg);
                }
            },"json");
        }
    });


    $.post("userServlet/echoData",{},function (data) {

        if(data != null){
            alert(data.userName);
            $("#username").prop("value",data.userName);
        }
    },"json");
});

//校验验证码的方法
function checkCode() {
    var checkCode = $("#check").val();
    $.post("userServlet/checkCo", {"check": checkCode}, function (data) {
        if (data.flag) {
            $("#errorMsg").html("");
        } else {
            $("#errorMsg").html("验证码错误");
        }
    }, "json");
}

function checkName() {

    var checkName = $("#username").val();
    var result = true;
    if (checkName == "") {
        $("#errorMsg").html("用户名或密码为空");
        result = false;
    } else {
        $("#errorMsg").html("");
    }
    return result;
}

function checkPassword() {
    var checkPassword = $("#password").val();
    var result = true;
    if (checkPassword == "") {
        $("#errorMsg").html("用户名或密码为空");
        result = false;
    }
    else {
        $("#errorMsg").html("");
    }
    return result;
}