package com.olist.DBMSProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.olist.DBMSProject.model.Location;
import com.olist.DBMSProject.model.ProductDelayPercentage;
import com.olist.DBMSProject.model.SellerDelay;
import com.olist.DBMSProject.service.DeliveryTimeAnalysisRepository;

@Controller
public class DeliveryTimeAnalysisController {

	@Autowired
	private DeliveryTimeAnalysisRepository repository;
	
	@RequestMapping(value="DeliveryTimeAnalysis", method = RequestMethod.GET)
	public ModelAndView DeliveryAnalysis()
	{
		ModelAndView mav = new ModelAndView("DeliveryTimeAnalysis");
		List<ProductDelayPercentage> productDelayPercentage = repository.showProductDelayPrecentage();
		List<SellerDelay> sellerDelay = repository.showSellerDeliveryDelay();
		

		mav.addObject("productDelayPercentage", productDelayPercentage);
		mav.addObject("sellerDelay", sellerDelay);
		return mav;
	}
	
	@RequestMapping(value="DeliveryDelayMap", method = RequestMethod.GET)
	public ModelAndView DeliverDelayMap()
	{
		ModelAndView mav = new ModelAndView("DeliveryDelayMap");
		List<Location> delayLocation = repository.showDelayOrder();
		
		mav.addObject("delayLocation", delayLocation);
		
		return mav;
	}
	
	
	
}
