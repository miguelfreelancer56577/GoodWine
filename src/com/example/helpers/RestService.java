package com.example.helpers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.wrapper.InfoUserWrapper;
import com.example.wrapper.ListPositionWrapper;
import com.example.exception.RestWineException;
import com.example.goodwine.R;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

public class RestService<T, E> extends RestTemplate{

	protected ApiService apiService;
	protected HttpMethod httpMethod;
	protected HttpEntity<T> requestEntity;
	protected Class<E> classResponse; 
	protected final String logname;
	protected Activity activity;
	public boolean statusRequest;
	
	public RestService(ApiService apiService,T entityRequest, Class<E> classResponse, Activity activity) {
		this.apiService = apiService;
		this.classResponse = classResponse;
		httpMethod = HttpMethod.POST;
        super.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestEntity = new HttpEntity<T>(entityRequest, requestHeaders);
        logname = LoginService.class.getSimpleName();
        this.activity = activity;
        statusRequest = false;
	}
	
	public ResponseEntity<E> doRequest() throws Exception{
		ResponseEntity<E> response = null;
		try {
			response = this.exchange(apiService.getUrl(), httpMethod,requestEntity, classResponse);
			Log.d(logname, "Your petition was successful.");
			statusRequest = true;
		} catch (RestClientException e) {
			isbadOperation(getStatus(e.getMessage()));
			e.printStackTrace();
			Log.e(logname, e.getMessage());
		}
		return response;
	}
	
protected boolean isbadOperation(HttpStatus status) throws Exception{
		
		boolean isOK = false;
		
		if(status == null)
			return isOK;
		
		switch (status) {
			case REQUEST_TIMEOUT:
					throw new RestWineException(true, activity.getString(R.string.STATUS408), HttpStatus.REQUEST_TIMEOUT);
			
			case INTERNAL_SERVER_ERROR:
				throw new RestWineException(true, activity.getString(R.string.STATUS500), HttpStatus.INTERNAL_SERVER_ERROR);
			
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
			String error = massage.substring(0, 3);
			if(error.equalsIgnoreCase("I/O")){
				concurrentStatus = getStatusFromInt(408);
			}
			Log.e(logname, e.getMessage());
		}
		
		return concurrentStatus;
	}
	
	protected HttpStatus getStatusFromInt(int status){
		
		HttpStatus thisStatus = null;
		
		switch (status) {
			
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
