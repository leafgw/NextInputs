package com.github.yoojia.inputs.verifiers;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class MinValueAdapter extends ValuedPairAdapter {

    public MinValueAdapter(Double valueA) {
        super(valueA, null);
    }

    public MinValueAdapter(Float valueA) {
        super(valueA, null);
    }

    public MinValueAdapter(Long valueA) {
        super(valueA, null);
    }

    public MinValueAdapter(Integer valueA) {
        super(valueA, null);
    }

    @Override
    public boolean perform(Double input, Double first, Double second) {
        return input >= first;
    }
}
