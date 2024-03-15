package com.syntax_institut.whatssyntax.data.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.syntax_institut.whatssyntax.MainActivity
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.databinding.FragmentCallsBinding
import com.syntax_institut.whatssyntax.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding

    val TAG = "ChatActivity"



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val mainActivity = activity as MainActivity
        val profile = mainActivity.profile
        //val setProfile = mainActivity.setProfile



        binding.bvSave.setOnClickListener {


            Toast.makeText(requireContext(), "FRAGMENT WAS SETTINGS, RENAME", Toast.LENGTH_SHORT).show()
        }


        binding.bvDelete.setOnClickListener {

            Toast.makeText(requireContext(), "FRAGMENT WAS SETTINGS, RENAME", Toast.LENGTH_SHORT).show()

        }

    }
}