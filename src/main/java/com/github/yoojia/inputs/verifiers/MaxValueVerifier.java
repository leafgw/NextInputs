package com.github.yoojia.inputs.verifiers;


import com.github.yoojia.inputs.Loader1;
import com.github.yoojia.inputs.PairVerifier;
import com.github.yoojia.inputs.SingleVerifier;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class MaxValueVerifier extends SingleVerifier<Double> {
    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        return false;
    }


//    @Override
//    public boolean perform(Double input, Double first, Double second) {
//        return input <= first;
//    }
}
