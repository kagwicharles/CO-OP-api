package com.kagwi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import account.NotificationAPI;

@Path("/NotifySimulation")
public class RequestNotification {

	public RequestNotification() {

	}

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/askNotification")
	public String getNotification() {
		new NotificationAPI().sendNotificationSim();
		return "Notification requested";
	}
}
