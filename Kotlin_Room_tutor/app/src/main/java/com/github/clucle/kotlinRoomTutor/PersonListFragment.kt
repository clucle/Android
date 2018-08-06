package com.github.clucle.kotlinRoomTutor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.github.clucle.kotlinRoomTutor.utilities.InjectorUtils
import com.github.clucle.kotlinRoomTutor.viewmodels.PersonListViewModel

class PersonListFragment : Fragment() {

    companion object {
        fun newInstance() = PersonListFragment()
    }


    private lateinit var viewModel: PersonListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_person_list, container, false)
        val context = context ?: return view

        val factory = InjectorUtils.providePersonListViewModelFactory(context)
        viewModel = ViewModelProviders.of(this, factory).get(PersonListViewModel::class.java)

        // 후에 처리
        return view
    }
}