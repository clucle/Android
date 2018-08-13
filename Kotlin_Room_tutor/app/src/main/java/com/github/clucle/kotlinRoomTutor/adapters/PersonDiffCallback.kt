package com.github.clucle.kotlinRoomTutor.adapters

import androidx.recyclerview.widget.DiffUtil
import com.github.clucle.kotlinRoomTutor.data.Person

class PersonDiffCallback : DiffUtil.ItemCallback<Person>() {

    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.uid == newItem.uid
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.firstName == newItem.firstName && oldItem.lastName == newItem.lastName
    }
}