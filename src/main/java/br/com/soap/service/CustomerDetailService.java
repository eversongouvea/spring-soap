package br.com.soap.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.soap.bean.CustomerBean;
import br.com.soap.help.Status;

@Service
public class CustomerDetailService {

	private static List<CustomerBean> customerBeans  = new ArrayList<>();
	
	static {
		
		CustomerBean c1 = new CustomerBean(1, "Bob", "5646-8888", "bob@gmail.com");
		CustomerBean c2 = new CustomerBean(2, "Maria", "1654-8888", "maria@gmail.com");
		CustomerBean c3 = new CustomerBean(3, "Joana", "1956-8888", "joana@gmail.com");
		CustomerBean c4 = new CustomerBean(4, "Pepa", "1564-8888", "pepa@gmail.com");
	
		customerBeans.add(c1);
		customerBeans.add(c2);
		customerBeans.add(c3);
		customerBeans.add(c4);
	}
	
	public  Optional<CustomerBean> findBy(int id) {
		
		return customerBeans.stream().filter(b -> b.getId() == id).findAny();
	}
	
	public List<CustomerBean> findAll(){
		
		return customerBeans;
	
	} 
	
	public Status deleteById(int id) {
		
		return customerBeans.stream()
		  			        .filter(customer -> customer.getId() == id)
		                    .findAny()
		                    .map(re -> {customerBeans.remove(re);
				            	 		return Status.SUCCESS;})
		                    .orElse(Status.FAILED);
		
	}
}
