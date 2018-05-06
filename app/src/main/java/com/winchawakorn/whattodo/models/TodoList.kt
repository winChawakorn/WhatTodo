package com.winchawakorn.whattodo.models

import com.winchawakorn.whattodo.presenters.TodoListPresenter
import java.util.*
import kotlin.collections.ArrayList

class TodoList private constructor() : Observable() {
    private var list: ArrayList<TodoListItem>

    init {
        list = ArrayList()
    }

    fun getList(): ArrayList<TodoListItem> {
        return list
    }

    fun addItem(item: TodoListItem) {
        list.add(item)
        setChanged()
        notifyObservers()
    }

    fun remove(item: TodoListItem) {
        list.remove(item)
        setChanged()
        notifyObservers()
    }

    private object Holder {
        val INSTANCE = TodoList()
    }

    companion object {
        val instance: TodoList by lazy { Holder.INSTANCE }
    }
}