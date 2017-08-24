package com.example.goodwine.admin.positioncatalog;

import com.example.beans.HeaderRequest;
import com.example.beans.Position;
import com.example.goodwine.R;
import com.example.helpers.ApiService;
import com.example.taks.UpdatePosition;
import com.example.taks.GetPositionById;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View.OnClickListener;

public class ConcurrentRecord extends Fragment {
	
	public static String SEARCH = "search";
	static final String SEARCHED = "searched";
	public Position recordPosition;
	protected String logname = this.getClass().getSimpleName();
	
//	components
	public EditText txtNamePosicion;
	public EditText txtDescriptionPosition;
	public CheckBox chxStatusPosicion;
	public Button btnSave;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.concurrent_record_position_catalog, container,false);
		txtNamePosicion = (EditText) rootView.findViewById(R.id.txtNamePosicion);
		txtDescriptionPosition = (EditText) rootView.findViewById(R.id.txtDescriptionPosition);
		chxStatusPosicion = (CheckBox) rootView.findViewById(R.id.chxStatusPosicion);;
		btnSave = (Button) rootView.findViewById(R.id.btnsave);
		GetPositionById getByName = new GetPositionById(this, ApiService.POSITION_CATALOG_GETBYID);
		HeaderRequest headerRequest = new HeaderRequest();
		Position position = new Position();
//		args.putInt(ConcurrentRecord.SEARCH, Integer.parseInt(concurrentPosicion.getIdPosition()));
		position.setIdPosition(String.valueOf(getArguments().getInt(SEARCH)));
		headerRequest.setBusinessRequest(position);
        getByName.execute(headerRequest);
		return rootView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		btnSave.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
            	Log.d(logname, "Saving Record.");
            	recordPosition.setDescriptionPosition(txtDescriptionPosition.getText().toString());
            	if(chxStatusPosicion.isChecked())
            		recordPosition.setIdStatus("1");
            	else
            		recordPosition.setIdStatus("0");
            	recordPosition.setNamePosition(txtNamePosicion.getText().toString());
	        	HeaderRequest headerRequest = new HeaderRequest();
	        	headerRequest.setBusinessRequest(recordPosition);
	        	UpdatePosition updatePosition = new UpdatePosition(ConcurrentRecord.this, ApiService.POSITION_CATALOG_UPDATE);
	        	updatePosition.execute(headerRequest);
            }
        });
		
//		getView().findViewById(R.id.deletePosition).setOnTouchListener(new View.OnTouchListener() {
//	        @Override
//	        public boolean onTouch(View view, MotionEvent motionEvent) {
//	        	Log.d(logname, "Deleting Record.");
//	        	HeaderRequest headerRequest = new HeaderRequest();
//	        	headerRequest.setBusinessRequest(recordPosition);
//	        	DeletePositionById deletePositionById = new DeletePositionById(ConcurrentRecord.this, ApiService.POSITION_CATALOG_DELETEBYID);
//	        	deletePositionById.execute(headerRequest);
//	            return true;
//	        }
//	    });
		
	}
}
