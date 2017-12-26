package org.jason.controller;


import org.jason.serviceImpl.PeopleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

@Controller
@RequestMapping("people")
public class PeopleController {
    @Resource
    private PeopleServiceImpl peopleServiceImpl;
    private Logger logger = LoggerFactory.getLogger(PeopleController.class);
    @RequestMapping("findAll")
    public String findAll(Model model) {
        logger.info("获取people表所有数据");
        model.addAttribute("name", "Jason");
        model.addAttribute("people", peopleServiceImpl.findAll());
        return "hello";
    }
}
