package com.example.goodwine.admin.positioncatalog;

import com.example.beans.HeaderRequest;
import com.example.beans.Position;
import com.example.goodwine.R;
import com.example.helpers.ApiService;
import com.example.taks.GetById;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

public class ConcurrentRecord extends Fragment {
	
	public static String SEARCH = "search";
	static final String SEARCHED = "searched";
	public Position recordPosition;
	
//	components
	public EditText txtNamePosicion;
	public EditText txtDescriptionPosition;
	public CheckBox chxStatusPosicion;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.concurrent_record_position_catalog, container,false);
		txtNamePosicion = (EditText) rootView.findViewById(R.id.txtNamePosicion);
		txtDescriptionPosition = (EditText) rootView.findViewById(R.id.txtDescriptionPosition);
		chxStatusPosicion = (CheckBox) rootView.findViewById(R.id.chxStatusPosicion);;
		GetById getByName = new GetById(this, ApiService.POSITION_CATALOG_GETBYID);
		HeaderRequest headerRequest = new HeaderRequest();
		Position position = new Position();
//		args.putInt(ConcurrentRecord.SEARCH, Integer.parseInt(concurrentPosicion.getIdPosition()));
		position.setIdPosition(String.valueOf(getArguments().getInt(SEARCH)));
		headerRequest.setBusinessRequest(position);
        getByName.execute(headerRequest);
		return rootView;
	}
}
