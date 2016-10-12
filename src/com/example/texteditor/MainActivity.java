package com.example.texteditor;

import android.os.Bundle;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

	

public class MainActivity extends Activity  implements  OnClickListener{
	//final Button btnRed=(Button)this.findViewById(R.id.btnRed);
   private Button btnRed,btnGreen,btnBlue;
   private TextView testText;
   private Button btnBold,btnItalic,btnMoren;
   private int flag=0;
   private EditText content;
  
	@Override
 	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		testText=(TextView)findViewById(R.id.testText);
		btnRed=(Button)findViewById(R.id.btnRed);
		btnGreen=(Button)findViewById(R.id.btnGreen);
		btnBlue=(Button)findViewById(R.id.btnBlue);           //根据ID获取控件
		
		ColorListener myColorListener=new ColorListener();   //创建监听对象
		btnRed.setOnClickListener(myColorListener);
		btnGreen.setOnClickListener(myColorListener);
		btnBlue.setOnClickListener(myColorListener);      //注册监听器
		
		
		testText.setTypeface(Typeface.DEFAULT);
		btnBold=(Button)findViewById(R.id.btnBold);
		btnItalic=(Button)findViewById(R.id.btnItalic);
		btnMoren=(Button)findViewById(R.id.btnMoren);
		
		btnItalic.setOnClickListener(this);
		btnBold.setOnClickListener(this);
		btnMoren.setOnClickListener(this);    //获取字体样式控件和监听
		
		
		content=(EditText)findViewById(R.id.content);
		content.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				// TODO Auto-generated method stub
				testText.setText(content.getText().toString());   //设置文本框内容
				return false;
				
			}
		});
			
		
	}
	
         private  class ColorListener implements OnClickListener{
        	 public void onClick(View v){
        		 switch(v.getId()){
        		 case R.id.btnRed:
        			 testText.setTextColor(Color.RED);break;
        		
        		 case R.id.btnBlue:
        			 testText.setTextColor(Color.BLUE);break;
        		 case R.id.btnGreen:
        			 testText.setTextColor(Color.GREEN);break;
        			 default:break;
        		 }
        	 }
         }
         
        	 public void onClick(View v) {		

        			Typeface tf=testText.getTypeface();         //获取当前字体样式
        			//testText.get
        			switch (v.getId()) {
        			case R.id.btnItalic:			                  //单击倾斜按钮
        				if(flag==2||flag==3){
        					testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
        					flag=3;
        				}else{
        					testText.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC);//斜体
        					flag=1;
        				}			
        				break;
        			case R.id.btnBold:                 //字体加粗
        				if(flag==1||flag==3){
        					testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);//粗体
        					flag=3;
        				}else{
        					testText.setTypeface(Typeface.DEFAULT_BOLD,Typeface.BOLD);//粗体
        					flag=2;
        				}						
        				break;
        			case R.id.btnMoren:                  //单击默认按钮
        				testText.setTypeface(Typeface.MONOSPACE,Typeface.NORMAL);
        				flag=0;
        				break;
        			default:
        				break;
        			}
}
}

