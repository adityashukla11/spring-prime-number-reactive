package com.app.reactivejavapractice.controllers;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.IntStream;


@RestController
public class PrimeNumberController {

//  @GetMapping("/primes/{n}")
//  public Flux<Integer> generatePrimes(@PathVariable int n) {
//    return Flux.fromStream(IntStream.rangeClosed(2, n).filter(this::isPrime).boxed())
//            .delayElements(Duration.ofSeconds(3));
//  }

  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping(value = "/primes/{n}", produces = "text/event-stream")
  public Flux<ServerSentEvent<Integer>> generatePrimes(@PathVariable int n) {
    return Flux.fromStream(IntStream.rangeClosed(2, n).filter(this::isPrime).boxed())
            .map(prime -> ServerSentEvent.<Integer>builder()
                    .data(prime)
                    .build())
            .delayElements(Duration.ofSeconds(3));
  }
  private boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

}
