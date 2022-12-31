package com.example.springkotlin.dto

data class DataClass(val id: Int, var name: String = "default", val value: String) {
    val isEmptyName: Boolean
        get() = name == ""
}
