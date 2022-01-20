package com.inu.appcenter.retrofitstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var repoList: RecyclerView
    lateinit var adapter:RepoAdapter
    private val baseUrl = "https://api.github.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = mutableListOf<String>()
        val user = "inu-appcenter"

        repoList = findViewById(R.id.repoList)
        repoList.layoutManager = LinearLayoutManager(this)
        repoList.adapter = RepoAdapter(list)

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val client = retrofit.create(GithubService::class.java)


        val search:EditText = findViewById(R.id.et_search)
        search.addTextChangedListener(object : TextWatcher{

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val call = client.getRepos(s.toString())
                call.enqueue(object: Callback<List<GitHubRepo>> {
                    override fun onFailure(call: Call<List<GitHubRepo>>, t: Throwable) {
                        Log.e("error", "${t.message}")
                    }

                    override fun onResponse(
                        call: Call<List<GitHubRepo>>,
                        response: Response<List<GitHubRepo>>
                    ) {

                        if(response.isSuccessful){
                            Log.d("응답 성공!", "onResponse is Successful!")
                            list.clear()
                            val repos = response.body()
                            repos?.forEach {
                                list.add("${it.name}")
                            }
                            repoList.adapter = RepoAdapter(list)
                        } else
                        {
                            Log.e("error", "response is not Successful")
                        }
                    }
                })
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })


    }
}