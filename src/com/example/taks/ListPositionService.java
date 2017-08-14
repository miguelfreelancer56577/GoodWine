package com.example.taks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.beans.HeaderRequest;
import com.example.beans.Position;
import com.example.goodwine.admin.ListRecords;
import com.example.helpers.ApiService;
import com.example.helpers.LoginService;
import com.example.helpers.RestService;
import com.example.helpers.GenericAsyncTask;
import com.example.wrapper.ListPositionWrapper;

public class ListPositionService extends GenericAsyncTask {
	
	protected ListPositionWrapper listPositionWrapper;
	protected ListRecords listRecords;
	protected String logname;
	protected ApiService apiService; 

	public ListPositionService(ListRecords listRecords, ApiService apiService) {
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
		
		RestService<HeaderRequest, ListPositionWrapper> restService = new RestService<HeaderRequest, ListPositionWrapper>(apiService, headerRequest, ListPositionWrapper.class, listRecords.getActivity());
		try {
			ResponseEntity<ListPositionWrapper> response = restService.doRequest();
			if(restService.statusRequest){
				listPositionWrapper = response.getBody();
				Log.d(logname, "Your petition was successful.");
				return true;
			}
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
			
			listRecords.adapterPosition = new ArrayAdapter<String>(listRecords.getActivity(),android.R.layout.simple_list_item_1,listRecords.records);
			listRecords.mPositionList.setAdapter(listRecords.adapterPosition);
			
		}else{
			Log.d(logname, "You had an error in your petition.");
		}
	}

}
