package com.olist.DBMSProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.olist.DBMSProject.model.ToleranceDifference;
import com.olist.DBMSProject.service.TupleRepository;

@Controller
public class TupleController {

	@Autowired
    public TupleRepository tupleRepository;
	
	
	 @RequestMapping(value="tupleNum", method = RequestMethod.GET)
	    public ModelAndView Location()
	    {  
	    ModelAndView mav = new ModelAndView("tupleNum");
	    //LocationRepository repository=new LocationRepository();
	     List<ToleranceDifference> tuple=tupleRepository.showTuple();
	     for(int i = 1; i < tuple.size(); i++)
	    	 System.out.println(tuple.get(i).getX());
	     mav.addObject("Tuple",tuple );
	     return mav;
	    }
	
}
