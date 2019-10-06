package com.google.android.exoplayer2.upstream.cache;

import java.io.File;

/* renamed from: com.google.android.exoplayer2.upstream.cache.e */
/* compiled from: CacheSpan */
public class C8469e implements Comparable<C8469e> {

    /* renamed from: a */
    public final String f18668a;

    /* renamed from: b */
    public final long f18669b;

    /* renamed from: c */
    public final long f18670c;

    /* renamed from: d */
    public final boolean f18671d;

    /* renamed from: e */
    public final File f18672e;

    /* renamed from: f */
    public final long f18673f;

    public C8469e(String key, long position, long length, long lastAccessTimestamp, File file) {
        this.f18668a = key;
        this.f18669b = position;
        this.f18670c = length;
        this.f18671d = file != null;
        this.f18672e = file;
        this.f18673f = lastAccessTimestamp;
    }

    /* renamed from: f */
    public boolean mo25963f() {
        return this.f18670c == -1;
    }

    /* renamed from: e */
    public boolean mo25962e() {
        return !this.f18671d;
    }

    /* renamed from: a */
    public int compareTo(C8469e another) {
        if (!this.f18668a.equals(another.f18668a)) {
            return this.f18668a.compareTo(another.f18668a);
        }
        long startOffsetDiff = this.f18669b - another.f18669b;
        int i = startOffsetDiff == 0 ? 0 : startOffsetDiff < 0 ? -1 : 1;
        return i;
    }
}
