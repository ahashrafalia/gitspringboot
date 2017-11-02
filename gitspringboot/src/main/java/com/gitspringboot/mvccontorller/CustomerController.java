package com.gitspringboot.mvccontorller;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gitspringboot.bean.CustomerBean;
import com.gitspringboot.bean.OrderBean;
import com.gitspringboot.model.Customer;
import com.gitspringboot.model.Order;
import com.gitspringboot.service.CustomerService;
import com.gitspringboot.service.OrderService;

import java.util.Map;

@Controller
@RequestMapping("/mvc/")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	

	@Autowired
	OrderService orderService;

	@RequestMapping(value="/addCustomer",method=RequestMethod.GET)
	public String addCustomer(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("customer") CustomerBean customerBean){
		return "addCustomer";
	}
	
	@RequestMapping(value="/addCustomer",method=RequestMethod.POST)
	public String addCustomerPost(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("customer") CustomerBean customerBean){
		Customer cust=new Customer();
		cust.setFirstName(customerBean.getFirstName());
		cust.setLastName(customerBean.getLastName());
		cust.setStreet(customerBean.getStreet());
		Customer cust2=customerService.save(cust);
		System.out.println("Customer added="+cust2);
		return "addCustomer";
	}
	
	@RequestMapping(value="/addOrder",method=RequestMethod.GET)
	public String addOrder(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("order") OrderBean orderBean,ModelMap model){
		List<Customer> listCutomer=customerService.getAll();
		Map<Long,String> mapCustomer= listCutomer.stream().collect(Collectors.toMap(Customer::getCustId, Customer::getFirstName));
		model.addAttribute("mapCustomer",mapCustomer);
		return "addOrder";
	}
	
	@RequestMapping(value="/addOrder",method=RequestMethod.POST)
	public String addOrderPost(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("order") OrderBean orderBean){
		Customer cust2=customerService.getById(orderBean.getCustId());
		Order ord=new Order();
		ord.setOrderDesc(orderBean.getOrderDesc());
		ord.setOrderDt(new Date());
		ord.setTotPrice(orderBean.getTotPrice());
		ord.setUpdatedTime(new Date());
		ord.setCustomer(cust2);
		ord=orderService.save(ord);
		System.out.println("Order added="+ord);
		return "addOrder";
	}
	
}
