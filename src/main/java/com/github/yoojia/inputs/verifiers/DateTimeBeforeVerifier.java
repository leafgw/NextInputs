package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader0;
import com.github.yoojia.inputs.Loader0Ex;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class DateTimeBeforeVerifier extends DateTimeAfterVerifier{

    public DateTimeBeforeVerifier(Loader0<Date> valueLoader) {
        super(valueLoader);
    }

    public DateTimeBeforeVerifier(Loader0<Date> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public DateTimeBeforeVerifier(Loader0Ex<String> valueLoader) {
        super(valueLoader);
    }

    public DateTimeBeforeVerifier(Loader0Ex<String> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public DateTimeBeforeVerifier(Date fixedValue) {
        super(fixedValue);
    }

    public DateTimeBeforeVerifier(Date fixedValue, SimpleDateFormat format) {
        super(fixedValue, format);
    }

    public DateTimeBeforeVerifier(String fixedValue) {
        super(fixedValue);
    }

    public DateTimeBeforeVerifier(String fixedValue, SimpleDateFormat format) {
        super(fixedValue, format);
    }

    @Override
    protected boolean performTypedTest(Long typedInput) {
        return getBasedValue() > typedInput;
    }
}
