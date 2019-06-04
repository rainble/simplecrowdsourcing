package cn.edu.fudan.selab.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/task")
public class SimpleTaskController {

    public static final Logger logger = Logger.getLogger(SimpleTaskController.class);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void listSimpleTask() {

    }

}