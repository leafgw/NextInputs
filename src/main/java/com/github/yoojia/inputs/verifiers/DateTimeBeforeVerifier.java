package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader0;

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

    public DateTimeBeforeVerifier(Loader0<String> basedDateTimeLoader) {
        super(basedDateTimeLoader);
    }

    public DateTimeBeforeVerifier(Loader0<String> basedDateTimeLoader, SimpleDateFormat format) {
        super(basedDateTimeLoader, format);
    }

    @Override
    protected boolean performTest(long basedValue, long sourceValue) {
        return basedValue > sourceValue;
    }
}
