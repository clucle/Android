package com.github.clucle.kotlinRoomTutor.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.github.clucle.kotlinRoomTutor.data.Person
import com.github.clucle.kotlinRoomTutor.data.PersonRepository

class PersonListViewModel internal constructor(
        private val personRepository: PersonRepository
) : ViewModel() {
    private val pageSize = 20
    private val prefetchDistance = 5

    private val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setPrefetchDistance(prefetchDistance)
            .setEnablePlaceholders(true)
            .build()

    private var personList: LiveData<PagedList<Person>> =
            LivePagedListBuilder(personRepository.persons(), config)
                    .build()

    fun persons() = personList

    fun createPerson(firstName: String, lastName: String) =
            personRepository.createPerson(firstName, lastName)

    fun deletePerson(person: Person) =
            personRepository.deletePerson(person)

}