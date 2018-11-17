package sematech.training.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class Publics {
    public static void toast(String msg) {
        Toast.makeText(BaseActivity.mActivity, msg, Toast.LENGTH_SHORT).show();
    }

    public static void closeKeyboard(View view) {
        try {
            InputMethodManager imm = (InputMethodManager) BaseApplication.baseApp.getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            //cannot close
        }

    }

}
