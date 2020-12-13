package com.example.adda247assignment.network

import com.example.adda247assignment.model.StudentModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiDataService {

    @GET("public-api/users/")
    fun getStudentArray(@Query("page") page: String): Call<StudentModel>
}