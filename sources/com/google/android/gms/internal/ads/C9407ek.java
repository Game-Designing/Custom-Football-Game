package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* renamed from: com.google.android.gms.internal.ads.ek */
final class C9407ek implements zzban<T> {

    /* renamed from: a */
    private final /* synthetic */ String f22219a;

    /* renamed from: b */
    private final /* synthetic */ long f22220b;

    /* renamed from: c */
    private final /* synthetic */ zzcmu f22221c;

    C9407ek(zzcmu zzcmu, String str, long j) {
        this.f22221c = zzcmu;
        this.f22219a = str;
        this.f22220b = j;
    }

    /* renamed from: a */
    public final void mo27998a(T t) {
        this.f22221c.m28596a(this.f22219a, 0, this.f22221c.f27049a.mo27934a() - this.f22220b);
    }

    /* renamed from: a */
    public final void mo27999a(Throwable th) {
        long a = this.f22221c.f27049a.mo27934a();
        int i = 3;
        if (th instanceof TimeoutException) {
            i = 2;
        } else if (!(th instanceof zzcmk)) {
            if (th instanceof CancellationException) {
                i = 4;
            } else if (!(th instanceof zzcgm)) {
                i = 6;
            } else if (((zzcgm) th).mo31157a() == 3) {
                i = 1;
            } else {
                i = 6;
            }
        }
        this.f22221c.m28596a(this.f22219a, i, a - this.f22220b);
    }
}
