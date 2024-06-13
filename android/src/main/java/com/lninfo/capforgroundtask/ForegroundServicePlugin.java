package com.lninfo.capforgroundtask;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ForegroundServicePlugin extends Plugin {

    private static final String TAG = "ForegroundServicePlugin";
    private static final String CHANNEL_ID = "ForegroundServiceChannel";
    private static final int NOTIFICATION_ID = 12345;

    private Intent serviceIntent;

    @Override
    public void load() {
        super.load();
        Log.d(TAG, "Plugin loaded successfully");
    }

    @PluginMethod
    public void startForegroundService(PluginCall call) {
        String input = call.getString("input");
        Context context = getContext();
        serviceIntent = new Intent(context, ForegroundService.class);
        serviceIntent.putExtra("inputExtra", input);
        context.startForegroundService(serviceIntent);

        JSObject ret = new JSObject();
        ret.put("success", true);
        call.resolve(ret);
    }

    @PluginMethod
    public void stopForegroundService(PluginCall call) {
        Context context = getContext();
        if (serviceIntent != null) {
            context.stopService(serviceIntent);
        }
        JSObject ret = new JSObject();
        ret.put("success", true);
        call.resolve(ret);
    }
}
