package com.example.loggertest.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController {

    @GetMapping(value = ["health"])
    fun healthCheck(): ResponseEntity<String> = ResponseEntity.ok("Ok")
}
