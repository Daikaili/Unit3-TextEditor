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
		btnBlue=(Button)findViewById(R.id.btnBlue);           //����ID��ȡ�ؼ�
		
		ColorListener myColorListener=new ColorListener();   //������������
		btnRed.setOnClickListener(myColorListener);
		btnGreen.setOnClickListener(myColorListener);
		btnBlue.setOnClickListener(myColorListener);      //ע�������
		
		
		testText.setTypeface(Typeface.DEFAULT);
		btnBold=(Button)findViewById(R.id.btnBold);
		btnItalic=(Button)findViewById(R.id.btnItalic);
		btnMoren=(Button)findViewById(R.id.btnMoren);
		
		btnItalic.setOnClickListener(this);
		btnBold.setOnClickListener(this);
		btnMoren.setOnClickListener(this);    //��ȡ������ʽ�ؼ��ͼ���
		
		
		content=(EditText)findViewById(R.id.content);
		content.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				// TODO Auto-generated method stub
				testText.setText(content.getText().toString());   //�����ı�������
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

        			Typeface tf=testText.getTypeface();         //��ȡ��ǰ������ʽ
        			//testText.get
        			switch (v.getId()) {
        			case R.id.btnItalic:			                  //������б��ť
        				if(flag==2||flag==3){
        					testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
        					flag=3;
        				}else{
        					testText.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC);//б��
        					flag=1;
        				}			
        				break;
        			case R.id.btnBold:                 //����Ӵ�
        				if(flag==1||flag==3){
        					testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);//����
        					flag=3;
        				}else{
        					testText.setTypeface(Typeface.DEFAULT_BOLD,Typeface.BOLD);//����
        					flag=2;
        				}						
        				break;
        			case R.id.btnMoren:                  //����Ĭ�ϰ�ť
        				testText.setTypeface(Typeface.MONOSPACE,Typeface.NORMAL);
        				flag=0;
        				break;
        			default:
        				break;
        			}
}
}

