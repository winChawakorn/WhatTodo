package com.winchawakorn.whattodo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import com.winchawakorn.whattodo.models.TodoList
import com.winchawakorn.whattodo.models.TodoListItem
import com.winchawakorn.whattodo.models.WhatTodo
import kotlinx.android.synthetic.main.activity_what_todo.*

class WhatTodoActivity : AppCompatActivity() {

    private lateinit var item: TodoListItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_what_todo)
        randomAndSetWhatTodo()
    }

    override fun onBackPressed() {
        changeIntent()
    }

    fun changeIntent() {
        val intent = Intent(this, TodoListActivity::class.java)
        startActivity(intent)
    }

    fun randomAndSetWhatTodo() {
        item = WhatTodo.instance.getWhatTodo()
        suggestion.text = item.name
    }

    fun onDecline(view: View) {
        randomAndSetWhatTodo()
    }

    fun onAccept(view: View) {
        TodoList.instance.add(item)
        changeIntent()
    }


}
