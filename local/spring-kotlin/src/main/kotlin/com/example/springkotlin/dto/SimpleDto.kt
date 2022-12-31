package com.example.springkotlin.dto

class SimpleDto {
    var status1 = "1"
        set(value) {
            field = "status1 = $value"
        }
    val status2 = "2"
    lateinit var status3: String
    val isEmptyStatus1: Boolean
        get() = status1.isEmpty()
}