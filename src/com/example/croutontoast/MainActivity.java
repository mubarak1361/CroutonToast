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
		warning = (Button)findViewById(R.id.warning);
		error = (Button)findViewById(R.id.error);
			
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
	
	
	
	
	/*public int getImageId(int groupPosition, int childPosition, Resources res) {

		TypedArray intarray = res.obtainTypedArray(R.array.all_imgs);
		int len1 = intarray.length();
		int[] resIds1 = new int[len1];

		for (int i = 0; i < len1; i++) {
			resIds1[i] = intarray.getResourceId(i, 0);
			Log.d("GroupArratIDs",
					"Res Id " + i + " is " + Integer.toHexString(resIds1[i]));
		}

		TypedArray intarray1 = res.obtainTypedArray(resIds1[groupPosition]);
		int len = intarray1.length();
		int[] resIds2 = new int[len];
		for (int k = 0; k < len; k++) {
			resIds2[k] = intarray1.getResourceId(k, 0);
			Log.v("ChildArrayIDs",
					"Res Id " + k + " is " + Integer.toHexString(resIds2[k]));
		}
		return resIds2[childPosition];

	}

	public ArrayList<String> getString(int position, Resources res) {

		TypedArray sringarray = res.obtainTypedArray(R.array.all_imgs);
		ArrayList<ArrayList<String>> title = new ArrayList<ArrayList<String>>();

		int n = sringarray.length();
		for (int i = 0; i < n; ++i) {
			int id = sringarray.getResourceId(i, 0);
			if (id > 0) {
				ArrayList<String> temp_name = new ArrayList<String>(
						Arrays.asList(res.getStringArray(id)));
				title.add(temp_name);
			} else {

			}
		}

		sringarray.recycle();

		return title.get(position);
	}
*/
}
