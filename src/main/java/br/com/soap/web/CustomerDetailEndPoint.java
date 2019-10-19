package br.com.soap.web;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.soap.CustamerDetail;
import br.com.soap.GetCustomerDetailRequest;
import br.com.soap.GetCustomerDetailResponse;

@Endpoint
public class CustomerDetailEndPoint {

	private static final String TARGET_NAMESPACE ="http://soap.com.br";
	
	@PayloadRoot(namespace = TARGET_NAMESPACE ,localPart = "GetCustomerDetailRequest")
	@ResponsePayload
	public GetCustomerDetailResponse prossCustomerDetailResponse(@RequestPayload GetCustomerDetailRequest req) {
		
		GetCustomerDetailResponse customerDetailResponse = new GetCustomerDetailResponse();
		CustamerDetail cd = new CustamerDetail();
		cd.setId(123);
		cd.setEmail("everson@gmail.com");
		cd.setName("Everson");
		cd.setTelefone("9999-9999");
		
		customerDetailResponse.setCustomeDetailResponse(cd);
		
		return customerDetailResponse;
	}
	
	
}
