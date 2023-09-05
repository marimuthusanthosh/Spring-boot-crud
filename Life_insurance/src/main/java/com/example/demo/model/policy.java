package com.example.demo.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="policyTable")
public class policy {
	private String name;
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long p_number;
	@Id
	private String uin;
	private int min_age;
	private int max_age;
	private int annual_income;
	private String nri;
	@ManyToMany(mappedBy = "policies")
	private Set<customer> customer;
	public policy() {
		super();
		// TODO Auto-generated constructor stub
	}
public policy(String name, Long p_number, String uin, int min_age, int max_age, int annual_income, String nri) {
	super();
	this.name = name;
	this.p_number = p_number;
	this.uin = uin;
	this.min_age = min_age;
	this.max_age = max_age;
	this.annual_income = annual_income;
	this.nri = nri;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Long getP_number() {
	return p_number;
}
public void setP_number(Long p_number) {
	this.p_number = p_number;
}
public String getUin() {
	return uin;
}
public void setUin(String uin) {
	this.uin = uin;
}
public int getMin_age() {
	return min_age;
}
public void setMin_age(int min_age) {
	this.min_age = min_age;
}
public int getMax_age() {
	return max_age;
}
public void setMax_age(int max_age) {
	this.max_age = max_age;
}
public int getAnnual_income() {
	return annual_income;
}
public void setAnnual_income(int annual_income) {
	this.annual_income = annual_income;
}
public String getNri() {
	return nri;
}
public void setNri(String nri) {
	this.nri = nri;
}
	
		
}
