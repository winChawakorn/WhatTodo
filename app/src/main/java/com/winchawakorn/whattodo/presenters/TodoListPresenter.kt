package com.winchawakorn.whattodo.presenters

import com.winchawakorn.whattodo.models.TodoList
import com.winchawakorn.whattodo.models.TodoListItem
import com.winchawakorn.whattodo.models.TodoListView
import java.util.*
import kotlin.collections.ArrayList

class TodoListPresenter(val view: TodoListView) : Observer {

    init {
        TodoList.instance.addObserver(this)
        setTodoListInView()
    }

    override fun update(observable: Observable?, obj: Any?) {
        if (observable == TodoList.instance) {
            setTodoListInView()
        }
    }

    fun setTodoListInView() {
        val names = ArrayList<String>()
        for (item in TodoList.instance.getList()) {
            names.add(item.name)
        }
        view.setTodoList(names)
    }
}