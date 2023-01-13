package com.example.recyclerviewapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewapi.databinding.ActivityMainBinding
import com.example.recyclerviewapi.network.RetrofitAPI
import com.example.recyclerviewapi.network.RetrofitService
import com.example.recyclerviewapi.recyclerView.MoviesAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var tag: String
    private lateinit var mAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tag = binding.editText.text.toString()


        val apiService = RetrofitService.getApiService()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = MoviesAdapter(mutableListOf())
        binding.recyclerView.adapter = mAdapter

        binding.button.setOnClickListener {
            Log.d("Tag", "Set ClickListener")
            getData(apiService)
        }
    }

    private fun getData(apiService: RetrofitAPI) {
        GlobalScope.launch(Dispatchers.IO) {
            val apiResponse = apiService.getMoviesData(binding.editText.text.toString())
            if (apiResponse.isSuccessful) {
                withContext(Dispatchers.Main) {
                    mAdapter.setData(apiResponse.body()?.Search)
                }
            }
        }
    }
}