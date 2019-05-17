package cn.edu.nenu.controller;

import cn.edu.nenu.domain.User;
import cn.edu.nenu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;

@Controller
@RequestMapping("/create")
public class LoginController {
    @Autowired
    public UserService userService;


    @PostMapping("")
    public String Login(Model model, ServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.getUser(username,password);
        if(user!=null){
            model.addAttribute(user);
            return "/welcome";
        }
        else{
            return "/fail";
        }


    }
}
