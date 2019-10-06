package com.bumptech.glide.p103f;

/* renamed from: com.bumptech.glide.f.k */
/* compiled from: ThumbnailRequestCoordinator */
public class C5996k implements C5987d, C5986c {

    /* renamed from: a */
    private final C5987d f10626a;

    /* renamed from: b */
    private C5986c f10627b;

    /* renamed from: c */
    private C5986c f10628c;

    /* renamed from: d */
    private boolean f10629d;

    C5996k() {
        this(null);
    }

    public C5996k(C5987d parent) {
        this.f10626a = parent;
    }

    /* renamed from: a */
    public void mo18780a(C5986c full, C5986c thumb) {
        this.f10627b = full;
        this.f10628c = thumb;
    }

    /* renamed from: c */
    public boolean mo18679c(C5986c request) {
        return m11194g() && (request.equals(this.f10627b) || !this.f10627b.mo18678c());
    }

    /* renamed from: g */
    private boolean m11194g() {
        C5987d dVar = this.f10626a;
        return dVar == null || dVar.mo18679c(this);
    }

    /* renamed from: b */
    public boolean mo18677b(C5986c request) {
        return m11193f() && request.equals(this.f10627b) && !mo18682d();
    }

    /* renamed from: f */
    public boolean mo18684f(C5986c request) {
        return m11192e() && request.equals(this.f10627b);
    }

    /* renamed from: e */
    private boolean m11192e() {
        C5987d dVar = this.f10626a;
        return dVar == null || dVar.mo18684f(this);
    }

    /* renamed from: f */
    private boolean m11193f() {
        C5987d dVar = this.f10626a;
        return dVar == null || dVar.mo18677b(this);
    }

    /* renamed from: d */
    public boolean mo18682d() {
        return m11195h() || mo18678c();
    }

    /* renamed from: e */
    public void mo18683e(C5986c request) {
        if (!request.equals(this.f10628c)) {
            C5987d dVar = this.f10626a;
            if (dVar != null) {
                dVar.mo18683e(this);
            }
            if (!this.f10628c.isComplete()) {
                this.f10628c.clear();
            }
        }
    }

    /* renamed from: d */
    public void mo18681d(C5986c request) {
        if (request.equals(this.f10627b)) {
            C5987d dVar = this.f10626a;
            if (dVar != null) {
                dVar.mo18681d(this);
            }
        }
    }

    /* renamed from: h */
    private boolean m11195h() {
        C5987d dVar = this.f10626a;
        return dVar != null && dVar.mo18682d();
    }

    /* renamed from: a */
    public void mo18673a() {
        this.f10629d = true;
        if (!this.f10627b.isComplete() && !this.f10628c.isRunning()) {
            this.f10628c.mo18673a();
        }
        if (this.f10629d && !this.f10627b.isRunning()) {
            this.f10627b.mo18673a();
        }
    }

    public void pause() {
        this.f10629d = false;
        this.f10627b.pause();
        this.f10628c.pause();
    }

    public void clear() {
        this.f10629d = false;
        this.f10628c.clear();
        this.f10627b.clear();
    }

    public boolean isRunning() {
        return this.f10627b.isRunning();
    }

    public boolean isComplete() {
        return this.f10627b.isComplete() || this.f10628c.isComplete();
    }

    /* renamed from: c */
    public boolean mo18678c() {
        return this.f10627b.mo18678c() || this.f10628c.mo18678c();
    }

    public boolean isCancelled() {
        return this.f10627b.isCancelled();
    }

    public boolean isFailed() {
        return this.f10627b.isFailed();
    }

    /* renamed from: b */
    public void mo18676b() {
        this.f10627b.mo18676b();
        this.f10628c.mo18676b();
    }

    /* renamed from: a */
    public boolean mo18675a(C5986c o) {
        boolean z = false;
        if (!(o instanceof C5996k)) {
            return false;
        }
        C5996k that = (C5996k) o;
        C5986c cVar = this.f10627b;
        if (cVar != null ? cVar.mo18675a(that.f10627b) : that.f10627b == null) {
            C5986c cVar2 = this.f10628c;
            if (cVar2 != null ? cVar2.mo18675a(that.f10628c) : that.f10628c == null) {
                z = true;
            }
        }
        return z;
    }
}
