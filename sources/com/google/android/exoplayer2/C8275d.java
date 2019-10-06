package com.google.android.exoplayer2;

import java.util.UUID;

/* renamed from: com.google.android.exoplayer2.d */
/* compiled from: C */
public final class C8275d {

    /* renamed from: a */
    public static final UUID f17531a = new UUID(0, 0);

    /* renamed from: b */
    public static final UUID f17532b = new UUID(1186680826959645954L, -5988876978535335093L);

    /* renamed from: c */
    public static final UUID f17533c = new UUID(-2129748144642739255L, 8654423357094679310L);

    /* renamed from: d */
    public static final UUID f17534d = new UUID(-1301668207276963122L, -6645017420763422227L);

    /* renamed from: e */
    public static final UUID f17535e = new UUID(-7348484286925749626L, -6083546864340672619L);

    /* renamed from: b */
    public static long m19231b(long timeUs) {
        return (timeUs == -9223372036854775807L || timeUs == Long.MIN_VALUE) ? timeUs : timeUs / 1000;
    }

    /* renamed from: a */
    public static long m19230a(long timeMs) {
        return (timeMs == -9223372036854775807L || timeMs == Long.MIN_VALUE) ? timeMs : 1000 * timeMs;
    }
}
