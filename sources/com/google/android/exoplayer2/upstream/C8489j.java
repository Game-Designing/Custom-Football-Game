package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.C8514e;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.upstream.j */
/* compiled from: DataSpec */
public final class C8489j {

    /* renamed from: a */
    public final Uri f18714a;

    /* renamed from: b */
    public final int f18715b;

    /* renamed from: c */
    public final byte[] f18716c;
    @Deprecated

    /* renamed from: d */
    public final byte[] f18717d;

    /* renamed from: e */
    public final long f18718e;

    /* renamed from: f */
    public final long f18719f;

    /* renamed from: g */
    public final long f18720g;

    /* renamed from: h */
    public final String f18721h;

    /* renamed from: i */
    public final int f18722i;

    public C8489j(Uri uri, long absoluteStreamPosition, long length, String key) {
        this(uri, absoluteStreamPosition, absoluteStreamPosition, length, key, 0);
    }

    public C8489j(Uri uri, long absoluteStreamPosition, long position, long length, String key, int flags) {
        this(uri, null, absoluteStreamPosition, position, length, key, flags);
    }

    public C8489j(Uri uri, byte[] postBody, long absoluteStreamPosition, long position, long length, String key, int flags) {
        this(uri, postBody != null ? 2 : 1, postBody, absoluteStreamPosition, position, length, key, flags);
    }

    public C8489j(Uri uri, int httpMethod, byte[] httpBody, long absoluteStreamPosition, long position, long length, String key, int flags) {
        byte[] bArr = httpBody;
        long j = absoluteStreamPosition;
        long j2 = position;
        long j3 = length;
        boolean z = true;
        C8514e.m20488a(j >= 0);
        C8514e.m20488a(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        C8514e.m20488a(z);
        this.f18714a = uri;
        this.f18715b = httpMethod;
        this.f18716c = (bArr == null || bArr.length == 0) ? null : bArr;
        this.f18717d = this.f18716c;
        this.f18718e = j;
        this.f18719f = j2;
        this.f18720g = j3;
        this.f18721h = key;
        this.f18722i = flags;
    }

    /* renamed from: b */
    public boolean mo26019b(int flag) {
        return (this.f18722i & flag) == flag;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataSpec[");
        sb.append(mo26018a());
        sb.append(" ");
        sb.append(this.f18714a);
        String str = ", ";
        sb.append(str);
        sb.append(Arrays.toString(this.f18716c));
        sb.append(str);
        sb.append(this.f18718e);
        sb.append(str);
        sb.append(this.f18719f);
        sb.append(str);
        sb.append(this.f18720g);
        sb.append(str);
        sb.append(this.f18721h);
        sb.append(str);
        sb.append(this.f18722i);
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: a */
    public final String mo26018a() {
        return m20335a(this.f18715b);
    }

    /* renamed from: a */
    public static String m20335a(int httpMethod) {
        if (httpMethod == 1) {
            return "GET";
        }
        if (httpMethod == 2) {
            return "POST";
        }
        if (httpMethod == 3) {
            return "HEAD";
        }
        throw new AssertionError(httpMethod);
    }

    /* renamed from: a */
    public C8489j mo26017a(long offset, long length) {
        if (offset == 0 && this.f18720g == length) {
            return this;
        }
        C8489j jVar = new C8489j(this.f18714a, this.f18715b, this.f18716c, this.f18718e + offset, this.f18719f + offset, length, this.f18721h, this.f18722i);
        return jVar;
    }
}
