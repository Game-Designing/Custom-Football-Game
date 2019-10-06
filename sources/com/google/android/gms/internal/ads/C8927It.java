package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.It */
final /* synthetic */ class C8927It implements Runnable {

    /* renamed from: a */
    private final C8906Ht f21272a;

    /* renamed from: b */
    private final zzvu f21273b;

    /* renamed from: c */
    private final zzvv f21274c;

    /* renamed from: d */
    private final zzbbr f21275d;

    C8927It(C8906Ht ht, zzvu zzvu, zzvv zzvv, zzbbr zzbbr) {
        this.f21272a = ht;
        this.f21273b = zzvu;
        this.f21274c = zzvv;
        this.f21275d = zzbbr;
    }

    public final void run() {
        C8906Ht ht = this.f21272a;
        zzvu zzvu = this.f21273b;
        zzvv zzvv = this.f21274c;
        zzbbr zzbbr = this.f21275d;
        try {
            zzvs a = zzvu.mo27780j().mo32326a(zzvv);
            if (!a.mo32317a()) {
                zzbbr.mo30337a(new RuntimeException("No entry contents."));
                ht.f21237c.m31323a();
                return;
            }
            C8969Kt kt = new C8969Kt(ht, a.mo32318c(), 1);
            int read = kt.read();
            if (read != -1) {
                kt.unread(read);
                zzbbr.mo30338b(kt);
                return;
            }
            throw new IOException("Unable to read from cache.");
        } catch (RemoteException | IOException e) {
            zzbad.m26356b("Unable to obtain a cache service instance.", e);
            zzbbr.mo30337a(e);
            ht.f21237c.m31323a();
        }
    }
}
