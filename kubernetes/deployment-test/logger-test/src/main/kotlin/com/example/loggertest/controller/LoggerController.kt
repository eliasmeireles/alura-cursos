package com.example.loggertest.controller

import lombok.extern.slf4j.Slf4j
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.util.UUID

@Slf4j
@RestController
class LoggerController {
    var logger: Logger = LogManager.getLogger(LoggerController::class.java)

    @GetMapping(value = ["logger"])
    fun get(
        @RequestParam(name = "sleep") sleep: Long,
        @RequestParam(name = "count") count: Int
    ): ResponseEntity<Flux<String>> {
        val flux = Flux.just("Logging...")
        val requestUUID = UUID.randomUUID()
        Thread {
            for (i in 1..count) {
                @Suppress("BlockingMethodInNonBlockingContext")
                Thread.sleep(sleep)
                logger.info("[{}]: Application running count: {}/{}", requestUUID.toString(), i, count)
            }
        }.start()

        return ResponseEntity.ok(flux)
    }
}
