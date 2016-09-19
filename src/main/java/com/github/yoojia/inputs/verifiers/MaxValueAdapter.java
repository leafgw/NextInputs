package com.github.yoojia.inputs.verifiers;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class MaxValueAdapter extends ValuedPairAdapter {

    public MaxValueAdapter(Double valueA) {
        super(valueA, null);
    }

    public MaxValueAdapter(Float valueA) {
        super(valueA, null);
    }

    public MaxValueAdapter(Long valueA) {
        super(valueA, null);
    }

    public MaxValueAdapter(Integer valueA) {
        super(valueA, null);
    }

    @Override
    public boolean perform(Double input, Double first, Double second) {
        return input <= first;
    }
}
