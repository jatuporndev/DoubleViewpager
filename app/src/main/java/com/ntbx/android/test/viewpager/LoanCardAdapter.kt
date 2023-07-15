package com.ntbx.android.test.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ntbx.android.test.viewpager.databinding.CardLoanBinding
import com.ntbx.android.test.viewpager.models.LoanData

class LoanCardAdapter : ListAdapter<LoanData, LoanCardAdapter.ViewHolder>(MyDiffItemCallback()) {
    class ViewHolder(val binding: CardLoanBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CardLoanBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        holder.binding.name.text = data.name
        holder.binding.detail.text = data.detail

    }

    class MyDiffItemCallback: DiffUtil.ItemCallback<LoanData>() {
        override fun areItemsTheSame(oldItem: LoanData, newItem: LoanData): Boolean {
            return oldItem.name ==newItem.name
        }

        override fun areContentsTheSame(oldItem: LoanData, newItem: LoanData): Boolean {
            return oldItem.name == newItem.name
        }

    }

}


