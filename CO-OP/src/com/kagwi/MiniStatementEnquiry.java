package com.kagwi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ministatement.MiniStatementAPI;

@Path("/MiniStatement")
public class MiniStatementEnquiry {

	public MiniStatementEnquiry() {

	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/getMiniStatement")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAccountBalance() {
		String balance_string = new MiniStatementAPI().getMiniStatement();
		if (balance_string != "")
			return balance_string;
		return "Empty Response";
	}
}