package com.github.yoojia.inputs.verifiers;


import com.github.yoojia.inputs.Loader0;
import com.github.yoojia.inputs.SingleVerifier;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class MaxValueVerifier extends SingleVerifier<Double> {

    public MaxValueVerifier(Loader0<Double> valueLoader) {
        super(valueLoader);
    }

    public MaxValueVerifier(Double fixedValue) {
        super(fixedValue);
    }

    @Override
    protected Double stringToTyped(String notEmptyInput) {
        return Double.parseDouble(notEmptyInput);
    }

    @Override
    protected boolean performTypedTest(Double typedInput) {
        return typedInput <= getBasedValue();
    }

}
