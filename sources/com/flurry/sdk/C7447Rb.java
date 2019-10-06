package com.flurry.sdk;

import android.text.TextUtils;

/* renamed from: com.flurry.sdk.Rb */
public abstract class C7447Rb {

    /* renamed from: a */
    protected String f14631a = "com.flurry.android.sdk.ReplaceMeWithAProperEventName";

    public C7447Rb(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f14631a = str;
            return;
        }
        throw new IllegalArgumentException("Event must have a name!");
    }

    /* renamed from: a */
    public final String mo23884a() {
        return this.f14631a;
    }

    /* renamed from: b */
    public final void mo23885b() {
        C7462Ub.m16528a().mo23908a(this);
    }
}
