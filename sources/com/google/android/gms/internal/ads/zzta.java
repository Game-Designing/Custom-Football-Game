package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

public final class zzta {

    /* renamed from: a */
    public final List<byte[]> f29354a;

    /* renamed from: b */
    public final int f29355b;

    /* renamed from: c */
    private final int f29356c;

    /* renamed from: d */
    private final int f29357d;

    /* renamed from: e */
    public final float f29358e;

    /* renamed from: a */
    public static zzta m31161a(zzst zzst) throws zzlm {
        float f;
        int i;
        int i2;
        try {
            zzst.mo32201c(4);
            int g = (zzst.mo32207g() & 3) + 1;
            if (g != 3) {
                ArrayList arrayList = new ArrayList();
                int g2 = zzst.mo32207g() & 31;
                for (int i3 = 0; i3 < g2; i3++) {
                    arrayList.add(m31162b(zzst));
                }
                int g3 = zzst.mo32207g();
                for (int i4 = 0; i4 < g3; i4++) {
                    arrayList.add(m31162b(zzst));
                }
                if (g2 > 0) {
                    zzsr a = zzsq.m31100a((byte[]) arrayList.get(0), g, ((byte[]) arrayList.get(0)).length);
                    int i5 = a.f29321b;
                    int i6 = a.f29322c;
                    f = a.f29323d;
                    i2 = i5;
                    i = i6;
                } else {
                    i2 = -1;
                    i = -1;
                    f = 1.0f;
                }
                zzta zzta = new zzta(arrayList, g, i2, i, f);
                return zzta;
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzlm("Error parsing AVC config", e);
        }
    }

    private zzta(List<byte[]> list, int i, int i2, int i3, float f) {
        this.f29354a = list;
        this.f29355b = i;
        this.f29356c = i2;
        this.f29357d = i3;
        this.f29358e = f;
    }

    /* renamed from: b */
    private static byte[] m31162b(zzst zzst) {
        int h = zzst.mo32208h();
        int b = zzst.mo32198b();
        zzst.mo32201c(h);
        return zzsl.m31086a(zzst.f29334a, b, h);
    }
}
