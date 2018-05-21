package com.winchawakorn.whattodo.models

import java.util.*
import kotlin.collections.ArrayList

class WhatTodo private constructor() {
    private var list: ArrayList<TodoListItem>
    private var showed: ArrayList<TodoListItem>
    private var filters: ArrayList<Int>

    init {
        list = ArrayList()
        showed = ArrayList()
        filters = ArrayList()
        addSuggestItems()
    }

    private object Holder {
        val INSTANCE = WhatTodo()
    }

    companion object {
        val instance: WhatTodo by lazy { Holder.INSTANCE }
    }

    fun setFilters(filters: ArrayList<Int>) {
        this.filters = filters
    }

    fun getWhatTodo(): TodoListItem {
        list.removeAll(showed)
        Collections.shuffle(list)
        for (item in list) {
            for (tag in filters) {
                if (tag == item.tag) {
                    list.remove(item)
                    showed.add(item)
                    return item
                }
            }
        }
        list.addAll(showed)
        showed.clear()
        return getWhatTodo()
    }


    fun addSuggestItems() {
        if (list.size != 0)
            return;
        list.add(TodoListItem("Play some games?", TodoListItem.Tag.ENTERTAINMENT.tag, "Play some game!, but don't forget to do your work."))
        list.add(TodoListItem("Watch a movie?", TodoListItem.Tag.ENTERTAINMENT.tag, "Great! this website may useful. 123movie.cc"))
        list.add(TodoListItem("Go to shopping?", TodoListItem.Tag.ENTERTAINMENT.tag, "Good choice!, but beware about your money."))
        list.add(TodoListItem("Taking a shower?", TodoListItem.Tag.ROUTINE.tag, "Taking a bath can make you be fresh"))
        list.add(TodoListItem("Have a sleep?", TodoListItem.Tag.ROUTINE.tag, "You should sleep at least 6 hours per day."))
        list.add(TodoListItem("Have a meal?", TodoListItem.Tag.ROUTINE.tag, "Don't eat too much, or you'll get fat."))
        list.add(TodoListItem("Cooking?", TodoListItem.Tag.ROUTINE.tag, "Don't know what to cook? https://www.kubkhao.com/"))
        list.add(TodoListItem("Do some housework?", TodoListItem.Tag.ROUTINE.tag, "Great! your home should be cleaned everyday"))
    }
}
