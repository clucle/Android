package com.github.clucle.kotlinRoomTutor.utilities

import android.content.Context
import com.github.clucle.kotlinRoomTutor.data.AppDatabase
import com.github.clucle.kotlinRoomTutor.data.PersonRepository
import com.github.clucle.kotlinRoomTutor.viewmodels.PersonListViewModelFactory

object InjectorUtils {
    private fun getPersonRepository(context: Context): PersonRepository {
        return PersonRepository.getInstance(AppDatabase.getInstance(context).personDao())
    }

    fun providePersonListViewModelFactory(
            context: Context
    ): PersonListViewModelFactory {
        val repository = getPersonRepository(context)
        return PersonListViewModelFactory(repository)
    }

}