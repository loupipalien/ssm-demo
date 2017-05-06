package com.ltchen.ssm.demo.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ltchen.ssm.demo.bean.User;
import com.ltchen.ssm.demo.service.UserService;

@Controller("userController")
public class UserController {
      @Autowired
      private UserService userService;
      
      @RequestMapping(value={"/","/index"})
      public String login(HttpServletRequest req, HttpServletResponse res){
            List<User> userList = userService.userList();
            req.setAttribute("userList", userList);
            return "index";
      }
}
