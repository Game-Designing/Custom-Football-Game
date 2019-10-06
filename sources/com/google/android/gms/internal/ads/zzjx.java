package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzjx extends IOException {

    /* renamed from: a */
    private final zzjq f28727a;

    public zzjx(String str, zzjq zzjq) {
        super(str);
        this.f28727a = zzjq;
    }

    public zzjx(IOException iOException, zzjq zzjq) {
        super(iOException);
        this.f28727a = zzjq;
    }

    public zzjx(String str, IOException iOException, zzjq zzjq) {
        super(str, iOException);
        this.f28727a = zzjq;
    }
}
