package com.eno.ayong;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {
	
	private Button btnCN;
	private Button btnEN;
	private Button btnTD;
	private Button btnGo;
	private TextView textView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btnCN=(Button)findViewById(R.id.chinese);
        btnEN=(Button)findViewById(R.id.english);
        btnTD=(Button)findViewById(R.id.td_chinese);
        textView=(TextView)findViewById(R.id.textView);        
        btnCN.setOnClickListener(new btnOnClick());
        btnEN.setOnClickListener(new btnOnClick());
        btnTD.setOnClickListener(new btnOnClick());
        
        textView.setText(R.string.hello);
        
        btnGo=(Button)findViewById(R.id.go);
        
        btnGo.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(Main.this, Main_two.class);
				startActivity(intent);
			}
        	
        });
        
    }
    
    class btnOnClick implements Button.OnClickListener{

		@Override
		public void onClick(View v) {
			if(v==btnCN){
				updateLange(Locale.SIMPLIFIED_CHINESE);
				System.out.println(Locale.SIMPLIFIED_CHINESE);
			}else if(v==btnEN){
				updateLange(Locale.ENGLISH);
			}else if(v==btnTD){
				updateLange(Locale.TRADITIONAL_CHINESE);
			}
		}
    	
    }
    
    private void updateLange(Locale locale){    	
		 Resources res = getResources();
		 Configuration config = res.getConfiguration();
		 config.locale = locale;
		 DisplayMetrics dm = res.getDisplayMetrics();
		 res.updateConfiguration(config, dm);
		 
//第二种设置方法
//    	Configuration config=new Configuration();
//    	config.locale=locale;
//    	getBaseContext().getResources().updateConfiguration(config, 
//    			getBaseContext().getResources().getDisplayMetrics());            
    	Toast.makeText(this, "Locale in "+locale+" @denny!", Toast.LENGTH_LONG).show();
    	refresh();  // 刷新當前頁面

    }

	public void refresh() {
		textView.setText(R.string.hello);
		btnGo.setText(R.string.intent);
	}
}