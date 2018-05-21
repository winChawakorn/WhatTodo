package com.winchawakorn.whattodo.models

import com.winchawakorn.whattodo.presenters.TodoListPresenter
import java.util.*
import kotlin.collections.ArrayList

class TodoList private constructor() : Observable() {
    private var list: ArrayList<TodoListItem>

    init {
        list = ArrayList()
    }

    private object Holder {
        val INSTANCE = TodoList()
    }

    companion object {
        val instance: TodoList by lazy { Holder.INSTANCE }
    }

    fun getList(): ArrayList<TodoListItem> {
        return list
    }

    fun notifyObserver() {
        setChanged()
        notifyObservers()
    }

    fun add(item: TodoListItem) {
        list.add(item)
        notifyObserver()
    }

    fun remove(item: TodoListItem) {
        if (!list.contains(item))
            return
        list.remove(item)
        notifyObserver()
    }

    fun remove(index: Int) {
        if (list.size == 0)
            return
        list.removeAt(index);
        notifyObserver()
    }
}