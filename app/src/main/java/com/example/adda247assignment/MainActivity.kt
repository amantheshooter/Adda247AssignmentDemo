package com.example.adda247assignment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.adda247assignment.adapter.StudentAdapter
import com.example.adda247assignment.model.StudentData
import com.example.adda247assignment.viewmodel.StudentViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mainViewModel: StudentViewModel? = null
    private var mAdapter: StudentAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(StudentViewModel::class.java)
        title = getString(R.string.title)
        val recyclerView = student_list_rv
        recyclerView!!.setHasFixedSize(true)

        mAdapter = StudentAdapter()
        //set the CustomAdapter
        recyclerView.adapter = mAdapter

        getAllDev()
    }

    private fun getAllDev() {
        ///get the list of dev from api response
        mainViewModel!!.allStudent.observe(this,
            Observer<List<Any>> { mStudentModel ->

                Log.d("TAG", "getAllDev: $mStudentModel")
                ///if any thing chnage the update the UI
                mAdapter?.setDeveloperList(mStudentModel as ArrayList<StudentData>)
                loadBar?.visibility = View.GONE
            })
    }
}