package com.syntax_institut.whatssyntax.data.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.syntax_institut.whatssyntax.MainActivity
import com.syntax_institut.whatssyntax.data.adapter.CallItemAdapter
import com.syntax_institut.whatssyntax.databinding.FragmentCallsBinding

class CallsFragment : Fragment() {

    private lateinit var binding: FragmentCallsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCallsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as MainActivity
        val call = mainActivity.calls


        binding.callsRecyclerView.adapter = CallItemAdapter(call)
    }
}