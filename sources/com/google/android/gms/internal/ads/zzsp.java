package com.google.android.gms.internal.ads;

import com.vungle.warren.model.Advertisement;

public final class zzsp {
    /* renamed from: a */
    public static boolean m31097a(String str) {
        return "audio".equals(m31099c(str));
    }

    /* renamed from: b */
    public static boolean m31098b(String str) {
        return Advertisement.KEY_VIDEO.equals(m31099c(str));
    }

    /* renamed from: c */
    private static String m31099c(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        String str2 = "Invalid mime type: ";
        String valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }
}
