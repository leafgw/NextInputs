package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader0;
import com.github.yoojia.inputs.Loader0Ex;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class DateAfterVerifier extends SingleDateTimeVerifier {

    public DateAfterVerifier(Loader0<Date> valueLoader) {
        super(valueLoader, DATE_FORMAT);
    }

    public DateAfterVerifier(Loader0<Date> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public DateAfterVerifier(Loader0Ex<String> valueLoader) {
        super(valueLoader, DATE_FORMAT);
    }

    public DateAfterVerifier(Loader0Ex<String> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public DateAfterVerifier(Date fixedValue) {
        super(fixedValue, DATE_FORMAT);
    }

    public DateAfterVerifier(Date fixedValue, SimpleDateFormat format) {
        super(fixedValue, format);
    }

    public DateAfterVerifier(String fixedValue) {
        super(fixedValue, DATE_FORMAT);
    }

    public DateAfterVerifier(String fixedValue, SimpleDateFormat format) {
        super(fixedValue, format);
    }

    @Override
    protected boolean performTypedTest(Long typedInput) {
        return getBasedValue() < typedInput;
    }

}
