package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.vt */
final class C9784vt implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ C9763ut f23347a;

    C9784vt(C9763ut utVar) {
        this.f23347a = utVar;
    }

    public final void run() {
        synchronized (this.f23347a.f23244c) {
            if (!this.f23347a.f23245d || !this.f23347a.f23246e) {
                zzbad.m26352a("App is still foreground");
            } else {
                this.f23347a.f23245d = false;
                zzbad.m26352a("App went background");
                for (zzut a : this.f23347a.f23247f) {
                    try {
                        a.mo28176a(false);
                    } catch (Exception e) {
                        zzbad.m26356b("", e);
                    }
                }
            }
        }
    }
}
