package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader0;
import com.github.yoojia.inputs.Loader0Ex;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class DateBeforeVerifier extends DateAfterVerifier{

    public DateBeforeVerifier(Loader0<Date> valueLoader) {
        super(valueLoader);
    }

    public DateBeforeVerifier(Loader0<Date> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public DateBeforeVerifier(Loader0Ex<String> valueLoader) {
        super(valueLoader);
    }

    public DateBeforeVerifier(Loader0Ex<String> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public DateBeforeVerifier(Date fixedValue) {
        super(fixedValue);
    }

    public DateBeforeVerifier(Date fixedValue, SimpleDateFormat format) {
        super(fixedValue, format);
    }

    public DateBeforeVerifier(String fixedValue) {
        super(fixedValue);
    }

    public DateBeforeVerifier(String fixedValue, SimpleDateFormat format) {
        super(fixedValue, format);
    }

    @Override
    protected boolean performTypedTest(Long typedInput) {
        return getBasedValue() > typedInput;
    }
}
