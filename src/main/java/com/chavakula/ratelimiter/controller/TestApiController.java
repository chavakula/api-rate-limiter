package com.chavakula.ratelimiter.controller;

import io.github.bucket4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
public class TestApiController {

    private  final Bucket bucket;

    public TestApiController() {
        // set 20 tokens per minute limit
        Bandwidth limit = Bandwidth.classic(20, Refill.greedy(20, Duration.ofMinutes(1)));
        this.bucket = Bucket4j.builder().addLimit(limit).build();
    }


    @GetMapping(value = "/api/getdetails")
    public ResponseEntity<String> getDetails(){
        if (bucket.tryConsume(1)) {
            return ResponseEntity.ok()
                    .body("Hey Guys, the new rate limiting API");
        }
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                .build();
    }
}
