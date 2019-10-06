package com.crashlytics.android.p126c;

import android.content.Context;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;

/* renamed from: com.crashlytics.android.c.Ka */
/* compiled from: ResourceUnityVersionProvider */
class C6434Ka implements C6446Qa {

    /* renamed from: a */
    private final Context f11532a;

    /* renamed from: b */
    private final C6446Qa f11533b;

    /* renamed from: c */
    private boolean f11534c = false;

    /* renamed from: d */
    private String f11535d;

    public C6434Ka(Context context, C6446Qa fallback) {
        this.f11532a = context;
        this.f11533b = fallback;
    }

    /* renamed from: a */
    public String mo19462a() {
        if (!this.f11534c) {
            this.f11535d = C13852l.m44063o(this.f11532a);
            this.f11534c = true;
        }
        String str = this.f11535d;
        if (str != null) {
            return str;
        }
        C6446Qa qa = this.f11533b;
        if (qa != null) {
            return qa.mo19462a();
        }
        return null;
    }
}
