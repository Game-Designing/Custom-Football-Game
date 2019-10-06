package com.google.android.gms.internal.ads;

public final class zzcjg implements zzbro, zzbsr {

    /* renamed from: a */
    private static final Object f26694a = new Object();

    /* renamed from: b */
    private static int f26695b = 0;

    /* renamed from: c */
    private final zzcjm f26696c;

    public zzcjg(zzcjm zzcjm) {
        this.f26696c = zzcjm;
    }

    public final void onAdLoaded() {
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24033We)).booleanValue() && m28474b()) {
            this.f26696c.mo31182a(true);
            m28473a();
        }
    }

    public final void onAdFailedToLoad(int i) {
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24033We)).booleanValue() && m28474b()) {
            this.f26696c.mo31182a(false);
            m28473a();
        }
    }

    /* renamed from: a */
    private static void m28473a() {
        synchronized (f26694a) {
            f26695b++;
        }
    }

    /* renamed from: b */
    private static boolean m28474b() {
        boolean z;
        synchronized (f26694a) {
            z = f26695b < ((Integer) zzyt.m31536e().mo29599a(zzacu.f24039Xe)).intValue();
        }
        return z;
    }
}
