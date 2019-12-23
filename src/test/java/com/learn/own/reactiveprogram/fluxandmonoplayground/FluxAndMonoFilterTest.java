package com.learn.own.reactiveprogram.fluxandmonoplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

public class FluxAndMonoFilterTest {

    List<String> names = Arrays.asList("adam", "anna", "jack", "jenny");

    @Test
    public void fluxUsingFilter() {
        Flux<String> stringFlux = Flux.fromIterable(names)
                .filter(s -> s.startsWith("a"));

        StepVerifier.create(stringFlux.log())
                .expectNext("adam", "anna")
                .verifyComplete();
    }

    @Test
    public void fluxTestLength() {
        Flux<String> stringFlux = Flux.fromIterable(names)
                .filter(s -> s.length() > 4);

        StepVerifier.create(stringFlux.log())
                .expectNext("jenny")
                .verifyComplete();
    }
}
