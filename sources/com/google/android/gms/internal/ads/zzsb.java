package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzsb extends IOException {

    /* renamed from: a */
    private final int f29301a;

    /* renamed from: b */
    private final zzry f29302b;

    public zzsb(String str, zzry zzry, int i) {
        super(str);
        this.f29302b = zzry;
        this.f29301a = 1;
    }

    public zzsb(IOException iOException, zzry zzry, int i) {
        super(iOException);
        this.f29302b = zzry;
        this.f29301a = i;
    }

    public zzsb(String str, IOException iOException, zzry zzry, int i) {
        super(str, iOException);
        this.f29302b = zzry;
        this.f29301a = 1;
    }
}
