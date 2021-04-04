package com.gomsang.recyclerviewexperiments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gomsang.recyclerviewexperiments.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val adapter = PostRecyclerViewAdapter(viewModel.eventListener)

        for (i in 0..10) {g
            adapter.posts.add(
                PostData(
                    "POST $i",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet massa vitae tortor condimentum lacinia quis vel eros. Est ante in nibh mauris cursus. Lorem ipsum dolor sit amet consectetur adipiscing elit ut. Arcu cursus euismod quis viverra. Nec tincidunt praesent semper feugiat. Augue neque gravida in fermentum et sollicitudin ac orci. Elementum sagittis vitae et leo. Nulla aliquet porttitor lacus luctus accumsan tortor posuere. In cursus turpis massa tincidunt dui ut ornare."
                )
            )
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}