package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader2A;
import com.github.yoojia.inputs.PairVerifier;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class RangeValueVerifier extends PairVerifier<Double> {

    public RangeValueVerifier(Loader2A<Double> valueLoader) {
        super(valueLoader);
    }

    public RangeValueVerifier(double fixedFirstValue, double fixedSecondValue) {
        super(fixedFirstValue, fixedSecondValue);
    }

    @Override
    protected boolean performTestValue(Double typedInput) {
        final Double minLength  = getFirstBasedValue();
        final Double maxLength  = getSecondBasedValue();
        return (minLength < typedInput || minLength.equals(typedInput))
                && (typedInput < maxLength || typedInput.equals(maxLength));
    }

    @Override
    protected Double stringToTyped(String notEmptyInput) {
        return Double.parseDouble(notEmptyInput);
    }
}
