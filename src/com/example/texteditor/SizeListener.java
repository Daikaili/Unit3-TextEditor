package com.example.texteditor;

import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SizeListener  implements OnClickListener{
	private TextView tv;
	public SizeListener(TextView tv) {      //��ʼ����Ҫ����Ŀؼ�

		
		this.tv = tv;
	}
	public void onClick(View v) {            //��ȡ��ǰ�������С

		float f=tv.getTextSize();            //�ж�����������С
		switch (v.getId()) {
		case R.id.btnBigger:
			f=f+2;                              //����ÿ������2
			break;                       
		case R.id.smaller:
			f=f-2;                                //����ÿ����С2
			break;
		default:
			break;
		}
		if(f>=72){
			f=72;                            //�ж������Ƿ����72
		}
		if(f<=8){       
			f=8;                             //�ж������Ƿ�С��8
		}
		tv.setTextSize(TypedValue.COMPLEX_UNIT_PX,f);
	}
}

