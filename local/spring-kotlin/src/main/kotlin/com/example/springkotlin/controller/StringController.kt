package com.example.springkotlin.controller

import com.example.springkotlin.request.StringListRequest
import com.example.springkotlin.response.StringListResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/strings")
class StringController {
    @GetMapping
    fun getStringList() = StringListResponse(listOf("a", "あ"))

    @PostMapping
    fun outputStringList(@RequestBody request: StringListRequest) {
        when (request.stringList.size) {
            0 -> println("empty")
            else -> {
                for (string in request.stringList) {
                    println(string)
                }
            }
        }
    }
}