package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzyc;
import java.io.IOException;

public abstract class zzyc<M extends zzyc<M>> extends zzyi {

    /* renamed from: b */
    protected zzye f30412b;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo32952a() {
        if (this.f30412b == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f30412b.mo32960a(); i2++) {
            i += this.f30412b.mo32961a(i2).mo32743a();
        }
        return i;
    }

    /* renamed from: a */
    public void mo32953a(zzya zzya) throws IOException {
        if (this.f30412b != null) {
            for (int i = 0; i < this.f30412b.mo32960a(); i++) {
                this.f30412b.mo32961a(i).mo32744a(zzya);
            }
        }
    }

    /* renamed from: c */
    public final /* synthetic */ zzyi mo32954c() throws CloneNotSupportedException {
        return (zzyc) clone();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzyc zzyc = (zzyc) super.clone();
        zzyg.m32615a(this, zzyc);
        return zzyc;
    }
}
