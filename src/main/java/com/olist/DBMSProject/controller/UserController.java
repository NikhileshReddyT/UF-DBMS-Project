package com.olist.DBMSProject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olist.DBMSProject.model.Users;
import com.olist.DBMSProject.service.UserRepository;

@Controller
//@RequestMapping("/user/*")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    private List<Users> user= new ArrayList<>();

    @RequestMapping("/index")
    public String index(HttpSession httpSession, Model model) {
        //httpSession.getAttribute("userLogin");
        model.getAttribute("name");
        return "index";
    }

    @RequestMapping("/LandingPage")
    public String LandingPage()
    {
    	return "LandingPage";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/login")
    public String login() {
//        String str="";
//        String username=user.get(0).getName();
//        if(username!=null) {
//        str="index";
//        }else {
//            str="login";
//        }
        return "login";
    }


    @RequestMapping("/uregister")
    public String register(HttpServletRequest request) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String str="";
        
            user=userRepository.findByName(username);
            if(user.isEmpty()) {
            	Users user=new Users();
            	user.setName(username);
            	user.setPassword(password);
            	user.setEmail(email);
            	userRepository.add(user);
            	
            	str="login";
            }else {
                str="register";
            }
            return str;
    }


    @RequestMapping("/ulogin")
    public String login(HttpServletRequest request) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        user=userRepository.findByNameAndPassword(username, password);
        String str="";
        if(!user.isEmpty()) {
//            String name = user.get(0).getName();
//            model.addAttribute("name", name);
            str="redirect:/MainPage";
        }else {
            str="login";
        }
        return str;
    }
}
