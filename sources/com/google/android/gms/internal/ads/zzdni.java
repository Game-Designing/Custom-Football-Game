package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;

public abstract class zzdni extends zzdmq {

    /* renamed from: a */
    private static final Logger f27981a = Logger.getLogger(zzdni.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final boolean f27982b = C9132Sp.m22995b();

    /* renamed from: c */
    C8859Fo f27983c = this;

    /* renamed from: com.google.android.gms.internal.ads.zzdni$a */
    static class C9874a extends zzdni {

        /* renamed from: d */
        private final byte[] f27984d;

        /* renamed from: e */
        private final int f27985e;

        /* renamed from: f */
        private final int f27986f;

        /* renamed from: g */
        private int f27987g;

        C9874a(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.f27984d = bArr;
                    this.f27985e = i;
                    this.f27987g = i;
                    this.f27986f = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        /* renamed from: h */
        public final void mo31574h(int i, int i2) throws IOException {
            mo31563b((i << 3) | i2);
        }

        /* renamed from: i */
        public final void mo31575i(int i, int i2) throws IOException {
            mo31574h(i, 0);
            mo31549a(i2);
        }

        /* renamed from: j */
        public final void mo31576j(int i, int i2) throws IOException {
            mo31574h(i, 0);
            mo31563b(i2);
        }

        /* renamed from: a */
        public final void mo31552a(int i, int i2) throws IOException {
            mo31574h(i, 5);
            mo31573d(i2);
        }

        /* renamed from: a */
        public final void mo31553a(int i, long j) throws IOException {
            mo31574h(i, 0);
            mo31559a(j);
        }

        /* renamed from: c */
        public final void mo31571c(int i, long j) throws IOException {
            mo31574h(i, 1);
            mo31572c(j);
        }

        /* renamed from: a */
        public final void mo31558a(int i, boolean z) throws IOException {
            mo31574h(i, 0);
            mo31546a(z ? (byte) 1 : 0);
        }

        /* renamed from: a */
        public final void mo31557a(int i, String str) throws IOException {
            mo31574h(i, 2);
            mo31579b(str);
        }

        /* renamed from: a */
        public final void mo31554a(int i, zzdmr zzdmr) throws IOException {
            mo31574h(i, 2);
            mo31578b(zzdmr);
        }

        /* renamed from: b */
        public final void mo31578b(zzdmr zzdmr) throws IOException {
            mo31563b(zzdmr.size());
            zzdmr.mo29328a((zzdmq) this);
        }

        /* renamed from: a */
        public final void mo31555a(int i, zzdpk zzdpk) throws IOException {
            mo31574h(i, 2);
            mo31580c(zzdpk);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final void mo31556a(int i, zzdpk zzdpk, C9822xp xpVar) throws IOException {
            mo31574h(i, 2);
            zzdmi zzdmi = (zzdmi) zzdpk;
            int h = zzdmi.mo31532h();
            if (h == -1) {
                h = xpVar.mo29085b(zzdmi);
                zzdmi.mo31530a(h);
            }
            mo31563b(h);
            xpVar.mo29081a(zzdpk, (C9435fq) this.f27983c);
        }

        /* renamed from: b */
        public final void mo31566b(int i, zzdpk zzdpk) throws IOException {
            mo31574h(1, 3);
            mo31576j(2, i);
            mo31555a(3, zzdpk);
            mo31574h(1, 4);
        }

        /* renamed from: b */
        public final void mo31565b(int i, zzdmr zzdmr) throws IOException {
            mo31574h(1, 3);
            mo31576j(2, i);
            mo31554a(3, zzdmr);
            mo31574h(1, 4);
        }

        /* renamed from: c */
        public final void mo31580c(zzdpk zzdpk) throws IOException {
            mo31563b(zzdpk.mo31603c());
            zzdpk.mo31602a(this);
        }

        /* renamed from: a */
        public final void mo31546a(byte b) throws IOException {
            try {
                byte[] bArr = this.f27984d;
                int i = this.f27987g;
                this.f27987g = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f27987g), Integer.valueOf(this.f27986f), Integer.valueOf(1)}), e);
            }
        }

        /* renamed from: a */
        public final void mo31549a(int i) throws IOException {
            if (i >= 0) {
                mo31563b(i);
            } else {
                mo31559a((long) i);
            }
        }

        /* renamed from: b */
        public final void mo31563b(int i) throws IOException {
            if (!zzdni.f27982b || mo31562b() < 10) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.f27984d;
                    int i2 = this.f27987g;
                    this.f27987g = i2 + 1;
                    bArr[i2] = (byte) ((i & Opcodes.LAND) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f27984d;
                    int i3 = this.f27987g;
                    this.f27987g = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f27987g), Integer.valueOf(this.f27986f), Integer.valueOf(1)}), e);
                }
            } else {
                while ((i & -128) != 0) {
                    byte[] bArr3 = this.f27984d;
                    int i4 = this.f27987g;
                    this.f27987g = i4 + 1;
                    C9132Sp.m22988a(bArr3, (long) i4, (byte) ((i & Opcodes.LAND) | 128));
                    i >>>= 7;
                }
                byte[] bArr4 = this.f27984d;
                int i5 = this.f27987g;
                this.f27987g = i5 + 1;
                C9132Sp.m22988a(bArr4, (long) i5, (byte) i);
            }
        }

        /* renamed from: d */
        public final void mo31573d(int i) throws IOException {
            try {
                byte[] bArr = this.f27984d;
                int i2 = this.f27987g;
                this.f27987g = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.f27984d;
                int i3 = this.f27987g;
                this.f27987g = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.f27984d;
                int i4 = this.f27987g;
                this.f27987g = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.f27984d;
                int i5 = this.f27987g;
                this.f27987g = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f27987g), Integer.valueOf(this.f27986f), Integer.valueOf(1)}), e);
            }
        }

        /* renamed from: a */
        public final void mo31559a(long j) throws IOException {
            if (!zzdni.f27982b || mo31562b() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.f27984d;
                    int i = this.f27987g;
                    this.f27987g = i + 1;
                    bArr[i] = (byte) ((((int) j) & Opcodes.LAND) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f27984d;
                    int i2 = this.f27987g;
                    this.f27987g = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f27987g), Integer.valueOf(this.f27986f), Integer.valueOf(1)}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.f27984d;
                    int i3 = this.f27987g;
                    this.f27987g = i3 + 1;
                    C9132Sp.m22988a(bArr3, (long) i3, (byte) ((((int) j) & Opcodes.LAND) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.f27984d;
                int i4 = this.f27987g;
                this.f27987g = i4 + 1;
                C9132Sp.m22988a(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        /* renamed from: c */
        public final void mo31572c(long j) throws IOException {
            try {
                byte[] bArr = this.f27984d;
                int i = this.f27987g;
                this.f27987g = i + 1;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.f27984d;
                int i2 = this.f27987g;
                this.f27987g = i2 + 1;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.f27984d;
                int i3 = this.f27987g;
                this.f27987g = i3 + 1;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.f27984d;
                int i4 = this.f27987g;
                this.f27987g = i4 + 1;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.f27984d;
                int i5 = this.f27987g;
                this.f27987g = i5 + 1;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.f27984d;
                int i6 = this.f27987g;
                this.f27987g = i6 + 1;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.f27984d;
                int i7 = this.f27987g;
                this.f27987g = i7 + 1;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.f27984d;
                int i8 = this.f27987g;
                this.f27987g = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f27987g), Integer.valueOf(this.f27986f), Integer.valueOf(1)}), e);
            }
        }

        /* renamed from: b */
        public final void mo31568b(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.f27984d, this.f27987g, i2);
                this.f27987g += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f27987g), Integer.valueOf(this.f27986f), Integer.valueOf(i2)}), e);
            }
        }

        /* renamed from: a */
        public final void mo31538a(byte[] bArr, int i, int i2) throws IOException {
            mo31568b(bArr, i, i2);
        }

        /* renamed from: b */
        public final void mo31579b(String str) throws IOException {
            int i = this.f27987g;
            try {
                int g = zzdni.m29735g(str.length() * 3);
                int g2 = zzdni.m29735g(str.length());
                if (g2 == g) {
                    this.f27987g = i + g2;
                    int a = C9199Vp.m23148a(str, this.f27984d, this.f27987g, mo31562b());
                    this.f27987g = i;
                    mo31563b((a - i) - g2);
                    this.f27987g = a;
                    return;
                }
                mo31563b(C9199Vp.m23147a((CharSequence) str));
                this.f27987g = C9199Vp.m23148a(str, this.f27984d, this.f27987g, mo31562b());
            } catch (C9283Zp e) {
                this.f27987g = i;
                mo31560a(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc((Throwable) e2);
            }
        }

        /* renamed from: a */
        public void mo31545a() {
        }

        /* renamed from: b */
        public final int mo31562b() {
            return this.f27986f - this.f27987g;
        }

        /* renamed from: e */
        public final int mo31581e() {
            return this.f27987g - this.f27985e;
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.zzdni$b */
    static final class C9875b extends C9874a {

        /* renamed from: h */
        private final ByteBuffer f27988h;

        /* renamed from: i */
        private int f27989i;

        C9875b(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.f27988h = byteBuffer;
            this.f27989i = byteBuffer.position();
        }

        /* renamed from: a */
        public final void mo31545a() {
            this.f27988h.position(this.f27989i + mo31581e());
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.zzdni$c */
    static final class C9876c extends zzdni {

        /* renamed from: d */
        private final ByteBuffer f27990d;

        /* renamed from: e */
        private final ByteBuffer f27991e;

        /* renamed from: f */
        private final int f27992f;

        C9876c(ByteBuffer byteBuffer) {
            super();
            this.f27990d = byteBuffer;
            this.f27991e = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f27992f = byteBuffer.position();
        }

        /* renamed from: h */
        public final void mo31574h(int i, int i2) throws IOException {
            mo31563b((i << 3) | i2);
        }

        /* renamed from: i */
        public final void mo31575i(int i, int i2) throws IOException {
            mo31574h(i, 0);
            mo31549a(i2);
        }

        /* renamed from: j */
        public final void mo31576j(int i, int i2) throws IOException {
            mo31574h(i, 0);
            mo31563b(i2);
        }

        /* renamed from: a */
        public final void mo31552a(int i, int i2) throws IOException {
            mo31574h(i, 5);
            mo31573d(i2);
        }

        /* renamed from: a */
        public final void mo31553a(int i, long j) throws IOException {
            mo31574h(i, 0);
            mo31559a(j);
        }

        /* renamed from: c */
        public final void mo31571c(int i, long j) throws IOException {
            mo31574h(i, 1);
            mo31572c(j);
        }

        /* renamed from: a */
        public final void mo31558a(int i, boolean z) throws IOException {
            mo31574h(i, 0);
            mo31546a(z ? (byte) 1 : 0);
        }

        /* renamed from: a */
        public final void mo31557a(int i, String str) throws IOException {
            mo31574h(i, 2);
            mo31584b(str);
        }

        /* renamed from: a */
        public final void mo31554a(int i, zzdmr zzdmr) throws IOException {
            mo31574h(i, 2);
            mo31582b(zzdmr);
        }

        /* renamed from: a */
        public final void mo31555a(int i, zzdpk zzdpk) throws IOException {
            mo31574h(i, 2);
            mo31585c(zzdpk);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final void mo31556a(int i, zzdpk zzdpk, C9822xp xpVar) throws IOException {
            mo31574h(i, 2);
            mo31583b(zzdpk, xpVar);
        }

        /* renamed from: b */
        public final void mo31566b(int i, zzdpk zzdpk) throws IOException {
            mo31574h(1, 3);
            mo31576j(2, i);
            mo31555a(3, zzdpk);
            mo31574h(1, 4);
        }

        /* renamed from: b */
        public final void mo31565b(int i, zzdmr zzdmr) throws IOException {
            mo31574h(1, 3);
            mo31576j(2, i);
            mo31554a(3, zzdmr);
            mo31574h(1, 4);
        }

        /* renamed from: c */
        public final void mo31585c(zzdpk zzdpk) throws IOException {
            mo31563b(zzdpk.mo31603c());
            zzdpk.mo31602a(this);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public final void mo31583b(zzdpk zzdpk, C9822xp xpVar) throws IOException {
            zzdmi zzdmi = (zzdmi) zzdpk;
            int h = zzdmi.mo31532h();
            if (h == -1) {
                h = xpVar.mo29085b(zzdmi);
                zzdmi.mo31530a(h);
            }
            mo31563b(h);
            xpVar.mo29081a(zzdpk, (C9435fq) this.f27983c);
        }

        /* renamed from: a */
        public final void mo31546a(byte b) throws IOException {
            try {
                this.f27991e.put(b);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        /* renamed from: b */
        public final void mo31582b(zzdmr zzdmr) throws IOException {
            mo31563b(zzdmr.size());
            zzdmr.mo29328a((zzdmq) this);
        }

        /* renamed from: a */
        public final void mo31549a(int i) throws IOException {
            if (i >= 0) {
                mo31563b(i);
            } else {
                mo31559a((long) i);
            }
        }

        /* renamed from: b */
        public final void mo31563b(int i) throws IOException {
            while ((i & -128) != 0) {
                this.f27991e.put((byte) ((i & Opcodes.LAND) | 128));
                i >>>= 7;
            }
            try {
                this.f27991e.put((byte) i);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        /* renamed from: d */
        public final void mo31573d(int i) throws IOException {
            try {
                this.f27991e.putInt(i);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        /* renamed from: a */
        public final void mo31559a(long j) throws IOException {
            while ((-128 & j) != 0) {
                this.f27991e.put((byte) ((((int) j) & Opcodes.LAND) | 128));
                j >>>= 7;
            }
            try {
                this.f27991e.put((byte) ((int) j));
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        /* renamed from: c */
        public final void mo31572c(long j) throws IOException {
            try {
                this.f27991e.putLong(j);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        /* renamed from: b */
        public final void mo31568b(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.f27991e.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc((Throwable) e);
            } catch (BufferOverflowException e2) {
                throw new zzc((Throwable) e2);
            }
        }

        /* renamed from: a */
        public final void mo31538a(byte[] bArr, int i, int i2) throws IOException {
            mo31568b(bArr, i, i2);
        }

        /* renamed from: b */
        public final void mo31584b(String str) throws IOException {
            int position = this.f27991e.position();
            try {
                int g = zzdni.m29735g(str.length() * 3);
                int g2 = zzdni.m29735g(str.length());
                if (g2 == g) {
                    int position2 = this.f27991e.position() + g2;
                    this.f27991e.position(position2);
                    m29809c(str);
                    int position3 = this.f27991e.position();
                    this.f27991e.position(position);
                    mo31563b(position3 - position2);
                    this.f27991e.position(position3);
                    return;
                }
                mo31563b(C9199Vp.m23147a((CharSequence) str));
                m29809c(str);
            } catch (C9283Zp e) {
                this.f27991e.position(position);
                mo31560a(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc((Throwable) e2);
            }
        }

        /* renamed from: a */
        public final void mo31545a() {
            this.f27990d.position(this.f27991e.position());
        }

        /* renamed from: b */
        public final int mo31562b() {
            return this.f27991e.remaining();
        }

        /* renamed from: c */
        private final void m29809c(String str) throws IOException {
            try {
                C9199Vp.m23149a((CharSequence) str, this.f27991e);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc((Throwable) e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.zzdni$d */
    static final class C9877d extends zzdni {

        /* renamed from: d */
        private final ByteBuffer f27993d;

        /* renamed from: e */
        private final ByteBuffer f27994e;

        /* renamed from: f */
        private final long f27995f;

        /* renamed from: g */
        private final long f27996g;

        /* renamed from: h */
        private final long f27997h;

        /* renamed from: i */
        private final long f27998i = (this.f27997h - 10);

        /* renamed from: j */
        private long f27999j = this.f27996g;

        C9877d(ByteBuffer byteBuffer) {
            super();
            this.f27993d = byteBuffer;
            this.f27994e = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f27995f = C9132Sp.m22977a(byteBuffer);
            this.f27996g = this.f27995f + ((long) byteBuffer.position());
            this.f27997h = this.f27995f + ((long) byteBuffer.limit());
        }

        /* renamed from: h */
        public final void mo31574h(int i, int i2) throws IOException {
            mo31563b((i << 3) | i2);
        }

        /* renamed from: i */
        public final void mo31575i(int i, int i2) throws IOException {
            mo31574h(i, 0);
            mo31549a(i2);
        }

        /* renamed from: j */
        public final void mo31576j(int i, int i2) throws IOException {
            mo31574h(i, 0);
            mo31563b(i2);
        }

        /* renamed from: a */
        public final void mo31552a(int i, int i2) throws IOException {
            mo31574h(i, 5);
            mo31573d(i2);
        }

        /* renamed from: a */
        public final void mo31553a(int i, long j) throws IOException {
            mo31574h(i, 0);
            mo31559a(j);
        }

        /* renamed from: c */
        public final void mo31571c(int i, long j) throws IOException {
            mo31574h(i, 1);
            mo31572c(j);
        }

        /* renamed from: a */
        public final void mo31558a(int i, boolean z) throws IOException {
            mo31574h(i, 0);
            mo31546a(z ? (byte) 1 : 0);
        }

        /* renamed from: a */
        public final void mo31557a(int i, String str) throws IOException {
            mo31574h(i, 2);
            mo31588b(str);
        }

        /* renamed from: a */
        public final void mo31554a(int i, zzdmr zzdmr) throws IOException {
            mo31574h(i, 2);
            mo31586b(zzdmr);
        }

        /* renamed from: a */
        public final void mo31555a(int i, zzdpk zzdpk) throws IOException {
            mo31574h(i, 2);
            mo31589c(zzdpk);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final void mo31556a(int i, zzdpk zzdpk, C9822xp xpVar) throws IOException {
            mo31574h(i, 2);
            mo31587b(zzdpk, xpVar);
        }

        /* renamed from: b */
        public final void mo31566b(int i, zzdpk zzdpk) throws IOException {
            mo31574h(1, 3);
            mo31576j(2, i);
            mo31555a(3, zzdpk);
            mo31574h(1, 4);
        }

        /* renamed from: b */
        public final void mo31565b(int i, zzdmr zzdmr) throws IOException {
            mo31574h(1, 3);
            mo31576j(2, i);
            mo31554a(3, zzdmr);
            mo31574h(1, 4);
        }

        /* renamed from: c */
        public final void mo31589c(zzdpk zzdpk) throws IOException {
            mo31563b(zzdpk.mo31603c());
            zzdpk.mo31602a(this);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public final void mo31587b(zzdpk zzdpk, C9822xp xpVar) throws IOException {
            zzdmi zzdmi = (zzdmi) zzdpk;
            int h = zzdmi.mo31532h();
            if (h == -1) {
                h = xpVar.mo29085b(zzdmi);
                zzdmi.mo31530a(h);
            }
            mo31563b(h);
            xpVar.mo29081a(zzdpk, (C9435fq) this.f27983c);
        }

        /* renamed from: a */
        public final void mo31546a(byte b) throws IOException {
            long j = this.f27999j;
            if (j < this.f27997h) {
                this.f27999j = 1 + j;
                C9132Sp.m22980a(j, b);
                return;
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j), Long.valueOf(this.f27997h), Integer.valueOf(1)}));
        }

        /* renamed from: b */
        public final void mo31586b(zzdmr zzdmr) throws IOException {
            mo31563b(zzdmr.size());
            zzdmr.mo29328a((zzdmq) this);
        }

        /* renamed from: a */
        public final void mo31549a(int i) throws IOException {
            if (i >= 0) {
                mo31563b(i);
            } else {
                mo31559a((long) i);
            }
        }

        /* renamed from: b */
        public final void mo31563b(int i) throws IOException {
            if (this.f27999j <= this.f27998i) {
                while ((i & -128) != 0) {
                    long j = this.f27999j;
                    this.f27999j = j + 1;
                    C9132Sp.m22980a(j, (byte) ((i & Opcodes.LAND) | 128));
                    i >>>= 7;
                }
                long j2 = this.f27999j;
                this.f27999j = 1 + j2;
                C9132Sp.m22980a(j2, (byte) i);
                return;
            }
            while (true) {
                long j3 = this.f27999j;
                if (j3 >= this.f27997h) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j3), Long.valueOf(this.f27997h), Integer.valueOf(1)}));
                } else if ((i & -128) == 0) {
                    this.f27999j = 1 + j3;
                    C9132Sp.m22980a(j3, (byte) i);
                    return;
                } else {
                    this.f27999j = j3 + 1;
                    C9132Sp.m22980a(j3, (byte) ((i & Opcodes.LAND) | 128));
                    i >>>= 7;
                }
            }
        }

        /* renamed from: d */
        public final void mo31573d(int i) throws IOException {
            this.f27994e.putInt((int) (this.f27999j - this.f27995f), i);
            this.f27999j += 4;
        }

        /* renamed from: a */
        public final void mo31559a(long j) throws IOException {
            if (this.f27999j <= this.f27998i) {
                while ((j & -128) != 0) {
                    long j2 = this.f27999j;
                    this.f27999j = j2 + 1;
                    C9132Sp.m22980a(j2, (byte) ((((int) j) & Opcodes.LAND) | 128));
                    j >>>= 7;
                }
                long j3 = this.f27999j;
                this.f27999j = 1 + j3;
                C9132Sp.m22980a(j3, (byte) ((int) j));
                return;
            }
            while (true) {
                long j4 = this.f27999j;
                if (j4 >= this.f27997h) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j4), Long.valueOf(this.f27997h), Integer.valueOf(1)}));
                } else if ((j & -128) == 0) {
                    this.f27999j = 1 + j4;
                    C9132Sp.m22980a(j4, (byte) ((int) j));
                    return;
                } else {
                    this.f27999j = j4 + 1;
                    C9132Sp.m22980a(j4, (byte) ((((int) j) & Opcodes.LAND) | 128));
                    j >>>= 7;
                }
            }
        }

        /* renamed from: c */
        public final void mo31572c(long j) throws IOException {
            this.f27994e.putLong((int) (this.f27999j - this.f27995f), j);
            this.f27999j += 8;
        }

        /* renamed from: b */
        public final void mo31568b(byte[] bArr, int i, int i2) throws IOException {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = (long) i2;
                long j2 = this.f27997h - j;
                long j3 = this.f27999j;
                if (j2 >= j3) {
                    C9132Sp.m22989a(bArr, (long) i, j3, j);
                    this.f27999j += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException(DonationsAnalytics.VALUE);
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.f27999j), Long.valueOf(this.f27997h), Integer.valueOf(i2)}));
        }

        /* renamed from: a */
        public final void mo31538a(byte[] bArr, int i, int i2) throws IOException {
            mo31568b(bArr, i, i2);
        }

        /* renamed from: b */
        public final void mo31588b(String str) throws IOException {
            long j = this.f27999j;
            try {
                int g = zzdni.m29735g(str.length() * 3);
                int g2 = zzdni.m29735g(str.length());
                if (g2 == g) {
                    int i = ((int) (this.f27999j - this.f27995f)) + g2;
                    this.f27994e.position(i);
                    C9199Vp.m23149a((CharSequence) str, this.f27994e);
                    int position = this.f27994e.position() - i;
                    mo31563b(position);
                    this.f27999j += (long) position;
                    return;
                }
                int a = C9199Vp.m23147a((CharSequence) str);
                mo31563b(a);
                m29837j(this.f27999j);
                C9199Vp.m23149a((CharSequence) str, this.f27994e);
                this.f27999j += (long) a;
            } catch (C9283Zp e) {
                this.f27999j = j;
                m29837j(this.f27999j);
                mo31560a(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc((Throwable) e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc((Throwable) e3);
            }
        }

        /* renamed from: a */
        public final void mo31545a() {
            this.f27993d.position((int) (this.f27999j - this.f27995f));
        }

        /* renamed from: b */
        public final int mo31562b() {
            return (int) (this.f27997h - this.f27999j);
        }

        /* renamed from: j */
        private final void m29837j(long j) {
            this.f27994e.position((int) (j - this.f27995f));
        }
    }

    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzc(String str) {
            String valueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            String valueOf2 = String.valueOf(str);
            super(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        zzc(String str, Throwable th) {
            String valueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            String valueOf2 = String.valueOf(str);
            super(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), th);
        }
    }

    /* renamed from: a */
    public static zzdni m29704a(byte[] bArr) {
        return new C9874a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public abstract void mo31545a() throws IOException;

    /* renamed from: a */
    public abstract void mo31546a(byte b) throws IOException;

    /* renamed from: a */
    public abstract void mo31549a(int i) throws IOException;

    /* renamed from: a */
    public abstract void mo31552a(int i, int i2) throws IOException;

    /* renamed from: a */
    public abstract void mo31553a(int i, long j) throws IOException;

    /* renamed from: a */
    public abstract void mo31554a(int i, zzdmr zzdmr) throws IOException;

    /* renamed from: a */
    public abstract void mo31555a(int i, zzdpk zzdpk) throws IOException;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo31556a(int i, zzdpk zzdpk, C9822xp xpVar) throws IOException;

    /* renamed from: a */
    public abstract void mo31557a(int i, String str) throws IOException;

    /* renamed from: a */
    public abstract void mo31558a(int i, boolean z) throws IOException;

    /* renamed from: a */
    public abstract void mo31559a(long j) throws IOException;

    /* renamed from: b */
    public abstract int mo31562b();

    /* renamed from: b */
    public abstract void mo31563b(int i) throws IOException;

    /* renamed from: b */
    public abstract void mo31565b(int i, zzdmr zzdmr) throws IOException;

    /* renamed from: b */
    public abstract void mo31566b(int i, zzdpk zzdpk) throws IOException;

    /* renamed from: b */
    public abstract void mo31568b(byte[] bArr, int i, int i2) throws IOException;

    /* renamed from: c */
    public abstract void mo31571c(int i, long j) throws IOException;

    /* renamed from: c */
    public abstract void mo31572c(long j) throws IOException;

    /* renamed from: d */
    public abstract void mo31573d(int i) throws IOException;

    /* renamed from: h */
    public abstract void mo31574h(int i, int i2) throws IOException;

    /* renamed from: i */
    public abstract void mo31575i(int i, int i2) throws IOException;

    /* renamed from: j */
    public abstract void mo31576j(int i, int i2) throws IOException;

    /* renamed from: a */
    public static zzdni m29703a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new C9875b(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        } else if (C9132Sp.m22999c()) {
            return new C9877d(byteBuffer);
        } else {
            return new C9876c(byteBuffer);
        }
    }

    private zzdni() {
    }

    /* renamed from: k */
    public final void mo31577k(int i, int i2) throws IOException {
        mo31576j(i, m29747m(i2));
    }

    /* renamed from: b */
    public final void mo31564b(int i, long j) throws IOException {
        mo31553a(i, m29743i(j));
    }

    /* renamed from: a */
    public final void mo31551a(int i, float f) throws IOException {
        mo31552a(i, Float.floatToRawIntBits(f));
    }

    /* renamed from: a */
    public final void mo31550a(int i, double d) throws IOException {
        mo31571c(i, Double.doubleToRawLongBits(d));
    }

    /* renamed from: c */
    public final void mo31570c(int i) throws IOException {
        mo31563b(m29747m(i));
    }

    /* renamed from: b */
    public final void mo31567b(long j) throws IOException {
        mo31559a(m29743i(j));
    }

    /* renamed from: a */
    public final void mo31548a(float f) throws IOException {
        mo31573d(Float.floatToRawIntBits(f));
    }

    /* renamed from: a */
    public final void mo31547a(double d) throws IOException {
        mo31572c(Double.doubleToRawLongBits(d));
    }

    /* renamed from: a */
    public final void mo31561a(boolean z) throws IOException {
        mo31546a(z ? (byte) 1 : 0);
    }

    /* renamed from: b */
    public static int m29709b(int i, int i2) {
        return m29727e(i) + m29731f(i2);
    }

    /* renamed from: c */
    public static int m29717c(int i, int i2) {
        return m29727e(i) + m29735g(i2);
    }

    /* renamed from: d */
    public static int m29721d(int i, int i2) {
        return m29727e(i) + m29735g(m29747m(i2));
    }

    /* renamed from: e */
    public static int m29728e(int i, int i2) {
        return m29727e(i) + 4;
    }

    /* renamed from: f */
    public static int m29732f(int i, int i2) {
        return m29727e(i) + 4;
    }

    /* renamed from: d */
    public static int m29722d(int i, long j) {
        return m29727e(i) + m29730e(j);
    }

    /* renamed from: e */
    public static int m29729e(int i, long j) {
        return m29727e(i) + m29730e(j);
    }

    /* renamed from: f */
    public static int m29733f(int i, long j) {
        return m29727e(i) + m29730e(m29743i(j));
    }

    /* renamed from: g */
    public static int m29737g(int i, long j) {
        return m29727e(i) + 8;
    }

    /* renamed from: h */
    public static int m29740h(int i, long j) {
        return m29727e(i) + 8;
    }

    /* renamed from: b */
    public static int m29708b(int i, float f) {
        return m29727e(i) + 4;
    }

    /* renamed from: b */
    public static int m29707b(int i, double d) {
        return m29727e(i) + 8;
    }

    /* renamed from: b */
    public static int m29713b(int i, boolean z) {
        return m29727e(i) + 1;
    }

    /* renamed from: g */
    public static int m29736g(int i, int i2) {
        return m29727e(i) + m29731f(i2);
    }

    /* renamed from: b */
    public static int m29712b(int i, String str) {
        return m29727e(i) + m29702a(str);
    }

    /* renamed from: c */
    public static int m29718c(int i, zzdmr zzdmr) {
        int e = m29727e(i);
        int size = zzdmr.size();
        return e + m29735g(size) + size;
    }

    /* renamed from: a */
    public static int m29697a(int i, zzdor zzdor) {
        int e = m29727e(i);
        int b = zzdor.mo31624b();
        return e + m29735g(b) + b;
    }

    /* renamed from: c */
    public static int m29719c(int i, zzdpk zzdpk) {
        return m29727e(i) + m29700a(zzdpk);
    }

    /* renamed from: b */
    static int m29711b(int i, zzdpk zzdpk, C9822xp xpVar) {
        return m29727e(i) + m29701a(zzdpk, xpVar);
    }

    /* renamed from: d */
    public static int m29724d(int i, zzdpk zzdpk) {
        return (m29727e(1) << 1) + m29717c(2, i) + m29719c(3, zzdpk);
    }

    /* renamed from: d */
    public static int m29723d(int i, zzdmr zzdmr) {
        return (m29727e(1) << 1) + m29717c(2, i) + m29718c(3, zzdmr);
    }

    /* renamed from: b */
    public static int m29710b(int i, zzdor zzdor) {
        return (m29727e(1) << 1) + m29717c(2, i) + m29697a(3, zzdor);
    }

    /* renamed from: e */
    public static int m29727e(int i) {
        return m29735g(i << 3);
    }

    /* renamed from: f */
    public static int m29731f(int i) {
        if (i >= 0) {
            return m29735g(i);
        }
        return 10;
    }

    /* renamed from: g */
    public static int m29735g(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((i & -268435456) == 0) {
            return 4;
        }
        return 5;
    }

    /* renamed from: h */
    public static int m29739h(int i) {
        return m29735g(m29747m(i));
    }

    /* renamed from: i */
    public static int m29742i(int i) {
        return 4;
    }

    /* renamed from: j */
    public static int m29744j(int i) {
        return 4;
    }

    /* renamed from: d */
    public static int m29725d(long j) {
        return m29730e(j);
    }

    /* renamed from: e */
    public static int m29730e(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        if ((j & -16384) != 0) {
            i++;
        }
        return i;
    }

    /* renamed from: f */
    public static int m29734f(long j) {
        return m29730e(m29743i(j));
    }

    /* renamed from: g */
    public static int m29738g(long j) {
        return 8;
    }

    /* renamed from: h */
    public static int m29741h(long j) {
        return 8;
    }

    /* renamed from: b */
    public static int m29706b(float f) {
        return 4;
    }

    /* renamed from: b */
    public static int m29705b(double d) {
        return 8;
    }

    /* renamed from: b */
    public static int m29715b(boolean z) {
        return 1;
    }

    /* renamed from: k */
    public static int m29745k(int i) {
        return m29731f(i);
    }

    /* renamed from: a */
    public static int m29702a(String str) {
        int i;
        try {
            i = C9199Vp.m23147a((CharSequence) str);
        } catch (C9283Zp e) {
            i = str.getBytes(zzdod.f28084a).length;
        }
        return m29735g(i) + i;
    }

    /* renamed from: a */
    public static int m29699a(zzdor zzdor) {
        int b = zzdor.mo31624b();
        return m29735g(b) + b;
    }

    /* renamed from: a */
    public static int m29698a(zzdmr zzdmr) {
        int size = zzdmr.size();
        return m29735g(size) + size;
    }

    /* renamed from: b */
    public static int m29716b(byte[] bArr) {
        int length = bArr.length;
        return m29735g(length) + length;
    }

    /* renamed from: a */
    public static int m29700a(zzdpk zzdpk) {
        int c = zzdpk.mo31603c();
        return m29735g(c) + c;
    }

    /* renamed from: a */
    static int m29701a(zzdpk zzdpk, C9822xp xpVar) {
        zzdmi zzdmi = (zzdmi) zzdpk;
        int h = zzdmi.mo31532h();
        if (h == -1) {
            h = xpVar.mo29085b(zzdmi);
            zzdmi.mo31530a(h);
        }
        return m29735g(h) + h;
    }

    /* renamed from: m */
    private static int m29747m(int i) {
        return (i >> 31) ^ (i << 1);
    }

    /* renamed from: i */
    private static long m29743i(long j) {
        return (j >> 63) ^ (j << 1);
    }

    /* renamed from: c */
    public final void mo31569c() {
        if (mo31562b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo31560a(String str, C9283Zp zp) throws IOException {
        f27981a.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zp);
        byte[] bytes = str.getBytes(zzdod.f28084a);
        try {
            mo31563b(bytes.length);
            mo31538a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzc((Throwable) e);
        } catch (zzc e2) {
            throw e2;
        }
    }

    @Deprecated
    /* renamed from: c */
    static int m29720c(int i, zzdpk zzdpk, C9822xp xpVar) {
        int e = m29727e(i) << 1;
        zzdmi zzdmi = (zzdmi) zzdpk;
        int h = zzdmi.mo31532h();
        if (h == -1) {
            h = xpVar.mo29085b(zzdmi);
            zzdmi.mo31530a(h);
        }
        return e + h;
    }

    @Deprecated
    /* renamed from: b */
    public static int m29714b(zzdpk zzdpk) {
        return zzdpk.mo31603c();
    }

    @Deprecated
    /* renamed from: l */
    public static int m29746l(int i) {
        return m29735g(i);
    }
}
