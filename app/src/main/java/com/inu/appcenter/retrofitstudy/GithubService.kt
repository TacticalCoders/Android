package com.inu.appcenter.retrofitstudy

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{username}/repos")
    fun getRepos(@Path("username") user: String) : Call<List<GitHubRepo>>
}