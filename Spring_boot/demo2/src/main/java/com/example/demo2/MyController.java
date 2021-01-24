package com.example.demo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class MyController {

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception{
        return "Model & View";
    }

    @RequestMapping("/test1")    // localhost:8081/test1
    public String test1(Model model) {
        model.addAttribute("name","홍길동");
        return "test1";          // 실제 호출 될 /WEB-INF/views/test1.jsp
    }

    @RequestMapping("/test2")    // localhost:8081/test2
    public ModelAndView test2() {
        ModelAndView mv=new ModelAndView();

        List<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");

        mv.addObject("lists",list);
        mv.addObject("ObjectTest","테스트입니다.");
        mv.addObject("name","홍길동");
        mv.setViewName("sub/test2");

        return mv;
    }

}
