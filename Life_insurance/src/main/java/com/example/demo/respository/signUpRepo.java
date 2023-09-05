package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.signUp;
@Repository
public interface signUpRepo extends JpaRepository<signUp, String>{
	@Query(value="select * from sign_up_table where email=:s and password=:ss",nativeQuery = true)
	public List<signUp> getInfoSignUp(@Param("s") String email,@Param("ss") String password);
}
