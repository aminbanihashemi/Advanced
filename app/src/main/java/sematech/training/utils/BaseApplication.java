package sematech.training.utils;

import android.app.Application;
import android.graphics.Typeface;

import sematech.training.Constants;

public class BaseApplication extends Application {
    public static BaseApplication baseApp;
    public static Typeface typeFace;
    @Override
    public void onCreate() {
        super.onCreate();
        baseApp = this;
        typeFace = Typeface.createFromAsset(getAssets(),Constants.appFontName);
    }
}
