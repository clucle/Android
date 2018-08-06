package com.github.clucle.kotlinRoomTutor.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(
    @PrimaryKey(autoGenerate = true)
    val uid: Long,
    val firstName: String = "",
    val lastName: String = ""
)