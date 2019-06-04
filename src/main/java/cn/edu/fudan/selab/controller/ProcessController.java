package cn.edu.fudan.selab.controller;

import cn.edu.fudan.selab.pojo.Process;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/process")
public class ProcessController {

    public static final Logger logger = Logger.getLogger(Process.class);

    private Process process = new Process();

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public void getProcessId(HttpServletRequest request) {

        process.setProcessInstanceId(Integer.valueOf(request.getParameter("processInstanceId")));
        process.setWorkerId(Integer.valueOf(request.getParameter("workerId")));
        process.setFirstStep(request.getParameter("firstStep"));
        logger.info(String.format("Get process info successfully with processInstanceId [ %d ] and workerId [ %d ]", process.getProcessInstanceId(), process.getWorkerId()));

    }

    @RequestMapping(value = "/getId", method = RequestMethod.GET)
    @ResponseBody
    public String getId() {

        JSONObject result = new JSONObject();
        result.put("processInstanceId", process.getProcessInstanceId());
        result.put("workerId", process.getWorkerId());
        result.put("firstStep", process.getFirstStep());
        return result.toJSONString();

    }

}
