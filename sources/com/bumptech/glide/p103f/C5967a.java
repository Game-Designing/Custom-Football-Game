package com.bumptech.glide.p103f;

/* renamed from: com.bumptech.glide.f.a */
/* compiled from: ErrorRequestCoordinator */
public final class C5967a implements C5987d, C5986c {

    /* renamed from: a */
    private final C5987d f10526a;

    /* renamed from: b */
    private C5986c f10527b;

    /* renamed from: c */
    private C5986c f10528c;

    public C5967a(C5987d parent) {
        this.f10526a = parent;
    }

    /* renamed from: a */
    public void mo18674a(C5986c primary, C5986c error) {
        this.f10527b = primary;
        this.f10528c = error;
    }

    /* renamed from: a */
    public void mo18673a() {
        if (!this.f10527b.isRunning()) {
            this.f10527b.mo18673a();
        }
    }

    public void pause() {
        if (!this.f10527b.isFailed()) {
            this.f10527b.pause();
        }
        if (this.f10528c.isRunning()) {
            this.f10528c.pause();
        }
    }

    public void clear() {
        this.f10527b.clear();
        if (this.f10528c.isRunning()) {
            this.f10528c.clear();
        }
    }

    public boolean isRunning() {
        return (this.f10527b.isFailed() ? this.f10528c : this.f10527b).isRunning();
    }

    public boolean isComplete() {
        return (this.f10527b.isFailed() ? this.f10528c : this.f10527b).isComplete();
    }

    /* renamed from: c */
    public boolean mo18678c() {
        return (this.f10527b.isFailed() ? this.f10528c : this.f10527b).mo18678c();
    }

    public boolean isCancelled() {
        return (this.f10527b.isFailed() ? this.f10528c : this.f10527b).isCancelled();
    }

    public boolean isFailed() {
        return this.f10527b.isFailed() && this.f10528c.isFailed();
    }

    /* renamed from: b */
    public void mo18676b() {
        this.f10527b.mo18676b();
        this.f10528c.mo18676b();
    }

    /* renamed from: a */
    public boolean mo18675a(C5986c o) {
        boolean z = false;
        if (!(o instanceof C5967a)) {
            return false;
        }
        C5967a other = (C5967a) o;
        if (this.f10527b.mo18675a(other.f10527b) && this.f10528c.mo18675a(other.f10528c)) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    public boolean mo18679c(C5986c request) {
        return m11037g() && m11038g(request);
    }

    /* renamed from: g */
    private boolean m11037g() {
        C5987d dVar = this.f10526a;
        return dVar == null || dVar.mo18679c(this);
    }

    /* renamed from: b */
    public boolean mo18677b(C5986c request) {
        return m11036f() && m11038g(request);
    }

    /* renamed from: f */
    public boolean mo18684f(C5986c request) {
        return m11035e() && m11038g(request);
    }

    /* renamed from: e */
    private boolean m11035e() {
        C5987d dVar = this.f10526a;
        return dVar == null || dVar.mo18684f(this);
    }

    /* renamed from: f */
    private boolean m11036f() {
        C5987d dVar = this.f10526a;
        return dVar == null || dVar.mo18677b(this);
    }

    /* renamed from: g */
    private boolean m11038g(C5986c request) {
        return request.equals(this.f10527b) || (this.f10527b.isFailed() && request.equals(this.f10528c));
    }

    /* renamed from: d */
    public boolean mo18682d() {
        return m11039h() || mo18678c();
    }

    /* renamed from: h */
    private boolean m11039h() {
        C5987d dVar = this.f10526a;
        return dVar != null && dVar.mo18682d();
    }

    /* renamed from: e */
    public void mo18683e(C5986c request) {
        C5987d dVar = this.f10526a;
        if (dVar != null) {
            dVar.mo18683e(this);
        }
    }

    /* renamed from: d */
    public void mo18681d(C5986c request) {
        if (!request.equals(this.f10528c)) {
            if (!this.f10528c.isRunning()) {
                this.f10528c.mo18673a();
            }
            return;
        }
        C5987d dVar = this.f10526a;
        if (dVar != null) {
            dVar.mo18681d(this);
        }
    }
}
