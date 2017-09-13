var base, phone, password, css;


$(function () {
    css = {
        "-moz-box-shadow": "0px 0px 10px #9e020c",
        "-webkit-box-shadow": "0px 0px 10px #9e020c",
        "box-shadow": "0px 0px 10px #9e020c"
    };

    login = function (b) {
        base = b;
        yname = $(".name");
        password = $(".password");

        yname.keyup(function () {
            if ((/^1[3-9][0-9]\d{8}$/.test(yname.val()))) {
                yname.removeAttr("style");
                $(".error").html("").hide();
                return;
            }
        });

        password.keyup(function () {
            if ((/^[a-zA-Z]\w{5,17}$/.test(password.val()))) {
                password.removeAttr("style");
                $(".error").html("").hide();
                return;
            }
        });


        //登录
        $(".submit").click(function () {
            $(".error").html("").hide();
            if (!(/^[\u4E00-\u9FA5A-Za-z0-9]{2,20}$/.test(yname.val()))) {
				yname.focus().css(css);
				yname.next(".errorInfo").html("用户名格式不正确").show();
				return;
			}

            if (!(/^[a-zA-Z]\w{5,17}$/.test(password.val()))) {
                password.focus().css(css);
                $(".error").html("密码格式不正确").show();
                return;
            }
            document.forms[0].submit();

//            $.ajax({
//                type: "POST", // 用POST方式传输
//                dataType: "json", // 数据格式:JSON
//                async: true,
//                url: base + '/web/login', // 目标地址
//                data: {
//                    mobilePhone: phone.val(),
//                    password: password.val()
//                },
//                success: function (msg) {
//                    if (msg.code == 0) {
//                        window.location.href = base + "/account/trades/profit/records";
//                    } else {
//                        $(".error").html(msg.msg).show();
//                    }
//                }
//            });

        });

        $(document).keyup(function (event) {
            if (event.keyCode == 13) {
                $(".submit").trigger("click");
            }
        });
    };
});


