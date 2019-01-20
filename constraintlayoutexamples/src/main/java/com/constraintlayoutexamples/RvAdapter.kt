package com.constraintlayoutexamples

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.constraintlayoutexamples.databinding.AdapterBinding

class RvAdapter : ListAdapter<RvViewEntity, RvAdapter.RvViewHolder>(DiffUtilItemCallback()) {
    private var onRvItemClick: OnRvItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder(
            AdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.getBinding().entity = getItem(position)
        holder.getBinding().root.setOnClickListener {
            onRvItemClick?.onClick(getItem(position).id)
        }
        holder.getBinding().executePendingBindings()
    }

    class RvViewHolder(private val adapterBinding: AdapterBinding) :
        RecyclerView.ViewHolder(adapterBinding.root) {

        fun getBinding(): AdapterBinding {
            return adapterBinding
        }
    }

    class DiffUtilItemCallback : DiffUtil.ItemCallback<RvViewEntity>() {
        override fun areItemsTheSame(oldItem: RvViewEntity, newItem: RvViewEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RvViewEntity, newItem: RvViewEntity): Boolean {
            return oldItem == newItem
        }
    }

    fun setOnRvItemClick(onRvItemClick: OnRvItemClick) {
        this.onRvItemClick = onRvItemClick
    }

    interface OnRvItemClick {
        fun onClick(id: Int)
    }
}