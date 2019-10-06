package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public abstract class zztv extends zztd {

    /* renamed from: a */
    private static final Logger f30255a = Logger.getLogger(zztv.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final boolean f30256b = C9946_a.m32002b();

    /* renamed from: c */
    C9934U f30257c = this;

    /* renamed from: com.google.android.gms.internal.measurement.zztv$a */
    static class C10021a extends zztv {

        /* renamed from: d */
        private final byte[] f30258d;

        /* renamed from: e */
        private final int f30259e;

        /* renamed from: f */
        private final int f30260f;

        /* renamed from: g */
        private int f30261g;

        C10021a(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.f30258d = bArr;
                    this.f30259e = i;
                    this.f30261g = i;
                    this.f30260f = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        /* renamed from: a */
        public final void mo32857a(int i, int i2) throws IOException {
            mo32867b((i << 3) | i2);
        }

        /* renamed from: b */
        public final void mo32868b(int i, int i2) throws IOException {
            mo32857a(i, 0);
            mo32854a(i2);
        }

        /* renamed from: c */
        public final void mo32873c(int i, int i2) throws IOException {
            mo32857a(i, 0);
            mo32867b(i2);
        }

        /* renamed from: e */
        public final void mo32878e(int i, int i2) throws IOException {
            mo32857a(i, 5);
            mo32876d(i2);
        }

        /* renamed from: a */
        public final void mo32858a(int i, long j) throws IOException {
            mo32857a(i, 0);
            mo32864a(j);
        }

        /* renamed from: c */
        public final void mo32874c(int i, long j) throws IOException {
            mo32857a(i, 1);
            mo32875c(j);
        }

        /* renamed from: a */
        public final void mo32863a(int i, boolean z) throws IOException {
            mo32857a(i, 0);
            mo32851a(z ? (byte) 1 : 0);
        }

        /* renamed from: a */
        public final void mo32862a(int i, String str) throws IOException {
            mo32857a(i, 2);
            mo32880b(str);
        }

        /* renamed from: a */
        public final void mo32859a(int i, zzte zzte) throws IOException {
            mo32857a(i, 2);
            mo32879b(zzte);
        }

        /* renamed from: b */
        public final void mo32879b(zzte zzte) throws IOException {
            mo32867b(zzte.size());
            zzte.mo32597a((zztd) this);
        }

        /* renamed from: d */
        public final void mo32883d(int i, zzvv zzvv) throws IOException {
            mo32857a(i, 2);
            mo32882c(zzvv);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final void mo32861a(int i, zzvv zzvv, C9906Fa fa) throws IOException {
            mo32857a(i, 2);
            zzsx zzsx = (zzsx) zzvv;
            int f = zzsx.mo32839f();
            if (f == -1) {
                f = fa.mo32555b(zzsx);
                zzsx.mo32837a(f);
            }
            mo32867b(f);
            fa.mo32553a(zzvv, (C9986lb) this.f30257c);
        }

        /* renamed from: a */
        public final void mo32860a(int i, zzvv zzvv) throws IOException {
            mo32857a(1, 3);
            mo32873c(2, i);
            mo32883d(3, zzvv);
            mo32857a(1, 4);
        }

        /* renamed from: b */
        public final void mo32870b(int i, zzte zzte) throws IOException {
            mo32857a(1, 3);
            mo32873c(2, i);
            mo32859a(3, zzte);
            mo32857a(1, 4);
        }

        /* renamed from: c */
        public final void mo32882c(zzvv zzvv) throws IOException {
            mo32867b(zzvv.mo32892a());
            zzvv.mo32894a(this);
        }

        /* renamed from: a */
        public final void mo32851a(byte b) throws IOException {
            try {
                byte[] bArr = this.f30258d;
                int i = this.f30261g;
                this.f30261g = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f30261g), Integer.valueOf(this.f30260f), Integer.valueOf(1)}), e);
            }
        }

        /* renamed from: a */
        public final void mo32854a(int i) throws IOException {
            if (i >= 0) {
                mo32867b(i);
            } else {
                mo32864a((long) i);
            }
        }

        /* renamed from: b */
        public final void mo32867b(int i) throws IOException {
            if (!zztv.f30256b || mo32850a() < 10) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.f30258d;
                    int i2 = this.f30261g;
                    this.f30261g = i2 + 1;
                    bArr[i2] = (byte) ((i & Opcodes.LAND) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f30258d;
                    int i3 = this.f30261g;
                    this.f30261g = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f30261g), Integer.valueOf(this.f30260f), Integer.valueOf(1)}), e);
                }
            } else {
                while ((i & -128) != 0) {
                    byte[] bArr3 = this.f30258d;
                    int i4 = this.f30261g;
                    this.f30261g = i4 + 1;
                    C9946_a.m31996a(bArr3, (long) i4, (byte) ((i & Opcodes.LAND) | 128));
                    i >>>= 7;
                }
                byte[] bArr4 = this.f30258d;
                int i5 = this.f30261g;
                this.f30261g = i5 + 1;
                C9946_a.m31996a(bArr4, (long) i5, (byte) i);
            }
        }

        /* renamed from: d */
        public final void mo32876d(int i) throws IOException {
            try {
                byte[] bArr = this.f30258d;
                int i2 = this.f30261g;
                this.f30261g = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.f30258d;
                int i3 = this.f30261g;
                this.f30261g = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.f30258d;
                int i4 = this.f30261g;
                this.f30261g = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.f30258d;
                int i5 = this.f30261g;
                this.f30261g = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f30261g), Integer.valueOf(this.f30260f), Integer.valueOf(1)}), e);
            }
        }

        /* renamed from: a */
        public final void mo32864a(long j) throws IOException {
            if (!zztv.f30256b || mo32850a() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.f30258d;
                    int i = this.f30261g;
                    this.f30261g = i + 1;
                    bArr[i] = (byte) ((((int) j) & Opcodes.LAND) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f30258d;
                    int i2 = this.f30261g;
                    this.f30261g = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f30261g), Integer.valueOf(this.f30260f), Integer.valueOf(1)}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.f30258d;
                    int i3 = this.f30261g;
                    this.f30261g = i3 + 1;
                    C9946_a.m31996a(bArr3, (long) i3, (byte) ((((int) j) & Opcodes.LAND) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.f30258d;
                int i4 = this.f30261g;
                this.f30261g = i4 + 1;
                C9946_a.m31996a(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        /* renamed from: c */
        public final void mo32875c(long j) throws IOException {
            try {
                byte[] bArr = this.f30258d;
                int i = this.f30261g;
                this.f30261g = i + 1;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.f30258d;
                int i2 = this.f30261g;
                this.f30261g = i2 + 1;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.f30258d;
                int i3 = this.f30261g;
                this.f30261g = i3 + 1;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.f30258d;
                int i4 = this.f30261g;
                this.f30261g = i4 + 1;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.f30258d;
                int i5 = this.f30261g;
                this.f30261g = i5 + 1;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.f30258d;
                int i6 = this.f30261g;
                this.f30261g = i6 + 1;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.f30258d;
                int i7 = this.f30261g;
                this.f30261g = i7 + 1;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.f30258d;
                int i8 = this.f30261g;
                this.f30261g = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f30261g), Integer.valueOf(this.f30260f), Integer.valueOf(1)}), e);
            }
        }

        /* renamed from: b */
        public final void mo32881b(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.f30258d, this.f30261g, i2);
                this.f30261g += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f30261g), Integer.valueOf(this.f30260f), Integer.valueOf(i2)}), e);
            }
        }

        /* renamed from: a */
        public final void mo32844a(byte[] bArr, int i, int i2) throws IOException {
            mo32881b(bArr, i, i2);
        }

        /* renamed from: b */
        public final void mo32880b(String str) throws IOException {
            int i = this.f30261g;
            try {
                int g = zztv.m32436g(str.length() * 3);
                int g2 = zztv.m32436g(str.length());
                if (g2 == g) {
                    this.f30261g = i + g2;
                    int a = C9956bb.m32068a(str, this.f30258d, this.f30261g, mo32850a());
                    this.f30261g = i;
                    mo32867b((a - i) - g2);
                    this.f30261g = a;
                    return;
                }
                mo32867b(C9956bb.m32067a((CharSequence) str));
                this.f30261g = C9956bb.m32068a(str, this.f30258d, this.f30261g, mo32850a());
            } catch (C9965eb e) {
                this.f30261g = i;
                mo32865a(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            }
        }

        /* renamed from: a */
        public final int mo32850a() {
            return this.f30260f - this.f30261g;
        }
    }

    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
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
    public static zztv m32409a(byte[] bArr) {
        return new C10021a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public abstract int mo32850a();

    /* renamed from: a */
    public abstract void mo32851a(byte b) throws IOException;

    /* renamed from: a */
    public abstract void mo32854a(int i) throws IOException;

    /* renamed from: a */
    public abstract void mo32857a(int i, int i2) throws IOException;

    /* renamed from: a */
    public abstract void mo32858a(int i, long j) throws IOException;

    /* renamed from: a */
    public abstract void mo32859a(int i, zzte zzte) throws IOException;

    /* renamed from: a */
    public abstract void mo32860a(int i, zzvv zzvv) throws IOException;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo32861a(int i, zzvv zzvv, C9906Fa fa) throws IOException;

    /* renamed from: a */
    public abstract void mo32862a(int i, String str) throws IOException;

    /* renamed from: a */
    public abstract void mo32863a(int i, boolean z) throws IOException;

    /* renamed from: a */
    public abstract void mo32864a(long j) throws IOException;

    /* renamed from: b */
    public abstract void mo32867b(int i) throws IOException;

    /* renamed from: b */
    public abstract void mo32868b(int i, int i2) throws IOException;

    /* renamed from: b */
    public abstract void mo32870b(int i, zzte zzte) throws IOException;

    /* renamed from: c */
    public abstract void mo32873c(int i, int i2) throws IOException;

    /* renamed from: c */
    public abstract void mo32874c(int i, long j) throws IOException;

    /* renamed from: c */
    public abstract void mo32875c(long j) throws IOException;

    /* renamed from: d */
    public abstract void mo32876d(int i) throws IOException;

    /* renamed from: e */
    public abstract void mo32878e(int i, int i2) throws IOException;

    private zztv() {
    }

    /* renamed from: d */
    public final void mo32877d(int i, int i2) throws IOException {
        mo32873c(i, m32452m(i2));
    }

    /* renamed from: b */
    public final void mo32869b(int i, long j) throws IOException {
        mo32858a(i, m32446i(j));
    }

    /* renamed from: a */
    public final void mo32856a(int i, float f) throws IOException {
        mo32878e(i, Float.floatToRawIntBits(f));
    }

    /* renamed from: a */
    public final void mo32855a(int i, double d) throws IOException {
        mo32874c(i, Double.doubleToRawLongBits(d));
    }

    /* renamed from: c */
    public final void mo32872c(int i) throws IOException {
        mo32867b(m32452m(i));
    }

    /* renamed from: b */
    public final void mo32871b(long j) throws IOException {
        mo32864a(m32446i(j));
    }

    /* renamed from: a */
    public final void mo32853a(float f) throws IOException {
        mo32876d(Float.floatToRawIntBits(f));
    }

    /* renamed from: a */
    public final void mo32852a(double d) throws IOException {
        mo32875c(Double.doubleToRawLongBits(d));
    }

    /* renamed from: a */
    public final void mo32866a(boolean z) throws IOException {
        mo32851a(z ? (byte) 1 : 0);
    }

    /* renamed from: f */
    public static int m32433f(int i, int i2) {
        return m32429e(i) + m32432f(i2);
    }

    /* renamed from: g */
    public static int m32437g(int i, int i2) {
        return m32429e(i) + m32436g(i2);
    }

    /* renamed from: h */
    public static int m32441h(int i, int i2) {
        return m32429e(i) + m32436g(m32452m(i2));
    }

    /* renamed from: i */
    public static int m32445i(int i, int i2) {
        return m32429e(i) + 4;
    }

    /* renamed from: j */
    public static int m32448j(int i, int i2) {
        return m32429e(i) + 4;
    }

    /* renamed from: d */
    public static int m32426d(int i, long j) {
        return m32429e(i) + m32431e(j);
    }

    /* renamed from: e */
    public static int m32430e(int i, long j) {
        return m32429e(i) + m32431e(j);
    }

    /* renamed from: f */
    public static int m32434f(int i, long j) {
        return m32429e(i) + m32431e(m32446i(j));
    }

    /* renamed from: g */
    public static int m32438g(int i, long j) {
        return m32429e(i) + 8;
    }

    /* renamed from: h */
    public static int m32442h(int i, long j) {
        return m32429e(i) + 8;
    }

    /* renamed from: b */
    public static int m32413b(int i, float f) {
        return m32429e(i) + 4;
    }

    /* renamed from: b */
    public static int m32412b(int i, double d) {
        return m32429e(i) + 8;
    }

    /* renamed from: b */
    public static int m32418b(int i, boolean z) {
        return m32429e(i) + 1;
    }

    /* renamed from: k */
    public static int m32450k(int i, int i2) {
        return m32429e(i) + m32432f(i2);
    }

    /* renamed from: b */
    public static int m32417b(int i, String str) {
        return m32429e(i) + m32408a(str);
    }

    /* renamed from: c */
    public static int m32423c(int i, zzte zzte) {
        int e = m32429e(i);
        int size = zzte.size();
        return e + m32436g(size) + size;
    }

    /* renamed from: a */
    public static int m32403a(int i, zzvc zzvc) {
        int e = m32429e(i);
        int b = zzvc.mo32914b();
        return e + m32436g(b) + b;
    }

    /* renamed from: b */
    public static int m32415b(int i, zzvv zzvv) {
        return m32429e(i) + m32406a(zzvv);
    }

    /* renamed from: b */
    static int m32416b(int i, zzvv zzvv, C9906Fa fa) {
        return m32429e(i) + m32407a(zzvv, fa);
    }

    /* renamed from: c */
    public static int m32424c(int i, zzvv zzvv) {
        return (m32429e(1) << 1) + m32437g(2, i) + m32415b(3, zzvv);
    }

    /* renamed from: d */
    public static int m32427d(int i, zzte zzte) {
        return (m32429e(1) << 1) + m32437g(2, i) + m32423c(3, zzte);
    }

    /* renamed from: b */
    public static int m32414b(int i, zzvc zzvc) {
        return (m32429e(1) << 1) + m32437g(2, i) + m32403a(3, zzvc);
    }

    /* renamed from: e */
    public static int m32429e(int i) {
        return m32436g(i << 3);
    }

    /* renamed from: f */
    public static int m32432f(int i) {
        if (i >= 0) {
            return m32436g(i);
        }
        return 10;
    }

    /* renamed from: g */
    public static int m32436g(int i) {
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
    public static int m32440h(int i) {
        return m32436g(m32452m(i));
    }

    /* renamed from: i */
    public static int m32444i(int i) {
        return 4;
    }

    /* renamed from: j */
    public static int m32447j(int i) {
        return 4;
    }

    /* renamed from: d */
    public static int m32428d(long j) {
        return m32431e(j);
    }

    /* renamed from: e */
    public static int m32431e(long j) {
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
    public static int m32435f(long j) {
        return m32431e(m32446i(j));
    }

    /* renamed from: g */
    public static int m32439g(long j) {
        return 8;
    }

    /* renamed from: h */
    public static int m32443h(long j) {
        return 8;
    }

    /* renamed from: b */
    public static int m32411b(float f) {
        return 4;
    }

    /* renamed from: b */
    public static int m32410b(double d) {
        return 8;
    }

    /* renamed from: b */
    public static int m32420b(boolean z) {
        return 1;
    }

    /* renamed from: k */
    public static int m32449k(int i) {
        return m32432f(i);
    }

    /* renamed from: a */
    public static int m32408a(String str) {
        int i;
        try {
            i = C9956bb.m32067a((CharSequence) str);
        } catch (C9965eb e) {
            i = str.getBytes(zzuq.f30342a).length;
        }
        return m32436g(i) + i;
    }

    /* renamed from: a */
    public static int m32405a(zzvc zzvc) {
        int b = zzvc.mo32914b();
        return m32436g(b) + b;
    }

    /* renamed from: a */
    public static int m32404a(zzte zzte) {
        int size = zzte.size();
        return m32436g(size) + size;
    }

    /* renamed from: b */
    public static int m32421b(byte[] bArr) {
        int length = bArr.length;
        return m32436g(length) + length;
    }

    /* renamed from: a */
    public static int m32406a(zzvv zzvv) {
        int a = zzvv.mo32892a();
        return m32436g(a) + a;
    }

    /* renamed from: a */
    static int m32407a(zzvv zzvv, C9906Fa fa) {
        zzsx zzsx = (zzsx) zzvv;
        int f = zzsx.mo32839f();
        if (f == -1) {
            f = fa.mo32555b(zzsx);
            zzsx.mo32837a(f);
        }
        return m32436g(f) + f;
    }

    /* renamed from: m */
    private static int m32452m(int i) {
        return (i >> 31) ^ (i << 1);
    }

    /* renamed from: i */
    private static long m32446i(long j) {
        return (j >> 63) ^ (j << 1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32865a(String str, C9965eb ebVar) throws IOException {
        f30255a.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", ebVar);
        byte[] bytes = str.getBytes(zzuq.f30342a);
        try {
            mo32867b(bytes.length);
            mo32844a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzc(e);
        } catch (zzc e2) {
            throw e2;
        }
    }

    @Deprecated
    /* renamed from: c */
    static int m32425c(int i, zzvv zzvv, C9906Fa fa) {
        int e = m32429e(i) << 1;
        zzsx zzsx = (zzsx) zzvv;
        int f = zzsx.mo32839f();
        if (f == -1) {
            f = fa.mo32555b(zzsx);
            zzsx.mo32837a(f);
        }
        return e + f;
    }

    @Deprecated
    /* renamed from: b */
    public static int m32419b(zzvv zzvv) {
        return zzvv.mo32892a();
    }

    @Deprecated
    /* renamed from: l */
    public static int m32451l(int i) {
        return m32436g(i);
    }
}
