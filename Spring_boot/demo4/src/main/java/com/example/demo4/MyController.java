package com.example.demo4;

import com.example.demo4.jdbc.MyUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @Autowired
    private MyUserDAO userDao;

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception{
        return "JdbcTEmplate 사용하기";
    }

    //@GetMapping("/user")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userlistPage(Model model) {
        model.addAttribute("users", userDao.list());
        return "userlist";
    }

}
