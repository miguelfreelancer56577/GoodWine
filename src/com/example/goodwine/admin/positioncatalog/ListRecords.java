package com.example.goodwine.admin.positioncatalog;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.example.beans.HeaderRequest;
import com.example.beans.Position;
import com.example.goodwine.R;
import com.example.goodwine.admin.MainActivity;
import com.example.goodwine.admin.positioncatalog.ConcurrentRecord;
import com.example.helpers.ApiService;
import com.example.taks.ListPositionService;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListRecords extends Fragment {
	
	public String[] records;
	protected String logname = this.getClass().getSimpleName();
	public ArrayAdapter<String> adapterPosition;
	public ListView mPositionList;
	public ListPositionService listPositionService;
	public Toast msg;
	public MainActivity activity;  
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity = (MainActivity) activity;
		this.activity.onSectionAttached(getArguments().getInt(
				MainActivity.ARG_SECTION_NUMBER));
		
		msg = Toast.makeText(activity, "", Toast.LENGTH_LONG);
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,false);
		mPositionList = (ListView) rootView.findViewById(R.id.position_list);
		adapterPosition = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1);
		mPositionList.setAdapter(adapterPosition);
		listPositionService = new ListPositionService(this, ApiService.POSITION_CATALOG_GETALL);
		listPositionService.execute(new HeaderRequest());
		return rootView;
	}
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPositionList.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> adapter, View v, int position,long id) {
				FragmentManager fragmentManager = activity.getSupportFragmentManager();
				Position concurrentPosicion = listPositionService.listPositionWrapper.getBusinessResponse().get(position);
				ConcurrentRecord concurrentRecord = new ConcurrentRecord();
				Bundle args = new Bundle();
				try {
					args.putInt(ConcurrentRecord.SEARCH, Integer.parseInt(concurrentPosicion.getIdPosition()));
					concurrentRecord.setArguments(args);
					fragmentManager.beginTransaction().replace(R.id.container,concurrentRecord).addToBackStack(null).commit();
				} catch (NumberFormatException e) {
					e.printStackTrace();
					msg.setText("it had an error to do your request.");
	                msg.show();
				}
			}
			
        });
    }
    
}
