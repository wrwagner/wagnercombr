package com.example.logonrmlocal.wagnercombr

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    val notificationTime = Calendar.getInstance().timeInMillis + 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botao1.setOnClickListener{
            val alarmeManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

            val alarmeIntent = Intent(this, AlarmeReciver::class.java)
            alarmeIntent.putExtra("MSG2","Msg da Main")

            val pendeinIntent = PendingIntent.getBroadcast(this,
                    0,
                    alarmeIntent,
                    PendingIntent.FLAG_CANCEL_CURRENT)

            alarmeManager.set(AlarmManager.RTC_WAKEUP,
                    notificationTime,
                    pendeinIntent)
        }

        botao2.setOnClickListener {
            NotificationUtils.showNotification(this,
                    123,
                    "CHANEL_BOTAO_DOIS",
                    "CHANEL_BOTAO_DOIS_NAME",
                    "Hello notification",
                    "Este e o primeiro exemplo"
                    )
        }
    }
}
