package com.example.taks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import android.app.Activity;
import android.util.Log;

import com.example.beans.HeaderRequest;
import com.example.beans.HeaderResponse;
import com.example.beans.Position;
import com.example.goodwine.R;
import com.example.goodwine.admin.ListRecords;
import com.example.goodwine.admin.MainActivity;
import com.example.helpers.ApiService;
import com.example.helpers.LoginService;
import com.example.helpers.ResponseEntityWine;
import com.example.helpers.RestService;
import com.example.wrapper.InfoUserWrapper;
import com.example.wrapper.ListPositionWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ListPositionService extends RestService {
	
	protected ListPositionWrapper listPositionWrapper;
	protected ListRecords listRecords;
	protected String logname;
	protected ApiService apiService; 

	public ListPositionService(ListRecords listRecords, ApiService apiService) {
		super(listRecords.getActivity());
		logname = this.getClass().getSimpleName();
		this.listRecords = listRecords;
		this.apiService = apiService;
	}

	@Override
	protected Boolean doInBackground(HeaderRequest... arg0) {
		
		HeaderRequest headerRequest = arg0[0];
		
		if(LoginService.INFOUSER != null){
			headerRequest.setIdUser(LoginService.INFOUSER.getUser().getIdUser());
			headerRequest.setToken(LoginService.INFOUSER.getUser().getToken());
		}
		
		headerRequest.setIdUser("1");
		headerRequest.setToken("Y65hraSOnp+SnaScYmht");
		headerRequest.setBusinessRequest(null);
		
		ResponseEntityWine<HeaderRequest, ListPositionWrapper> responseEntityWine = new ResponseEntityWine<HeaderRequest, ListPositionWrapper>(apiService, headerRequest, ListPositionWrapper.class);
		try {
			ResponseEntity<ListPositionWrapper> response = responseEntityWine.doRequest();
			listPositionWrapper = response.getBody();
			Log.d(logname, "Your petition was successful.");
			doStatusOperation(response.getStatusCode());
			return true;
		} catch (RestClientException e) {
			doStatusOperation(getStatus(e.getMessage()));
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
		
		listRecords.records = null;
		
		if(result){
			
			listRecords.records = new String[listPositionWrapper.getBusinessResponse().size()];
			
			Log.d(logname, "The status of your petition was successfull");
			
			int cont = 0; 
			
			for(Position position: listPositionWrapper.getBusinessResponse()){
				listRecords.records[cont] = position.getNamePosition();
				cont ++;
			}
			
		}else{
			Log.d(logname, "You had an error in your petition.");
		}
	}

}
