package com.example.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.example.beans.HeaderRequest;
import com.example.beans.HeaderResponse;
import com.example.beans.InfoUser;
import com.example.beans.User;
import com.example.goodwine.LoginActivity;
import com.example.goodwine.R;
import com.example.goodwine.admin.MainActivity;
import com.example.wrapper.InfoUserWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public abstract class RestService extends AsyncTask<HeaderRequest, Integer, Boolean> {
	
	protected Activity activity;
	protected String logname;
	protected ObjectMapper mp;
	
	public RestService(Activity activity) {
		super();
		this.activity = activity;
		logname = this.getClass().getSimpleName();
		mp = new ObjectMapper();
	}

	protected boolean doStatusOperation(HttpStatus status){
		
		boolean isOK = false;
		
		if(status == null)
			return isOK;
		
		switch (status) {
		
			case OK:
					isOK = true;
			break;
					
			case REQUEST_TIMEOUT:
			break;
			
			case INTERNAL_SERVER_ERROR:
			break;
			
			case UNAUTHORIZED:
				LoginService.INFOUSER = null;
				activity.finish();
			break;
			
			case METHOD_NOT_ALLOWED:
			break;
			
			case FORBIDDEN:
			break;
			
			case BAD_REQUEST:
			break;
	
			default:
				
				break;
				
		}
		return isOK;
	} 
	
	protected HttpStatus getStatus(String massage){
		HttpStatus concurrentStatus = null;
		try {
			int status = Integer.parseInt(massage.substring(0, 3));
			concurrentStatus = getStatusFromInt(status);
		} catch (NumberFormatException e) {
			Log.e(logname, e.getMessage());
		}
		
		return concurrentStatus;
	}
	
	protected HttpStatus getStatusFromInt(int status){
		
		HttpStatus thisStatus = null;
		
		switch (status) {
			
			case 200:
				thisStatus = HttpStatus.OK;
				break;
					
			case 408:
				thisStatus = HttpStatus.REQUEST_TIMEOUT;
				break;
			
			case 500:
				thisStatus = HttpStatus.INTERNAL_SERVER_ERROR;
				break;
			
			case 401:
				thisStatus = HttpStatus.UNAUTHORIZED;
				break;
			
			case 405:
				thisStatus = HttpStatus.METHOD_NOT_ALLOWED;
				break;
			
			case 403:
				thisStatus = HttpStatus.FORBIDDEN;
				break;
			
			case 400:
				thisStatus = HttpStatus.BAD_REQUEST;
				break;
	
			default:
				break;
				
		}
		
		return thisStatus;
		
	}
	
}
