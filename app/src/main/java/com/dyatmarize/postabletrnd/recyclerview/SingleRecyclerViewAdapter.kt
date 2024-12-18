package com.dyatmarize.postabletrnd.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.dyatmarize.postabletrnd.util.AndroidUtil.Companion.blockingClickListener


/**
 * Using single based adapter for multiple card view
 */
abstract class SingleRecyclerViewAdapter : RecyclerView.Adapter<SingleViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SingleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            layoutInflater, viewType, parent, false
        )
        return SingleViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: SingleViewHolder,
        position: Int
    ) {
        val obj = getObjForPosition(position)
        holder.itemView.blockingClickListener() { v -> getOnItemClickListener(position) }
        holder.bind(obj)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }


    protected abstract fun getObjForPosition(position: Int): Any

    protected abstract fun getLayoutIdForPosition(position: Int): Int

    protected abstract fun getOnItemClickListener(position: Int)
}