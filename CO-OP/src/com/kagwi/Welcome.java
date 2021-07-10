package com.kagwi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class Welcome {
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "CO-OP" + "</title>" + "<body><h1>" + "Welcome to CO-OP Integration API"
				+ "</h1></body>" + "</html> ";
	}
}
