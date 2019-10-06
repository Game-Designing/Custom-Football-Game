package com.google.android.gms.internal.ads;

public final class zzakw extends zzbbw<zzalf> {

    /* renamed from: c */
    private final Object f24392c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzala f24393d;

    /* renamed from: e */
    private boolean f24394e;

    public zzakw(zzala zzala) {
        this.f24393d = zzala;
    }

    /* renamed from: c */
    public final void mo29798c() {
        synchronized (this.f24392c) {
            if (!this.f24394e) {
                this.f24394e = true;
                mo30344a(new C9786wa(this), new zzbbu());
                mo30344a(new C9807xa(this), new C9828ya(this));
            }
        }
    }
}
