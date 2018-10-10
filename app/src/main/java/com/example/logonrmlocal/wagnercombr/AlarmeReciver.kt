package com.example.logonrmlocal.wagnercombr

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmeReciver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val service = Intent(context, NotificationService::class.java)
        service.putExtra("MSG","TEST")
        service.putExtra("MGG2", intent?.getStringExtra("MSG2"))
        context?.startService(service)
    }
}