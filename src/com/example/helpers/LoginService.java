package com.example.helpers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.goodwine.R;
import com.example.beans.HeaderResponse;
import com.example.beans.InfoUser;
import com.example.beans.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class LoginService extends AsyncTask<User, Integer, Boolean> {
	
	protected HeaderResponse headerResponse;
	protected Context ctx;
	protected ApiService apiService; 
	public static InfoUser INFOUSER;
	protected final String logname;
	protected ObjectMapper mp;
	
	public LoginService(Context ctx, ApiService apiService) {
		super();
		this.ctx = ctx;
		this.apiService = apiService;
		mp = new ObjectMapper();
		logname = LoginService.class.getSimpleName() + " -> ";
	}

	@Override
	protected void onPreExecute (){}

	@Override
	protected Boolean doInBackground(User... users) {
		
		User user = users[0]; 
		ResponseEntityWine<User, HeaderResponse> responseEntityWine = new ResponseEntityWine<User, HeaderResponse>(apiService, user, HeaderResponse.class);
		try {
			ResponseEntity<HeaderResponse> response = responseEntityWine.doRequest();
			Log.e(logname, "Your petition was successful.");
			headerResponse = response.getBody();
			return true;
		} catch (RestClientException e) {
			e.printStackTrace();
			Log.e(logname, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			Log.e(logname, e.getMessage());
		}
		return false;
	}
	
	@Override
	protected void onPostExecute(Boolean result){
		try {
			Log.d(logname, "reponse object " + mp.writeValueAsString(headerResponse));
			if(result){
				if(ctx != null){
					
					Toast msg = Toast.makeText(ctx,"",Toast.LENGTH_LONG);
					
					String status = Long.toString(headerResponse.getStatus()).trim();
					
					if(status.equalsIgnoreCase(ApiStatusCode.STATUS200.getStatusCode())){
						msg.setText(ctx.getString(R.string.STATUS200));
						INFOUSER = (InfoUser) headerResponse.getBusinessResponse();
					}else if(status.equalsIgnoreCase(ApiStatusCode.STATUS406.getStatusCode())){
						msg.setText(ctx.getString(R.string.STATUS406));
						msg.show();
					}else if(status.equalsIgnoreCase(ApiStatusCode.STATUS408.getStatusCode())){
						msg.setText(ctx.getString(R.string.STATUS408));
						msg.show();
					}else if(status.equalsIgnoreCase(ApiStatusCode.STATUS500.getStatusCode())){
						msg.setText(ctx.getString(R.string.STATUS500));
						msg.show();
					}
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			Log.d(logname, e.getMessage());
		}
	}
	
}
