package com.github.clucle.kotlinRoomTutor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.clucle.kotlinRoomTutor.adapters.PersonAdapter
import com.github.clucle.kotlinRoomTutor.databinding.FragmentPersonListBinding
import com.github.clucle.kotlinRoomTutor.utilities.InjectorUtils
import com.github.clucle.kotlinRoomTutor.viewmodels.PersonListViewModel

class PersonListFragment : Fragment() {

    private lateinit var viewModel: PersonListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val factory = InjectorUtils.providePersonListViewModelFactory(requireActivity())
        val personViewModel = ViewModelProviders.of(this, factory)
                .get(PersonListViewModel::class.java)
        val adapter = PersonAdapter()
        val binding: FragmentPersonListBinding = DataBindingUtil.inflate<FragmentPersonListBinding>(
                inflater, R.layout.fragment_person_list, container, false).apply {
            viewModel = personViewModel
            setLifecycleOwner(this@PersonListFragment)
            personList.adapter = adapter
            createPersonBtn.setOnClickListener { view ->
                viewModel.createPerson("first", "last")
            }
        }
        subscribeUi(adapter)
        return binding.root
    }

    private fun subscribeUi(adapter: PersonAdapter) {
        viewModel.getAllPerson().observe(viewLifecycleOwner, Observer { persons ->
            if (persons != null) adapter.submitList(persons)
        })
    }
}