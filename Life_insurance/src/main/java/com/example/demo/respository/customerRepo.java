package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.customer;

@Repository
public interface customerRepo extends JpaRepository<customer,String >
{
	@Query(value="select * from customer_table where email=:s or name=:sn",nativeQuery = true)
	public List<customer> getInfo(@Param("s") String email,@Param("sn")String name);
	
}
