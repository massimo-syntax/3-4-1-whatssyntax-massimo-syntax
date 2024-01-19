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


        binding.ivContactImg.setImageResource(profile.image)
        binding.tvContactName.setText(profile.name)
        binding.tvContactNumber.setText(profile.number)


        binding.bvSave.setOnClickListener {

            val updateName = binding.tvContactName.text.toString()
            val updateNumber = binding.tvContactNumber.text.toString()


            profile.name = updateName
            profile.number = updateNumber


            Toast.makeText(requireContext(), "Changes saved", Toast.LENGTH_SHORT).show()
        }


        binding.bvDelete.setOnClickListener {

            binding.tvContactName.text.clear()
            binding.tvContactNumber.text.clear()

            Toast.makeText(requireContext(), "Profile Has been Deleted", Toast.LENGTH_SHORT).show()

        }

    }
}