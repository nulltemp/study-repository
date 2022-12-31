package com.example.springkotlin.dto

sealed class SealedClass {
    abstract fun test()
}

class SealedTestClass(private val status: String) : SealedClass() {
    override fun test() = println(status)
}