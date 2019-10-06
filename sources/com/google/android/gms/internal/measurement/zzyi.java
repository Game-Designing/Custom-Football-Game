package com.google.android.gms.internal.measurement;

import java.io.IOException;

public abstract class zzyi {

    /* renamed from: a */
    protected volatile int f30425a = -1;

    /* renamed from: d */
    public final int mo32966d() {
        if (this.f30425a < 0) {
            mo32965b();
        }
        return this.f30425a;
    }

    /* renamed from: b */
    public final int mo32965b() {
        int a = mo32952a();
        this.f30425a = a;
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo32952a() {
        return 0;
    }

    /* renamed from: a */
    public void mo32953a(zzya zzya) throws IOException {
    }

    public String toString() {
        return zzyj.m32621a(this);
    }

    /* renamed from: c */
    public zzyi clone() throws CloneNotSupportedException {
        return (zzyi) super.clone();
    }
}
