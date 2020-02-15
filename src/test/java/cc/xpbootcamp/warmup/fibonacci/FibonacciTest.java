package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FibonacciTest {
    public Fibonacci fibonacci;

    @BeforeEach
    void beforeEach() {
        fibonacci = new Fibonacci();
    }

    @Test
    public void should_return_1_when_calculate_given_position_is_1() {
        Long result = fibonacci.getFibonacciResult(1L);
        assert (result.equals(1L));
    }
}