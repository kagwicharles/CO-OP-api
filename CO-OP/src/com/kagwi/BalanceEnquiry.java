package com.kagwi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import account_balance.AccountBalanceAPI;

@Path("/Account")
public class BalanceEnquiry {

	public BalanceEnquiry() {

	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/getBalance")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAccountBalance() {
		String balance_string = new AccountBalanceAPI().getAccountBalance();
		if (balance_string != "")
			return balance_string;
		return "Empty Response";
	}
}
