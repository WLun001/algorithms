package practice;

import java.util.function.Function;

public class FP {
    public static void main(String[] args) {

    }

    private static Integer invert(Integer value) {
        return -value;
    }

    public static Integer invertTheNumber() {
        Integer toInvert = 5;
        Function<Integer, Integer> invertFunction = FP::invert;
        return compute(invertFunction, toInvert);
    }

    public static Integer compute(Function<Integer, Integer> function, Integer value) {
        return function.apply(value);
    }
}
