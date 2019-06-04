package cn.edu.fudan.selab.controller;

import cn.edu.fudan.selab.enums.SimpleTaskState;
import cn.edu.fudan.selab.service.CompleteService;
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
@RequestMapping("/complete")
public class CompleteController {

    public static final Logger logger = Logger.getLogger(CompleteController.class);

    @Autowired
    CompleteService completeService;
    /**
     * complete task interface
     * @param request
     * @return java.lang.String
     * @create 2019-05-20 10:59
    **/
    @RequestMapping(value = "/completetask", method = RequestMethod.POST)
    @ResponseBody
    public String completeSimpleTask(HttpServletRequest request) {
        int taskId = Integer.valueOf(request.getParameter("taskId"));
        SimpleTaskState simpleTaskState = completeService.completeSimpleTask(taskId);
        logger.info(String.format("Complete simple task servlet is called successfully at [ %s ]", new Date()));
        JSONObject result = new JSONObject();
        result.put("result", simpleTaskState.toString());
        return result.toJSONString();
    }

}