package com.github.clucle.kotlinRoomTutor.data

import com.github.clucle.kotlinRoomTutor.utilities.runOnIoThread

class PersonRepository private constructor(
        private val personDao: PersonDao
) {
    fun createPerson(firstName: String, lastName: String) {
        runOnIoThread {
            val person = Person(0, firstName = firstName, lastName = lastName)
            personDao.insert(person)
        }
    }

    fun deletePerson(person: Person) {
        runOnIoThread {
            personDao.delete(person)
        }
    }

    fun persons() = personDao.persons()

    fun getAllPeople() = personDao.getAllPeople()

    companion object {
        @Volatile private var instance: PersonRepository? = null

        fun getInstance(personDao: PersonDao) =
                instance ?: synchronized(this) {
                    instance ?: PersonRepository(personDao).also { instance = it }
                }
    }
}