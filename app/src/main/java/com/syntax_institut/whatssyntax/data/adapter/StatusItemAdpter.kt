package com.syntax_institut.whatssyntax.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.data.model.Contact
import com.syntax_institut.whatssyntax.data.ui.StatusFragmentDirections
import com.syntax_institut.whatssyntax.databinding.StatusListItemBinding


class StatusItemAdapter(
    private val statusDataset: List<Contact>,
) : RecyclerView.Adapter<StatusItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: StatusListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            StatusListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = statusDataset[position]
        holder.binding.ivContact.setImageResource(item.image)
        holder.binding.tvContactName.text = item.name

        if (item.status != null) {
            holder.binding.statusCard.setOnClickListener {
                val aktion = holder.binding.statusCard.findNavController()
                aktion.navigate(StatusFragmentDirections.actionStatusFragmentToStatusView(item.status.text))
            }
            holder.binding.tvContactName.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.black
                )
            )
            holder.binding.ivContact.alpha = 1.0f
        } else {
            holder.itemView.isClickable = false
            holder.binding.tvContactName.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.grau
                )
            )
            holder.binding.ivContact.alpha = 0.4f
        }
    }

    override fun getItemCount(): Int {
        return statusDataset.size
    }

}

