package com.example.taks;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import android.util.Log;
import android.widget.EditText;

import com.example.beans.HeaderRequest;
import com.example.beans.HeaderResponse;
import com.example.beans.Position;
import com.example.exception.RestWineException;
import com.example.goodwine.admin.positioncatalog.ConcurrentRecord;
import com.example.helpers.ApiService;
import com.example.helpers.GenericAsyncTask;
import com.example.helpers.LoginService;
import com.example.helpers.RestService;
import com.example.wrapper.ListPositionWrapper;
import com.example.wrapper.PositionWrapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetById extends GenericAsyncTask {

	protected PositionWrapper positionWrapper;
	protected ConcurrentRecord concurrentRecord;
	protected String logname;
	protected ApiService apiService; 
	
	public GetById(ConcurrentRecord concurrentRecord, ApiService apiService) {
		super(concurrentRecord.getActivity());
		logname = this.getClass().getSimpleName();
		this.concurrentRecord = concurrentRecord;
		this.apiService = apiService;
	}
	
	@Override
	protected Boolean doInBackground(HeaderRequest... arg0) {
		
		 HeaderRequest headerRequest = arg0[0];
		
		if(LoginService.INFOUSER != null){
			headerRequest.setIdUser(LoginService.INFOUSER.getUser().getIdUser());
			headerRequest.setToken(LoginService.INFOUSER.getUser().getToken());
		}
		
		RestService<HeaderRequest, PositionWrapper> restService = new RestService<HeaderRequest, PositionWrapper>(apiService, headerRequest, PositionWrapper.class, concurrentRecord.getActivity());
		try {
			ResponseEntity<PositionWrapper> response = restService.doRequest();
			if(restService.statusRequest){
				positionWrapper = response.getBody();
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
		if(result){
					concurrentRecord.recordPosition = positionWrapper.getBusinessResponse();
					concurrentRecord.txtDescriptionPosition.setText(concurrentRecord.recordPosition.getDescriptionPosition().trim());
					concurrentRecord.txtNamePosicion.setText(concurrentRecord.recordPosition.getNamePosition().trim());
					int status;
					try {
						status = Integer.parseInt(concurrentRecord.recordPosition.getIdStatus());
						if(status == 1)
							concurrentRecord.chxStatusPosicion.setChecked(true);
						else
							concurrentRecord.chxStatusPosicion.setChecked(false);
					} catch (NumberFormatException e) {
						Log.e(logname, "Error to parse the status of the record.");
						e.printStackTrace();
					}
		}
	}

}
