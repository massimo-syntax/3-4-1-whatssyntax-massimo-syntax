package com.syntax_institut.whatssyntax.data.adapter

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.data.model.Call
import com.syntax_institut.whatssyntax.databinding.CallListItemBinding


class CallItemAdapter(
    private val callDataset: List<Call>,
) : RecyclerView.Adapter<CallItemAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(val binding: CallListItemBinding) :
        RecyclerView.ViewHolder(binding.root)


    /*
    private companion object {
        const val REQUEST_CALL_PHONE_PERMISSION = 1
    }

     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            CallListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return callDataset.size
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = callDataset[position]

        holder.binding.ivContact.setImageResource(item.contact.image)
        holder.binding.tvContactName.text = item.contact.name
        holder.binding.tvTime.text = item.time


        holder.binding.callCard.setOnClickListener {
            val phoneNumber = callDataset[position].contact.number

            val intent = Intent(Intent.ACTION_DIAL)


            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(holder.itemView.context, intent, null)

        }

        /*

        if (ContextCompat.checkSelfPermission(
                holder.itemView.context, android.Manifest.permission.CALL_PHONE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(holder.itemView.context, intent, null)
        } else {
            ActivityCompat.requestPermissions(
                holder.itemView.context as Activity,
                arrayOf(android.Manifest.permission.CALL_PHONE),
                REQUEST_CALL_PHONE_PERMISSION
            )
        }
    }

    */


        when {
            item.incoming && item.accepted -> {
                holder.binding.ivCall.rotation = 180f
                holder.binding.ivCall.setImageResource(R.drawable.icon_call_accepted)
            }

            !item.incoming && item.accepted -> {
                holder.binding.ivCall.setImageResource(R.drawable.icon_call_accepted)
            }

            item.incoming && !item.accepted -> {
                holder.binding.ivCall.rotation = 180f
                holder.binding.ivCall.setImageResource(R.drawable.icon_call_missed)
            }

            else -> {
                holder.binding.ivCall.setImageResource(R.drawable.icon_call_missed)
            }
        }


    }
}

