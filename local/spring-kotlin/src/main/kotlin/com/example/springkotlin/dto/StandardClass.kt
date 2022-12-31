package com.example.springkotlin.dto

class StandardClass(private val status: String) {
    fun test(value: String) = println("$status $value")
}