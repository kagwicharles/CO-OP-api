package messaging;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class TwilioAPI {

	public TwilioAPI() {

	}

	public static final String ACCOUNT_SID = "AC02d145c6ee546685079a8dcbcba665f5";
	public static final String AUTH_TOKEN = "";

	public void sendMessage(String eventType, String amount, String currency, String accountNo, String narration) {

		String messageContent = "Hello, Confirmed " + eventType + " " + amount + currency + ", Account Number "
				+ accountNo + " for " + narration + ".";

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(new com.twilio.type.PhoneNumber("+254712464436"),
				new com.twilio.type.PhoneNumber("+14708237658"), messageContent).create();

		// System.out.println(message.getSid());
	}
}