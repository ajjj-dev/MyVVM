package com.aj.myvvm.ui.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aj.myvvm.data.db.Items
import com.aj.myvvm.databinding.RowItemBinding
import com.aj.myvvm.ui.recyclerview.RowItemAdapter.*

class RowItemAdapter : RecyclerView.Adapter<ItemViewHolder>() {

    private var itemsList = listOf<Items>()

    fun submitList(items: List<Items>) {
        itemsList = items
        notifyDataSetChanged()
    }

    class ItemViewHolder(val binding: RowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Items) {
            binding.tvRowItem.text = item.item
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): ItemViewHolder {
        val binding = RowItemBinding.inflate(
            android.view.LayoutInflater.from(parent.context),
            parent, false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ItemViewHolder,
        position: Int
    ) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int = itemsList.size

}