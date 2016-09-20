package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader0;
import com.github.yoojia.inputs.Loader0Ex;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class TimeAfterVerifier extends SingleDateTimeVerifier {
    
    public TimeAfterVerifier(Loader0<Date> valueLoader) {
        super(valueLoader, DATE_FORMAT);
    }

    public TimeAfterVerifier(Loader0<Date> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public TimeAfterVerifier(Loader0Ex<String> valueLoader) {
        super(valueLoader, DATE_FORMAT);
    }

    public TimeAfterVerifier(Loader0Ex<String> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public TimeAfterVerifier(Date fixedValue) {
        super(fixedValue, DATE_FORMAT);
    }

    public TimeAfterVerifier(Date fixedValue, SimpleDateFormat format) {
        super(fixedValue, format);
    }

    public TimeAfterVerifier(String fixedValue) {
        super(fixedValue, DATE_FORMAT);
    }

    public TimeAfterVerifier(String fixedValue, SimpleDateFormat format) {
        super(fixedValue, format);
    }

    @Override
    protected boolean performTypedTest(Long typedInput) {
        return getBasedValue() < typedInput;
    }

}
