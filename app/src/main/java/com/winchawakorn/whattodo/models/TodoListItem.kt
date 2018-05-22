package com.winchawakorn.whattodo.models

import android.os.Parcel
import android.os.Parcelable
import java.util.*
import kotlin.collections.ArrayList

class TodoListItem(final val name: String, final val tag: Int, final val suggestion: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readString()) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        if (p0 != null) {
            p0.writeString(name)
            p0.writeInt(tag)
            p0.writeString(suggestion)
        }
    }

    enum class Tag(val tag: Int) {
        ADD_BY_USER(0), WORK(1), ENTERTAINMENT(2), ROUTINE(3)
    }

    companion object CREATOR : Parcelable.Creator<TodoListItem> {
        override fun createFromParcel(parcel: Parcel): TodoListItem {
            return TodoListItem(parcel)
        }

        override fun newArray(size: Int): Array<TodoListItem?> {
            return arrayOfNulls(size)
        }
    }

}