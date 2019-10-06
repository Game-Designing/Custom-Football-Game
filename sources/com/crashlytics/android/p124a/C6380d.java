package com.crashlytics.android.p124a;

import com.crashlytics.android.p124a.C6380d;
import java.util.Map;
import p024io.fabric.sdk.android.C13920f;

/* renamed from: com.crashlytics.android.a.d */
/* compiled from: AnswersEvent */
public abstract class C6380d<T extends C6380d> {

    /* renamed from: a */
    final C6381e f11403a = new C6381e(20, 100, C13920f.m44246g());

    /* renamed from: b */
    final C6379c f11404b = new C6379c(this.f11403a);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Map<String, Object> mo19384a() {
        return this.f11404b.f11402b;
    }

    /* renamed from: a */
    public T mo19383a(String key, String value) {
        this.f11404b.mo19381a(key, value);
        return this;
    }
}
