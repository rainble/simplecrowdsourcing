package cn.edu.fudan.selab.controller;


import cn.edu.fudan.selab.enums.SimpleTaskState;
import cn.edu.fudan.selab.pojo.SimpleTask;
import cn.edu.fudan.selab.service.PublishService;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/publish")
public class PublishController{

    public static final Logger logger = Logger.getLogger(PublishController.class);

    @Autowired
    PublishService publishService;

    @RequestMapping(value = "/publishtask", method = RequestMethod.POST)
    @ResponseBody
    public String publishSimpleTask(HttpServletRequest request) {
        SimpleTask simpleTask = new SimpleTask();

        int publisherId = Integer.valueOf(request.getParameter("userId"));
        simpleTask.setTaskDesc(request.getParameter("taskDesc"));
        simpleTask.setLocationDesc(request.getParameter("locationDesc"));
        simpleTask.setBonus(Integer.valueOf(request.getParameter("bonus")));
        simpleTask.setDuration(Integer.parseInt(request.getParameter("duration")));
        String callbackUrl = request.getParameter("callbackUrl");

        SimpleTaskState simpleTaskState = publishService.publishSimpleTask(simpleTask, publisherId, callbackUrl);
        logger.info(String.format("Publish simple task servlet is called successfully at [ %s ]", new Date()));
        JSONObject result = new JSONObject();
        result.put("result", simpleTaskState.toString());
        result.put("data", simpleTask.toString());
        return result.toJSONString();
    }

    @RequestMapping(value = "/listPublishedTask", method = RequestMethod.GET, produces = {
            "application/json; charset=utf-8"})
    @ResponseBody
    public String listPublishedSimpleTask() {
        return "success";
    }

}
