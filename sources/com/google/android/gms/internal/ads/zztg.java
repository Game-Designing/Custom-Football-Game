package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

public final class zztg {

    /* renamed from: a */
    public final List<byte[]> f29369a;

    /* renamed from: b */
    public final int f29370b;

    /* renamed from: a */
    public static zztg m31165a(zzst zzst) throws zzlm {
        try {
            zzst.mo32201c(21);
            int g = zzst.mo32207g() & 3;
            int g2 = zzst.mo32207g();
            int b = zzst.mo32198b();
            int i = 0;
            int i2 = 0;
            while (i < g2) {
                zzst.mo32201c(1);
                int h = zzst.mo32208h();
                int i3 = i2;
                for (int i4 = 0; i4 < h; i4++) {
                    int h2 = zzst.mo32208h();
                    i3 += h2 + 4;
                    zzst.mo32201c(h2);
                }
                i++;
                i2 = i3;
            }
            zzst.mo32199b(b);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            int i6 = 0;
            while (i5 < g2) {
                zzst.mo32201c(1);
                int h3 = zzst.mo32208h();
                int i7 = i6;
                for (int i8 = 0; i8 < h3; i8++) {
                    int h4 = zzst.mo32208h();
                    System.arraycopy(zzsq.f29316a, 0, bArr, i7, zzsq.f29316a.length);
                    int length = i7 + zzsq.f29316a.length;
                    System.arraycopy(zzst.f29334a, zzst.mo32198b(), bArr, length, h4);
                    i7 = length + h4;
                    zzst.mo32201c(h4);
                }
                i5++;
                i6 = i7;
            }
            return new zztg(i2 == 0 ? null : Collections.singletonList(bArr), g + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzlm("Error parsing HEVC config", e);
        }
    }

    private zztg(List<byte[]> list, int i) {
        this.f29369a = list;
        this.f29370b = i;
    }
}
