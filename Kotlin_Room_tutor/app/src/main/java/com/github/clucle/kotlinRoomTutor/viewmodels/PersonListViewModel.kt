package com.github.clucle.kotlinRoomTutor.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.github.clucle.kotlinRoomTutor.data.Person
import com.github.clucle.kotlinRoomTutor.data.PersonRepository

class PersonListViewModel internal constructor(
        private val personRepository: PersonRepository
) : ViewModel() {
    private val personList = MediatorLiveData<List<Person>>()

    init {
        val plist = personRepository.getAllPeople()
        personList.addSource(plist, personList::setValue)
    }

    fun getAllPerson() = personList

    fun createPerson(firstName: String, lastName: String) =
            personRepository.createPerson(firstName, lastName)
}