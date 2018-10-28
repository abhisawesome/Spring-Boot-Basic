package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import transferClass.CustomerTransfer;

@RestController
public class Controller {

	@Autowired
	CustomerRepo cust;
	@Autowired
	CustomerService cuser;
	
	@RequestMapping("/save")
	public String process()
	{
		
		cust.save(new Customer(5,"Abhijith","V"));
		cust.save(new Customer(4,"Abh","asd"));
		return "Done";
	}
	
	
	@RequestMapping(value="/saveCust/",method=RequestMethod.POST)
	public ResponseEntity<String>saveAcustomer(@RequestBody Customer customerTransfer)
	{
		if(cuser.count(customerTransfer)==true)
		{
			return new ResponseEntity<String>("Cant save",HttpStatus.BAD_REQUEST);
		}
		else
		{
			cust.save(customerTransfer);
			return new ResponseEntity<String>("Saved Succefully",HttpStatus.ACCEPTED);
		}
		
	}
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public ResponseEntity<Customer> getDetails(@PathVariable("id") long id)
	{
		String s="Accepted";
		
		
		if(cust.findById(id).equals(null))
		{
			
			return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
				
		}
		else
		{
			
			 Customer cu=cust.getOne(id);
			 return new ResponseEntity<Customer>(cu,HttpStatus.ACCEPTED);
			
			
		}
			
		
		
	}
	
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public ResponseEntity<List<Customer>>getAllDetails()
	{
		List<Customer> obj=cuser.getDetailsOfCustomer();
		
		return new ResponseEntity<List<Customer>>(obj,HttpStatus.ACCEPTED);
	}

	
	
		
	
	
	
}
