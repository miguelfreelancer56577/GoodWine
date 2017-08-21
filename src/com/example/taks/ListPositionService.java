package com.example.taks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.beans.HeaderRequest;
import com.example.beans.Position;
import com.example.exception.RestWineException;
import com.example.goodwine.admin.positioncatalog.ListRecords;
import com.example.helpers.ApiService;
import com.example.helpers.LoginService;
import com.example.helpers.RestService;
import com.example.helpers.GenericAsyncTask;
import com.example.wrapper.ListPositionWrapper;

public class ListPositionService extends GenericAsyncTask {
	
	public ListPositionWrapper listPositionWrapper;
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
		
		RestService<HeaderRequest, ListPositionWrapper> restService = new RestService<HeaderRequest, ListPositionWrapper>(apiService, headerRequest, ListPositionWrapper.class, listRecords.getActivity());
		try {
			ResponseEntity<ListPositionWrapper> response = restService.doRequest();
			if(restService.statusRequest){
				listPositionWrapper = response.getBody();
				Log.d(logname, "Your petition was successful.");
				return true;
			}
		} catch (RestWineException e) {
			restWineException = e;
			e.printStackTrace();
			Log.e(logname, e.getMessage());
		} catch (Exception e) {
			Log.e(logname, e.getMessage());
		}
		return false;
	}

	@Override
	protected void onPostExecute(Boolean result){
		super.onPostExecute(result);
		listRecords.records = null;
		if(result){
			
			listRecords.records = new String[listPositionWrapper.getBusinessResponse().size()];
			
			Log.d(logname, "The status of your petition was successfull");
			
			int cont = 0; 
			
			for(Position position: listPositionWrapper.getBusinessResponse()){
				listRecords.adapterPosition.add(position.getNamePosition());
			}
		}
	}

}
