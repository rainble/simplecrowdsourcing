package cn.edu.fudan.selab.service;


import cn.edu.fudan.selab.DAO.*;
import cn.edu.fudan.selab.enums.SimpleTaskState;
import cn.edu.fudan.selab.pojo.*;
import cn.edu.fudan.selab.utils.HttpRequest;
import cn.edu.fudan.selab.utils.Parameters;
import cn.edu.fudan.selab.utils.WXMessage;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AcceptService {

    public static final Logger logger = Logger.getLogger(AcceptService.class);


    @Autowired
    private AcceptDAO acceptDAO;
    @Autowired
    private SimpleTaskDAO simpleTaskDAO;
    @Autowired
    private PublishDAO publishDAO;

//    public int processId;
//    public int instanceId;

    public SimpleTaskState acceptSimpleTaskService(int taskId, int workerId) {
        Accept accept = new Accept();
        accept.setWorkerId(workerId);
        accept.setTaskId(taskId);
        Publish publish = publishDAO.queryPublishedSimpleByTaskId(taskId);
        accept.setPublish(publish);

        if (simpleTaskDAO.querySimpleTaskByTaskId(taskId).getState() == 1) {
            synchronized (this) {
                int res = acceptDAO.addAcceptSimpleTask(accept);
                logger.info(String.format("the auto-increment primary key of this accept is [ %d ]", res));
                simpleTaskDAO.updateSimpleTaskState(taskId, Parameters.ACCEPT_STATE);
                String postPara = "serviceId=Human_Machine_Thing#2_GetCoffeeService&userId=" + publish.getPublisherId() + "&workerId="+ workerId + "&taskId=" + taskId +"&taskName=众包辅助接咖啡";
                String result = HttpRequest.sendPost(Parameters.SEND_BPMN_TO_BROKER, postPara);
//
//                JSONObject process = JSON.parseObject(result);
//                processId = process.getInteger("processId");
//                instanceId = process.getInteger("instanceId");

                logger.info(String.format("The result of send bpmn to broker is [ %s ]", result));

//                publishDAO.deletePublishedSimpleTask(accept.getPublish().getPublishId());
            }
            logger.info(String.format("NO.[ %d ] task is accepted by NO.[ %d ] user at [ %s ]", taskId, workerId, new Date()));
            WXMessage.sendAcceptMessage(accept);
            return SimpleTaskState.ACCEPT;
        } else {
            logger.info(String.format("NO.[ %d ] task is already accepted by NO.[ %d ] user at [ %s ]", taskId, accept.getWorkerId(), accept.getAcceptTime()));
            return SimpleTaskState.FAIL_ACCEPT;
        }
    }

    public List<Accept> listAcceptedSimpleTaskByWorkerId(int workerId) {
        List<Accept> list = acceptDAO.listAcceptedSimpleTaskByWorkerId(workerId);
        return list;
    }

    public List<Accept> listAcceptedSimpleTaskByPublisherId(int publisherId) {
        List<Accept> list = acceptDAO.listAcceptedSimpleTaskByUserId(publisherId);
        return list;
    }

}
