package com.jiahui.activitygroup;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TabHost;

public class MainTabActivity extends TabActivity {
    FrameLayout fmpan;
	TabHost tabHost;
    ImageView image;
    FrameLayout fm;
    LayoutInflater inflater;
	private RadioButton tab_home, tab_second;
    public boolean isReverse=false;
    PopupWindow popup;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab);	
		initView();
		fm.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
		          if(isReverse)
		          {
		        	  isReverse=false;
					popup.dismiss();
					image.setImageResource(R.drawable.toolbar_plus);					 
				 }
		          else{
		        	  isReverse=true;
					    image.setImageResource(R.drawable.toolbar_plusback);
					     showWindow(fmpan);
				 }
		    }
			
		});
		
	}

	private void initView() {
		inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	   // View view=inflater.inflate(R.layout.tab,null);
		fmpan=(FrameLayout)findViewById(R.id.tab1);
		fm=(FrameLayout)findViewById(R.id.btn_ck);
      image=(ImageView)findViewById(R.id.image1);
      View view=inflater.inflate(R.layout.write_tab,null);
	}
	
	   /** 
	60.     * ��ʾ 
	61.     *  
	62.     * @param parent 
	63.     */  
	    private void showWindow(View parent) {  
	  
	      if (popup == null) {  
	            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	  
	         View   view = layoutInflater.inflate(R.layout.write_tab, null);  
	            // ����һ��PopuWidow����  
	         popup = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,320);  
	        }  	  
	       // ʹ��ۼ�  
	      popup.setFocusable(true);  
	      // ����������������ʧ  
	      popup.setOutsideTouchable(true);  	  
	        // �����Ϊ�˵��������Back��Ҳ��ʹ����ʧ�����Ҳ�����Ӱ����ı���  
	      popup.setBackgroundDrawable(new BitmapDrawable());
	      popup.setTouchInterceptor(new OnTouchListener() {  
	    	  
	    	           
	    	             public boolean onTouch(View view, MotionEvent event) {  
	    	    
	    	                 if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {  
	    	   
	    	                	  isReverse=false;
	    	  					popup.dismiss();
	    	  					image.setImageResource(R.drawable.toolbar_plus); 
	    	    
	    	                     return true;  
	    	    
	    	                 }  
	    	    
	    	                  return false;  
	    	              }  
	           });  

	      
	      WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);  
	      // ��ʾ��λ��Ϊ:��Ļ�Ŀ�ȵ�һ��-PopupWindow�ĸ߶ȵ�һ��  
	              int xPos = windowManager.getDefaultDisplay().getWidth() / 2  
	                      - popup.getWidth() / 2;  
	      popup.showAsDropDown(parent,Gravity.CENTER,0);  
	    }  

	
}