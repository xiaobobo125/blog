function checkEmail(email){
    var myReg=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
    if(myReg.test(email)){
        return true;
    }else{
        return false;
    }
}
function checkFormat(password,user,email,user_confim) {
    var msg = $("#errorMsg");
    if (user == "") {
        msg.text("用户名不可为空!");
        return false;
    }if(user.length < 3){
        msg.text("用户名的最小长度为3！");
        return false;
    } else if (password == "" || user_confim == "") {
        msg.text("密码不可为空!");
        return false;
    }else if(password.length < 6){
        msg.text("密码的最小长度为6！");
        return false;
    }else if(password != user_confim){
        msg.text("密码与确认密码不一致！");
        return false;
    }else if (email == ""){
        msg.text("邮箱不能为空!");
        return false;
    }else if(!checkEmail(email)) {
        msg.text("邮箱格式不正确");
        return false;
    }
    return true;
}
$("#submit-btn").click(function () {
    var msg = $("#errorMsg");
    var email = $("#user_email").val();
    var user = $("#user_login").val();
    var password = $("#user_pass").val();
    var user_confim = $("#user_confim").val();
    if(checkFormat(password,user,email,user_confim)){
        $.ajax({
            async: false,//同步，待请求完毕后再执行后面的代码
            type: "POST",
            url: '/registVerify',
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            data: $("#registform").serialize(),
            dataType: "json",
            success: function (data) {
                if(data.code==0) {
                    msg.text(data.msg);
                } else {
                    window.location.href="/login";
                }
            },
            error: function () {
                msg.text("数据获取失败")
            }
        })
    }
})