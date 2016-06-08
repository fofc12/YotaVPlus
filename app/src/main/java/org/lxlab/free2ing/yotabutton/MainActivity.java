// yotav+ by free2ing, 160608
// haoyunmail@qq.com, http://i.blog.sina.com.cn/
package org.lxlab.free2ing.yotabutton;


import java.lang.reflect.Method;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity 
{
	//
	LinearLayout mFloatLayout;
	//
	WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();
    WindowManager mWindowManager;
    //** Called when the activity is first created. 
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //WindowManagerImpl.CompatModeWrapper
       /* mWindowManager = (WindowManager)getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        //window type
		//wmParams.type = LayoutParams.TYPE_PHONE; 
		//
        wmParams.format = PixelFormat.RGBA_8888; 
        wmParams.flags = 
//          LayoutParams.FLAG_NOT_TOUCH_MODAL |
          LayoutParams.FLAG_NOT_FOCUSABLE
//          LayoutParams.FLAG_NOT_TOUCHABLE
          ;
        //
        wmParams.gravity = Gravity.LEFT | Gravity.TOP; 
        //
        wmParams.x = 0;
        wmParams.y = 0;

        //
        wmParams.width = 200;
        wmParams.height = 80;
        
        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        
        LayoutInflater inflater = LayoutInflater.from(getApplication());
        mFloatLayout = (LinearLayout) inflater.inflate(R.layout.float_layout, null);
        mWindowManager.addView(mFloatLayout, wmParams);
        
        //
        Button mFloatView = (Button)mFloatLayout.findViewById(R.id.float_id);
       
        mFloatView.setOnTouchListener(new OnTouchListener() 
        {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) 
			{
				// TODO Auto-generated method stub
				 wmParams.x = (int) event.getRawX()-mFloatLayout.getWidth()/2;
	             wmParams.y = (int) event.getRawY()-mFloatLayout.getHeight()/2-25;
	             mWindowManager.updateViewLayout(mFloatLayout, wmParams);
				return true;
			}
		});*/
        
        //FloatingWindowActivity
        Button start = (Button)findViewById(R.id.start_id);
        
        Button remove = (Button)findViewById(R.id.remove_id);
        
        start.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, FxService.class);
				startService(intent);
				finish();
			}
		});
        
        remove.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				//uninstallApp("com.phicomm.hu");
				Intent intent = new Intent(MainActivity.this, FxService.class);
				stopService(intent);
			}
		});
        
    }
    
    private void uninstallApp(String packageName)
    {
    	Uri packageURI = Uri.parse("package:"+packageName);
    	Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
    	startActivity(uninstallIntent);
        //setIntentAndFinish(true, true);
    }
    
   /* private void forceStopApp(String packageName) 
    {
    	 ActivityManager am = (ActivityManager)getSystemService(
                 Context.ACTIVITY_SERVICE);
    		 am.forceStopPackage(packageName);
    	 
    	Class c = Class.forName("com.android.settings.applications.ApplicationsState");
    	Method m = c.getDeclaredMethod("getInstance", Application.class);
    	
    	  //mState = ApplicationsState.getInstance(this.getApplication());
    }*/
}