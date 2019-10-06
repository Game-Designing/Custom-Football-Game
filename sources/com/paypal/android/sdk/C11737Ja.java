package com.paypal.android.sdk;

import java.util.Locale;

/* renamed from: com.paypal.android.sdk.Ja */
public final class C11737Ja implements C11996qb {

    /* renamed from: a */
    private static volatile C11737Ja f36706a;

    private C11737Ja() {
    }

    /* renamed from: a */
    public static C11737Ja m38864a() {
        if (f36706a == null) {
            synchronized (C11737Ja.class) {
                if (f36706a == null) {
                    f36706a = new C11737Ja();
                }
            }
        }
        return f36706a;
    }

    /* renamed from: a */
    public final String mo38575a(String str) {
        return str;
    }

    /* renamed from: b */
    public final Locale mo38576b() {
        return Locale.getDefault();
    }

    /* renamed from: c */
    public final C11812eh mo38577c() {
        return new C11812eh(Locale.getDefault().getCountry());
    }

    /* renamed from: d */
    public final C11812eh mo38578d() {
        return mo38577c();
    }
}
