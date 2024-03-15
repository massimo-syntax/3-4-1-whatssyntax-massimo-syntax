package com.syntax_institut.whatssyntax.data.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.syntax_institut.whatssyntax.MainActivity
import com.syntax_institut.whatssyntax.data.Datasource
import com.syntax_institut.whatssyntax.data.adapter.ChatItemAdapter
import com.syntax_institut.whatssyntax.data.adapter.ChatViewAdapter
import com.syntax_institut.whatssyntax.data.model.Chat
import com.syntax_institut.whatssyntax.databinding.FragmentArticlesBinding


class ChatFragment : Fragment() {
    private lateinit var binding: FragmentArticlesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticlesBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as MainActivity
        val chat = mainActivity.chats


        binding.chatsRecyclerView.adapter = ChatItemAdapter(chat)

    }
}