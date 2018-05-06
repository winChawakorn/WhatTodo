package com.winchawakorn.whattodo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import com.winchawakorn.whattodo.models.TodoList
import com.winchawakorn.whattodo.models.TodoListItem
import com.winchawakorn.whattodo.models.TodoListView
import com.winchawakorn.whattodo.presenters.TodoListPresenter
import kotlinx.android.synthetic.main.activity_todo_list.*

class TodoListActivity : AppCompatActivity(), TodoListView {

    lateinit var presenter: TodoListPresenter;

    var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_todo_list)
        presenter = TodoListPresenter(this);
    }

    override fun setTodoList(todoList: ArrayList<String>) {
        if (todoList.size == 0) {
            val empty = ArrayList<String>()
            empty.add("Nothing to do")
            adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, empty)
        } else
            adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoList)
        todolist.adapter = adapter;
    }

    fun onAddClicked(view: View) {
        TodoList.instance.addItem(TodoListItem("Test", TodoListItem.Tag.ADD_BY_USER.tag, ""))
    }

    fun changeActivity() {
//        val intent = Intent(this, TodoListActivity::class.java);
//        startActivity(intent);
    }

}
