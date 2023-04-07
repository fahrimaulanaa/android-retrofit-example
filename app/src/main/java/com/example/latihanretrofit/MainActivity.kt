package com.example.latihanretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<PostResponse>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set recyclerview
        var rvResponse: RecyclerView = findViewById(R.id.rvResponse)
        rvResponse.setHasFixedSize(true)
        rvResponse.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getPosts().enqueue(object : Callback<ArrayList<PostResponse>> {
            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>
            ) {
                if (response.isSuccessful) {
                    list.addAll(response.body()!!)
                    val adapter = PostAdapter(list)
                    rvResponse.adapter = adapter
                }
            }

            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}