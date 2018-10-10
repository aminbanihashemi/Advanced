package sematech.training.custom_views;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import sematech.training.utils.BaseApplication;

public class MyEditText extends AppCompatEditText {
    public MyEditText(Context context) {
        super(context);
        this.setTypeface(BaseApplication.typeFace);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(BaseApplication.typeFace);
    }
    public String text(){
        return (this.getText() != null ? this.getText().toString():"");
    }
}

