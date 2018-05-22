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
        list.removeAll(TodoList.instance.getList())
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
        return TodoListItem("", -1, "")
    }

    fun addSuggestItems() {
        if (list.size != 0)
            return;
        list.add(TodoListItem("Play some games", TodoListItem.Tag.ENTERTAINMENT.tag, "Play some game!, but don't forget to do your work."))
        list.add(TodoListItem("Watch a movie", TodoListItem.Tag.ENTERTAINMENT.tag, "Great! this website may useful. 123movie.cc"))
        list.add(TodoListItem("Go to shopping", TodoListItem.Tag.ENTERTAINMENT.tag, "Good choice!, but beware about your money."))
        list.add(TodoListItem("Taking a shower", TodoListItem.Tag.ROUTINE.tag, "Taking a bath can make you be fresh"))
        list.add(TodoListItem("Have a sleep", TodoListItem.Tag.ROUTINE.tag, "You should sleep at least 6 hours per day."))
        list.add(TodoListItem("Have a meal", TodoListItem.Tag.ROUTINE.tag, "Don't eat too much, or you'll get fat."))
        list.add(TodoListItem("Cooking", TodoListItem.Tag.ROUTINE.tag, "Don't know what to cook? https://www.kubkhao.com/"))
        list.add(TodoListItem("Do some housework", TodoListItem.Tag.ROUTINE.tag, "Great! your home should be cleaned everyday"))
        list.add(TodoListItem("Do the exercise", TodoListItem.Tag.ROUTINE.tag, "Exercising at least twice a week to have a good health."))
        list.add(TodoListItem("Do your work", TodoListItem.Tag.WORK.tag, "Finish your work early, so you don't have to worry about the deadline."))
        list.add(TodoListItem("Re-check your work", TodoListItem.Tag.WORK.tag, "May be you made some mistakes."))
        list.add(TodoListItem("Go home", TodoListItem.Tag.ROUTINE.tag, "Beware about the traffic"))
        list.add(TodoListItem("Do your hobby", TodoListItem.Tag.ENTERTAINMENT.tag, "The best entertainer is your hobby."))
        list.add(TodoListItem("Brush your teeth", TodoListItem.Tag.ROUTINE.tag, "Ew! you forgot brushing your teeth?"))
        list.add(TodoListItem("Read some news", TodoListItem.Tag.ENTERTAINMENT.tag, "Read most of it, or you'll be out of the loop"))
        list.add(TodoListItem("Talk to your family", TodoListItem.Tag.ENTERTAINMENT.tag, "Throw your phone away, and pay attention to your family."))
        list.add(TodoListItem("Have some coffee", TodoListItem.Tag.WORK.tag, "Coffee can make you fresh."))
        list.add(TodoListItem("Have a break", TodoListItem.Tag.WORK.tag, "You may brighter from a little break."))
        list.add(TodoListItem("Walk around", TodoListItem.Tag.WORK.tag, "You may get some idea while walking."))
        list.add(TodoListItem("Do your homework", TodoListItem.Tag.WORK.tag, "Great! This make you practicing yourself."))
        list.add(TodoListItem("Watch something you like", TodoListItem.Tag.ENTERTAINMENT.tag, "www.youtube.com"))
        list.add(TodoListItem("Continue your work", TodoListItem.Tag.WORK.tag, "Continue it before you forget it."))
        list.add(TodoListItem("Go on vacation", TodoListItem.Tag.ENTERTAINMENT.tag, "This activity take time, you should done your work before."))
        list.add(TodoListItem("Have a dessert", TodoListItem.Tag.ENTERTAINMENT.tag, "Beware about the fat and debate."))
        list.add(TodoListItem("Preparing for next project", TodoListItem.Tag.WORK.tag, "Read about it can make you more understand."))
        list.add(TodoListItem("Read your favorite book", TodoListItem.Tag.ENTERTAINMENT.tag, "This can improve your meditation."))
        list.add(TodoListItem("Playing some songs", TodoListItem.Tag.ENTERTAINMENT.tag, "Practicing new song to be your show."))
        list.add(TodoListItem("Clean your bedroom", TodoListItem.Tag.WORK.tag, "If you're lazy, cleaning robot can help you."))
        list.add(TodoListItem("Go to a party", TodoListItem.Tag.ENTERTAINMENT.tag, "Don't drive if you're drunk"))
        list.add(TodoListItem("Play the TypingThrower", TodoListItem.Tag.ENTERTAINMENT.tag, "https://github.com/winChawakorn/TypingThrower"))
        list.add(TodoListItem("Play ROV", TodoListItem.Tag.ENTERTAINMENT.tag, "Add me Nazaori"))
        list.add(TodoListItem("Drink a lot of water", TodoListItem.Tag.ROUTINE.tag, "Human should drink a water more than 6 glasses per day."))
        list.add(TodoListItem("Do Yoga", TodoListItem.Tag.ROUTINE.tag, "Do it 30 minutes per day for your health."))
        list.add(TodoListItem("Do meditation", TodoListItem.Tag.ROUTINE.tag, "Do it everyday to increase your meditation."))
        list.add(TodoListItem("Listen to the music", TodoListItem.Tag.ENTERTAINMENT.tag, "Listen to a new song, or you'll be ouy of the loop."))
        list.add(TodoListItem("Tell the people around you how much you love them", TodoListItem.Tag.ENTERTAINMENT.tag, "Make friend to the people can make them love you."))
        list.add(TodoListItem("Go to the hospital", TodoListItem.Tag.ROUTINE.tag, "We should check the health every 6 months."))
        list.add(TodoListItem("Check your email", TodoListItem.Tag.WORK.tag, "Check the email to not miss the trend."))
        list.add(TodoListItem("Explore the technology site", TodoListItem.Tag.WORK.tag, "Do it everyday to make you in trend."))
        list.add(TodoListItem("Go to the gym", TodoListItem.Tag.ROUTINE.tag, "Exercising at least twice a week to have a good health."))
        list.add(TodoListItem("Water the garden", TodoListItem.Tag.ROUTINE.tag, "Do it, or the plants die."))
        list.add(TodoListItem("Find new project", TodoListItem.Tag.WORK.tag, "Time wait for no man. Do it now!"))
        list.add(TodoListItem("Plan what to do", TodoListItem.Tag.WORK.tag, "Planing can make you do the task faster."))
    }
}
