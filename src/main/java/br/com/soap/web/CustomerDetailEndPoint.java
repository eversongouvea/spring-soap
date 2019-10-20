package br.com.soap.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.soap.CustamerDetail;
import br.com.soap.DeleteCustomerDetailRequest;
import br.com.soap.DeleteCustomerDetailResponse;
import br.com.soap.GetAllCustomerDetailRequest;
import br.com.soap.GetAllCustomerDetailResponse;
import br.com.soap.GetCustomerDetailRequest;
import br.com.soap.GetCustomerDetailResponse;
import br.com.soap.bean.CustomerBean;
import br.com.soap.exception.CustomerNotfoundExeption;
import br.com.soap.help.Status;
import br.com.soap.service.CustomerDetailService;

@Endpoint
public class CustomerDetailEndPoint {

	private static final String TARGET_NAMESPACE ="http://soap.com.br";
	
	@Autowired
	private CustomerDetailService customerDetailService;
	
	@PayloadRoot(namespace = TARGET_NAMESPACE ,localPart = "GetCustomerDetailRequest")
	@ResponsePayload
	public GetCustomerDetailResponse getDetailResponse(@RequestPayload GetCustomerDetailRequest req){
		
		CustamerDetail customerDetail = customerDetailService.findBy(req.getId())
															 .map(t -> t.ofCustamerDetail())
															 .orElseThrow(() -> new CustomerNotfoundExeption(String.format("Id %d não encontrado.", req.getId()) ));
		
		GetCustomerDetailResponse customerDetailResponse = new GetCustomerDetailResponse();
		
		customerDetailResponse.setCustomeDetailResponse(customerDetail);
		
		return customerDetailResponse;
	}
	
	@PayloadRoot(namespace = TARGET_NAMESPACE ,localPart = "GetAllCustomerDetailRequest")
	@ResponsePayload
	public GetAllCustomerDetailResponse getAllDetailResponse(@RequestPayload GetAllCustomerDetailRequest req){
		
		return CustomerBean.ofCustamerDetail(customerDetailService.findAll());
	}
	
	@PayloadRoot(namespace = TARGET_NAMESPACE ,localPart = "DeleteCustomerDetailRequest")
	@ResponsePayload
	public DeleteCustomerDetailResponse deleteCustomerDetail(@RequestPayload DeleteCustomerDetailRequest req){
		
		Status status = customerDetailService.deleteById(req.getId());
		
		DeleteCustomerDetailResponse deleteCustomer = new DeleteCustomerDetailResponse();
		deleteCustomer.setStatus(br.com.soap.Status.valueOf(status.toString()));
		return deleteCustomer;
	}
}
