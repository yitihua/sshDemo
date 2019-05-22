package cn.edu.nenu.controller;

import cn.edu.nenu.domain.Dict;
import cn.edu.nenu.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    public DictService dictService;

    @RequestMapping("")
    public String Index(Model model){
        List<Dict> dicts = dictService.findAll();
        model.addAttribute("dictList",dicts);
        return "/index";
    }

}
