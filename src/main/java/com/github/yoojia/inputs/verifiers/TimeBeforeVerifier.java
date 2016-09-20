package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader0;
import com.github.yoojia.inputs.Loader0Ex;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class TimeBeforeVerifier extends TimeAfterVerifier{

    public TimeBeforeVerifier(Loader0<Date> valueLoader) {
        super(valueLoader);
    }

    public TimeBeforeVerifier(Loader0<Date> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public TimeBeforeVerifier(Loader0Ex<String> valueLoader) {
        super(valueLoader);
    }

    public TimeBeforeVerifier(Loader0Ex<String> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public TimeBeforeVerifier(Date fixedValue) {
        super(fixedValue);
    }

    public TimeBeforeVerifier(Date fixedValue, SimpleDateFormat format) {
        super(fixedValue, format);
    }

    public TimeBeforeVerifier(String fixedValue) {
        super(fixedValue);
    }

    public TimeBeforeVerifier(String fixedValue, SimpleDateFormat format) {
        super(fixedValue, format);
    }

    @Override
    protected boolean performTypedTest(Long typedInput) {
        return getBasedValue() > typedInput;
    }

}
