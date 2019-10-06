package com.crashlytics.android.p124a;

import java.util.Locale;
import java.util.Map;
import p024io.fabric.sdk.android.C13920f;

/* renamed from: com.crashlytics.android.a.e */
/* compiled from: AnswersEventValidator */
class C6381e {

    /* renamed from: a */
    final int f11405a;

    /* renamed from: b */
    final int f11406b;

    /* renamed from: c */
    boolean f11407c;

    public C6381e(int maxNumAttributes, int maxStringLength, boolean failFast) {
        this.f11405a = maxNumAttributes;
        this.f11406b = maxStringLength;
        this.f11407c = failFast;
    }

    /* renamed from: a */
    public String mo19385a(String value) {
        int length = value.length();
        int i = this.f11406b;
        if (length <= i) {
            return value;
        }
        m12347a((RuntimeException) new IllegalArgumentException(String.format(Locale.US, "String is too long, truncating to %d characters", new Object[]{Integer.valueOf(i)})));
        return value.substring(0, this.f11406b);
    }

    /* renamed from: a */
    public boolean mo19386a(Object object, String paramName) {
        if (object != null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(paramName);
        sb.append(" must not be null");
        m12347a((RuntimeException) new NullPointerException(sb.toString()));
        return true;
    }

    /* renamed from: a */
    public boolean mo19387a(Map<String, Object> attributeMap, String key) {
        if (attributeMap.size() < this.f11405a || attributeMap.containsKey(key)) {
            return false;
        }
        m12347a((RuntimeException) new IllegalArgumentException(String.format(Locale.US, "Limit of %d attributes reached, skipping attribute", new Object[]{Integer.valueOf(this.f11405a)})));
        return true;
    }

    /* renamed from: a */
    private void m12347a(RuntimeException ex) {
        if (!this.f11407c) {
            C13920f.m44245e().mo43325b("Answers", "Invalid user input detected", ex);
            return;
        }
        throw ex;
    }
}
