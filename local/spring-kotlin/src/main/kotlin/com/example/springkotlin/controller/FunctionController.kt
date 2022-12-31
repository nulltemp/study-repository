package com.example.springkotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("functions")
class FunctionController {
    @GetMapping
    fun test() {
        println(isStringOrMoreChars10("FunctionController"))
        println(isStringOrMoreChars10("Function"))
    }

    fun isStringOrMoreChars10(str: String): Boolean {
        val result = if (str.length >= 10) {
            println("10 over")
            true
        } else {
            false
        }

        return result
    }
}