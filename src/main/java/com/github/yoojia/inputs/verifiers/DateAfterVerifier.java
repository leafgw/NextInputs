package com.github.yoojia.inputs.verifiers;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class DateAfterVerifier extends SingleDateTimeVerifier {

    public DateAfterVerifier(String dateTimeStr) {
        super(dateTimeStr, DATE_FORMAT);
    }

    public DateAfterVerifier(String dateTimeStr, SimpleDateFormat format) {
        super(dateTimeStr, format);
    }

    public DateAfterVerifier(Date basedValue) {
        super(basedValue.getTime(), DATE_FORMAT);
    }

    public DateAfterVerifier(Date basedValue, SimpleDateFormat format) {
        super(basedValue.getTime(), format);
    }

    @Override
    protected boolean performTest(long basedValue, long sourceValue) {
        return basedValue < sourceValue;
    }
}
