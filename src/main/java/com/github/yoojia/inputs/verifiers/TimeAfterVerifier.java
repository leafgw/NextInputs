package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader0;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class TimeAfterVerifier extends SingleDateTimeVerifier {

    public TimeAfterVerifier(String dateTimeStr) {
        super(dateTimeStr, TIME_FORMAT);
    }

    public TimeAfterVerifier(String dateTimeStr, SimpleDateFormat format) {
        super(dateTimeStr, format);
    }

    public TimeAfterVerifier(Date basedValue) {
        super(basedValue, TIME_FORMAT);
    }

    public TimeAfterVerifier(Date basedValue, SimpleDateFormat format) {
        super(basedValue, format);
    }

    public TimeAfterVerifier(Loader0<String> basedDateTimeLoader) {
        super(basedDateTimeLoader, TIME_FORMAT);
    }

    public TimeAfterVerifier(Loader0<String> basedDateTimeLoader, SimpleDateFormat format) {
        super(basedDateTimeLoader, format);
    }

    @Override
    protected boolean performTest(long basedValue, long sourceValue) {
        return basedValue < sourceValue;
    }
}
