package cn.edu.fudan.selab.service;


import cn.edu.fudan.selab.enums.SimpleTaskState;
import cn.edu.fudan.selab.pojo.*;
import cn.edu.fudan.selab.DAO.*;
import cn.edu.fudan.selab.utils.Parameters;
import cn.edu.fudan.selab.utils.WXMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishService {

    public static final Logger logger = Logger.getLogger(PublishService.class);

    @Autowired
    private SimpleTaskDAO simpleTaskDAO;
    @Autowired
    private PublishDAO publishDAO;

    public SimpleTaskState publishSimpleTask(SimpleTask simpleTask, int publisherId, String callbackUrl) {
        simpleTaskDAO.addSimpleTask(simpleTask);
        Publish publish = new Publish();
        publish.setPublisherId(publisherId);
        publish.setTaskId(simpleTask.getTaskId());
        publish.setCallbackUrl(callbackUrl);
        publish.setSimpleTask(simpleTask);
        publishDAO.addPublishSimpleTask(publish);
        if (simpleTask.getTaskId() > 0) {
            simpleTaskDAO.updateSimpleTaskState(simpleTask.getTaskId(), Parameters.PUBLISH_STATE);
            WXMessage.sendPublishMessage(publish);
            logger.info(
                    String.format("SimpleTask is published successfully. The taskId is [ %d ], publisherId is [ %d ], taskDesc is [ %s ]",
                            simpleTask.getTaskId(), publisherId, simpleTask.getTaskDesc()));

            return SimpleTaskState.PUBLISH;
        } else {
            return SimpleTaskState.FAIL_PUBLISH;
        }

    }

    public List<Publish> queryPublishedSimpleTask() {
        List<Publish> list = publishDAO.listAllPublishedSimpleTask();
        return list;
    }


}
