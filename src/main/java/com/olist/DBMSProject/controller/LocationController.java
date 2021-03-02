package com.olist.DBMSProject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.olist.DBMSProject.model.Location;
import com.olist.DBMSProject.model.RevenueLoacation;
import com.olist.DBMSProject.service.LocationRepository;
@Controller
public class LocationController {
    @Autowired
    public LocationRepository locationRepository;
    
    //This one is for order's location
    @RequestMapping(value="location", method = RequestMethod.GET)
    public ModelAndView Location()
    {  
	 	ModelAndView mav = new ModelAndView("location");
	 	List<Location> orderlocation=locationRepository.orderLocation();
	 	mav.addObject("orderlocation",orderlocation );
     
	 	return mav;
    }
    
    @RequestMapping(value="revenueLocation", method = RequestMethod.GET)
    public ModelAndView revenueLocation()
    {  
    	ModelAndView mav = new ModelAndView("revenueLocation");
    
    	List<RevenueLoacation> k =locationRepository.revenuelocation();
        mav.addObject("revenuelocation",k );
        
        return mav;
    }
    
    
    
    
    
    
}