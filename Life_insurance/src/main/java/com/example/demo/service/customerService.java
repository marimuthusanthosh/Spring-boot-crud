package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.customer;
import com.example.demo.respository.customerRepo;

@Service
public class customerService 
{
	@Autowired 
	customerRepo cr;  
	public customer addCustomer(customer cu) 
	{
		return cr.save(cu);
	}
	public List<customer> showCustomer()
	{
		return cr.findAll();
	}
	public customer putCustomer(customer cu)
	{
		return cr.saveAndFlush(cu);
	}
	public void deleteCustomer(customer cu)
	{
		cr.delete(cu);
	}
	public void deleteid(String email)
	{
		cr.deleteById(email);
	}
	public List<customer> sortCustomer(String s)
	{
		return cr.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
	}
	public String deleteCustomerByID(String email)
	{
		if(cr.existsById(email))
		{
			cr.deleteById(email);
			return "Customer details deleted";
		}
		else
		{
			return "Enter correct email";
		}
	}
	public List<customer> getdetails(String email,String name)
	{
		return cr.getInfo(email, name);
	}
	public List<customer> addAllCustomer(List<customer> cu)
	{
		return (List<customer>)cr.saveAll(cu);
	}
	public List<customer> getpage(int pgno,int psize,String id)
	{
		Sort ord=Sort.by(Sort.DEFAULT_DIRECTION,id);
		Page<customer> b=cr.findAll(PageRequest.of(pgno, psize,ord));
		return b.getContent();
	}
}
