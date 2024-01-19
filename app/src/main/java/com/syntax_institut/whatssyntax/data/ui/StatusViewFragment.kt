package com.syntax_institut.whatssyntax.data.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.clearFragmentResult
import androidx.navigation.findNavController
import com.syntax_institut.whatssyntax.MainActivity
import com.syntax_institut.whatssyntax.databinding.FragmentStatusBinding
import com.syntax_institut.whatssyntax.databinding.FragmentStatusViewBinding

class StatusViewFragment : Fragment() {
    private lateinit var binding: FragmentStatusViewBinding

    private var contactStatus = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            contactStatus = it.getString("status") ?: ""
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatusViewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvStatus.text = contactStatus

        binding.statusView.setOnClickListener {

            val aktion = binding.statusView.findNavController()
            aktion.navigateUp()

        }


    }
}