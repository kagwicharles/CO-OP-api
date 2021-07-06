package com.kagwi;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import mail.MailAPI;

@Path("/Notify")
public class Notification {

	public Notification() {

	}

	@SuppressWarnings("unchecked")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getNotification")
	public String getNotification() {
		new MailAPI().sendMail();
		return "Notification sent...";
	}

}
