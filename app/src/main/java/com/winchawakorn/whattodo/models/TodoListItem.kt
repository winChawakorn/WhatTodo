package com.winchawakorn.whattodo.models

import java.util.*
import kotlin.collections.ArrayList

class TodoListItem(final val name: String, final val tag: Int, final val suggestion: String) {

    enum class Tag(val tag: Int) {
        ADD_BY_USER(0), WORK(1), ENTERTAINMENT(2), ROUTINE(3)
    }

}