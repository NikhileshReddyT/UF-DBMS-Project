package com.olist.DBMSProject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.olist.DBMSProject.model.Location;
import com.olist.DBMSProject.model.OrderRevenueReview;
import com.olist.DBMSProject.model.RevenueLoacation;
import com.olist.DBMSProject.model.SeasonAnalysis;
import com.olist.DBMSProject.service.LocationRepository;
import com.olist.DBMSProject.service.OrderRevenueReviewRepository;
import com.olist.DBMSProject.service.SeasonAnalysisRepository;
@Controller
public class OrderRevenueReviewController2 {
    @Autowired
    public OrderRevenueReviewRepository Repository;
    
    //List<Location> sellerlocation = locationRepository.sellerlocations();
    
//	@RequestMapping("/location")
//    public String Location()
//    {
//    	return "location";
//    }
	
    
 @RequestMapping(value="ORRR", method = RequestMethod.GET)
    public ModelAndView ORRR()
    {  
    ModelAndView mav = new ModelAndView("ORRR");
  
    List<OrderRevenueReview> k =Repository.showeachordertype();
 
    System.out.println(k.size());
    
         mav.addObject("ORRR",k );
        return mav;
    }
 
    
}