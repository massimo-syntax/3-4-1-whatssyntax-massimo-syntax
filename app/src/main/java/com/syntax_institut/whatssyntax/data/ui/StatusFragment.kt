package com.syntax_institut.whatssyntax.data.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.syntax_institut.whatssyntax.MainActivity
import com.syntax_institut.whatssyntax.data.adapter.StatusItemAdapter
import com.syntax_institut.whatssyntax.databinding.FragmentStatusBinding


class StatusFragment : Fragment() {
    private lateinit var binding: FragmentStatusBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatusBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as MainActivity
        val status = mainActivity.contacts
        binding.statusRecyclerView.adapter = StatusItemAdapter(status)


    }
}