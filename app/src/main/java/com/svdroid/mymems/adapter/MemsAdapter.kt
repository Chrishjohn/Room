package com.svdroid.mymems.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.svdroid.mymems.R
import com.svdroid.mymems.databinding.MemRawBinding
import com.svdroid.mymems.model.Meme

class MemsAdapter constructor() :
    ListAdapter<Meme, MemsAdapter.MyViewHolder>(Diff) {
    inner class MyViewHolder(private val binding: MemRawBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mem: Meme) {
            binding.apply {
                txtName.text = mem.name
                Glide.with(root.context).load(mem.url)
                    .placeholder(R.drawable.ic_baseline_image_24).into(imgHolder)
            }
        }
    }

    object Diff : DiffUtil.ItemCallback<Meme>() {
        override fun areItemsTheSame(oldItem: Meme, newItem: Meme): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Meme, newItem: Meme): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            MemRawBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pos = holder.adapterPosition
        val item = getItem(pos)
        if (item != null) {
            holder.bind(item)
        }
    }
}