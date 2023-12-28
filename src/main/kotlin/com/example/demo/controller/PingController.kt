package com.example.demo.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api/v1"], produces = [MediaType.APPLICATION_JSON_VALUE])
class PingController {

    @GetMapping(path = ["ping"])
    fun ping():String = "Pong"
}