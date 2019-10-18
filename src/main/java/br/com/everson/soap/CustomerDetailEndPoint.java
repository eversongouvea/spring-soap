package br.com.everson.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.everson.teste.CustamerDetail;
import br.com.everson.teste.GetCustomerDetailRequest;
import br.com.everson.teste.GetCustomerDetailResponse;

@Endpoint
public class CustomerDetailEndPoint {

	@PayloadRoot(namespace = "br.com.everson.teste",localPart = "GetCustomerDetailResponse")
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
