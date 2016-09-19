package com.github.yoojia.inputs.verifiers;

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
        super(basedValue.getTime(), TIME_FORMAT);
    }

    public TimeAfterVerifier(Date basedValue, SimpleDateFormat format) {
        super(basedValue.getTime(), format);
    }

    @Override
    protected boolean performTest(long basedValue, long sourceValue) {
        return basedValue < sourceValue;
    }
}
