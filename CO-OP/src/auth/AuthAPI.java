package auth;

import java.io.IOException;
import java.util.Base64;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AuthAPI {

	private final static String url = "https://openapi-sandbox.co-opbank.co.ke/token?grant_type=client_credentials";

	public AuthAPI() {

	}

	public String getAuth() {
		String app_key = "HMB2yUn8ao_nUiVtz_9zHpq_5gsa";
		String app_secret = "rrJu_1d4M927UDdTEGqbX0058MQa";
		String appKeySecret = app_key + ":" + app_secret; // Combine consumer secret and consumer key
		String token = "";

		try {

			String encodedString = Base64.getEncoder().encodeToString(appKeySecret.getBytes());

			OkHttpClient client = new OkHttpClient().newBuilder().hostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			}).build();
			RequestBody requestbody = RequestBody.create(null, new byte[0]);
			Request request = new Request.Builder()

					.url(url).method("POST", requestbody).addHeader("Authorization", "Basic " + encodedString)
					.addHeader("cache-control", "no-cache").build();

			Response response = client.newCall(request).execute();
			JSONObject jsonObj = new JSONObject(response.body().string());
			token = jsonObj.get("access_token").toString();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return token;
	}
}