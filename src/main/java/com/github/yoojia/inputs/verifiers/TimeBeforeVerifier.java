package com.github.yoojia.inputs.verifiers;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class TimeBeforeVerifier extends TimeAfterVerifier{

    public TimeBeforeVerifier(String dateTimeStr){
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

    @Override
    protected boolean performTest(long basedValue, long sourceValue) {
        return basedValue > sourceValue;
    }
}
