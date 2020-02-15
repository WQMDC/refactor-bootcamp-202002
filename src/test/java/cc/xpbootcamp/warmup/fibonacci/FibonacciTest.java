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
        Long result = fibonacci.getFibonacciResult(1);
        assert (result.equals(1L));
    }

    @Test
    public void should_return_1_when_calculate_give_position_is_2() {
        Long result = fibonacci.getFibonacciResult(2);
        assert (result.equals(1L));
    }

    @Test
    public void should_return_1_when_calculate_give_position_is_3() {
        Long result = fibonacci.getFibonacciResult(3);
        assert (result.equals(2L));
    }
}