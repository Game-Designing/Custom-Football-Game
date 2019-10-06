package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class GmsLogger {

    /* renamed from: a */
    private static final int f20107a = 15;

    /* renamed from: b */
    private static final String f20108b = null;

    /* renamed from: c */
    private final String f20109c;

    /* renamed from: d */
    private final String f20110d;

    public GmsLogger(String str, String str2) {
        Preconditions.m21858a(str, (Object) "log tag cannot be null");
        Preconditions.m21865a(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, Integer.valueOf(23));
        this.f20109c = str;
        if (str2 == null || str2.length() <= 0) {
            this.f20110d = null;
        } else {
            this.f20110d = str2;
        }
    }

    public GmsLogger(String str) {
        this(str, null);
    }
}
