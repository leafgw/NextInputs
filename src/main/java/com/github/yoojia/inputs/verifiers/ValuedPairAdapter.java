package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.PairAdapter;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
abstract class ValuedPairAdapter extends PairAdapter<Double> {

    private final Double mValueA;
    private final Double mValueB;

    public ValuedPairAdapter(Double valueA, Double valueB) {
        this.mValueA = valueA;
        this.mValueB = valueB;
    }

    public ValuedPairAdapter(Float valueA, Float valueB) {
        this.mValueA = valueA == null ? 0 : valueA.doubleValue();
        this.mValueB = valueB == null ? 0 : valueB.doubleValue();
    }

    public ValuedPairAdapter(Long valueA, Long valueB) {
        this.mValueA = valueA == null ? 0 : valueA.doubleValue();
        this.mValueB = valueB == null ? 0 : valueB.doubleValue();
    }

    public ValuedPairAdapter(Integer valueA, Integer valueB) {
        this.mValueA = valueA == null ? 0 : valueA.doubleValue();
        this.mValueB = valueB == null ? 0 : valueB.doubleValue();
    }

    @Override
    public Double getFirst() {
        return mValueA;
    }

    @Override
    public Double getSecond() {
        return mValueB;
    }

    @Override
    public Double inputToTyped(String input) {
        return Double.valueOf(input);
    }

}
