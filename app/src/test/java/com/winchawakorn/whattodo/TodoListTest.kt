package com.winchawakorn.whattodo

import com.winchawakorn.whattodo.models.TodoList
import com.winchawakorn.whattodo.models.TodoListItem
import org.junit.Before
import org.junit.Test

class TodoListTest {
    lateinit var todoList: TodoList

    @Before
    fun init() {
        todoList = TodoList.instance
    }

    @Test
    fun testSingleton() {
        var todoList2 = TodoList.instance
        assert(todoList.equals(todoList2))
    }

    @Test
    fun testAdd() {
        todoList.add(TodoListItem("name", 0, "suggestion"))
        assert(todoList.getList()[0].name.equals("name"))
        assert(todoList.getList()[0].tag == 0)
        assert(todoList.getList()[0].suggestion.equals("suggestion"))
        assert(todoList.getList().size == 0)
    }

    @Test
    fun testRemoveByIndex() {
        todoList.add(TodoListItem("one", 0, "1"))
        todoList.add(TodoListItem("two", 0, "2"))
        todoList.add(TodoListItem("three", 0, "3"))
        todoList.remove(2)
        assert(todoList.getList().size == 2)
        assert(todoList.getList().get(todoList.getList().size - 1).name == "two")
    }

    fun testRemoveByItem() {
        var item = TodoListItem("item", 1, "testing")
        todoList.add(item)
        todoList.add(TodoListItem("not item", 0, ""))
        todoList.remove(item)
        assert(todoList.getList().size == 1)
        assert(todoList.getList()[0].name == "not item")
    }
}