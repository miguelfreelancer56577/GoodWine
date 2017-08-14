package com.example.helpers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.example.goodwine.LoginActivity;
import com.example.goodwine.R;
import com.example.goodwine.admin.MainActivity;
import com.example.wrapper.InfoUserWrapper;
import com.example.beans.InfoUser;
import com.example.beans.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class LoginService extends AsyncTask<User, Integer, Boolean> {
	
	protected InfoUserWrapper infoUserWrapper;
	protected LoginActivity ctx;
	protected ApiService apiService; 
	public static InfoUser INFOUSER;
	protected final String logname;
	protected ObjectMapper mp;
	
	public LoginService(LoginActivity ctx, ApiService apiService) {
		super();
		this.ctx = ctx;
		this.apiService = apiService;
		mp = new ObjectMapper();
		logname = LoginService.class.getSimpleName();
	}

	@Override
	protected void onPreExecute (){}

	@Override
	protected Boolean doInBackground(User... users) {
		
		User user = users[0]; 
		RestServiceLogin<User, InfoUserWrapper> restServiceLogin = new RestServiceLogin<User, InfoUserWrapper>(apiService, user, InfoUserWrapper.class);
		try {
			ResponseEntity<InfoUserWrapper> response = restServiceLogin.doRequest();
			Log.d(logname, "Your petition was successful.");
			infoUserWrapper = response.getBody();
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
		ctx.showProgress(false);
		Toast msg = Toast.makeText(
                ctx.getApplicationContext(),
                "",
                Toast.LENGTH_LONG);
		try {
			Log.d(logname, "reponse object " + mp.writeValueAsString(infoUserWrapper));
			if(result){
					
				String status = Long.toString(infoUserWrapper.getStatus()).trim();
				
				if(status.equalsIgnoreCase(ApiStatusCode.STATUS200.getStatusCode())){
					msg.setText(ctx.getString(R.string.STATUS200));
					INFOUSER = (InfoUser) infoUserWrapper.getBusinessResponse();
					Intent fireIntent = new Intent(ctx, MainActivity.class);
					ctx.startActivity(fireIntent);
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
					
			}else{
				msg.setText(ctx.getString(R.string.STATUS000));
				msg.show();
			}
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			Log.e(logname, e.getMessage());
		}
	}
	
	@Override
	protected void onCancelled() {
		ctx.showProgress(false);
	}
	
}
