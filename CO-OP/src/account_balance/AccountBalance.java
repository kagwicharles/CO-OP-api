package account_balance;

import java.io.IOException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import org.json.JSONObject;

import auth.AuthToken;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AccountBalance {

	private Response response;

	public AccountBalance() {

	}

	public String getAccountBalance() {
		String jsonString = "";
		OkHttpClient client = new OkHttpClient().newBuilder().hostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		}).build();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, jsonRequestBody());

		Request request = new Request.Builder()
				.url("https://openapi-sandbox.co-opbank.co.ke/Enquiry/AccountBalance/1.0.0/").post(body)
				.addHeader("Authorization", "Bearer " + new AuthToken().getAuth())
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
		object.put("MessageReference", "40ca18c6765086089a");
		object.put("AccountNumber", "36001873000");
		return object.toString();
	}

}
