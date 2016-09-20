package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader1;
import com.github.yoojia.inputs.PairVerifier;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class RangeValueAdapter extends PairVerifier<Double> {

    public RangeValueAdapter(Loader1<Double> valueLoader) {
        super(valueLoader);
    }

    public RangeValueAdapter(double fixedFirstValue, double fixedSecondValue) {
        super(fixedFirstValue, fixedSecondValue);
    }

    @Override
    protected boolean performTestValue(Double typedInput) {
        final double minLength  = getFirstBasedValue();
        final double maxLength  = getSecondBasedValue();
        return minLength <= typedInput && typedInput <= maxLength;
    }

    @Override
    protected Double stringToTyped(String notEmptyInput) {
        return Double.parseDouble(notEmptyInput);
    }
}
