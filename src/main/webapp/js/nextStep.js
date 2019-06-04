$(document).ready(function () {
    getId();
});

// 调用方法和变量初始化的顺序有问题？

var processinstanceId;
var workerId;
var firstStep;

function getId() {
    $.ajax({
        url: "http://localhost:8081/simplecrowdsourcing_war_exploded/process/getId",
        type: "get",
        async: false,
        error: function (xhr, status, errorThrown) {
            console.log("Error: " + errorThrown);
            console.log("Status: " + status);
            console.log(xhr);
        },
        success: function (json) {
            // count++;
            var process = JSON.parse(json);
            processinstanceId = process.processinstanceId;
            workerId = process.workerId;
            firstStep = process.firstStep;
        }
    });
    
}


function nextStep(userId) {
    console.log("next step js function is called");
    $.ajax({
        url: "http://192.168.1.194:8084/smartLab/iffullclosed",
        type: "post",
        date:"{\"processInstanceId\"=" + processinstanceId + "}",
        async: false,
        error: function (xhr, status, errorThrown) {
            console.log("Error: " + errorThrown);
            console.log("Status: " + status);
            console.log(xhr);
        },
        success: function (json) {
            // count++;
            var tmpJson = JSON.parse(json);
            var stepDesc = tmpJson.stepDesc;
            $("#taskDesc").text(stepDesc);
        }
    });
}