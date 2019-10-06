package com.mopub.common.util;

public class Numbers {
    private Numbers() {
    }

    public static Double parseDouble(Object value) throws ClassCastException {
        if (value instanceof Number) {
            return Double.valueOf(((Number) value).doubleValue());
        }
        String str = " as double.";
        String str2 = "Unable to parse ";
        if (value instanceof String) {
            try {
                return Double.valueOf((String) value);
            } catch (NumberFormatException e) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(value);
                sb.append(str);
                throw new ClassCastException(sb.toString());
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(value);
            sb2.append(str);
            throw new ClassCastException(sb2.toString());
        }
    }

    public static long convertMillisecondsToSecondsRoundedUp(long millis) {
        return Math.round(Math.ceil((double) (((float) millis) / 1000.0f)));
    }
}
