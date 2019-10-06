package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

public final class zzry {

    /* renamed from: a */
    public final Uri f29268a;

    /* renamed from: b */
    public final byte[] f29269b;

    /* renamed from: c */
    public final long f29270c;

    /* renamed from: d */
    public final long f29271d;

    /* renamed from: e */
    public final long f29272e;

    /* renamed from: f */
    public final String f29273f;

    /* renamed from: g */
    public final int f29274g;

    public zzry(Uri uri) {
        this(uri, 0);
    }

    private zzry(Uri uri, int i) {
        this(uri, 0, -1, null, 0);
    }

    public zzry(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
    }

    private zzry(Uri uri, long j, long j2, String str, int i) {
        this(uri, 0, 0, -1, null, 0);
    }

    private zzry(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    public zzry(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        boolean z = true;
        zzsk.m31080a(j >= 0);
        zzsk.m31080a(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        zzsk.m31080a(z);
        this.f29268a = uri;
        this.f29269b = bArr;
        this.f29270c = j;
        this.f29271d = j2;
        this.f29272e = j3;
        this.f29273f = str;
        this.f29274g = i;
    }

    /* renamed from: a */
    public final boolean mo32175a(int i) {
        return (this.f29274g & 1) == 1;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f29268a);
        String arrays = Arrays.toString(this.f29269b);
        long j = this.f29270c;
        long j2 = this.f29271d;
        long j3 = this.f29272e;
        String str = this.f29273f;
        int i = this.f29274g;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 93 + String.valueOf(arrays).length() + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(valueOf);
        String str2 = ", ";
        sb.append(str2);
        sb.append(arrays);
        sb.append(str2);
        sb.append(j);
        sb.append(str2);
        sb.append(j2);
        sb.append(str2);
        sb.append(j3);
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }
}
