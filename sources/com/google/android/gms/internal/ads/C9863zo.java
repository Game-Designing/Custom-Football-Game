package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.ads.zo */
class C9863zo extends C9842yo {

    /* renamed from: e */
    protected final byte[] f23750e;

    C9863zo(byte[] bArr) {
        if (bArr != null) {
            this.f23750e = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public byte mo29209a(int i) {
        return this.f23750e[i];
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public byte mo29212h(int i) {
        return this.f23750e[i];
    }

    public int size() {
        return this.f23750e.length;
    }

    /* renamed from: a */
    public final zzdmr mo29326a(int i, int i2) {
        int b = zzdmr.m29655b(0, i2, size());
        if (b == 0) {
            return zzdmr.f27972a;
        }
        return new C9758uo(this.f23750e, mo29211f(), b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29210a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f23750e, 0, bArr, 0, i3);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo29328a(zzdmq zzdmq) throws IOException {
        zzdmq.mo31538a(this.f23750e, mo29211f(), size());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final String mo29327a(Charset charset) {
        return new String(this.f23750e, mo29211f(), size(), charset);
    }

    /* renamed from: c */
    public final boolean mo29330c() {
        int f = mo29211f();
        return C9199Vp.m23151a(this.f23750e, f, size() + f);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdmr) || size() != ((zzdmr) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof C9863zo)) {
            return obj.equals(this);
        }
        C9863zo zoVar = (C9863zo) obj;
        int e = mo31541e();
        int e2 = zoVar.mo31541e();
        if (e == 0 || e2 == 0 || e == e2) {
            return mo29329a((zzdmr) zoVar, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo29329a(zzdmr zzdmr, int i, int i2) {
        if (i2 > zzdmr.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzdmr.size()) {
            int size2 = zzdmr.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzdmr instanceof C9863zo)) {
            return zzdmr.mo29326a(0, i2).equals(mo29326a(0, i2));
        } else {
            C9863zo zoVar = (C9863zo) zzdmr;
            byte[] bArr = this.f23750e;
            byte[] bArr2 = zoVar.f23750e;
            int f = mo29211f() + i2;
            int f2 = mo29211f();
            int f3 = zoVar.mo29211f();
            while (f2 < f) {
                if (bArr[f2] != bArr2[f3]) {
                    return false;
                }
                f2++;
                f3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo29325a(int i, int i2, int i3) {
        return zzdod.m29911a(i, this.f23750e, mo29211f(), i3);
    }

    /* renamed from: d */
    public final zzdnd mo29331d() {
        return zzdnd.m29671a(this.f23750e, mo29211f(), size(), true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public int mo29211f() {
        return 0;
    }
}
