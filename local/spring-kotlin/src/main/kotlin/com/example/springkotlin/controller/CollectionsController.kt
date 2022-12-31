package com.example.springkotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/collections")
class CollectionsController {
    @GetMapping
    fun test() {
        val intList = listOf(1, 2)
        println(intList)

        val mutableIntList = mutableListOf(1, 2)
        println(mutableIntList)
        mutableIntList.add(3)
        println(mutableIntList)

        val map = mapOf(1 to "a", 2 to "b")
        println(map)

        val mutableMap = mutableMapOf(1 to "a", 2 to "b")
        println(mutableMap)
        mutableMap[3] = "c"
        println(mutableMap)

        val set = setOf(1, 2)
        println(set)

        val mutableSet = mutableSetOf(1, 2)
        println(mutableSet)
        mutableSet.add(3)
        println(mutableSet)
    }
}