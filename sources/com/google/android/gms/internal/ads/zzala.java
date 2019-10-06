package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;

public final class zzala extends zzbbw<zzajw> {

    /* renamed from: c */
    private final Object f24400c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public zzayp<zzajw> f24401d;

    /* renamed from: e */
    private boolean f24402e;

    /* renamed from: f */
    private int f24403f;

    public zzala(zzayp<zzajw> zzayp) {
        this.f24401d = zzayp;
        this.f24402e = false;
        this.f24403f = 0;
    }

    /* renamed from: c */
    public final zzakw mo29801c() {
        zzakw zzakw = new zzakw(this);
        synchronized (this.f24400c) {
            mo30344a(new C9849za(this, zzakw), new C8740Aa(this, zzakw));
            Preconditions.m21867b(this.f24403f >= 0);
            this.f24403f++;
        }
        return zzakw;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final void mo29802d() {
        synchronized (this.f24400c) {
            Preconditions.m21867b(this.f24403f > 0);
            zzawz.m26003f("Releasing 1 reference for JS Engine");
            this.f24403f--;
            m25181f();
        }
    }

    /* renamed from: e */
    public final void mo29803e() {
        synchronized (this.f24400c) {
            Preconditions.m21867b(this.f24403f >= 0);
            zzawz.m26003f("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.f24402e = true;
            m25181f();
        }
    }

    /* renamed from: f */
    private final void m25181f() {
        synchronized (this.f24400c) {
            Preconditions.m21867b(this.f24403f >= 0);
            if (!this.f24402e || this.f24403f != 0) {
                zzawz.m26003f("There are still references to the engine. Not destroying.");
            } else {
                zzawz.m26003f("No reference is left (including root). Cleaning up engine.");
                mo30344a(new C8761Ba(this), new zzbbu());
            }
        }
    }
}
