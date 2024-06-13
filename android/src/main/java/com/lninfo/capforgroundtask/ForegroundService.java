package com.lninfo.capforgroundtask;

import android.util.Log;

public class ForegroundService {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
