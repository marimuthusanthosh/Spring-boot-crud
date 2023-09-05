package com.example.demo.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="customerTable")
public class customer 
{
	private String name;
	@Id
	private String email;
	private Long mobile_no;
	private int age;   
	private String gender; 
	private String occupation; 
	private Long salary;
	private String nri; 
	private String policy_no; 
	private String uin;
	@ManyToMany
	@JoinTable(
		name="policy_customer",
		joinColumns=@JoinColumn(name="fk_email"),
		inverseJoinColumns = @JoinColumn(name="fk_uin")
	)
	private List<policy> policies;
	public customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public customer(String name, String email, Long mobile_no, int age, String gender, String occupation, Long salary,
			String nri, String policy_no, String uin, List<policy> policies) {
		super();
		this.name = name;
		this.email = email;
		this.mobile_no = mobile_no;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.salary = salary;
		this.nri = nri;
		this.policy_no = policy_no;
		this.uin = uin;
		this.policies = policies;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(Long mobile_no) {
		this.mobile_no = mobile_no;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getNri() {
		return nri;
	}
	public void setNri(String nri) {
		this.nri = nri;
	}
	public String getPolicy_no() {
		return policy_no;
	}
	public void setPolicy_no(String policy_no) {
		this.policy_no = policy_no;
	}
	public String getUin() {
		return uin;
	}
	public void setUin(String uin) {
		this.uin = uin;
	}
	public List<policy> getPolicies() {
		return policies;
	}
	public void setPolicies(List<policy> policies) {
		this.policies = policies;
	}
				
}
