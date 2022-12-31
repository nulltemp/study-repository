package com.example.springkotlin.controller

import com.example.springkotlin.dto.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/class-test")
class ClassTestController {
    @GetMapping("test1")
    fun test1() {
        val standardClass = StandardClass("status")
        standardClass.test("value")

        val childClass = ChildClass("childStatus")
        childClass.outputStatus()
        childClass.test()

        val sealedTestClass = SealedTestClass("status")
        sealedTestClass.test()

        val interfaceImplClass = InterfaceImplClass()
        interfaceImplClass.test()

        val simpleDto = SimpleDto()
        simpleDto.status1 = "a"
        println(simpleDto.status1)
        println(simpleDto.isEmptyStatus1)
        //simpleDto.status2 = "b"
        println(simpleDto.status2)
        simpleDto.status3 = "c"
        println(simpleDto.status3)
    }

    @GetMapping("test2")
    fun test2() {
        val dataClass = DataClass(1, "hoge", "value")
        println(dataClass)
        println(dataClass.component1())
        println(dataClass.component2())
        println(dataClass.isEmptyName)

        val copy1DataClass = dataClass.copy()
        println(copy1DataClass)

        val copy2DataClass = dataClass.copy(id = 3)
        println(copy2DataClass)

        val dataClass2 = DataClass(id = 2, value = "test")
        println(dataClass2)
    }
}