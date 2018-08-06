package com.github.clucle.kotlinRoomTutor.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.clucle.kotlinRoomTutor.data.PersonRepository

class PersonListViewModelFactory(
        private val repository: PersonRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create(modelClass: Class<T>) = PersonListViewModel(repository) as T
}