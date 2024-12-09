package com.hexw.web.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexw.web.BankRepo.BankRepo;
import com.hexw.web.Entity.Customer;

@Service
public class BankService {
	@Autowired
	BankRepo rep;
	
	
	public Customer saveDataC(Customer c) {
		int flag=0;
		List<Customer> l=rep.findAll();
		for(Customer x : l) {
			if(c.getActno()==x.getActno()) {
				flag=1;
				break;
			}
			
		}
		//System.out.println(flag);
		if(flag==0) {
		Customer r=rep.save(c);
		return r;
		}
		else {
			return null;
		}
	}


	public List show() {
		List l=rep.findAll();
		return l;
	}


	public Customer getdatabyid(int ac) {
		Customer r= rep.findById(ac).orElse(null);
		return r;
	}


	public String removeDataa(int ac) {
		String str;
		if(rep.findById(ac).isPresent()) {
		rep.deleteById(ac);
		str= "Removed";
		}
		else
			str="Not found";
		return str;	
		
	}


	public String updatedata(int ac, double fe) {
		String str;
		if(rep.findById(ac).isPresent()) {
			Customer r= rep.findById(ac).orElse(null);
			r.setFee(fe);
			rep.save(r);
			str= "Updated";
		}
		else
		{
			str="Not found";
		}
		return str;
	}


	public String depositdata(int ac, double fe) {
		String str;
		if(rep.findById(ac).isPresent()) {
			Customer r= rep.findById(ac).orElse(null);
			r.setFee(r.getFee()+fe);
			rep.save(r);
			str= "Updated";
		}
		else
		{
			str="Not found";
		}
		return str;
	}


	public String withdrawdata(int ac, double fe) {
		String str;
		if(rep.findById(ac).isPresent()) {
			Customer r= rep.findById(ac).orElse(null);
			if(r.getFee()>fe) {
				
			
			r.setFee(r.getFee()-fe);
			rep.save(r);
			str= "Withdrawn";
			}
			else {
				str= "Insufficient Balance";
			}
		}
		else
		{
			str="Not found";
		}
		return str;
	}


	public List<Customer> namecontains(String str) {
		List<Customer> l1=rep.findByNameContaining(str);
		return l1;
	}

	public List<Customer> feegreaterthan(double fe) {
		List<Customer> l1= rep.findByFeeGreaterThan(fe);
		return l1;
	}


	public List<Customer> feebetw(double fe1, double fe2) {
		List<Customer> l1=rep.findByFeeBetween(fe1,fe2);
		return l1;
	}


	public List<Customer> namelikee(String str) {
		List<Customer> l1=rep.findByNameLike(str);
		return l1;
	}


	public List<Customer> namefeeval(String name, double fe) {
		List<Customer> l1=rep.findnamefee(name,fe);
		return l1;
	}


	public List<Customer> show2() {
		List<Customer> l1=rep.findeverything();
		return l1;
	}


	public String updatedata2(int ac, double fe) {
		
		String str;
		if(rep.findById(ac).isPresent()) {
			rep.updatefeevalue(ac,fe);
			str= "Updated";
		}
		else
		{
			str="Not found";
		}
		return str;
		
	}


	public String removeDataa2(int ac) {
		String str;
		if(rep.findById(ac).isPresent()) {
		rep.deleteById2(ac);
		str= "Removed";
		}
		else
			str="Not found";
		return str;
		
	}


	public int getcountfee() {
		int c=0;
		List<Customer> li = rep.findAll();
		for(Customer customer : li) {
			if(customer.getFee()>5000)
				c++;
		}
		return c;
	}


	public List<Customer> getcountfeename() {
		List<Customer> li = rep.findAll();
		List<Customer> li1= li.stream().filter((temp)->temp.getFee()>5000).collect(Collectors.toList());
		if(li1.isEmpty())
			return null;
		else {
			return li1;
		}
	}


	public List<Customer> feelessthan(double fe) {
		List<Customer> l1= rep.findByFeeLessThan(fe);
		return l1;
	}
}
