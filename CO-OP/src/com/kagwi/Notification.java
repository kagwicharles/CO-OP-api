package com.kagwi;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import twilio.TwilioAPI;

@Path("/Notify")
public class Notification {

	public Notification() {

	}

	@SuppressWarnings("unchecked")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getNotification")
	@Consumes(MediaType.APPLICATION_JSON)
	public String getNotification(String json_payload) {
		JSONObject jsonObj = new JSONObject(json_payload);
		String accountNo = jsonObj.get("AccountNumber").toString();
		String amount = jsonObj.get("Amount").toString();
		String eventType = jsonObj.get("EventType").toString();
		String currency = jsonObj.get("Currency").toString();
		String narration = jsonObj.get("Narration").toString();

		new TwilioAPI().sendMessage(eventType, amount, currency, accountNo, narration);
		return "Notification sent...";
	}

}
