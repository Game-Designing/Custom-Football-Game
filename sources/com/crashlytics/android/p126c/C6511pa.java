package com.crashlytics.android.p126c;

import android.content.Context;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;
import p024io.fabric.sdk.android.p348a.p353e.C13902p;

/* renamed from: com.crashlytics.android.c.pa */
/* compiled from: DialogStringResolver */
class C6511pa {

    /* renamed from: a */
    private final Context f11693a;

    /* renamed from: b */
    private final C13902p f11694b;

    public C6511pa(Context context, C13902p promptData) {
        this.f11693a = context;
        this.f11694b = promptData;
    }

    /* renamed from: e */
    public String mo19599e() {
        return m12755a("com.crashlytics.CrashSubmissionPromptTitle", this.f11694b.f42168a);
    }

    /* renamed from: c */
    public String mo19597c() {
        return m12755a("com.crashlytics.CrashSubmissionPromptMessage", this.f11694b.f42169b);
    }

    /* renamed from: d */
    public String mo19598d() {
        return m12755a("com.crashlytics.CrashSubmissionSendTitle", this.f11694b.f42170c);
    }

    /* renamed from: a */
    public String mo19595a() {
        return m12755a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.f11694b.f42174g);
    }

    /* renamed from: b */
    public String mo19596b() {
        return m12755a("com.crashlytics.CrashSubmissionCancelTitle", this.f11694b.f42172e);
    }

    /* renamed from: a */
    private String m12755a(String resourceName, String settingsValue) {
        return m12757b(C13852l.m44043b(this.f11693a, resourceName), settingsValue);
    }

    /* renamed from: b */
    private String m12757b(String firstChoice, String fallback) {
        return m12756a(firstChoice) ? fallback : firstChoice;
    }

    /* renamed from: a */
    private boolean m12756a(String s) {
        return s == null || s.length() == 0;
    }
}
