package com.example.taks;

import java.util.Iterator;

import org.springframework.http.ResponseEntity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.Toast;

import com.example.goodwine.R;
import com.example.beans.HeaderRequest;
import com.example.beans.HeaderResponse;
import com.example.exception.RestWineException;
import com.example.goodwine.admin.positioncatalog.ConcurrentRecord;
import com.example.goodwine.admin.positioncatalog.ListRecords;
import com.example.helpers.ApiService;
import com.example.helpers.GenericAsyncTask;
import com.example.helpers.LoginService;
import com.example.helpers.RestService;

public class UpdatePosition extends GenericAsyncTask {

	protected HeaderResponse headerResponse;
	protected ConcurrentRecord concurrentRecord;
	protected String logname;
	protected ApiService apiService; 
	
	public UpdatePosition(ConcurrentRecord concurrentRecord, ApiService apiService) {
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
		
		RestService<HeaderRequest, HeaderResponse> restService = new RestService<HeaderRequest, HeaderResponse>(apiService, headerRequest, HeaderResponse.class, concurrentRecord.getActivity());
		try {
			ResponseEntity<HeaderResponse> response = restService.doRequest();
			if(restService.statusRequest){
				headerResponse = response.getBody();
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
			Log.d(logname, concurrentRecord.getActivity().getText(R.string.isOkUpdate).toString());
			Toast.makeText(concurrentRecord.getActivity(),concurrentRecord.getActivity().getText(R.string.isOkUpdate),Toast.LENGTH_LONG).show();
		}else{
			Log.d(logname, concurrentRecord.getActivity().getText(R.string.isErrorUpdate).toString());
			Toast.makeText(concurrentRecord.getActivity(),concurrentRecord.getActivity().getText(R.string.isErrorUpdate),Toast.LENGTH_LONG).show();
		}
	}

}
