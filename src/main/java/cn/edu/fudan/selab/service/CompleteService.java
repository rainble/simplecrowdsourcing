package cn.edu.fudan.selab.service;

import cn.edu.fudan.selab.enums.SimpleTaskState;
import cn.edu.fudan.selab.pojo.*;
import cn.edu.fudan.selab.DAO.*;
import cn.edu.fudan.selab.utils.HttpRequest;
import cn.edu.fudan.selab.utils.Parameters;
import cn.edu.fudan.selab.utils.WXMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompleteService {

    public static final Logger logger = Logger.getLogger(CompleteService.class);

    @Autowired
    SimpleTaskDAO simpleTaskDAO;

    @Autowired
    CompleteDAO completeDAO;

    @Autowired
    PublishDAO publishDAO;

    @Autowired
    AcceptDAO acceptDAO;

    // TODO: 2019-05-23 思考publish和accept表里数据要不要删除的问题

    public SimpleTaskState completeSimpleTask(int taskId) {
        Complete complete = new Complete();
        complete.setTaskId(taskId);
        if (simpleTaskDAO.querySimpleTaskByTaskId(taskId).getState() == Parameters.ACCEPT_STATE) {
            completeDAO.addCompleteSimpleTask(complete);
            simpleTaskDAO.updateSimpleTaskState(taskId, Parameters.COMPLETE_STATE);
            complete = completeDAO.queryCompletedSimpleTaskByTaskId(taskId);
            logger.info(String.format("NO.[ %d ] task is completed by NO.[ %d ] user at [ %s ]",
                    taskId, complete.getAccept().getWorkerId(), complete.getCompleteTime()));
//            acceptDAO.deleteAcceptedSimpleTask(taskId);
//            publishDAO.deletePublishedSimpleTask(complete.getAccept().getPublish().getPublishId());
            String result = HttpRequest.sendGet(complete.getAccept().getPublish().getCallbackUrl());
            logger.info(String.format("The result of send callback to process engine is [ %s ]", result));

            WXMessage.sendCompleteMessage(complete);
            return SimpleTaskState.COMPLETE;
        } else {
            logger.info(String.format(
                    "NO.[ %d ] task is already accepted by NO.[ %d ] user at [ %s ]，do not submit repeatedly",
                    taskId, acceptDAO.queryAcceptedSimpleTaskByTaskId(taskId).getWorkerId(), complete.getCompleteTime()));
            return SimpleTaskState.FAIL_COMPLETE;
        }
    }
}