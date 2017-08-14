package com.example.goodwine.admin;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.example.beans.HeaderRequest;
import com.example.beans.Position;
import com.example.goodwine.R;
import com.example.helpers.ApiService;
import com.example.taks.ListPositionService;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListRecords extends Fragment {
	
	public String[] records;
	protected String logname = this.getClass().getSimpleName();
	public ArrayAdapter<String> adapterPosition;
	public ListView mPositionList;
	
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListPositionService listPositionService = new ListPositionService(this, ApiService.POSITION_CATALOG_GETALL);
        listPositionService.execute(new HeaderRequest());
    }
    
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//    	mLeadsList.setAdapter(mLeadsAdapter);
		View rootView = inflater.inflate(R.layout.fragment_main, container,false);
		mPositionList = (ListView) rootView.findViewById(R.id.position_list);
		return rootView;
	}
    
    @Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(getArguments().getInt(
				((MainActivity) activity).ARG_SECTION_NUMBER));
	}

}
