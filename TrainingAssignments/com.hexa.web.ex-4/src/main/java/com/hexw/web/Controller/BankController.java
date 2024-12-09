package com.hexw.web.Controller;

import java.util.ArrayList;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexw.web.Entity.Customer;
import com.hexw.web.Entity.CustomerDTO;
import com.hexw.web.Exception.CustomerNotAddedException;
import com.hexw.web.Exception.CustomerNotFoundException;
import com.hexw.web.Service.BankService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class BankController {
	@Autowired
	BankService ser;
	@Autowired
	ModelMapper mp;
	
	
	/*
	 * CustomerDTO maptoDTO(Customer c) { return new
	 * CustomerDTO(c.getActno(),c.getName(),c.getFee()); }
	 * 
	 * Customer mapToEntity(CustomerDTO c) { return new
	 * Customer(c.getActno(),c.getName(),c.getFee()); }
	 */
	
	
	/*
	 * @PostMapping("/savedata") public ResponseEntity<?> saveD(@Valid @RequestBody
	 * CustomerDTO c) { try { Customer d = mp.map(c,Customer.class);
	 * //System.out.println("Hello"); Customer r= ser.saveDataC(d);
	 * //System.out.println(r); if(r==null) { throw new
	 * CustomerNotAddedException("Customer already present with account no. "
	 * +c.getActno()); } else { //return new ResponseEntity<>(r,HttpStatus.CREATED);
	 * CustomerDTO x=mp.map(r, CustomerDTO.class); return
	 * ResponseEntity.status(HttpStatus.CREATED).body(x); } }catch
	 * (CustomerNotAddedException e) { return new ResponseEntity<>(e.getMessage(),
	 * HttpStatus.NOT_FOUND); }catch (Exception e) { e.printStackTrace(); return new
	 * ResponseEntity<>("An error occurred while retrieving customer data.",
	 * HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */
	
	@PostMapping("/savedata")
	public ResponseEntity<?>  saveD(@Valid @RequestBody CustomerDTO c) throws CustomerNotAddedException {
		
		Customer d = mp.map(c,Customer.class);
		//System.out.println("Hello");
		Customer r= ser.saveDataC(d);
		//System.out.println(r);
		if(r==null)
		{
			throw new CustomerNotAddedException("Customer already present with account no. " +c.getActno());
		}
		else {
		//return new ResponseEntity<>(r,HttpStatus.CREATED);
		CustomerDTO x=mp.map(r, CustomerDTO.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(x);
		}
	}
	
	@GetMapping("/getall")
	public ResponseEntity< List<CustomerDTO>> getdata(){
		List<Customer> l = ser.show();
		List<CustomerDTO> user= new ArrayList<>();
		for(Customer customer : l)
		{
			CustomerDTO x=mp.map(customer,CustomerDTO.class);
			user.add(x);
		}
		
		if(user.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/getone/{ac}")
	public ResponseEntity<CustomerDTO> getbyId(@PathVariable int ac) throws CustomerNotFoundException {
		Customer r = ser.getdatabyid(ac);
		
		if(r!=null) {
			CustomerDTO x=mp.map(r,CustomerDTO.class);
		return new ResponseEntity<>(x,HttpStatus.FOUND);
		}
		else {
			//return new ResponseEntity<>(x,HttpStatus.NOT_FOUND);
			throw new CustomerNotFoundException("Not Found");
		}
	}
	
	@GetMapping("/feegt")
	public ResponseEntity<Integer> getfeegreater(){
		int count=ser.getcountfee();
		return new ResponseEntity<>(count,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/feegtname")
	public ResponseEntity<List<Customer>> getfeegreatername() throws Exception{
		List<Customer> li=ser.getcountfeename();
		if(li==null)
		{
			throw new Exception("Some Error Occured");
			//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(li,HttpStatus.OK);
		}
	}
	
	
	
	@DeleteMapping("/removeone/{ac}")
	public ResponseEntity<?> removeData(@PathVariable int ac) {
		try {
		String s= ser.removeDataa(ac);
		if(s.equals("Removed")) {
			return new ResponseEntity<>(s,HttpStatus.OK);
		}
		throw new CustomerNotFoundException("Customer not found with account no. " +ac);
		}catch (CustomerNotFoundException e) {
	          
	           return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	       } catch (Exception e) {
	           
	           return new ResponseEntity<>("An error occurred while retrieving customer data.", HttpStatus.INTERNAL_SERVER_ERROR);
	       }
	}
	
	@PutMapping("/updatefee/{ac}/{fe}")
	public ResponseEntity<String> updatefee(@PathVariable int ac,@PathVariable double fe) throws CustomerNotFoundException {
		String s= ser.updatedata(ac,fe);
		if(s.equals("Updated")) {
			return new ResponseEntity<>(s,HttpStatus.OK);
		}
		else {
			throw new CustomerNotFoundException("No data of enterd customer exists");
		}
		//return new ResponseEntity<>(s,HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/depositfee/{ac}/{fe}")
	public String depositfee(@PathVariable int ac,@PathVariable double fe) {
		String s= ser.depositdata(ac,fe);
		return s;
	}
	@PutMapping("/withdrawfee/{ac}/{fe}")
	public String withdrawfee(@PathVariable int ac,@PathVariable double fe) {
		String s= ser.withdrawdata(ac,fe);
		return s;
	}
	
	@PutMapping("/namecontent/{str}")
	public List<Customer> namecontain(@PathVariable String str){
		List l= ser.namecontains(str);
		
		return l;
	}
	
	@PutMapping("/feegreater/{fe}")
	public List<Customer> feegt(@PathVariable double fe){
		List<Customer> l= ser.feegreaterthan(fe);
		return l;
	}
	
	@PutMapping("/feebetween/{fe1}/{fe2}")
	public List<Customer> feebetweens(@PathVariable double fe1,@PathVariable double fe2){
		List<Customer> l= ser.feebetw(fe1,fe2);
		return l;
	}
	
	@PutMapping("/namelike/{str}")
	public List<Customer> namelik(@PathVariable String str){
		List<Customer> l= ser.namelikee(str);
		return l;
	}
	
	@GetMapping("/getall2")
	public List<Customer> getdata2(){
		List<Customer> l = ser.show2();
		return l;
	}
	
	@PutMapping("/nameandfee/{name}/{fe}")
	public List<Customer> namefee(@PathVariable String name,@PathVariable double fe){
		List<Customer> l= ser.namefeeval(name,fe);
		return l;
	}
	
	@PutMapping("/updatefee2/{ac}/{fe}")
	public String updatefee2(@PathVariable int ac,@PathVariable double fe) {
		String s= ser.updatedata2(ac,fe);
		return s;
	}
	
	@DeleteMapping("/removeone2/{ac}")
	public String removeData2(@PathVariable int ac) {
		String s= ser.removeDataa2(ac);
		return s;
	}
	
	@GetMapping("/feelessthan/{ac}")
	public List<Customer> feelt(@PathVariable double fe){
		List<Customer> l= ser.feelessthan(fe);
		return l;
	}
}
