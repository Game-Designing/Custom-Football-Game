package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.d */
abstract class C8691d extends C8688b {

    /* renamed from: c */
    private static final WeakReference<byte[]> f19950c = new WeakReference<>(null);

    /* renamed from: d */
    private WeakReference<byte[]> f19951d = f19950c;

    C8691d(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: Sa */
    public abstract byte[] mo27656Sa();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final byte[] mo27652a() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f19951d.get();
            if (bArr == null) {
                bArr = mo27656Sa();
                this.f19951d = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
