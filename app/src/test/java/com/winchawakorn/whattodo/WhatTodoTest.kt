package com.winchawakorn.whattodo

import com.winchawakorn.whattodo.models.WhatTodo
import org.junit.Before
import org.junit.Test

class WhatTodoTest {
    lateinit var whatTodo: WhatTodo

    @Before
    fun init() {
        whatTodo = WhatTodo.instance
    }

    @Test
    fun testSingleton() {
        var whatTodo2 = WhatTodo.instance
        assert(whatTodo2.equals(whatTodo))
    }

    @Test
    fun testSetFilterAndGetWhatTodo() {
        whatTodo.setFilters(arrayListOf(0, 1))
        for (i in 1..10) {
            var item = whatTodo.getWhatTodo()
            assert(item.tag == 0 || item.tag == 1)
        }
    }
}