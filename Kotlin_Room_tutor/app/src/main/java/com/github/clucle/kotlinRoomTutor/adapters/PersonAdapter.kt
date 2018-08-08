package com.github.clucle.kotlinRoomTutor.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.clucle.kotlinRoomTutor.data.Person
import com.github.clucle.kotlinRoomTutor.databinding.ListItemPersonBinding


class PersonAdapter : ListAdapter<Person, PersonAdapter.ViewHolder>(PersonDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemPersonBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = getItem(position)
        holder.apply {
            bind(createOnClickListener(person.uid.toString()), person)
            itemView.tag = person
        }
    }

    private fun createOnClickListener(personId: String): View.OnClickListener {
        return View.OnClickListener {
            Log.d("DEBUG ADDAPTER", personId);
        }
    }

    class ViewHolder(
            private val binding: ListItemPersonBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Person) {
            binding.apply {
                clickListener = listener
                person = item
                executePendingBindings()
            }
        }
    }
}