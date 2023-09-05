package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.policy;
import com.example.demo.respository.policyRepo;

@Service
public class policyService 
{
@Autowired
policyRepo ps;
public policy addPolicy(policy po)
{
	return ps.save(po);
}
public List<policy> showPolicy()
{
	return ps.findAll();
}
public policy putPolicy(policy po)
{
	return ps.saveAndFlush(po);
}
public void deletePolicy(policy po)
{
	 ps.delete(po);
}
public List<policy> sortPolicy(String name)
{
	return ps.findAll(Sort.by(Sort.DEFAULT_DIRECTION,name));
}
public String deletePolicyById(String uin)
{
	if(ps.existsById(uin)) {
		ps.deleteById(uin);
		return "Policy is deleted";
	}
	else
	{
		return "Enter correct UIN  number";
	}
}
public List<policy> getdetails(String uin)
{
	return ps.getInfoPolicy(uin);
}
public List<policy> addAllPolicy(List<policy> po)
{
	return (List<policy>)ps.saveAll(po);
}
public List<policy> getpages(int pgno,int psize,String id)
{
	Sort ord=Sort.by(Sort.DEFAULT_DIRECTION,id);
	Page<policy> b=ps.findAll(PageRequest.of(pgno, psize,ord));
	return b.getContent();
}
}
