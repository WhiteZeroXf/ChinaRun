document.write("<script language=javascript src='js/md5.js'><\/script>");

var path = "http://localhost";
$(function () {
    $('#img-black').on("click", function () {
        history.go(-1);
    });
});

function back() {
    history.go(-1);
}

/**
 * 将对象以键值对的形式存到本地
 * @param name
 * @param obj
 */
function objToLocalStorage(name, obj) {
    var str = JSON.stringify(obj);
    localStorage.setItem(name, str);
}

/**
 * 将存在本地的对取出
 * @param name
 * @returns {any}
 */
function localStorageToObj(name) {
    var obj = JSON.parse(localStorage.getItem(name));
    if (name === 'user') {
        if (!obj) {
            window.location.href = "login.html";
        }
    }
    return obj;
}

/**
 * 取出URL地址中对应的键的值(GET)
 * @param name
 * @returns {*}
 */
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

/**
 * 封装的 Ajax
 * @param url 请求的服务器的 url 地址
 * @param data 需要上传到服务器的数据，json 格式，无数据时填：{}
 * @param callback 请求成功之后要执行的函数
 * @param flag 是否异步请求,可以为空, 默认异步
 */
function myAjax(url, data, callback, flag) {
    data.token = hex_md5(url + localStorageToObj("userToken"));
    data.userToken = localStorageToObj("userToken");
    $.ajax({
        type: "POST",
        url: path + url,
        data: data,
        dataType: "json",
        async: flag && true,
        success: function (result) {
            if (result.code === 1) {//请求成功
                if (callback)
                    callback(result.data);
                return;
            }
            if (result.code === 5) {//需要登陆，用户未登录或登录过期
                //alert(path + "用户未登录");
                window.location.href = result.data.url;
                return;
            }
            if (result.code === 52) {//用户名密码错误
                alert(path + "用户名密码错误");
                return;
            }
            alert("服务器内部错误 " + path + result.code + " " + result.msg);
        },
        error: function () {
            alert("服务器请求失败:" + path + url);
            return null;
        }
    });
}
