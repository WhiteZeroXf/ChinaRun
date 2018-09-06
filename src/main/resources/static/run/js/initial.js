
$(document).ready(function () {
    getPos();
    $("#count").hide();
});


function getPos() {
    //构造position对象
    function position(x,y)
    {
        //经度
        this.x=x;
        //纬度
        this.y=y;
    }
    var map, geolocation;
    //加载地图，调用浏览器定位服务
    map = new AMap.Map('container', {
        resizeEnable: true,
        zoom:20
    });
    map.plugin('AMap.Geolocation', function() {
        geolocation = new AMap.Geolocation({
            enableHighAccuracy: true,//是否使用高精度定位，默认:true
            timeout: 10000,          //超过10秒后停止定位，默认：无穷大
            zoomToAccuracy: true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
            convert:false,
            showButton:false,
            panToLocation:false
        });
        map.addControl(geolocation);
        hideCopy();
        geolocation.getCurrentPosition();
        AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
        AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
    });
    //解析定位结果
    function onComplete(data) {
        //中心点偏移
        map.panTo(new AMap.LngLat(data.position.getLng(),data.position.getLat()-0.001));
    }
    //解析定位错误信息
    function onError(data) {
        alert("定位失败");
    }
}

$("#add").on("click",function () {
    getPos();
});

$("#be").on("click",function () {
    $("#first").hide();
    $("#count").show();
    var ssecond = 3;
    function time() {
        $(".count").html(ssecond);
        ssecond=ssecond-1;
        if (ssecond===0){
            window.location.href = "Running.html";
        }
    }
    setInterval(time,1000);
});

function hideCopy() {
    $(".amap-logo").hide();
    $(".amap-copyright").hide();
    $(".amap-mcode").hide();
    $(".amap-copyright").html("");
    $(".amap-mcode").html("");
}