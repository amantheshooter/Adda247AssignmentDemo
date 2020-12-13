package com.example.adda247assignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Meta {
    @SerializedName("pagination")
    @Expose
    var pagination: Pagination? = null

}