package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader0;
import com.github.yoojia.inputs.Loader0Ex;
import com.github.yoojia.inputs.SingleVerifier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
abstract class SingleDateTimeVerifier extends SingleVerifier<Long>{

    static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    private final SimpleDateFormat mFormat;

    // Loader: Data
    public SingleDateTimeVerifier(final Loader0<Date> valueLoader, SimpleDateFormat format) {
        super(new Loader0<Long>() {
            @Override public Long getValue() {
                return valueLoader.getValue().getTime();
            }
        });
        mFormat = format;
    }

    // Loader: String
    public SingleDateTimeVerifier(final Loader0Ex<String> valueLoader, final SimpleDateFormat format) {
        super(new Loader0<Long>() {
            @Override
            public Long getValue() {
                return DateTimeKit.parse(valueLoader.toString(), format).getTime();
            }
        });
        mFormat = format;
    }

    // Fixed: Date
    public SingleDateTimeVerifier(Date fixedValue, SimpleDateFormat format) {
        super(fixedValue.getTime());
        mFormat = format;
    }

    // Fixed: String
    public SingleDateTimeVerifier(String fixedValue, SimpleDateFormat format) {
        this(DateTimeKit.parse(fixedValue, format), format);
    }

    @Override
    protected Long stringToTyped(String notEmptyInput) {
        return DateTimeKit.parse(notEmptyInput, mFormat).getTime();
    }

}
