package com.example.apptest

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.apptest.databinding.ListItemBinding
import com.example.apptest.model.Place

class PlacesAdapter(private val onItemClicked: (Place) -> Unit) :
    ListAdapter<Place, PlacesAdapter.PlacesViewHolder>(DiffCallback) {

    private lateinit var context: Context

    class PlacesViewHolder(private var binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(place: Place, context: Context) {
            binding.title.text = context.getString(place.titleResourceId)
            binding.translationTitle.text = context.getString(place.transTitleResourceId)
            binding.cardDescription.text = context.getString(place.titleDescriptionId)
            binding.placesImage.load(place.imageResourceId)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PlacesViewHolder {
        context = parent.context
        return PlacesViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PlacesViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current, context)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Place>() {
            override fun areItemsTheSame(oldItem: Place, newItem: Place): Boolean {
                return (oldItem.id == newItem.id ||
                        oldItem.titleResourceId == newItem.titleResourceId //||
                        //oldItem.subTitleResourceId == newItem.subTitleResourceId
                        )
            }

            override fun areContentsTheSame(oldItem: Place, newItem: Place): Boolean {
                return oldItem == newItem
            }
        }
    }
}