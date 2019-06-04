package cn.edu.fudan.selab.utils;


import cn.edu.fudan.selab.pojo.*;
import org.apache.log4j.Logger;

public class WXMessage {

    public static final Logger logger = Logger.getLogger(WXMessage.class);

    public static void sendPublishMessage(Publish publish) {

        SimpleTask simpleTask = publish.getSimpleTask();

        String SendMessageContentChinese = "这是一个 [ " + simpleTask.getTaskDesc() +"] 的任务，位于 [ "
                + simpleTask.getLocationDesc() + " ], 由 [ " + publish.getPublisherId()
                + " ] 号用户发布. 奖励有 [ " + simpleTask.getBonus() + " ]。 发布者希望能在 [ "
                + simpleTask.getDuration() + " ] 分钟内完成. 有意请点击。";

        String SendMessageContent = "This task description is [ " + simpleTask.getTaskDesc() +"]  at [ "
                + simpleTask.getLocationDesc() + " ], which is published bu user NO." + publish.getPublisherId()
                + ". Bonus is " + simpleTask.getBonus() + ". Publisher want you to finish this task in "
                + simpleTask.getDuration() + " minutes. If you want to accept this task, click please.";
        String AcceptTaskUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?";
        String AcceptTaskUrlPara = "appid=wxcb6063d8a90280c6%26redirect_uri=http%3A%2F%2Fwww.fudanse.club%2Fwm%2Fwx%2Fredirect%2Fwxcb6063d8a90280c6%2FAcceptTask"
                + simpleTask.getTaskId() + "%26response_type=code%26scope=snsapi_userinfo%26state=%26connect_redirect=1#wechat_redirect\"";

        String SendMessagePara = "content='" + SendMessageContent + "'&url=" + AcceptTaskUrl + AcceptTaskUrlPara;
        String res = null;
        res = HttpRequest.sendPost(Parameters.WXMessage_URL, SendMessagePara);
        logger.info(String.format("Send wechat [ publish ] message is [ %s ].", res));
    }

    public static void sendAcceptMessage(Accept accept) {
        Publish publish = accept.getPublish();
        SimpleTask simpleTask = publish.getSimpleTask();

        String SendMessageContentChinese = "您已接受 " + publish.getTaskId() +"] 号任务，位于 [ "
                + simpleTask.getLocationDesc() + " ], 由 [ " + publish.getPublisherId()
                + " ] 号用户发布. 奖励是 [ " + simpleTask.getBonus() + " ]。 发布者希望能在 [ "
                + simpleTask.getDuration() + " ] 分钟内完成。行动起来！";

        String SendMessageContent = "You have accepted the NO.[ " + publish.getTaskId() +"]  at [ "
                + simpleTask.getLocationDesc() + " ], which is published by NO.[ " + publish.getPublisherId()
                + " ] user. The Bonus of task is " + simpleTask.getBonus() + ". Publisher want you to finish this task in "
                + simpleTask.getDuration() + " minutes. Take action now！";

        String SendMessagePara = "userId=" + accept.getWorkerId() + "&content='" + SendMessageContent + "'&url=null";
        String res = null;
        res = HttpRequest.sendPost(Parameters.WXMessage_URL_ONE, SendMessagePara);
        logger.info(String.format("Send wechat [ accept ]message is [ %s ].", res));
    }

    public static void sendCompleteMessage(Complete complete) {

        String SendMessageContentChinese = "您已经在 [ "+ complete.getCompleteTime() +" ] 成功完成了 [ "
                + complete.getTaskId() +"] 号任务!";

        String SendMessageContent = "You have completed the NO.[ " + complete.getTaskId() +"] task successfully at [ "
                + complete.getCompleteTime() + " ]. ";
        String SendMessagePara = "userId=" + complete.getAccept().getWorkerId() + "content='" + SendMessageContent + "'&url=null";
        String res = null;
        res = HttpRequest.sendPost(Parameters.WXMessage_URL_ONE, SendMessagePara);
        logger.info(String.format("Send wechat [ complete ] message is [ %s ].", res));
    }
}
