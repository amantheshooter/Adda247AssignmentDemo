package com.example.adda247assignment

import androidx.paging.PageKeyedDataSource
import com.example.adda247assignment.model.StudentData

class ItemDataSource : PageKeyedDataSource<Int, StudentData>() {
    //this will be called once to load the initial data

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, StudentData>) {
        TODO("Not yet implemented")
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, StudentData>) {
        TODO("Not yet implemented")
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, StudentData>
    ) {
        TODO("Not yet implemented")
    }
}