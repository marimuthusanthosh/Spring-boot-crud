package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.policy;
@Repository
public interface policyRepo extends JpaRepository<policy, String>{
	@Query(value="select * from policy_table where uin=:s",nativeQuery = true)
	public List<policy> getInfoPolicy(@Param("s") String uin);
}
