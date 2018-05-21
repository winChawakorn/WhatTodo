package com.winchawakorn.whattodo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import com.winchawakorn.whattodo.models.TodoListItem
import com.winchawakorn.whattodo.models.WhatTodo
import kotlinx.android.synthetic.main.activity_filter.*

class FilterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_filter)
    }

    fun onGoClicked(view: View) {
        var filters = ArrayList<Int>()
        if (work.isChecked)
            filters.add(TodoListItem.Tag.WORK.tag)
        if (entertainment.isChecked)
            filters.add(TodoListItem.Tag.ENTERTAINMENT.tag)
        if (routine.isChecked)
            filters.add(TodoListItem.Tag.ROUTINE.tag)
        var intent = Intent(this, WhatTodoActivity::class.java);
        if (filters.size == 0)
            intent = Intent(this, TodoListActivity::class.java)
        else
            WhatTodo.instance.setFilters(filters)
        startActivity(intent);
    }
}
