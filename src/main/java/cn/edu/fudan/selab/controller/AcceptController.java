package cn.edu.fudan.selab.controller;

import cn.edu.fudan.selab.enums.SimpleTaskState;
import cn.edu.fudan.selab.service.AcceptService;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Controller
@RequestMapping("/accept")
public class AcceptController {

    public static final Logger logger = Logger.getLogger(AcceptController.class);

    @Autowired
    AcceptService acceptService;

    @RequestMapping(value = "/accepttask", method = RequestMethod.GET)
    public String acceptSimpleTask(HttpServletRequest request) {
        int workerId = Integer.valueOf(request.getParameter("userId"));
        int taskId = Integer.valueOf(request.getParameter("taskId"));
        SimpleTaskState simpleTaskState = acceptService.acceptSimpleTaskService(taskId, workerId);
        logger.info(String.format("Accpet simple task servlet is called successfully at [ %s ]", new Date()));
        JSONObject result = new JSONObject();
        result.put("result", simpleTaskState.toString());
        return "TaskProcess";
    }


}