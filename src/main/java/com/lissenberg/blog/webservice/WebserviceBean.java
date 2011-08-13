package com.lissenberg.blog.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class WebserviceBean {

	@WebMethod
	public String sayHello() {
		return "Hello there!";
	}

	@WebMethod
	public String sayHi(String name) {
		return "Hi " + name + "!";
	}


}
