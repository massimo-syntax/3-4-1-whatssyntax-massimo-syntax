package com.syntax_institut.whatssyntax.data.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.contains
import androidx.core.view.marginEnd
import androidx.core.view.marginLeft
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.data.model.Chat
import com.syntax_institut.whatssyntax.data.model.Contact
import com.syntax_institut.whatssyntax.data.model.Message
import com.syntax_institut.whatssyntax.databinding.ChatViewListItemBinding


class ChatViewAdapter(
    private val chatDataset: List<Message>,
) : RecyclerView.Adapter<ChatViewAdapter.ItemViewHolder>() {


    inner class ItemViewHolder(val binding: ChatViewListItemBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ChatViewListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = chatDataset[position]


        holder.binding.tvMessage.text = item.text


        val constraintSet = ConstraintSet()

        if (item.incoming) {

            holder.binding.tvMessage.textAlignment = View.TEXT_ALIGNMENT_TEXT_END

            constraintSet.clone(holder.binding.chatViewListItem)
            constraintSet.clear(holder.binding.chatCard.id, ConstraintSet.END)
            constraintSet.connect(
                holder.binding.chatCard.id,
                ConstraintSet.START,
                ConstraintSet.PARENT_ID,
                ConstraintSet.START
            )
        } else {

            holder.binding.tvMessage.textAlignment = View.TEXT_ALIGNMENT_VIEW_START

            constraintSet.clone(holder.binding.chatViewListItem)
            constraintSet.clear(holder.binding.chatCard.id, ConstraintSet.START)
            constraintSet.connect(
                holder.binding.chatCard.id,
                ConstraintSet.END,
                ConstraintSet.PARENT_ID,
                ConstraintSet.END
            )
        }
        constraintSet.applyTo(holder.binding.chatViewListItem)



    }

    override fun getItemCount(): Int {
        return chatDataset.size
    }

}