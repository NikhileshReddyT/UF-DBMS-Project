package com.olist.DBMSProject.controller;

//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.olist.DBMSProject.model.TotalSalesPerMonth;
import com.olist.DBMSProject.model.TotalSalesPerYear;
//import com.olist.DBMSProject.model.Users;
//import com.olist.DBMSProject.model.orderstatus;
//import com.olist.DBMSProject.service.DashBoardRepository;
import com.olist.DBMSProject.service.TotalSalesVsTimeRepository;
//import com.olist.DBMSProject.service.UserRepository;

@Controller
public class TotalSalesVsTimeController 
{
    @Autowired
    private TotalSalesVsTimeRepository repository;
    
    @RequestMapping(value="TotalSalesVsTime", method = RequestMethod.GET)

    public ModelAndView TotalSalesVsTime() 
    {
    	ModelAndView mav = new ModelAndView("TotalSalesVsTime");
    	List<TotalSalesPerYear> SalesPerYear = repository.showSalesVsYear();
    	List<TotalSalesPerMonth> SalesPerMonth = repository.showSalesVsMonth();
    	mav.addObject("SalesYearWise", SalesPerYear);
    	mav.addObject("SalesMonthWise", SalesPerMonth);
        return mav;
    }
}
