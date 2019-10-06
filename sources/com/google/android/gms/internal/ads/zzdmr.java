package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

public abstract class zzdmr implements Serializable, Iterable<Byte> {

    /* renamed from: a */
    public static final zzdmr f27972a = new C9863zo(zzdod.f28086c);

    /* renamed from: b */
    private static final C9779vo f27973b = (C9587mo.m23884a() ? new C8754Ao(null) : new C9737to(null));

    /* renamed from: c */
    private static final Comparator<zzdmr> f27974c = new C9695ro();

    /* renamed from: d */
    private int f27975d = 0;

    zzdmr() {
    }

    /* renamed from: a */
    public abstract byte mo29209a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo29325a(int i, int i2, int i3);

    /* renamed from: a */
    public abstract zzdmr mo29326a(int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo29327a(Charset charset);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo29328a(zzdmq zzdmq) throws IOException;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo29210a(byte[] bArr, int i, int i2, int i3);

    /* renamed from: c */
    public abstract boolean mo29330c();

    /* renamed from: d */
    public abstract zzdnd mo29331d();

    public abstract boolean equals(Object obj);

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public abstract byte mo29212h(int i);

    public abstract int size();

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m29654b(byte b) {
        return b & 255;
    }

    /* renamed from: a */
    public static zzdmr m29653a(byte[] bArr, int i, int i2) {
        m29655b(i, i + i2, bArr.length);
        return new C9863zo(f27973b.mo28026a(bArr, i, i2));
    }

    /* renamed from: b */
    public static zzdmr m29656b(byte[] bArr) {
        return m29653a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    static zzdmr m29652a(byte[] bArr) {
        return new C9863zo(bArr);
    }

    /* renamed from: a */
    public static zzdmr m29651a(String str) {
        return new C9863zo(str.getBytes(zzdod.f28084a));
    }

    /* renamed from: a */
    public final byte[] mo31539a() {
        int size = size();
        if (size == 0) {
            return zzdod.f28086c;
        }
        byte[] bArr = new byte[size];
        mo29210a(bArr, 0, 0, size);
        return bArr;
    }

    /* renamed from: b */
    public final String mo31540b() {
        return size() == 0 ? "" : mo29327a(zzdod.f28084a);
    }

    public final int hashCode() {
        int i = this.f27975d;
        if (i == 0) {
            int size = size();
            i = mo29325a(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.f27975d = i;
        }
        return i;
    }

    /* renamed from: i */
    static C9800wo m29657i(int i) {
        return new C9800wo(i, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final int mo31541e() {
        return this.f27975d;
    }

    /* renamed from: b */
    static int m29655b(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public /* synthetic */ Iterator iterator() {
        return new C9674qo(this);
    }
}
