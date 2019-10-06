package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class zzfk implements Callable {

    /* renamed from: a */
    private final String f28405a = getClass().getSimpleName();

    /* renamed from: b */
    protected final zzdy f28406b;

    /* renamed from: c */
    private final String f28407c;

    /* renamed from: d */
    private final String f28408d;

    /* renamed from: e */
    protected final C15005zza f28409e;

    /* renamed from: f */
    protected Method f28410f;

    /* renamed from: g */
    private final int f28411g;

    /* renamed from: h */
    private final int f28412h;

    public zzfk(zzdy zzdy, String str, String str2, C15005zza zza, int i, int i2) {
        this.f28406b = zzdy;
        this.f28407c = str;
        this.f28408d = str2;
        this.f28409e = zza;
        this.f28411g = i;
        this.f28412h = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo31743a() throws IllegalAccessException, InvocationTargetException;

    /* renamed from: b */
    public Void call() throws Exception {
        try {
            long nanoTime = System.nanoTime();
            this.f28410f = this.f28406b.mo31710a(this.f28407c, this.f28408d);
            if (this.f28410f == null) {
                return null;
            }
            mo31743a();
            zzda i = this.f28406b.mo31721i();
            if (!(i == null || this.f28411g == Integer.MIN_VALUE)) {
                i.mo31337a(this.f28412h, this.f28411g, (System.nanoTime() - nanoTime) / 1000);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException e) {
        }
    }
}
