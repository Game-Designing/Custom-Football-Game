package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public abstract class zzdst extends zzdsr implements zzbd {

    /* renamed from: l */
    private int f28270l;

    /* renamed from: m */
    private int f28271m;

    protected zzdst(String str) {
        super(str);
    }

    /* renamed from: b */
    public final int mo31685b() {
        if (!this.f28258d) {
            mo31683a();
        }
        return this.f28270l;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final long mo31686b(ByteBuffer byteBuffer) {
        this.f28270l = zzbc.m26410a(byteBuffer.get());
        this.f28271m = (zzbc.m26412b(byteBuffer) << 8) + 0 + zzbc.m26410a(byteBuffer.get());
        return 4;
    }
}
