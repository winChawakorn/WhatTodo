package com.winchawakorn.whattodo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome)
        changeActivity();
    }

    fun changeActivity() {
        val handler = Handler()
        handler.postDelayed(Runnable {
            val intent = Intent(this, TodoListActivity::class.java);
            startActivity(intent);
        }, 3000)
    }

}
