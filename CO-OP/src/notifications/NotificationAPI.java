package notifications;

import java.io.IOException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import org.json.simple.JSONObject;

import auth.AuthAPI;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NotificationAPI {

	private Response response;
	private final static String url = "https://openapi-sandbox.co-opbank.co.ke/Notifications/INS/Simulation/1.0.0/Transaction";

	public NotificationAPI() {

	}

	public String sendNotificationSim() {
		String jsonString = "";
		OkHttpClient client = new OkHttpClient().newBuilder().hostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		}).build();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, jsonRequestBody());

		Request request = new Request.Builder().url(url).post(body)
				.addHeader("Authorization", "Bearer " + new AuthAPI().getAuth())
				.addHeader("NotificationEndpoint", "http://localhost:8080/CO-OP/coop/Notify/getNotification")
				.addHeader("content-type", "application/json").build();
		try {
			response = client.newCall(request).execute();
			jsonString = response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonString;
	}

	public String jsonRequestBody() {

		JSONObject object = new JSONObject();
		object.put("MessageReference", "93C4EEB126E056B6E05400144FF97BA9");
		object.put("MessageDateTime", "2021-07-06T12:42:11.990Z");
		object.put("ServiceName", "string");
		object.put("NotificationCode", "string");
		object.put("PaymentRef", "SFI427E9136D7D3F21C2C89");
		object.put("AccountNumber", "54321987654321");
		object.put("Amount", "120777.45");
		object.put("TransactionDate", "20190301165420");
		object.put("EventType", "DEBIT");
		object.put("Currency", "KES");
		object.put("ExchangeRate", "1");
		object.put("Narration", "Supplier Payments");
		object.put("CustMemo",
				"{\n" + "		    \"CustMemoLine1\": \"728210595 ABD01\",\n"
						+ "		    \"CustMemoLine2\": \"string\",\n" + "		    \"CustMemoLine3\": \"string\"\n"
						+ "		  }");
		object.put("ValueDate", "20190301");
		object.put("EntryDate", "20190301");
		object.put("TransactionId", "1169716b65891lI6");

		return object.toString();
	}
}