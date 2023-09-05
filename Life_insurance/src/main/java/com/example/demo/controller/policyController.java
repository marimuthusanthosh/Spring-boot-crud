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

import com.example.demo.model.policy;
import com.example.demo.service.policyService;

@RestController
public class policyController {
@Autowired
policyService sd;
@PostMapping("addPolicy")
public policy add(@RequestBody policy po)
{
	return sd.addPolicy(po);
}
@GetMapping("showPolicy")
public List<policy> show()
{
	return sd.showPolicy();
}
@PutMapping("putPolicy")
public policy put(@RequestBody policy po)
{
	return sd.putPolicy(po);
}
@DeleteMapping("deletePolicy")
public String delete(@RequestBody policy po)
{
	sd.deletePolicy(po); 
	return "POLICY IS REMOVED FROM THE DATABASE";
}
@GetMapping("sortPolicy/{uin}")
public List<policy> sortPolicy(@PathVariable String s)
{
	return sd.sortPolicy(s);
}
@DeleteMapping("deletePolicyById/{uin}")
public String deletePolicy(@PathVariable String uin)
{
	return sd.deletePolicyById(uin);
}
@GetMapping("queryPolicy/{uin}")
public List<policy> getInfo(@PathVariable String uin)
{
	return sd.getdetails(uin);
}
@PostMapping("addAllPolicy")
public List<policy> addAllPolicy(@RequestBody List<policy> po)
{
	return sd.addAllPolicy(po);
}
@GetMapping("pageSortPolicy/{pageno}/{pagesize}/{id}")
public List<policy> sortpage(@PathVariable int pageno,@PathVariable int pagesize,@PathVariable String id)
{
	return sd.getpages(pageno, pagesize, id);
}
}
