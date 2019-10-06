package com.mopub.common.util;

import java.security.MessageDigest;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

public class Utils {

    /* renamed from: a */
    private static final AtomicLong f34612a = new AtomicLong(1);

    public static String sha1(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = string.getBytes("UTF-8");
            digest.update(bytes, 0, bytes.length);
            for (byte b : digest.digest()) {
                stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(b)}));
            }
            return stringBuilder.toString().toLowerCase(Locale.US);
        } catch (Exception e) {
            return "";
        }
    }

    public static long generateUniqueId() {
        long result;
        long newValue;
        do {
            result = f34612a.get();
            newValue = 1 + result;
            if (newValue > 9223372036854775806L) {
                newValue = 1;
            }
        } while (!f34612a.compareAndSet(result, newValue));
        return result;
    }

    public static boolean bitMaskContainsFlag(int bitMask, int flag) {
        return (bitMask & flag) != 0;
    }
}
