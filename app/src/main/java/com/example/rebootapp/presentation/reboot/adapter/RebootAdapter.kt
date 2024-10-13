package com.example.rebootapp.presentation.reboot.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rebootapp.databinding.ItemRebootBinding
import com.example.rebootapp.domain.model.RebootInfo

class RebootAdapter(
) : ListAdapter<RebootInfo, RebootAdapter.RebootHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RebootHolder(
        ItemRebootBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: RebootHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RebootHolder(private val binding: ItemRebootBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: RebootInfo) = with(binding) {
            rebootTitle.text = item.date
            rebootBody.text = item.count.toString()
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<RebootInfo>() {
        override fun areItemsTheSame(old: RebootInfo, new: RebootInfo): Boolean =
            old.date == new.date

        override fun areContentsTheSame(
            old: RebootInfo,
            new: RebootInfo
        ): Boolean =
            old.date == new.date
    }
}