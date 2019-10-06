package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.Ms */
final class C9010Ms {

    /* renamed from: a */
    private final zznn[] f21494a;

    /* renamed from: b */
    private final zznp f21495b;

    /* renamed from: c */
    private zznn f21496c;

    public C9010Ms(zznn[] zznnArr, zznp zznp) {
        this.f21494a = zznnArr;
        this.f21495b = zznp;
    }

    /* renamed from: a */
    public final zznn mo28457a(zzno zzno, Uri uri) throws IOException, InterruptedException {
        zznn zznn = this.f21496c;
        if (zznn != null) {
            return zznn;
        }
        zznn[] zznnArr = this.f21494a;
        int length = zznnArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zznn zznn2 = zznnArr[i];
            try {
                if (zznn2.mo32058a(zzno)) {
                    this.f21496c = zznn2;
                    zzno.mo32044a();
                    break;
                }
                i++;
            } catch (EOFException e) {
            } finally {
                zzno.mo32044a();
            }
        }
        zznn zznn3 = this.f21496c;
        if (zznn3 != null) {
            zznn3.mo32057a(this.f21495b);
            return this.f21496c;
        }
        String a = zzsy.m31149a((Object[]) this.f21494a);
        StringBuilder sb = new StringBuilder(String.valueOf(a).length() + 58);
        sb.append("None of the available extractors (");
        sb.append(a);
        sb.append(") could read the stream.");
        throw new zzrc(sb.toString(), uri);
    }

    /* renamed from: a */
    public final void mo28458a() {
        zznn zznn = this.f21496c;
        if (zznn != null) {
            zznn.mo32055a();
            this.f21496c = null;
        }
    }
}
