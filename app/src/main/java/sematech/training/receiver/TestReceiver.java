package sematech.training.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import sematech.training.utils.Publics;

public class TestReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Publics.toast("Battery Changed");

    }
}
