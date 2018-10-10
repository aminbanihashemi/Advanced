package sematech.training.custom_views;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import sematech.training.utils.BaseApplication;

public class MyTextView extends AppCompatTextView {
    public MyTextView(Context context) {
        super(context);
        this.setTypeface(BaseApplication.typeFace);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(BaseApplication.typeFace);
    }
}
