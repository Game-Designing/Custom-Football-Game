package com.facebook.login;

/* renamed from: com.facebook.login.r */
/* compiled from: LoginBehavior */
public enum C6773r {
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true),
    NATIVE_ONLY(true, true, false, false, false, true),
    KATANA_ONLY(false, true, false, false, false, false),
    WEB_ONLY(false, false, true, false, true, false),
    WEB_VIEW_ONLY(false, false, true, false, false, false),
    DIALOG_ONLY(false, true, true, false, true, true),
    DEVICE_AUTH(false, false, false, true, false, false);
    

    /* renamed from: i */
    private final boolean f12447i;

    /* renamed from: j */
    private final boolean f12448j;

    /* renamed from: k */
    private final boolean f12449k;

    /* renamed from: l */
    private final boolean f12450l;

    /* renamed from: m */
    private final boolean f12451m;

    /* renamed from: n */
    private final boolean f12452n;

    private C6773r(boolean allowsGetTokenAuth, boolean allowsKatanaAuth, boolean allowsWebViewAuth, boolean allowsDeviceAuth, boolean allowsCustomTabAuth, boolean allowsFacebookLiteAuth) {
        this.f12447i = allowsGetTokenAuth;
        this.f12448j = allowsKatanaAuth;
        this.f12449k = allowsWebViewAuth;
        this.f12450l = allowsDeviceAuth;
        this.f12451m = allowsCustomTabAuth;
        this.f12452n = allowsFacebookLiteAuth;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public boolean mo20115i() {
        return this.f12447i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public boolean mo20116j() {
        return this.f12448j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public boolean mo20117s() {
        return this.f12449k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public boolean mo20113f() {
        return this.f12450l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo20112e() {
        return this.f12451m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public boolean mo20114g() {
        return this.f12452n;
    }
}
