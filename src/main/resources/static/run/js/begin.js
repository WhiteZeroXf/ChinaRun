$(document).ready(function () {
    //获得subjectId
    var subject = localStorageToObj("subject");
    $('#milage').append(subject["mileageFinish"]);
    $('#totalKm').append(subject["mileageTotal"]);
    $('.up-title').append(subject["title"]);
    getTop3User();
    getTopic();
});

function getTop3User() {
    var subjectId = localStorageToObj("subject").subjectId;
    myAjax("/run/getTop3User",{"subjectId":subjectId},function (data) {
        for(var i =0;i<3;i++){
            var u = "#user"+i;
            var h = "#head"+i;
            var headImg = "../"+data[i].headImg;
            $(u).append(data[i].username+"刚刚结束了跑步");
            $(h).attr("src", headImg);

        }
    });
}

function getTopic() {
    var topicId = localStorageToObj("subject").topicId;
    myAjax("/topic/getTopicById",{"topicId":topicId},function (data) {
        objToLocalStorage("topic",data);
    });

}

