package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.measurement.O */
class C9923O extends C9921N {

    /* renamed from: e */
    protected final byte[] f30022e;

    C9923O(byte[] bArr) {
        if (bArr != null) {
            this.f30022e = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public byte mo32581a(int i) {
        return this.f30022e[i];
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public byte mo32583h(int i) {
        return this.f30022e[i];
    }

    public int size() {
        return this.f30022e.length;
    }

    /* renamed from: a */
    public final zzte mo32595a(int i, int i2) {
        int b = zzte.m32391b(0, i2, size());
        if (b == 0) {
            return zzte.f30248a;
        }
        return new C9915K(this.f30022e, mo32582d(), b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32597a(zztd zztd) throws IOException {
        zztd.mo32844a(this.f30022e, mo32582d(), size());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final String mo32596a(Charset charset) {
        return new String(this.f30022e, mo32582d(), size(), charset);
    }

    /* renamed from: b */
    public final boolean mo32599b() {
        int d = mo32582d();
        return C9956bb.m32070a(this.f30022e, d, size() + d);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzte) || size() != ((zzte) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof C9923O)) {
            return obj.equals(this);
        }
        C9923O o = (C9923O) obj;
        int c = mo32846c();
        int c2 = o.mo32846c();
        if (c == 0 || c2 == 0 || c == c2) {
            return mo32598a((zzte) o, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo32598a(zzte zzte, int i, int i2) {
        if (i2 > zzte.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzte.size()) {
            int size2 = zzte.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzte instanceof C9923O)) {
            return zzte.mo32595a(0, i2).equals(mo32595a(0, i2));
        } else {
            C9923O o = (C9923O) zzte;
            byte[] bArr = this.f30022e;
            byte[] bArr2 = o.f30022e;
            int d = mo32582d() + i2;
            int d2 = mo32582d();
            int d3 = o.mo32582d();
            while (d2 < d) {
                if (bArr[d2] != bArr2[d3]) {
                    return false;
                }
                d2++;
                d3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo32594a(int i, int i2, int i3) {
        return zzuq.m32536a(i, this.f30022e, mo32582d(), i3);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public int mo32582d() {
        return 0;
    }
}
