package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Js */
final class C8947Js implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ C9010Ms f21386a;

    /* renamed from: b */
    private final /* synthetic */ C8884Gs f21387b;

    C8947Js(C8884Gs gs, C9010Ms ms) {
        this.f21387b = gs;
        this.f21386a = ms;
    }

    public final void run() {
        this.f21386a.mo28458a();
        int size = this.f21387b.f21106p.size();
        for (int i = 0; i < size; i++) {
            ((zzqt) this.f21387b.f21106p.valueAt(i)).mo32110a();
        }
    }
}
