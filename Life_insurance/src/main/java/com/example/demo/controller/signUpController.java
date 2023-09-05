package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.signUp;
import com.example.demo.service.signUpService;

@RestController
public class signUpController {
@Autowired
signUpService sus;
@PostMapping("addSignUp")
public signUp add(@RequestBody signUp su)
{
	return sus.saveSignUpInfo(su);
}
@GetMapping("showSignUp")
public List<signUp> show()
{
	return sus.showSignUpInfo();
}
@PutMapping("putSignUp")
public signUp put(@RequestBody signUp su)
{
	return sus.putSignUpInfo(su);
}
@DeleteMapping("deleteSignUp")
public String delete(@RequestBody signUp su)
{
	sus.deleteSignUpInfo(su);
	return "SIGN UP DETAILS DELETED FROM THE DATABASE";
}
@GetMapping("sortSignUp/{name}")
public List<signUp> sort(@PathVariable String name)
{
	return sus.sortSignUp(name); 	
}
@DeleteMapping("deleteSignUpById")
public String deleteSignUp(@RequestParam String email)
{
	return (sus.deleteById(email));
}
@PutMapping("putSignUpById")
public String modifyId(@RequestParam String email,@RequestBody signUp su)
{
	return sus.putSignUpById(email, su);
}
@GetMapping("querySignUp")
public List<signUp> getInfo(@RequestParam String email,@RequestParam String password)
{
	return sus.getInfoSign(email,password);
}
@PostMapping("addAllSignUp")
public List<signUp> saveAllInfo(@RequestBody List<signUp> su)
{
	return sus.saveAllInfo(su);
}
@GetMapping("pageSortSignUp/{pageno}/{pagesize}/{id}")
public List<signUp> sortpage(@PathVariable int pageno,@PathVariable int pagesize,@PathVariable String id)
{
	return sus.sortpage(pageno, pagesize, id);
}
}
