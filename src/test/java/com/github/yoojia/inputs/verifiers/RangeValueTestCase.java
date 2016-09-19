package com.github.yoojia.inputs.verifiers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class RangeValueTestCase {

    @Test
    public void testPassed() throws Exception {
        ValuedPairAdapter bridge = new RangeValueAdapter(5, 10);
        PairVerifier<Double> verifier = new PairVerifier<>(bridge);
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("5"));
        Assert.assertTrue(verifier.perform("8"));
        Assert.assertTrue(verifier.perform("10"));
    }

    @Test
    public void testFail() throws Exception {
        ValuedPairAdapter bridge = new RangeValueAdapter(5, 10);
        PairVerifier<Double> verifier = new PairVerifier<>(bridge);
        Assert.assertFalse(verifier.perform("-10"));
        Assert.assertFalse(verifier.perform("4"));
        Assert.assertFalse(verifier.perform("11"));
        Assert.assertFalse(verifier.perform("999"));
    }
}
