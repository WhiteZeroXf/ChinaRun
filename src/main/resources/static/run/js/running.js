//###############主要事件开始##############################

$(document).ready(function () {

    //获取subject对象
    var subject = localStorageToObj("subject");
    //获取user对象
    var user = localStorageToObj("user");
    //新建run对象
    var run = new Run(0,user.userId,subject.subjectId,0,"0",1);

    $(".three").hide();
    $("#first").hide();
    newRun(run);
    Reset();
    startPos();
    start();
    getPosAdd();

    hideCopy();
});

//###############主要事件结束##############################

//###############开始跑步后台生成run对象开始###############

function newRun(run){
    myAjax("/run/newRun", JSON.parse(JSON.stringify(run)), function (data) {
        objToLocalStorage("run",data);
    });
}

//###############开始跑步后台生成run对象结束###############

//###############获取后台坐标开始##########################

function getRoad(){
    var run = localStorageToObj("run");
    myAjax("/run/putPoses", {"runId":run.runId}, function(data){
        data = dataToPath(data);
        draw(data);
        var dis = distance(data);
        $("#mail").html(dis);
        run.totalMileage = dis;
        objToLocalStorage("run",run);
    });
}

//###############获取后台坐标结束##########################

//###############控件切换方法开始##########################

$("#zt").on("click",function () {
    $(".two").hide();
    $(".three").show();
    stop();
    getRoad();
    stopPos();
});

$("#be").on("click",function () {
    $(".two").show();
    $(".three").hide();
    start();
    startPos();
});

//结束事件
$("#end").on("click",function () {
    //计时器暂停
    stop();
    stopPos();
    //跳转到下一页面
    window.location.href="End.html";
});

//定位
$("#add").on("click",function () {
    getPosAdd();
});

//###############控件切换方法结束##########################



//###############时间计时器正计时方法开始##################

var hour,minute,second;//时 分 秒
hour=minute=second=0;//初始化
var int;
function Reset()//重置
{
    window.clearInterval(int);
    hour=minute=second=0;
    $("#time").append('00:00:00');
}

function start()//开始
{
    int=setInterval(timer,1000);
}

function timer()//计时
{
    second=second+1;
    if(second>=60)
    {
        second=0;
        minute=minute+1;
    }

    if(minute>=60)
    {
        minute=0;
        hour=hour+1;
    }

    var t = temp(hour)+':'+temp(minute)+':'+temp(second);
    $("#time").html(t);
}

function stop()//暂停
{
    window.clearInterval(int);
    var run = localStorageToObj("run");
    run["totalTime"] = temp(hour)+':'+temp(minute)+':'+temp(second);
    objToLocalStorage("run",run);
}

function temp(t) {
    if(t<10){
        return "0"+t;
    }
    return t;
}

//###############时间计时器正计时方法结束##################

//#####################描绘轨迹开始########################

//将json数据转弯LngLat类型数据
function dataToPath(data) {
    var path = new Array();
    $.each(data,function (i,n) {
        path.push(new AMap.LngLat(this.lng,this.lat));
    });
    return path;
}

//轨迹描绘
function draw(data) {
    //创建地图

    var map = new AMap.Map('container', {
        resizeEnable: true,
        zoom:20
    });

    AMapUI.load(['ui/misc/PathSimplifier', 'lib/$'], function(PathSimplifier, $) {

        if (!PathSimplifier.supportCanvas) {
            alert('当前环境不支持 Canvas！');
            return;
        }
        //启动页面
        initPage(PathSimplifier);

    });

    function initPage(PathSimplifier){
        var pathSimplifierIns = new PathSimplifier({
            zIndex: 100,
            map: map, //所属的地图实例
            getPath: function(pathData, pathIndex) {
                //返回轨迹数据中的节点坐标信息，[AMap.LngLat, AMap.LngLat...] 或者 [[lng|number,lat|number],...]
                return pathData.path;
            },
            renderOptions: {
                //轨迹线的样式
                pathLineStyle: {
                    strokeStyle: 'red',
                    lineWidth: 6,
                    dirArrowStyle: true
                }
            }
        });


        pathSimplifierIns.setData([{
            name: '轨迹0',
            path: data //后台传来经过转换的数据
        }]);
        //选中路线0
        pathSimplifierIns.setSelectedPathIndex(0);
    }

    hideCopy();
}
//总距离转为公里
function distance(data) {
    var dis = 0.00;
    for(var i=0;i<data.length-1;i++){
        dis = dis + AMap.GeometryUtil.distance(data[i],data[i+1]);
    }
    dis = dis/1000;
    dis = dis.toFixed(2);
    return dis;
}

//#####################描绘轨迹结束########################


//#####################获取坐标开始########################

function getPos() {
    var geolocation;
    geolocation = new AMap.Geolocation({
        enableHighAccuracy: true,//是否使用高精度定位，默认:true
        timeout: 10000,          //超过10秒后停止定位，默认：无穷大
        convert:false
    });
    geolocation.getCurrentPosition();
    AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
    //解析定位结果
    function onComplete(data) {
        var run = localStorageToObj("run");
        var point = new Point();
        point.runId = run.runId;
        point.lat = data.position.getLat();
        point.lng = data.position.getLng();
        point.type = 1;
        myAjax("/run/getNowPos", JSON.parse(JSON.stringify(point)), function (data) {

        });
    }
}

//#####################获取坐标结束########################

//#####################获取定位开始########################

function getPosAdd() {
    //构造position对象
    function position(lng,lat)
    {
        //经度
        this.lng=lng;
        //纬度
        this.lat=lat;
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
        geolocation.getCurrentPosition();
        AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
        AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
    });
    //解析定位结果
    function onComplete(data) {
        var run = localStorageToObj("run");
        var point = new Point();
        point.runId = run.runId;
        point.lat = data.position.getLat();
        point.lng = data.position.getLng();
        point.type = 1;
        myAjax("/run/getNowPos", JSON.parse(JSON.stringify(point)), function (data) {

        });
    }
    //解析定位错误信息
    function onError(data) {
        alert("定位失败");
    }
}

//#####################获取定位开始########################

//#####################坐标计时器开始######################

var intPos;
function startPos()//开始
{
    intPos=setInterval(getPos,5000);
}

function stopPos()//暂停
{
    window.clearInterval(intPos);
}

//#####################坐标计时器结束######################

function hideCopy() {
    $(".amap-logo").hide();
    $(".amap-copyright").hide();
    $(".amap-mcode").hide();
    $(".amap-copyright").html("");
    $(".amap-mcode").html("");
    $(".amap-logo").html("");
}