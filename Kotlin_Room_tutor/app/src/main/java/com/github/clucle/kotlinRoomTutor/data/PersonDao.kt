package com.github.clucle.kotlinRoomTutor.data

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    fun getAllPeople(): LiveData<List<Person>>

    @Query("SELECT * FROM person ORDER BY uid ASC")
    fun persons(): DataSource.Factory<Int, Person>

    @Insert
    fun insert(person: Person)

    @Delete
    fun delete(person: Person)
}