package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzju extends IOException {

    /* renamed from: a */
    private final String f28721a;

    public zzju(String str) {
        String valueOf = String.valueOf(str);
        String str2 = "Unsupported URI scheme: ";
        super(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.f28721a = str;
    }
}
