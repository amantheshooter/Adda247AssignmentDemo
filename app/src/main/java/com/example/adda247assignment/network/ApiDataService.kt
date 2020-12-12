package com.example.adda247assignment.network

import com.example.adda247assignment.model.StudentModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiDataService {

    @get:GET("public-api/users/")
    val apiRequestsArray: Call<StudentModel>

}