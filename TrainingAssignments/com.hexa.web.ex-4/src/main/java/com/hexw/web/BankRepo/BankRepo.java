package com.hexw.web.BankRepo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hexw.web.Entity.Customer;
@Repository
public interface BankRepo extends JpaRepository<Customer,Integer> {

	public List<Customer> findByNameContaining(String str);
	public List<Customer> findByFeeGreaterThan(double fe);
	public List<Customer> findByFeeLessThan(double fe);
	public List<Customer> findByFeeBetween(double fe1, double fe2);
	public List<Customer> findByNameLike(String str);
	
	@Query("Select u from Customer u where u.name=:name and u.fee=:fe")
	public List<Customer> findnamefee(@Param("name")String name, @Param("fe")double fe);
	
	@Query("Select u from Customer u")
	public List<Customer> findeverything();
	
	@Modifying
	@Transactional
	@Query(value="Update Customer SET fee=:fe where actno=:ac",nativeQuery=true)
	public void updatefeevalue(@Param("ac")int ac, @Param("fe")double fe);
	
	@Modifying
	@Transactional
	@Query(value="Delete From Customer where actno=:ac",nativeQuery=true)
	public void deleteById2(@Param("ac")int ac);
	
	

}
