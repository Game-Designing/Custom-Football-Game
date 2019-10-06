package com.google.android.gms.internal.ads;

public abstract class zzlr {

    /* renamed from: a */
    public static final zzlr f28815a = new C8820Dr();

    /* renamed from: a */
    public abstract int mo28169a(Object obj);

    /* renamed from: a */
    public abstract zzlt mo28170a(int i, zzlt zzlt, boolean z);

    /* renamed from: a */
    public abstract zzlu mo28171a(int i, zzlu zzlu, boolean z, long j);

    /* renamed from: b */
    public abstract int mo28172b();

    /* renamed from: c */
    public abstract int mo28173c();

    /* renamed from: a */
    public final boolean mo31960a() {
        return mo28172b() == 0;
    }

    /* renamed from: a */
    public final zzlu mo31959a(int i, zzlu zzlu, boolean z) {
        return mo28171a(i, zzlu, false, 0);
    }

    /* renamed from: a */
    public final int mo31958a(int i, zzlt zzlt, zzlu zzlu, int i2) {
        mo28170a(i, zzlt, false);
        mo31959a(0, zzlu, false);
        int i3 = 1;
        if (i != 0) {
            return i + 1;
        }
        if (i2 != 0) {
            if (i2 == 1) {
                i3 = 0;
            } else if (i2 != 2) {
                throw new IllegalStateException();
            } else if (mo28172b() - 1 == 0) {
                i3 = 0;
            }
        } else if (mo28172b() - 1 == 0) {
            i3 = -1;
        }
        if (i3 == -1) {
            return -1;
        }
        mo31959a(i3, zzlu, false);
        return 0;
    }
}
