package sematech.training.custom_views;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import sematech.training.utils.BaseApplication;

public class MyButton extends AppCompatButton {
    public MyButton(Context context) {
        super(context);
        this.setTypeface(BaseApplication.typeFace);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(BaseApplication.typeFace);
    }
}
