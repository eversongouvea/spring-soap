package br.com.soap.bean;

import java.util.List;
import java.util.stream.Collectors;

import br.com.soap.CustamerDetail;
import br.com.soap.GetAllCustomerDetailResponse;

public class CustomerBean {

	private int id;

	private String nome, telefone, email;

	public CustomerBean() {
		
	}
	
	public CustomerBean(int id, String nome, String telefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public CustamerDetail ofCustamerDetail() {
		
		CustamerDetail cd = new CustamerDetail();
		cd.setId(this.id);
		cd.setEmail(this.email);
		cd.setName(this.nome);
		cd.setTelefone(this.telefone);
		
		return cd;
	}
	
	public static GetAllCustomerDetailResponse ofCustamerDetail(List<CustomerBean> customerBeans) {
		
		List<CustamerDetail> collect = customerBeans.stream()
													.map(c -> c.ofCustamerDetail())
													.collect(Collectors.toList());
		
		GetAllCustomerDetailResponse get = new GetAllCustomerDetailResponse();
		get.getCustamerDetail().addAll(collect);
		
		return get;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + "]";
	}

}
