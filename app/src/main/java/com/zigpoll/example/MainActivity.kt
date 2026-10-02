package com.zigpoll.example

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.zigpoll.Zigpoll

/* Zigpoll Android SDK example.

   Setup:
   1. In the Zigpoll dashboard, create a survey and set its delivery type
      to API (Delivery Settings -> API).
   2. Replace YOUR_ACCOUNT_ID with your account id (Dashboard -> Installation)
      and YOUR_SURVEY_ID with the survey's id.
   3. Run, then tap "Trigger survey". */

class MainActivity : AppCompatActivity() {

    private val pollId = "YOUR_SURVEY_ID"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Zigpoll.configure(this, "YOUR_ACCOUNT_ID", preview = true)

        /* Optional: associate responses with your app user. */
        Zigpoll.identify("example-user-1", mapOf("email" to "user@example.com"))

        Zigpoll.onLoad = { Log.d("zigpoll", "survey loaded") }
        Zigpoll.onComplete = { responses -> Log.d("zigpoll", "completed: ${responses.size} responses") }
        Zigpoll.onClose = { responses -> Log.d("zigpoll", "closed: ${responses.size} responses") }
        Zigpoll.onError = { error -> Log.d("zigpoll", "error: $error") }

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(48, 48, 48, 48)
        }

        layout.addView(TextView(this).apply {
            text = "Zigpoll SDK Example"
            textSize = 22f
            gravity = Gravity.CENTER
        })

        layout.addView(Button(this).apply {
            text = "Trigger survey"
            setOnClickListener { Zigpoll.trigger(pollId, this@MainActivity) }
        })

        layout.addView(Button(this).apply {
            text = "Dismiss"
            setOnClickListener { Zigpoll.dismiss() }
        })

        layout.addView(Button(this).apply {
            text = "Logout"
            setOnClickListener { Zigpoll.logout() }
        })

        setContentView(layout)
    }
}
