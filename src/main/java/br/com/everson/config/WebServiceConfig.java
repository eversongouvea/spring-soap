package br.com.everson.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WebServiceConfig extends WsConfigurerAdapter{

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDisServlet(ApplicationContext context) {
		
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean<MessageDispatcherServlet>(messageDispatcherServlet,"/ws/*");
		
	}
	
	@Bean
	public XsdSchema customerSchema() {
		
		return new SimpleXsdSchema(new ClassPathResource("customer-informat.xsd")); 
	}
	
	@Bean(name="customers")
	public DefaultWsdl11Definition DefaultWsdl11Definition(XsdSchema customerSchema) {
		
		DefaultWsdl11Definition defination = new DefaultWsdl11Definition();
		defination.setPortTypeName("CustomerPort");
		defination.setTargetNamespace("http://everson.com.br");
		defination.setLocationUri("/ws");
		defination.setSchema(customerSchema);
		
		return defination;
	}
}
