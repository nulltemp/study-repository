package com.example.springkotlin.dto

class ChildClass(status: String): SuperClass(status) {
    override fun test() {
        println("child")
        super.test()
    }
}