package com.github.yoojia.inputs.verifiers;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class DateTimeAfterVerifier extends SingleDateTimeVerifier {

    public DateTimeAfterVerifier(String dateTimeStr) {
        super(dateTimeStr, DATE_TIME_FORMAT);
    }

    public DateTimeAfterVerifier(String dateTimeStr, SimpleDateFormat format) {
        super(dateTimeStr, format);
    }

    public DateTimeAfterVerifier(Date basedValue) {
        super(basedValue.getTime(), DATE_TIME_FORMAT);
    }

    public DateTimeAfterVerifier(Date basedValue, SimpleDateFormat format) {
        super(basedValue.getTime(), format);
    }

    @Override
    protected boolean performTest(long basedValue, long sourceValue) {
        return basedValue < sourceValue;
    }
}
