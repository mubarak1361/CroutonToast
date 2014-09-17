package com.example.croutontoast;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private CroutonToast successToast,warningToast,errorToast;
	private Button success;
	private Button warning;
	private Button error;
	private final int interval = 2000; 
	private FragmentTransaction ft;
	private Handler handler ;
	private Runnable runnable;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        handler = new Handler();
        
        successToast = new CroutonToast("Success Message" , Color.parseColor("#8bc34a"));		
        warningToast = new CroutonToast("Warning Message" , Color.parseColor("#ff9800"));
        errorToast = new CroutonToast("Error Message" , Color.parseColor("#e51c23"));
        
		success = (Button)findViewById(R.id.success);
		warning = (Button) findViewById(R.id.warning);
		error = (Button)  findViewById(R.id.error);
			
		success.setOnClickListener(this);
		warning.setOnClickListener(this);
		error.setOnClickListener(this);
		
    }

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.success:
			
			ft = getSupportFragmentManager().beginTransaction();
	        ft.setCustomAnimations(R.animator.enter,R.animator.exit);
	        ft.replace(R.id.crouton, successToast);
			ft.show(successToast);
			ft.commit();
			
			 runnable = new Runnable(){
			    public void run() {
			    	
			    	ft = getSupportFragmentManager().beginTransaction();
			        ft.setCustomAnimations(R.animator.enter,R.animator.exit);
			        ft.remove(successToast);
			 		ft.commit();
			 				    	
			    }
			};

			handler.postAtTime(runnable, System.currentTimeMillis()+interval);
			handler.postDelayed(runnable, interval);
			
			break;
			
		case R.id.warning:
			
			ft = getSupportFragmentManager().beginTransaction();
	        ft.setCustomAnimations(R.animator.enter,R.animator.exit);
	        ft.replace(R.id.crouton, warningToast);
			ft.show(warningToast);
			ft.commit();
			
			runnable = new Runnable(){
			    public void run() {
			    	
			    	ft = getSupportFragmentManager().beginTransaction();
			        ft.setCustomAnimations(R.animator.enter,R.animator.exit);
			        ft.remove(warningToast);
			 		ft.commit();
			 				    	
			    }
			};

			handler.postAtTime(runnable, System.currentTimeMillis()+interval);
			handler.postDelayed(runnable, interval);
			
			break;
			
		case R.id.error:
			
			ft = getSupportFragmentManager().beginTransaction();
	        ft.setCustomAnimations(R.animator.enter,R.animator.exit);
	        ft.replace(R.id.crouton, errorToast);
			ft.show(errorToast);
			ft.commit();
			
			runnable = new Runnable(){
			    public void run() {
			    	
			    	ft = getSupportFragmentManager().beginTransaction();
			        ft.setCustomAnimations(R.animator.enter,R.animator.exit);
			        ft.remove(errorToast);
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
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		
		 handler.removeCallbacksAndMessages(null);
		 
	}
}
