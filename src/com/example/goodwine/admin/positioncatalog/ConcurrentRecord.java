package com.example.goodwine.admin.positioncatalog;

import com.example.goodwine.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ConcurrentRecord extends Fragment {
	public static String SEARCH = "search";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.concurrent_record_position_catalog, container,false);
		return rootView;
	}
	
	
}
