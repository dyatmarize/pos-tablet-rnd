package com.dyatmarize.postabletrnd.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView

class SingleViewHolder(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.getRoot()) {

    fun bind(obj: Any?) {
        binding.setVariable(BR.viewModel, obj);
        binding.executePendingBindings();
    }
}