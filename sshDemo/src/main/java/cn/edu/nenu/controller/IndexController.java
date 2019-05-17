package cn.edu.nenu.controller;

import cn.edu.nenu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    public UserService userService;

    @RequestMapping("")
    public String Index(){
        return "/index";
    }

}
