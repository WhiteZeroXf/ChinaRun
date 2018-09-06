//公共对象

function Comment(commentId,userId,flashId,supportSum,commentTime,content) {
    this.commentId = commentId;
    this.userId = userId;
    this.flashId = flashId;
    this.supportSum = supportSum;
    this.commentTime = commentTime;
    this.content = content;
}

function Fans(fansId,userId,userFansId,createTime) {
    this.fansId = fansId;
    this.userId = userId;
    this.userFansId = userFansId;
    this.createTime = createTime;
}

function Flash(flashId,userId,subjectId,topicId,title,supportSum,commentSum,media,publishTime,pointId,content) {
    this.flashId = flashId;
    this.userId = userId;
    this.subjectId = subjectId;
    this.topicId = topicId;
    this.title = title;
    this.supportSum = supportSum;
    this.commentSum = commentSum;
    this.media = media;
    this.publishTime = publishTime;
    this.pointId = pointId;
    this.content = content;
}

function FlashCommentLog(flashCommentLogId,userId,type,typeId,createTime) {
    this.flashCommentLogId = flashCommentLogId;
    this.userId = userId;
    this.type = type;
    this.typeId = typeId;
    this.createTime = createTime;
}

function Inform(informId,type,typeId,userId,reason,createTime) {
    this.informId = informId;
    this.type = type;
    this.typeId = typeId;
    this.userId = userId;
    this.reason = reason;
    this.createTime = createTime;
}

function Join(joinId,subjectId,userId,joinTime) {
    this.joinId = joinId;
    this.subjectId = subjectId;
    this.userId = userId;
    this.joinTime = joinTime;
}

function MsgSystem(mstSystemId,userId,content,state,createTime) {
    this.mstSystemId = mstSystemId;
    this.userId = userId;
    this.content = content;
    this.state = state;
    this.createTime = createTime;
}

function MsgUser(msgUserId,userId,type,typeId,state,createTime,content) {
    this.msgUserId = msgUserId;
    this.userId = userId;
    this.type = type;
    this.typeId = typeId;
    this.state = state;
    this.createTime = createTime;
    this.content = content;
}

function Point(pointId,runId,lng,lat,type,createTime) {
    this.pointId = pointId;
    this.runId = runId;
    this.lng = lng;
    this.lat = lat;
    this.type = type;
    this.createTime = createTime;
}

function Run(runId,userId,subjectId,totalMileage,totalTime,startPointId,endPointId,startTime,endTime) {
    this.runId = runId;
    this.userId = userId;
    this.subjectId = subjectId;
    this.totalMileage = totalMileage;
    this.totalTime = totalTime;
    this.startPointId = startPointId;
    this.endPointId = endPointId;
    this.startTime = startTime;
    this.endTime = endTime;
}

function Subject(subject_id,title,topicId,img,mileageTotal,mileageFinish,personSum,userId,startTime,finishTime,pointId,state,content) {
    this.subjectId = subject_id;
    this.title = title;
    this.topicId = topicId;
    this.img = img;
    this.mileageTotal = mileageTotal;
    this.mileageFinish = mileageFinish;
    this.personSum = personSum;
    this.userId = userId;
    this.startTime = startTime;
    this.finishTime = finishTime;
    this.pointId = pointId;
    this.state = state;
    this.content = content;
}

function Topic(topicId,topicName,personSum) {
    this.topicId = topicId;
    this.topicName = topicName;
    this.personSum = personSum;
}

function User(userId,username,password,gender,age,birthday,headImg,sign,fansSum,follwSum,contributeHours,contributeSum,messageSum) {
    this.userId = userId;
    this.username = username;
    this.password = password;
    this.gender = gender;
    this.age = age;
    this.birthday = birthday;
    this.headImg = headImg;
    this.sign = sign;
    this.fansSum = fansSum;
    this.follwSum = follwSum;
    this.contributeHours = contributeHours;
    this.contributeSum = contributeSum;
    this.messageSum = messageSum;
}