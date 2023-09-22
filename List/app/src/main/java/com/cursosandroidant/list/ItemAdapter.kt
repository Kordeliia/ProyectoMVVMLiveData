package com.cursosandroidant.list

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cursosandroidant.list.databinding.ItemListBinding

class ItemAdapter(private val listener: OnClickListener) : ListAdapter<ItemEntity, RecyclerView.ViewHolder>(ItemDiffCallback()) {
    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val binding = ItemListBinding.bind(view)
        fun setListener(itemEntity: ItemEntity){
            binding.cbFavorite.setOnClickListener{listener.onClick(itemEntity) }
        }
    }
    class ItemDiffCallback: DiffUtil.ItemCallback<ItemEntity>(){
        override fun areItemsTheSame(oldItem: ItemEntity, newItem: ItemEntity) : Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ItemEntity, newItem: ItemEntity): Boolean = oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemEntity = getItem(position)
        with(holder as ViewHolder){
            setListener(itemEntity)
            binding.tvText.text = itemEntity.text
            binding.cbFavorite.isChecked = itemEntity.favorite
        }
    }
}