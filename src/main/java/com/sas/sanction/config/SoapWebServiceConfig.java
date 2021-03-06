package com.sas.sanction.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.sas.sanction.interceptors.SanctionDataInterceptor;

@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter
{
	
	/*@Override
	public void addInterceptors(java.util.List<EndpointInterceptor> interceptors)
	{
		SanctionDataInterceptor interceptor = new SanctionDataInterceptor();
		interceptor.setValidateRequest(true);
		interceptor.setValidateResponse(true);
		interceptor.setXsdSchema(sanctionDataSchema());
		interceptors.add(interceptor);
	}*/
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext)
	{
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}
	
	@Bean(name="sanctiondata")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema sanctionDataSchema)
	{
		DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
		defaultWsdl11Definition.setPortTypeName("SanctionDataPort");
		defaultWsdl11Definition.setLocationUri("/ws/sanction-data");
		defaultWsdl11Definition.setTargetNamespace("http://www.sanction.sas.com/webservices");
		defaultWsdl11Definition.setSchema(sanctionDataSchema);
		return defaultWsdl11Definition;
	}
	
	@Bean
	public XsdSchema sanctionDataSchema()
	{
		return new SimpleXsdSchema(new ClassPathResource("sanction.xsd"));
	}
}
