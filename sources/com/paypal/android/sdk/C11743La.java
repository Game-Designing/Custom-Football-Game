package com.paypal.android.sdk;

import java.util.UUID;

/* renamed from: com.paypal.android.sdk.La */
public final class C11743La {

    /* renamed from: a */
    public C11817ex f36741a = new C11817ex();

    /* renamed from: b */
    public C11806dv f36742b;

    /* renamed from: c */
    public String f36743c;

    /* renamed from: d */
    public C11804dl f36744d;

    /* renamed from: e */
    public C11807dx f36745e;

    /* renamed from: f */
    public C11802db f36746f;

    /* renamed from: g */
    public C11806dv f36747g;

    /* renamed from: h */
    private String f36748h;

    /* renamed from: i */
    public boolean f36749i;

    /* renamed from: j */
    public String f36750j;

    public C11743La() {
        new C11809ea();
        mo38590a();
    }

    /* renamed from: a */
    public final void mo38590a() {
        this.f36748h = UUID.randomUUID().toString();
    }

    /* renamed from: b */
    public final String mo38591b() {
        return this.f36748h;
    }

    /* renamed from: c */
    public final boolean mo38592c() {
        C11806dv dvVar = this.f36742b;
        return dvVar != null && dvVar.mo38702a();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BackendState(accessTokenState:");
        sb.append(this.f36742b);
        sb.append(" loginAccessToken:");
        sb.append(this.f36747g);
        sb.append(")");
        return sb.toString();
    }
}
