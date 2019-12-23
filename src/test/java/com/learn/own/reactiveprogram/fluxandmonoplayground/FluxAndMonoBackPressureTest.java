package com.learn.own.reactiveprogram.fluxandmonoplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxAndMonoBackPressureTest {

    @Test
    public void backPressureTest() {
        Flux<Integer> integerFlux = Flux.range(1, 10);

        StepVerifier.create(integerFlux.log())
                .expectSubscription()
                .thenRequest(1)
                .expectNext(1)
                .thenRequest(1)
                .expectNext(2)
                .thenRequest(2)
                .expectNext(3, 4)
                .thenCancel()
                .verify();
    }

    @Test
    public void backPressure() {
        Flux<Integer> integerFlux = Flux.range(1, 10)
                .log();

        integerFlux.subscribe(element -> System.out.println("Element is : " + element),
                error -> System.out.println("Error is : " + error),
                () -> System.out.println("Done"),
                subscription -> subscription.request(2));
    }

    @Test
    public void backPressure_Cancel() {
        Flux<Integer> integerFlux = Flux.range(1, 10)
                .log();

        integerFlux.subscribe(element -> System.out.println("Element is : " + element),
                error -> System.out.println("Error is : " + error),
                () -> System.out.println("Done"),
                subscription -> subscription.cancel());
    }

    @Test
    public void customized_backPressure() {
        Flux<Integer> integerFlux = Flux.range(1, 10)
                .log();

        integerFlux.subscribe(new BaseSubscriber<Integer>() {
            @Override
            protected void hookOnNext(Integer value) {
                request(1);
                System.out.println("Value is ======> " + value);
                if(value == 4) cancel();
            }
        });
    }
}
