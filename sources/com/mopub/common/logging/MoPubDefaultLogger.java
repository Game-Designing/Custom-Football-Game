package com.mopub.common.logging;

import android.util.Log;

public class MoPubDefaultLogger implements MoPubLogger {

    /* renamed from: a */
    static int f34411a = 3072;

    public void log(String className, String methodName, String identifier, String message) {
        String[] a;
        for (String segment : m37074a(message)) {
            String str = MoPubLog.LOGTAG;
            if (identifier == null) {
                Log.i(str, String.format("[%s][%s] %s", new Object[]{className, methodName, segment}));
            } else {
                Log.i(str, String.format("[%s][%s][%s] %s", new Object[]{className, methodName, identifier, segment}));
            }
        }
    }

    /* renamed from: a */
    static String[] m37074a(String message) {
        if (message == null) {
            return new String[1];
        }
        int segmentCount = (message.length() / f34411a) + 1;
        String[] segments = new String[segmentCount];
        for (int i = 0; i < segmentCount; i++) {
            int i2 = f34411a;
            segments[i] = message.substring(i * i2, Math.min((i + 1) * i2, message.length()));
        }
        return segments;
    }
}
