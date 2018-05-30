package com.sas.sanction.interceptors;

import javax.xml.namespace.QName;

import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;

public class SanctionDataInterceptor extends PayloadValidatingInterceptor
{
	@Override
	public QName getDetailElementName() 
	{
		return new QName("http://www.sanction.sas.com/webservices", "error", "sanction");
	}
}
