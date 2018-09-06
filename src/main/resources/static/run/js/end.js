$(document).ready(function () {

    getHeadImg();
    setData();
    ifLast();
});

//###########################最后一名检测开始####################

function ifLast(){
    var subject = localStorageToObj("subject");
    $("#sub").html(subject.title);
    var run = localStorageToObj("run");
    var t1 = Number(subject.mileageTotal);
    var f1 = Number(subject.mileageFinish);
    var t2 = Number(run.totalMileage);
    var t3 = f1+t2;
    subject.mileageFinish=t3;
    if(t1>t3) {
        $(".lightup").show();
        subject.state=2;
    }
    myAjax("/run/finishRun",JSON.parse(JSON.stringify(run)),function (data) {
        
    },false);
    myAjax("/subject/finishSubject",JSON.parse(JSON.stringify(subject)),function (data) {
        //alert(JSON.stringify(subject));
    },false);
}

//###########################最后一名检测开始####################


//###########################点击事件开始########################

//点击相机按钮
$(".came").on("click",function () {
    alert("开发中");
});

//点击分享按钮
$(".share").on("click",function () {
    alert("开发中");
});

$(".lightup").on("click",function () {
    $(".lightup").hide();
});
//###########################点击事件结束########################

//###########################头像显示开始########################

function getHeadImg() {
    var user = localStorageToObj("user");
    var headImg = "../"+user.headImg;
    $('#headImg').attr("src", headImg);
}

//###########################头像显示结束########################

//###########################数据填入开始########################

function setData() {
    var subject = localStorageToObj("subject");
    var run = localStorageToObj("run");
    var topic = localStorageToObj("topic");
    $(".milage-down").html(run.totalMileage+"<span>Km</span>"+"<span style='font-size: 15px;position:relative;left: 1.5rem;'><a href='../index.html'>返回首页>></a></span>");
    $(".topic-des").html("#"+topic.topicName+"#");
    $(".title-des").html(subject.title);
    getRoad(run);
}

//###########################数据填入结束########################

//###########################定位地图绘制开始########################

//###############获取后台坐标开始##########################

function getRoad(run){
    myAjax("/run/putPoses", {"runId":run.runId}, function(data){
        data = dataToPath(data);
        draw(data);
        objToLocalStorage("run",run);
    });
}

//###############获取后台坐标结束##########################

function dataToPath(data) {
    var path = new Array();
    $.each(data,function (i,n) {
        path.push(new AMap.LngLat(this.lng,this.lat));
    });
    return path;
}

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

//###########################定位地图绘制结束########################


function hideCopy() {
    $(".amap-logo").hide();
    $(".amap-copyright").hide();
    $(".amap-mcode").hide();
    $(".amap-copyright").html("");
    $(".amap-mcode").html("");
    $(".amap-logo").html("");
}