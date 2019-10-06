package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.RemoteControlWriter;

/* renamed from: com.google.android.gms.internal.ads._n */
abstract class C9301_n implements zzdlk {

    /* renamed from: a */
    private static final int[] f22053a = m23400b(new byte[]{101, 120, 112, 97, 110, 100, RemoteControlWriter.BLOCK_CMDOK, 51, 50, 45, 98, 121, 116, 101, RemoteControlWriter.BLOCK_CMDOK, 107});

    /* renamed from: b */
    int[] f22054b;

    /* renamed from: c */
    private final int f22055c;

    C9301_n(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.f22054b = m23400b(bArr);
            this.f22055c = i;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract int mo28823a();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract int[] mo28824a(int[] iArr, int i);

    /* renamed from: a */
    public final byte[] mo28835a(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length <= MoPubClientPositioning.NO_REPEAT - mo28823a()) {
            ByteBuffer allocate = ByteBuffer.allocate(mo28823a() + bArr.length);
            mo28834a(allocate, bArr);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28834a(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() - mo28823a() >= bArr.length) {
            byte[] a = zzdlo.m29627a(mo28823a());
            byteBuffer.put(a);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int remaining = wrap.remaining();
            int i = (remaining / 64) + 1;
            for (int i2 = 0; i2 < i; i2++) {
                ByteBuffer a2 = mo28833a(a, this.f22055c + i2);
                if (i2 == i - 1) {
                    zzdjs.m29587a(byteBuffer, wrap, a2, remaining % 64);
                } else {
                    zzdjs.m29587a(byteBuffer, wrap, a2, 64);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final ByteBuffer mo28833a(byte[] bArr, int i) {
        int[] a = mo28824a(m23400b(bArr), i);
        int[] iArr = (int[]) a.clone();
        m23397a(iArr);
        for (int i2 = 0; i2 < a.length; i2++) {
            a[i2] = a[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(a, 0, 16);
        return order;
    }

    /* renamed from: a */
    static void m23399a(int[] iArr, int[] iArr2) {
        int[] iArr3 = f22053a;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, f22053a.length, 8);
    }

    /* renamed from: a */
    static void m23397a(int[] iArr) {
        int[] iArr2 = iArr;
        for (int i = 0; i < 10; i++) {
            m23398a(iArr2, 0, 4, 8, 12);
            m23398a(iArr2, 1, 5, 9, 13);
            m23398a(iArr2, 2, 6, 10, 14);
            m23398a(iArr2, 3, 7, 11, 15);
            m23398a(iArr2, 0, 5, 10, 15);
            m23398a(iArr2, 1, 6, 11, 12);
            m23398a(iArr2, 2, 7, 8, 13);
            m23398a(iArr2, 3, 4, 9, 14);
        }
    }

    /* renamed from: a */
    private static void m23398a(int[] iArr, int i, int i2, int i3, int i4) {
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = m23396a(iArr[i4] ^ iArr[i], 16);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = m23396a(iArr[i2] ^ iArr[i3], 12);
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = m23396a(iArr[i] ^ iArr[i4], 8);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = m23396a(iArr[i2] ^ iArr[i3], 7);
    }

    /* renamed from: b */
    private static int[] m23400b(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    /* renamed from: a */
    private static int m23396a(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }
}
