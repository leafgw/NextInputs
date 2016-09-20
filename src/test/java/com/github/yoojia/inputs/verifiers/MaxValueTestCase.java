package com.github.yoojia.inputs.verifiers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class MaxValueTestCase {

    @Test
    public void testPassed() throws Exception {
        ValuedPairAdapter bridge = new MaxValueVerifier(10);
        PairVerifier<Double> verifier = new PairVerifier<>(bridge);
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("9"));
        Assert.assertTrue(verifier.perform("0"));
        Assert.assertTrue(verifier.perform("-99"));
    }

    @Test
    public void testFail() throws Exception {
        ValuedPairAdapter bridge = new MaxValueVerifier(10);
        PairVerifier<Double> verifier = new PairVerifier<>(bridge);
        Assert.assertFalse(verifier.perform("11"));
        Assert.assertFalse(verifier.perform("999"));
    }
}
