package cn.edu.nenu.controller;

import cn.edu.nenu.domain.Dict;
import cn.edu.nenu.service.DictService;
import cn.edu.nenu.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/dict")
public class DictController {
    @Autowired
    public DictService dictService;

    @RequestMapping("")
    public String Index(){
        return "/dict";
    }

    @PostMapping("/create")
    public String create(ServletRequest request, RedirectAttributes redirectAttributes){
        Dict newDict = new Dict();

        newDict.setCode(request.getParameter("code"));
        newDict.setType(request.getParameter("type"));
        newDict.setName(request.getParameter("name"));
        float sort = dictService.getMaxSort();
        newDict.setSort(sort+1);
        newDict.setStatus(Constants.Status.ENABLE);
        dictService.save(newDict);
        redirectAttributes.addFlashAttribute("message","创建数据字典成功");
        return "redirect:/dict/";
     }

    @GetMapping(value = "update/{id}")
    public String updateForm(@PathVariable("id") Long pkId, Model model){
        Dict dict = dictService.findOne(pkId);
        model.addAttribute("dict",dict);
        model.addAttribute("action","update");
        return "dict/dictForm";
    }

    @PostMapping(value = "update")
    public String update(@Valid Dict dict, RedirectAttributes redirectAttributes){
        Long pkId = dict.getId();
        Dict newDict = dictService.findOne(pkId);
        newDict.setType(dict.getType());
        newDict.setCode(dict.getCode());
        newDict.setName(dict.getName());

        dictService.save(newDict);
        redirectAttributes.addFlashAttribute("message","更改数据字典成功");
        return  "redirect:/dict/";

    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long pkId, RedirectAttributes redirectAttributes){
        System.out.println("aaaaa");
        String message = "删除字典成功";
        try{
            dictService.remove(pkId);
        }catch (Exception e){
            message = "删除字典失败，该字典被使用";
        }
        redirectAttributes.addFlashAttribute("message",message);
        return "redirect:/index/";

    }
}
