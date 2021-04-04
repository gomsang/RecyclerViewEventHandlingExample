package com.gomsang.recyclerviewexperiments

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val eventListener = object : PostRecyclerViewAdapter.PostRecyclerViewEventListener() {
        override fun onPostSelected(postData: PostData) {
            Log.d("MainViewModel", "onPostSelected: ${postData.title}")
        }
        override fun onAdSelected() {
            Log.d("MainViewModel", "onAdSelected")
        }
    }
}