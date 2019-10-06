package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class zzse {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final ExecutorService f29307a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C9202Vs<? extends zzsh> f29308b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IOException f29309c;

    public zzse(String str) {
        this.f29307a = zzsy.m31150a(str);
    }

    /* renamed from: a */
    public final <T extends zzsh> long mo32182a(T t, zzsf<T> zzsf, int i) {
        Looper myLooper = Looper.myLooper();
        zzsk.m31082b(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C9202Vs vs = new C9202Vs(this, myLooper, t, zzsf, i, elapsedRealtime);
        vs.mo28670a(0);
        return elapsedRealtime;
    }

    /* renamed from: a */
    public final boolean mo32185a() {
        return this.f29308b != null;
    }

    /* renamed from: b */
    public final void mo32186b() {
        this.f29308b.mo28671a(false);
    }

    /* renamed from: a */
    public final void mo32184a(Runnable runnable) {
        C9202Vs<? extends zzsh> vs = this.f29308b;
        if (vs != null) {
            vs.mo28671a(true);
        }
        this.f29307a.execute(runnable);
        this.f29307a.shutdown();
    }

    /* renamed from: a */
    public final void mo32183a(int i) throws IOException {
        IOException iOException = this.f29309c;
        if (iOException == null) {
            C9202Vs<? extends zzsh> vs = this.f29308b;
            if (vs != null) {
                vs.mo28669a(vs.f21868c);
                return;
            }
            return;
        }
        throw iOException;
    }
}
