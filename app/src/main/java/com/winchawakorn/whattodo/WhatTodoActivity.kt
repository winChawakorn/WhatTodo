package com.winchawakorn.whattodo

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.view.View
import android.view.WindowManager
import android.widget.EditText
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
        if (item.tag == -1)
            alert("Out of suggestion", "I'm out of suggestion, please remove some from todo list.")
        suggestion.text = item.name + "?"
    }

    fun alert(title: String, msg: String) {
        val alertDialog = AlertDialog.Builder(this@WhatTodoActivity).create()
        alertDialog.setTitle(title)
        alertDialog.setMessage(msg)
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ok",
                DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                    changeIntent()
                })
        alertDialog.show()
    }

    fun onDecline(view: View) {
        randomAndSetWhatTodo()
    }

    fun onAccept(view: View) {
        TodoList.instance.add(item)
        alert("Suggestion", item.suggestion)
    }


}
