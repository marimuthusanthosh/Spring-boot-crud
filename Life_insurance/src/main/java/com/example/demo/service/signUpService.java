package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.signUp;
import com.example.demo.respository.signUpRepo;

@Service
public class signUpService {
@Autowired
signUpRepo sur;
public signUp saveSignUpInfo(signUp su)
{
	return sur.save(su);
}
public List<signUp> showSignUpInfo()
{
	return sur.findAll();
}
public signUp putSignUpInfo(signUp su)
{
	return sur.saveAndFlush(su);
}
public void deleteSignUpInfo(signUp su)
{
	sur.delete(su);
}
public List<signUp> sortSignUp(String s)
{
	return sur.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
}
public String deleteById(String email)
{
	if(sur.existsById(email)) {
		sur.deleteById(email);
		return "SignUp details deleted";
	}
	else
	{
		return "Invalid email id";
	}
}
public List<signUp> getInfoSign(String email,String password)
{
	return sur.getInfoSignUp(email,password);
}
public String putSignUpById(String email,signUp su)
{
	if(sur.existsById(email))
	{
		sur.saveAndFlush(su);
		return "Updated";
	}
	else
	{
		return "Enter valid Id";
	}
}
public List<signUp> saveAllInfo(List<signUp> su)
{
	return (List<signUp>)sur.saveAll(su);
}
public List<signUp> sortpage(int pageno,int pagesize,String id)
{
	Sort ord=Sort.by(Sort.DEFAULT_DIRECTION,id);
	Page<signUp> b=sur.findAll(PageRequest.of(pageno, pagesize, ord));
	return b.getContent();
}
}