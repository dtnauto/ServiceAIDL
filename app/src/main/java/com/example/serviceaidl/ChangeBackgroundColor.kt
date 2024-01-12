package com.example.serviceaidl

import android.app.Service
import android.content.Intent
import android.graphics.Color
import android.os.IBinder
import android.util.Log
import java.util.Random

class ChangeBackgroundColor : Service() {

    private var binder: AIDLInterface.Stub = object : AIDLInterface.Stub() {
        override fun getBackgroundColor(): Int {
            var color = Color.argb(255,Random().nextInt(254),Random().nextInt(254),Random().nextInt(254))
            Log.d("mycodeisblocking","getcolor: "+ color)
            return color
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }
}