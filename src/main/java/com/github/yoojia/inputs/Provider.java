package com.github.yoojia.inputs;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.5.3
 */
@Deprecated
public class Provider extends InputProviders{

    public static Input fromString(final String fixedValue) {
        return fixedString(fixedValue);
    }

    public static Input fromInt(int fixedValue) {
        return fixedInt(fixedValue);
    }

    public static Input fromLong(long fixedValue) {
        return fixedLong(fixedValue);
    }

    public static Input fromFloat(float fixedValue) {
        return fixedFloat(fixedValue);
    }

    public static Input fromDouble(double fixedValue) {
        return fixedDouble(fixedValue);
    }

    public static Input fromBool(boolean fixedValue) {
        return fixedBool(fixedValue);
    }
}
