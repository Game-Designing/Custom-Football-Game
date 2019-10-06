package com.google.android.gms.internal.ads;

public final class zzqz extends zzlr {

    /* renamed from: b */
    private static final Object f29190b = new Object();

    /* renamed from: c */
    private final long f29191c;

    /* renamed from: d */
    private final long f29192d;

    /* renamed from: e */
    private final long f29193e;

    /* renamed from: f */
    private final long f29194f;

    /* renamed from: g */
    private final boolean f29195g;

    /* renamed from: h */
    private final boolean f29196h;

    public zzqz(long j, boolean z) {
        this(j, j, 0, 0, z, false);
    }

    private zzqz(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.f29191c = j;
        this.f29192d = j2;
        this.f29193e = 0;
        this.f29194f = 0;
        this.f29195g = z;
        this.f29196h = false;
    }

    /* renamed from: b */
    public final int mo28172b() {
        return 1;
    }

    /* renamed from: a */
    public final zzlu mo28171a(int i, zzlu zzlu, boolean z, long j) {
        zzsk.m31077a(i, 0, 1);
        boolean z2 = this.f29195g;
        long j2 = this.f29192d;
        zzlu.f28822a = null;
        zzlu.f28823b = -9223372036854775807L;
        zzlu.f28824c = -9223372036854775807L;
        zzlu.f28825d = z2;
        zzlu.f28826e = false;
        zzlu.f28829h = 0;
        zzlu.f28830i = j2;
        zzlu.f28827f = 0;
        zzlu.f28828g = 0;
        zzlu.f28831j = 0;
        return zzlu;
    }

    /* renamed from: c */
    public final int mo28173c() {
        return 1;
    }

    /* renamed from: a */
    public final zzlt mo28170a(int i, zzlt zzlt, boolean z) {
        zzsk.m31077a(i, 0, 1);
        Object obj = z ? f29190b : null;
        return zzlt.mo31962a(obj, obj, 0, this.f29191c, 0, false);
    }

    /* renamed from: a */
    public final int mo28169a(Object obj) {
        return f29190b.equals(obj) ? 0 : -1;
    }
}
