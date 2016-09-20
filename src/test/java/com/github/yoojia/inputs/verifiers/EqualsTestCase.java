package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.LazyLoader;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class EqualsTestCase {

    @Test
    public void testPassed() throws Exception {
        EqualsVerifier bridge = new EqualsVerifier(new LazyLoader<String>() {
            @Override
            public String getValue() {
                return "NextInputs";
            }
        });
        PairVerifier<String> verifier = new PairVerifier<>(bridge);
        Assert.assertTrue(verifier.perform("NextInputs"));
    }

    @Test
    public void testFail() throws Exception {
        EqualsVerifier bridge = new EqualsVerifier(new LazyLoader<String>() {
            @Override
            public String getValue() {
                return "NextInputs";
            }
        });
        PairVerifier<String> verifier = new PairVerifier<>(bridge);
        Assert.assertFalse(verifier.perform("NextInputs-Java"));
    }
}
