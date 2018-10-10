package sematech.training.utils;

import android.widget.Toast;

public class Publics {
    public static void toast(String msg){
        Toast.makeText(BaseActivity.mActivity, msg, Toast.LENGTH_SHORT).show();
    }

}
