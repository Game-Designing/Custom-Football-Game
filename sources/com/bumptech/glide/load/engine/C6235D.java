package com.bumptech.glide.load.engine;

import com.bumptech.glide.p107h.C6024i;
import com.bumptech.glide.p107h.p108a.C6008d;
import com.bumptech.glide.p107h.p108a.C6008d.C6011c;
import com.bumptech.glide.p107h.p108a.C6015g;
import p002b.p003c.p053g.p061f.C1269m;

/* renamed from: com.bumptech.glide.load.engine.D */
/* compiled from: LockedResource */
final class C6235D<Z> implements C6236E<Z>, C6011c {

    /* renamed from: a */
    private static final C1269m<C6235D<?>> f11008a = C6008d.m11225b(20, new C6234C());

    /* renamed from: b */
    private final C6015g f11009b = C6015g.m11235a();

    /* renamed from: c */
    private C6236E<Z> f11010c;

    /* renamed from: d */
    private boolean f11011d;

    /* renamed from: e */
    private boolean f11012e;

    /* renamed from: a */
    static <Z> C6235D<Z> m11885a(C6236E<Z> resource) {
        LockedResource<Z> lockedResource = (C6235D) f11008a.mo9148a();
        C6024i.m11264a(lockedResource);
        LockedResource<Z> result = (C6235D) lockedResource;
        result.m11886b(resource);
        return result;
    }

    C6235D() {
    }

    /* renamed from: b */
    private void m11886b(C6236E<Z> toWrap) {
        this.f11012e = false;
        this.f11011d = true;
        this.f11010c = toWrap;
    }

    /* renamed from: f */
    private void m11887f() {
        this.f11010c = null;
        f11008a.mo9149a(this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public synchronized void mo19100d() {
        this.f11009b.mo18795b();
        if (this.f11011d) {
            this.f11011d = false;
            if (this.f11012e) {
                mo18969b();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    /* renamed from: c */
    public Class<Z> mo18970c() {
        return this.f11010c.mo18970c();
    }

    public Z get() {
        return this.f11010c.get();
    }

    /* renamed from: a */
    public int mo18968a() {
        return this.f11010c.mo18968a();
    }

    /* renamed from: b */
    public synchronized void mo18969b() {
        this.f11009b.mo18795b();
        this.f11012e = true;
        if (!this.f11011d) {
            this.f11010c.mo18969b();
            m11887f();
        }
    }

    /* renamed from: e */
    public C6015g mo18779e() {
        return this.f11009b;
    }
}
