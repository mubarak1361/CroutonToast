package com.example.croutontoast;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity extends SherlockFragmentActivity implements OnClickListener {

	private CroutonToast croutonToast;
	private Button toast;
	private final int interval = 2000; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        croutonToast = (CroutonToast) getSupportFragmentManager().findFragmentById(R.id.crouton);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.hide(croutonToast);
		ft.commit();
		
		toast = (Button)findViewById(R.id.toast);
		toast.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.toast:
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
	        ft.setCustomAnimations(R.animator.enter,R.animator.exit);
			ft.show(croutonToast);
			ft.commit();
			
			Handler handler = new Handler();
			 Runnable runnable = new Runnable(){
			    public void run() {

			         FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			         ft.setCustomAnimations(R.animator.enter,R.animator.exit);
			 		ft.hide(croutonToast);
			 		ft.commit();
			 		
			    	
			    }
			};

			handler.postAtTime(runnable, System.currentTimeMillis()+interval);
			handler.postDelayed(runnable, interval);
			
			break;

		default:
			break;
		}
		
	}
}
