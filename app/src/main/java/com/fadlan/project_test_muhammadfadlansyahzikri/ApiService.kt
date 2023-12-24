package com.fadlan.project_test_muhammadfadlansyahzikri

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getPosts(): Call<ArrayList<PostResponse>>

}