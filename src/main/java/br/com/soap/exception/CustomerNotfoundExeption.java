package br.com.soap.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,customFaultCode = "{http://soap.com.br}001_Costumer_not_found")
public class CustomerNotfoundExeption extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public CustomerNotfoundExeption(String msg) {
		super(msg);
	}
	
}
