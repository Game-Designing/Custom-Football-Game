package com.google.android.gms.internal.ads;

import android.net.Uri;

public final class zzjq {

    /* renamed from: a */
    public final Uri f28690a;

    /* renamed from: b */
    public final long f28691b;

    /* renamed from: c */
    public final long f28692c;

    /* renamed from: d */
    public final long f28693d;

    /* renamed from: e */
    public final String f28694e;

    /* renamed from: f */
    public final int f28695f;

    public zzjq(Uri uri) {
        this(uri, 0);
    }

    private zzjq(Uri uri, int i) {
        this(uri, 0, -1, null, 0);
    }

    public zzjq(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, null, 0);
    }

    private zzjq(Uri uri, long j, long j2, String str, int i) {
        this(uri, 0, 0, -1, null, 0);
    }

    public zzjq(Uri uri, long j, long j2, long j3, String str, int i) {
        boolean z = true;
        zzkh.m30535a(j >= 0);
        zzkh.m30535a(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        zzkh.m30535a(z);
        this.f28690a = uri;
        this.f28691b = j;
        this.f28692c = j2;
        this.f28693d = j3;
        this.f28694e = str;
        this.f28695f = i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f28690a);
        long j = this.f28691b;
        long j2 = this.f28692c;
        long j3 = this.f28693d;
        String str = this.f28694e;
        int i = this.f28695f;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 91 + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(valueOf);
        String str2 = ", ";
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
