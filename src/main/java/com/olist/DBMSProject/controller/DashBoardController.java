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
import org.springframework.web.servlet.ModelAndView;

import com.olist.DBMSProject.model.Users;
import com.olist.DBMSProject.model.orderstatus;
import com.olist.DBMSProject.service.DashBoardRepository;
import com.olist.DBMSProject.service.UserRepository;

@Controller
public class DashBoardController {
    @Autowired
    private DashBoardRepository repository;

    private List<Users> user= new ArrayList<>();

 
    
    @RequestMapping(value="MainPage", method = RequestMethod.GET)
    public ModelAndView dashboard() {
    	ModelAndView mav = new ModelAndView("MainPage");
    	 int l=repository.showtotalorders();
    	 mav.addObject("noorder", l);
//         System.out.println(l+"jyotik");
         List<orderstatus> orders=repository.showorderstatus();
         float a=repository.showrepeatrate();
         double b = 4.2;
         for(int i=1;i<orders.size();i++) {
        	 
        	 System.out.println(orders.get(i).getOrders()+"  "+orders.get(i).getStatus());
         }
         mav.addObject("orderstatus", orders);
         mav.addObject("repeatrate",a);
         mav.addObject("reviewScore", b);
        return mav;
    }

}
