package com.example.springkotlin.dto

open class SuperClass(private val status: String) {
    fun outputStatus() = println(status)
    open fun test() = println("super")
}