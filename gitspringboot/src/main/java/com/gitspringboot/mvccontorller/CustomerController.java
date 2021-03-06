package com.gitspringboot.mvccontorller;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gitspringboot.bean.CustomerBean;
import com.gitspringboot.bean.OrderBean;
import com.gitspringboot.model.Customer;
import com.gitspringboot.model.Invoice;
import com.gitspringboot.model.Order;
import com.gitspringboot.service.CustomerService;
import com.gitspringboot.service.OrderService;
import com.gitspringboot.validation.CustomerValidator;

import java.util.Map;

@Controller
@RequestMapping("/mvc/")
public class CustomerController {
	
	private static final Logger log = LoggerFactory
			.getLogger(CustomerController.class);

	@Autowired
	ApplicationContext appCtx;
	
	@Autowired
	CustomerService customerService;
	
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	CustomerValidator customerValidator;
	
	@InitBinder
	public void dataBinding(WebDataBinder binder){
		binder.addValidators(customerValidator);
	}

	@RequestMapping(value="/addCustomer",method=RequestMethod.GET)
	public String addCustomer(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("customer") CustomerBean customerBean){
		log.info("Add Customer is invoked-info appCtx="+appCtx);
		log.error("Add Customer is invoked-error");
		return "addCustomer";
	}
	
	@RequestMapping(value="/addCustomer",method=RequestMethod.POST)
	public String addCustomerPost(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("customer") @Valid CustomerBean customerBean,BindingResult result){
		if(result.hasErrors()){
			return "addCustomer";
		}
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
		
		Invoice inv=new Invoice();
		inv.setAmountDue(1000-ord.getTotPrice());
		inv.setOrder(ord);
		inv.setOrderCancelledDt(new Date());
		inv.setOrderRaisedDt(new Date());
		inv.setOrderSettledDt(new Date());
		inv.setUpdatedTime(new Date());
		
		ord.setInvoice(inv);
		ord=orderService.save(ord);
		System.out.println("Order added="+ord);
		return "addOrder";
	}
	
	@RequestMapping(value="/findCustomer",method=RequestMethod.GET)
	public String findCustomerPost(HttpServletRequest request, HttpServletResponse response
			){
		Customer cust2=customerService.getById(2l);
		System.out.println("Customer found="+cust2);
		return "home";
	}
	
}
