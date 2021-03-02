package com.olist.DBMSProject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.olist.DBMSProject.model.Location;
import com.olist.DBMSProject.model.ToleranceDifference;
import com.olist.DBMSProject.service.LocationRepository;
import com.olist.DBMSProject.service.TolreanceDifferenceRepository;
@Controller
public class ToleranceDifferenceController {
    @Autowired
    public TolreanceDifferenceRepository reviewStringRepository;
    
    //List<Location> sellerlocation = locationRepository.sellerlocations();
    
//	@RequestMapping("/location")
//    public String Location()
//    {
//    	return "location";
//    }
	
    
 @RequestMapping(value="tolerence", method = RequestMethod.GET)
    public ModelAndView Location()
    {  
    ModelAndView mav = new ModelAndView("tolerence");
    //LocationRepository repository=new LocationRepository();
     List<ToleranceDifference> tolerencediff=reviewStringRepository.showReviewString();
     for(int i = 1; i < tolerencediff.size(); i++)
    	 System.out.println(tolerencediff.get(i).getX());
         mav.addObject("tolerencediff",tolerencediff );
        return mav;
    }
    
}