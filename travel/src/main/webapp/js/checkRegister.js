//校验用户名 符合格式 异步校验
//校验密码 符合格式
//校验邮箱 符合格式
//校验姓名 不为空
//校验手机号 符合格式
//校验日期 符合格式 不为空
$(function () {
    //校验用户名
    $("#username").blur(checkUserName);
    //校验密码
    $("#password").blur(checkPassWord);
    //校验邮箱
    $("#email").blur(checkEmail);
    //校验姓名
    $("#name").blur(checkName);
    //校验电话
    $("#telephone").blur(checkTelePhone);
    //校验生日日期
    $("#birthday").blur(checkBirthDay);
    //校验验证码
    $("#check").keyup(checkCode);

    $("#registerForm").submit(function () {
        if (checkUserName() && checkPassWord()
            && checkEmail() && checkName() && checkTelePhone() && checkBirthDay()) {
            $.post("userServlet/register",$(this).serialize(), function (data) {
                if (data.flag) {
                    location.href = "register_ok.html";
                } else {
                    $("#errorMsg").html(data.errorMsg);
                }
            },"json");
        }
        //2.不让页面跳转
        return false;
        //如果这个方法没有返回值，或者返回为true，则表单提交，如果返回为false，则表单不提交
    });
});

//检测用户名的方法
function checkUserName() {
    var username = $("#username").val();
    var regex = /^\w{8,20}$/;
    var result = regex.test(username);
    if (result) {
        //用户名合法
        $.post("userServlet/checkName", {"username": username}, function (data) {
            if (data.flag) {
                $("#username").css("border", "green 2px solid");
            }
        }, "json");
    } else {
        //用户名不合法
        $("#username").css("border", "red 1px solid");
    }
    return result;
}

//检测密码的方法
function checkPassWord() {
    var password = $("#password").val();
    var regex = /^\w{6,12}$/;
    var result = regex.test(password);
    if (result) {
        //用户名合法
        $("#password").css("border", "");
    } else {
        //用户名不合法
        $("#password").css("border", "red 1px solid");
    }
    return result;
}

//检测邮箱的方法
function checkEmail() {
    var email = $("#email").val();
    var reg_email = /^\w+@\w+\.\w+$/;
    //3.判断
    var result = reg_email.test(email);
    if (result) {
        $("#email").css("border", "");
    } else {
        $("#email").css("border", "1px solid red");
    }
    return result;
}

//检测姓名的方法
function checkName() {
    var name = $("#name").val();
    var result = false;
    if (name != "") {
        //用户名合法
        $("#name").css("border", "");
        result = true;
    } else {
        //用户名不合法
        $("#name").css("border", "red 1px solid");
    }
    return result;
}

//检测手机号的方法
function checkTelePhone() {
    var telephone = $("#telephone").val();
    var regex = /^[1][^0124][^4]\d{8}$/;
    var result = regex.test(telephone);
    if (result) {
        //用户名合法
        $("#telephone").css("border", "");
    } else {
        //用户名不合法
        $("#telephone").css("border", "red 1px solid");
    }
    return result;
}

//检测生日的方法
function checkBirthDay() {
    var birthday = $("#birthday").val();
    var reg_birthday = /^\d{4}-\d{2}-\d{2}$/;
    //3.判断
    var result = reg_birthday.test(birthday);
    if (result) {
        $("#birthday").css("border", "");
    } else {
        $("#birthday").css("border", "red 1px solid ");
    }
    return result;
}

//校验验证码的方法
function checkCode() {
    var checkCode = $("#check").val();
    $.post("userServlet/checkCo", {"check": checkCode}, function (data) {
        if (data.flag) {
            $("#check").css("border", "green 2px solid");
        } else {
            $("#check").css("border", "red 1px solid ");
        }
    }, "json");
}
