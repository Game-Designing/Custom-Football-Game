package com.google.android.gms.internal.ads;

@zzard
public final class zzbin {

    /* renamed from: a */
    private final int f25377a;

    /* renamed from: b */
    public final int f25378b;

    /* renamed from: c */
    public final int f25379c;

    /* renamed from: a */
    public static zzbin m27014a(zzyd zzyd) {
        if (zzyd.f29771d) {
            return new zzbin(3, 0, 0);
        }
        if (zzyd.f29776i) {
            return new zzbin(2, 0, 0);
        }
        if (zzyd.f29775h) {
            return m27015b();
        }
        return m27013a(zzyd.f29773f, zzyd.f29770c);
    }

    /* renamed from: b */
    public static zzbin m27015b() {
        return new zzbin(0, 0, 0);
    }

    /* renamed from: a */
    public static zzbin m27013a(int i, int i2) {
        return new zzbin(1, i, i2);
    }

    /* renamed from: c */
    public static zzbin m27016c() {
        return new zzbin(4, 0, 0);
    }

    /* renamed from: d */
    public static zzbin m27017d() {
        return new zzbin(5, 0, 0);
    }

    private zzbin(int i, int i2, int i3) {
        this.f25377a = i;
        this.f25379c = i2;
        this.f25378b = i3;
    }

    /* renamed from: a */
    public final boolean mo30649a() {
        return this.f25377a == 2;
    }

    /* renamed from: e */
    public final boolean mo30650e() {
        return this.f25377a == 3;
    }

    /* renamed from: f */
    public final boolean mo30651f() {
        return this.f25377a == 0;
    }

    /* renamed from: g */
    public final boolean mo30652g() {
        return this.f25377a == 4;
    }

    /* renamed from: h */
    public final boolean mo30653h() {
        return this.f25377a == 5;
    }
}
