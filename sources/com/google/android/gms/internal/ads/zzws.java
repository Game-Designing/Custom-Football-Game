package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzws {

    /* renamed from: a */
    private final byte[] f29609a;

    /* renamed from: b */
    private int f29610b;

    /* renamed from: c */
    private int f29611c;

    /* renamed from: d */
    private final /* synthetic */ zzwo f29612d;

    private zzws(zzwo zzwo, byte[] bArr) {
        this.f29612d = zzwo;
        this.f29609a = bArr;
    }

    /* renamed from: a */
    public final synchronized void mo32333a() {
        try {
            if (this.f29612d.f29608b) {
                this.f29612d.f29607a.mo31757a(this.f29609a);
                this.f29612d.f29607a.mo31762o(this.f29610b);
                this.f29612d.f29607a.mo31761l(this.f29611c);
                this.f29612d.f29607a.mo31758a((int[]) null);
                this.f29612d.f29607a.mo31759ab();
            }
        } catch (RemoteException e) {
            zzbad.m26353a("Clearcut log failed", e);
        }
    }

    /* renamed from: a */
    public final zzws mo32332a(int i) {
        this.f29610b = i;
        return this;
    }

    /* renamed from: b */
    public final zzws mo32334b(int i) {
        this.f29611c = i;
        return this;
    }
}
