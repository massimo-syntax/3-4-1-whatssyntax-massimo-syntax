package com.syntax_institut.whatssyntax.data.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.syntax_institut.whatssyntax.MainActivity
import com.syntax_institut.whatssyntax.data.adapter.ChatViewAdapter
import com.syntax_institut.whatssyntax.data.model.Message
import com.syntax_institut.whatssyntax.databinding.FragmentChatViewBinding


class ChatViewFragment : Fragment() {

    private lateinit var binding: FragmentChatViewBinding
    private var ourChat = mutableListOf<Message>()
    private var name = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatViewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as MainActivity
        val chat = mainActivity.chats

        arguments?.let {
            name = ((it.getString("contact") ?: "").toString())
        }

        /*if (savedInstanceState != null) {
            name = savedInstanceState.getString("contacrt").toString()
        }
*/

        chat.forEach {
            if (it.contact.name == name) {
                ourChat = it.messages
            }
        }

        val adapter = ChatViewAdapter(ourChat)

        binding.toolBar.title = name
        binding.bvSend.setOnClickListener {

            val newChat = binding.tvMessage.editableText.toString()

            if (newChat != "") {

                val newMessage = Message(newChat, false)

                ourChat.add(newMessage)

                adapter.notifyItemInserted(ourChat.size - 1)

                binding.tvMessage.editableText.clear()

                binding.chatViewRecyclerView.scrollToPosition(ourChat.size - 1)
            }

        }


        binding.chatViewRecyclerView.adapter = adapter


        binding.doneButton.setOnClickListener {
            val action = binding.doneButton.findNavController()
            action.navigateUp()
        }
    }


}