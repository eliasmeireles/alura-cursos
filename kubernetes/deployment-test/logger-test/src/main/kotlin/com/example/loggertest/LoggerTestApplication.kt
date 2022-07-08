package com.example.loggertest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LoggerTestApplication

fun main(args: Array<String>) {
    runApplication<LoggerTestApplication>(*args)
}
