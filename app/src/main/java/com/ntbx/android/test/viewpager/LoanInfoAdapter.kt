package com.ntbx.android.test.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ntbx.android.test.viewpager.databinding.CardInfoBinding
import com.ntbx.android.test.viewpager.models.LoanData

class LoanInfoAdapter:  ListAdapter<LoanData, LoanInfoAdapter.ViewHolder>(MyDiffItemCallback()) {
    class ViewHolder(val binding: CardInfoBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CardInfoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        holder.binding.text.text = data.name
    }


    class MyDiffItemCallback: DiffUtil.ItemCallback<LoanData>() {
        override fun areItemsTheSame(oldItem: LoanData, newItem: LoanData): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: LoanData, newItem: LoanData): Boolean {
            return oldItem.name == newItem.name
        }

    }


}