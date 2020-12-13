package com.example.adda247assignment.repository

import androidx.lifecycle.MutableLiveData
import com.example.adda247assignment.model.StudentData
import com.example.adda247assignment.model.StudentModel
import com.example.adda247assignment.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class StudentRepository {
    private val mStudentModelList = ArrayList<StudentData>()
    private val mutableLiveData = MutableLiveData<List<StudentData>>()

    fun getMutableLiveData(): MutableLiveData<List<StudentData>> {

        val userDataService = RetrofitClient.service
        val call = userDataService.apiRequestsArray

        call.enqueue(object : Callback<StudentModel> {
            override fun onResponse(call: Call<StudentModel>, resp: Response<StudentModel>) {
//                val gson = GsonBuilder().create()
                if (resp.body() != null) {
                    //Log.e("data",json.toString())
                    var myData = resp.body()

                    try {
                        for (data in myData!!.data!!)
                            mStudentModelList.add(data)
                    } catch (ex: Exception) {
                        ex.printStackTrace()
                    }
                    mutableLiveData.value = mStudentModelList
                }
            }

            override fun onFailure(call: Call<StudentModel>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return mutableLiveData
    }

}