package com.winchawakorn.whattodo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.winchawakorn.whattodo.models.TodoList
import com.winchawakorn.whattodo.models.TodoListItem
import com.winchawakorn.whattodo.models.TodoListView
import com.winchawakorn.whattodo.presenters.TodoListPresenter
import kotlinx.android.synthetic.main.activity_todo_list.*
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.widget.EditText


class TodoListActivity : AppCompatActivity(), TodoListView {

    lateinit var presenter: TodoListPresenter;

    var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_todo_list)
        presenter = TodoListPresenter(this);
        todolistview.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (TodoList.instance.getList().size == 0)
                    return
                val alertDialog = AlertDialog.Builder(this@TodoListActivity).create()
                alertDialog.setTitle("Delete")
                alertDialog.setMessage("Do you want to delete \"" + TodoList.instance.getList().get(position).name + "\"?")
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Yes",
                        DialogInterface.OnClickListener { dialog, which ->
                            dialog.dismiss()
                            TodoList.instance.remove(position)
                        })
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                        DialogInterface.OnClickListener { dialog, which ->
                            dialog.dismiss()
                        })
                alertDialog.show()
            }
        })
    }

    override fun setTodoList(todoList: ArrayList<String>) {
        if (todoList.size == 0)
            todoList.add("Nothing to do")
        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoList)
        todolistview.adapter = adapter;
    }

    fun onAddClicked(view: View) {
        val alertDialog = AlertDialog.Builder(this@TodoListActivity).create()
        alertDialog.setTitle("Add")
        alertDialog.setMessage("What do you want to add?")
        val et = EditText(this)
        alertDialog.setView(et)
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "add",
                DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                    TodoList.instance.add(TodoListItem(et.text.toString().trim(), TodoListItem.Tag.ADD_BY_USER.tag, ""))
                })
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "cancel",
                DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
        alertDialog.show()
    }

    fun changeActivity() {
//        val intent = Intent(this, TodoListActivity::class.java);
//        startActivity(intent);
    }

}
