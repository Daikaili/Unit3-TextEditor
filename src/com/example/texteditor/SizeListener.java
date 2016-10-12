package com.example.texteditor;

import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SizeListener  implements OnClickListener{
	private TextView tv;
	public SizeListener(TextView tv) {      //初始化需要传入的控件

		
		this.tv = tv;
	}
	public void onClick(View v) {            //获取当前的字体大小

		float f=tv.getTextSize();            //判断是增大还是缩小
		switch (v.getId()) {
		case R.id.btnBigger:
			f=f+2;                              //字体每次增大2
			break;                       
		case R.id.smaller:
			f=f-2;                                //字体每次缩小2
			break;
		default:
			break;
		}
		if(f>=72){
			f=72;                            //判断字体是否大于72
		}
		if(f<=8){       
			f=8;                             //判断字体是否小于8
		}
		tv.setTextSize(TypedValue.COMPLEX_UNIT_PX,f);
	}
}

