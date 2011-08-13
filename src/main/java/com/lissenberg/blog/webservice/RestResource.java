package com.lissenberg.blog.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/say")
public class RestResource {

	@GET
	@Produces("text/plain")
	@Path("/hi")
	public String sayHi() {
		return "Hi!";
	}

	@GET
	@Path("/hello/{name}")
	@Produces("text/plain")
	public String sayHello(@PathParam("name") String user) {
		return "Hello " + user;
	}


}
