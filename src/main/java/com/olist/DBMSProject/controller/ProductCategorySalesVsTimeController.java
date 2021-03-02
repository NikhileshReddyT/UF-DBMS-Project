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

import com.olist.DBMSProject.model.CategorywiseProductSales;
import com.olist.DBMSProject.model.PdtCategorySalesPerMonth;
//import com.olist.DBMSProject.model.PdtCategorySalesPerMonth;
//import com.olist.DBMSProject.model.PdtCategorySalesPerYear;
//import com.olist.DBMSProject.model.TotalSalesPerMonth;
//import com.olist.DBMSProject.model.TotalSalesPerYear;
import com.olist.DBMSProject.service.ProductCategorySalesVsTimeRepository;
//import com.olist.DBMSProject.model.Users;
//import com.olist.DBMSProject.model.orderstatus;
//import com.olist.DBMSProject.service.DashBoardRepository;
//import com.olist.DBMSProject.service.TotalSalesVsTimeRepository;
//import com.olist.DBMSProject.service.UserRepository;

@Controller
//@RequestMapping("/user/*")
public class ProductCategorySalesVsTimeController 
{
    @Autowired
    private ProductCategorySalesVsTimeRepository repository;
    
    @RequestMapping(value="ProductCategorySalesVsTime", method = RequestMethod.GET)

    public ModelAndView TotalSalesVsTime() 
    {
    	ModelAndView mav = new ModelAndView("ProductCategorySalesVsTime");
    	List<CategorywiseProductSales> CategorywiseSalesTrend = repository.ProductCategoryVsSales();
    	
//    	for(int i = 0; i < CategorywiseSalesTrend.size(); i++)
//    		System.out.println(CategorywiseSalesTrend.get(i).getCategory());
//    	List<PdtCategorySalesPerYear> PdtCategorySalesPerYear = repository.pdtCategorySalesVsYear();
    	List<PdtCategorySalesPerMonth> PdtCategorySalesPerMonth = repository.pdtCategoryshowSalesVsMonth();
    	mav.addObject("CategorywiseSalesTrend", CategorywiseSalesTrend);
//    	mav.addObject("Sales", PdtCategorySalesPerYear);
    	mav.addObject("PdtCategorySalesVsMonth", PdtCategorySalesPerMonth);
        return mav;
    }
}
