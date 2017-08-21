package com.example.helpers;

import org.springframework.http.HttpStatus;

import com.example.beans.HeaderRequest;
import com.example.beans.Position;
import com.example.exception.RestWineException;
import com.example.goodwine.R;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public abstract class GenericAsyncTask extends AsyncTask<HeaderRequest, Integer, Boolean>{
	
	protected RestWineException restWineException;
	
	protected String logname;
	protected Activity activity;
	
	public GenericAsyncTask(Activity activity) {
		super();
		this.activity = activity;
		logname = this.getClass().getSimpleName();
	}

	@Override
	protected void onPostExecute(Boolean result){
		if(result == false){
			Log.d(logname, "It had an error.");
			if(restWineException != null){
				switch (restWineException.getStatusError()) {
					case REQUEST_TIMEOUT:
						Toast.makeText(activity, restWineException.getMessage(), Toast.LENGTH_LONG).show();
					break;
					case INTERNAL_SERVER_ERROR:
						Toast.makeText(activity, restWineException.getMessage(), Toast.LENGTH_LONG).show();
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
			}
		}
	}
}
