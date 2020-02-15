package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {

    public Long getFibonacciResult(int index) {
        Long a = 1L;
        Long b = 1L;
        Long sum = 1L;

        if (index < 3) {
            return sum;
        }
        for (int i = 3; i <= index; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}