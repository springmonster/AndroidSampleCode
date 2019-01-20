package com.toolattributes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.toolattributes.databinding.ItemBinding

class Adapter : ListAdapter<Item, Adapter.AdapterViewHolder>(AdapterItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.getBinding().item = getItem(position)
    }


    class AdapterViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun getBinding(): ItemBinding {
            return binding
        }
    }

    class AdapterItemCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }
}