package com.gomsang.recyclerviewexperiments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gomsang.recyclerviewexperiments.databinding.ItemAdBinding
import com.gomsang.recyclerviewexperiments.databinding.ItemRegularPostBinding

class PostRecyclerViewAdapter(private val recyclerViewEventListener: PostRecyclerViewEventListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val posts = mutableListOf<PostData>()

    open class PostRecyclerViewEventListener
        : RegularPostViewHolder.RegularPostViewHolderEvent, AdViewHolder.AdViewHolderEvent {
        override fun onPostSelected(postData: PostData) {}
        override fun onAdSelected() {}
    }

    class RegularPostViewHolder(private val binding: ItemRegularPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            regularPostViewHolderEvent: RegularPostViewHolderEvent,
            postData: PostData
        ) {
            binding.apply {
                event = regularPostViewHolderEvent
                post = postData
            }
        }

        interface RegularPostViewHolderEvent {
            fun onPostSelected(postData: PostData)
        }
    }

    class AdViewHolder(private val binding: ItemAdBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(adViewHolderEvent: AdViewHolderEvent) {
            binding.apply {
                event = adViewHolderEvent
            }
        }

        interface AdViewHolderEvent {
            fun onAdSelected()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if ((position + 1) % 5 == 0) 1 else 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 1) {
            return AdViewHolder(
                ItemAdBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
        return RegularPostViewHolder(
            ItemRegularPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is RegularPostViewHolder) holder.bind(
            recyclerViewEventListener,
            posts[position - (position + 1) / 5]
        )
        if (holder is AdViewHolder) holder.bind(recyclerViewEventListener)
    }

    override fun getItemCount(): Int {
        return posts.size + (posts.size) / 5
    }
}