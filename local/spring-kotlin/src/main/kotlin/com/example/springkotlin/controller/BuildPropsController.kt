package com.example.springkotlin.controller

import org.springframework.boot.info.BuildProperties
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/buildProps")
class BuildPropsController (private var buildProperties: BuildProperties) {
    @GetMapping
    fun getBuildProps() = buildProperties
}