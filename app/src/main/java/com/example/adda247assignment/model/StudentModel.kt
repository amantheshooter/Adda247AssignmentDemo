package com.example.adda247assignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StudentModel {
    @SerializedName("code")
    @Expose
    var code: Int? = null

    @SerializedName("meta")
    @Expose
    var meta: com.example.adda247assignment.model.Meta? = null

    @SerializedName("data")
    @Expose
    var data: List<StudentData>? = null

}