package com.github.clucle.kotlinRoomTutor.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    fun getAllPeople(): LiveData<List<Person>>

    @Insert
    fun insert(person: Person)
}