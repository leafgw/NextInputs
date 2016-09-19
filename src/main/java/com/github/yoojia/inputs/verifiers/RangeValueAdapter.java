package com.github.yoojia.inputs.verifiers;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class RangeValueAdapter extends ValuedPairAdapter {

    public RangeValueAdapter(Double valueA, Double valueB) {
        super(valueA, valueB);
    }

    public RangeValueAdapter(Float valueA, Float valueB) {
        super(valueA, valueB);
    }

    public RangeValueAdapter(Long valueA, Long valueB) {
        super(valueA, valueB);
    }

    public RangeValueAdapter(Integer valueA, Integer valueB) {
        super(valueA, valueB);
    }

    @Override
    public boolean perform(Double input, Double first, Double second) {
        return first <= input && input <= second;
    }
}
