package com.example.springkotlin.controller

import com.example.springkotlin.request.NumberRangeRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/numbers")
class NumberController {
    @PostMapping("/range")
    fun outputNumberRange(@RequestBody request: NumberRangeRequest) {
        when (request.range) {
            0 -> println("***0***")
            in 1..10 -> {
                for (i in 1..request.range) {
                    println(i)
                }
            }
            else -> println("too large")
        }
    }
}