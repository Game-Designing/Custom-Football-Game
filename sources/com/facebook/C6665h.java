package com.facebook;

/* renamed from: com.facebook.h */
/* compiled from: AccessTokenSource */
public enum C6665h {
    NONE(false),
    FACEBOOK_APPLICATION_WEB(true),
    FACEBOOK_APPLICATION_NATIVE(true),
    FACEBOOK_APPLICATION_SERVICE(true),
    WEB_VIEW(true),
    CHROME_CUSTOM_TAB(true),
    TEST_USER(true),
    CLIENT_TOKEN(true),
    DEVICE_AUTH(true);
    

    /* renamed from: k */
    private final boolean f12160k;

    private C6665h(boolean canExtendToken) {
        this.f12160k = canExtendToken;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo19873e() {
        return this.f12160k;
    }
}
