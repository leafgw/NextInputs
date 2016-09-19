package com.github.yoojia.inputs.verifiers;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class DateTimeBeforeVerifier extends DateTimeAfterVerifier{

    public DateTimeBeforeVerifier(String dateTimeStr) {
        super(dateTimeStr);
    }

    public DateTimeBeforeVerifier(String dateTimeStr, SimpleDateFormat format) {
        super(dateTimeStr, format);
    }

    public DateTimeBeforeVerifier(Date basedValue) {
        super(basedValue);
    }

    public DateTimeBeforeVerifier(Date basedValue, SimpleDateFormat format) {
        super(basedValue, format);
    }

    @Override
    protected boolean performTest(long basedValue, long sourceValue) {
        return basedValue > sourceValue;
    }
}
