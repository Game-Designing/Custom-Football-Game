package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzdrw {

    /* renamed from: a */
    protected volatile int f28166a = -1;

    /* renamed from: a */
    public final int mo31681a() {
        int c = mo31672c();
        this.f28166a = c;
        return c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo31672c() {
        return 0;
    }

    /* renamed from: a */
    public void mo31670a(zzdrp zzdrp) throws IOException {
    }

    /* renamed from: a */
    public static final byte[] m30019a(zzdrw zzdrw) {
        byte[] bArr = new byte[zzdrw.mo31681a()];
        try {
            zzdrp a = zzdrp.m29994a(bArr, 0, bArr.length);
            zzdrw.mo31670a(a);
            a.mo31661a();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public String toString() {
        return zzdrx.m30024a(this);
    }

    /* renamed from: b */
    public zzdrw clone() throws CloneNotSupportedException {
        return (zzdrw) super.clone();
    }
}
