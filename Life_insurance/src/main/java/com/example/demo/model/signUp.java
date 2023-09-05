package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="signUpTable")
public class signUp {
private String name;
private String dob;
private String gender;
private int age;
private Long mobile_no;
@Id
private String email;
private String password;
private String confirm_password;

public signUp() {
	super();
	// TODO Auto-generated constructor stub
}
public signUp(String name, String dob, String gender, int age, Long mobile_no, String email, String password,
		String confirm_password) {
	super();
	this.name = name;
	this.dob = dob;
	this.gender = gender;
	this.age = age;
	this.mobile_no = mobile_no;
	this.email = email;
	this.password = password;
	this.confirm_password = confirm_password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Long getMobile_no() {
	return mobile_no;
}
public void setMobile_no(Long mobile_no) {
	this.mobile_no = mobile_no;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfirm_password() {
	return confirm_password;
}
public void setConfirm_password(String confirm_password) {
	this.confirm_password = confirm_password;
}


}
