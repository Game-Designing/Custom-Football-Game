package com.bumptech.glide.load.engine;

import android.os.Looper;
import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.p107h.C6024i;

/* renamed from: com.bumptech.glide.load.engine.y */
/* compiled from: EngineResource */
class C6340y<Z> implements C6236E<Z> {

    /* renamed from: a */
    private final boolean f11311a;

    /* renamed from: b */
    private final boolean f11312b;

    /* renamed from: c */
    private C6341a f11313c;

    /* renamed from: d */
    private C6344g f11314d;

    /* renamed from: e */
    private int f11315e;

    /* renamed from: f */
    private boolean f11316f;

    /* renamed from: g */
    private final C6236E<Z> f11317g;

    /* renamed from: com.bumptech.glide.load.engine.y$a */
    /* compiled from: EngineResource */
    interface C6341a {
        /* renamed from: a */
        void mo19280a(C6344g gVar, C6340y<?> yVar);
    }

    C6340y(C6236E<Z> toWrap, boolean isCacheable, boolean isRecyclable) {
        C6024i.m11264a(toWrap);
        this.f11317g = toWrap;
        this.f11311a = isCacheable;
        this.f11312b = isRecyclable;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19298a(C6344g key, C6341a listener) {
        this.f11314d = key;
        this.f11313c = listener;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C6236E<Z> mo19300e() {
        return this.f11317g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public boolean mo19301f() {
        return this.f11311a;
    }

    /* renamed from: c */
    public Class<Z> mo18970c() {
        return this.f11317g.mo18970c();
    }

    public Z get() {
        return this.f11317g.get();
    }

    /* renamed from: a */
    public int mo18968a() {
        return this.f11317g.mo18968a();
    }

    /* renamed from: b */
    public void mo18969b() {
        if (this.f11315e > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f11316f) {
            this.f11316f = true;
            if (this.f11312b) {
                this.f11317g.mo18969b();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo19299d() {
        if (this.f11316f) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            this.f11315e++;
        } else {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo19302g() {
        if (this.f11315e <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            int i = this.f11315e - 1;
            this.f11315e = i;
            if (i == 0) {
                this.f11313c.mo19280a(this.f11314d, this);
            }
        } else {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EngineResource{isCacheable=");
        sb.append(this.f11311a);
        sb.append(", listener=");
        sb.append(this.f11313c);
        sb.append(", key=");
        sb.append(this.f11314d);
        sb.append(", acquired=");
        sb.append(this.f11315e);
        sb.append(", isRecycled=");
        sb.append(this.f11316f);
        sb.append(", resource=");
        sb.append(this.f11317g);
        sb.append('}');
        return sb.toString();
    }
}
