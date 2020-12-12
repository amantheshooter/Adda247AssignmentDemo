package com.example.adda247assignment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.adda247assignment.model.StudentData
import com.example.adda247assignment.repository.StudentRepository

class StudentViewModel(application: Application) : AndroidViewModel(application) {
    private val mDeveloperRepository: StudentRepository = StudentRepository()

    val allStudent: LiveData<List<StudentData>>
        get() = mDeveloperRepository.getMutableLiveData()
}