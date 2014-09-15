package com.example.croutontoast;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

public class CroutonToast extends SherlockFragment {
	private TextView message;
	private String text;
	private int bgColor;
	private RelativeLayout rel;
	
	public CroutonToast(String text,int bgColor) {
		this.text =  text;
		this.bgColor = bgColor;
	}
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.success_pop_up, container, false);
		rel =  (RelativeLayout)view.findViewById(R.id.layout);
		rel.setBackgroundColor(bgColor);
		message =(TextView) view.findViewById(R.id.pop_up_text);
		message.setText(text);
		
		return view;
	}
}
