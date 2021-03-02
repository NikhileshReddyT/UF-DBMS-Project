package com.olist.DBMSProject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.olist.DBMSProject.model.Location;
import com.olist.DBMSProject.model.RevenueLoacation;
import com.olist.DBMSProject.model.SeasonAnalysis;
import com.olist.DBMSProject.service.LocationRepository;
import com.olist.DBMSProject.service.SeasonAnalysisRepository;
@Controller
public class SeasonAnalysisController {
    @Autowired
    public SeasonAnalysisRepository Repository;
    
    //List<Location> sellerlocation = locationRepository.sellerlocations();
    
//	@RequestMapping("/location")
//    public String Location()
//    {
//    	return "location";
//    }
	
    
 @RequestMapping(value="Seasonal", method = RequestMethod.GET)
    public ModelAndView Seasonal()
    {  
    ModelAndView mav = new ModelAndView("Seasonal");
  
    List<SeasonAnalysis> k =Repository.showrankwiseorder();
    List<SeasonAnalysis> k1=Repository.showeachordertype();
    System.out.println(k.size());
    
         mav.addObject("SeasonAnalysis",k );
         mav.addObject("showeachordertype", k1);
        // mav.addObject("sellerlocation", sellerlocation);
        return mav;
    }
 
    
}