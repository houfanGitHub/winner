package com.item.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.FinanceProductFunds;

@Controller
@RequestMapping("/Yx")
public class Yx_Subject_Controller {
    @Autowired
	private Yx_Subject_Controller yx_FinanceProductFunds_Services;
    
    @RequestMapping("/list")
    public String list(){
    	return null;
    }
}
