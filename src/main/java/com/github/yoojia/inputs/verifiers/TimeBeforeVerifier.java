package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader0;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class TimeBeforeVerifier extends TimeAfterVerifier{


    public TimeBeforeVerifier(String dateTimeStr) {
        super(dateTimeStr);
    }

    public TimeBeforeVerifier(String dateTimeStr, SimpleDateFormat format) {
        super(dateTimeStr, format);
    }

    public TimeBeforeVerifier(Date basedValue) {
        super(basedValue);
    }

    public TimeBeforeVerifier(Date basedValue, SimpleDateFormat format) {
        super(basedValue, format);
    }

    public TimeBeforeVerifier(Loader0<String> basedDateTimeLoader) {
        super(basedDateTimeLoader);
    }

    public TimeBeforeVerifier(Loader0<String> basedDateTimeLoader, SimpleDateFormat format) {
        super(basedDateTimeLoader, format);
    }

    @Override
    protected boolean performTest(long basedValue, long sourceValue) {
        return basedValue > sourceValue;
    }
}
