package com.syntax_institut.whatssyntax.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.data.model.Chat
import com.syntax_institut.whatssyntax.data.ui.ChatFragmentDirections
import com.syntax_institut.whatssyntax.databinding.ArticlesListItemBinding


class ChatItemAdapter(
    private val chatDataset: List<Chat>,
) : RecyclerView.Adapter<ChatItemAdapter.ItemViewHolder>() {


    inner class ItemViewHolder(val binding: ArticlesListItemBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ArticlesListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = chatDataset[position]
        holder.binding.ivContact.setImageResource(item.contact.image)
        holder.binding.tvContactName.text = item.contact.name


        val originalText = item.messages.last().text
        val space = " ..."
        val truncatedText =
            if (originalText.length > 25) originalText.substring(0, 25) else originalText

        if (truncatedText == originalText) {
            holder.binding.tvMessage.text = truncatedText
        } else {

            holder.binding.tvMessage.text = truncatedText + space
        }


        holder.binding.chatCard.setOnClickListener {
            val aktion = holder.binding.chatCard.findNavController()
            aktion.navigate(ChatFragmentDirections.actionChatFragmentToChatViewFragment(item.contact.name))
        }


    }

    override fun getItemCount(): Int {
        return chatDataset.size
    }

}