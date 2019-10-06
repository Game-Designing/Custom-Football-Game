package com.crashlytics.android.p124a;

import android.annotation.SuppressLint;
import android.content.Context;
import p024io.fabric.sdk.android.p348a.p352d.C13884c;
import p024io.fabric.sdk.android.p348a.p352d.C13885d;

/* renamed from: com.crashlytics.android.a.o */
/* compiled from: AnswersPreferenceManager */
class C6391o {

    /* renamed from: a */
    private final C13884c f11430a;

    /* renamed from: a */
    public static C6391o m12376a(Context context) {
        return new C6391o(new C13885d(context, "settings"));
    }

    C6391o(C13884c prefStore) {
        this.f11430a = prefStore;
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: b */
    public void mo19412b() {
        C13884c cVar = this.f11430a;
        cVar.mo43294a(cVar.edit().putBoolean("analytics_launched", true));
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    public boolean mo19411a() {
        return this.f11430a.get().getBoolean("analytics_launched", false);
    }
}
