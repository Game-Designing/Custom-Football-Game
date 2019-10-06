package com.paypal.android.sdk;

import java.util.Collection;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;

/* renamed from: com.paypal.android.sdk.l */
public enum C11842l {
    FUTURE_PAYMENTS("https://uri.paypal.com/services/payments/futurepayments", false),
    PROFILE("profile", true),
    PAYPAL_ATTRIBUTES("https://uri.paypal.com/services/paypalattributes", true),
    OPENID("openid", true),
    EMAIL("email", true),
    ADDRESS(AgentOptions.ADDRESS, true),
    PHONE("phone", true);
    

    /* renamed from: h */
    public static final Collection f37266h = null;

    /* renamed from: i */
    public static final Collection f37267i = null;

    /* renamed from: k */
    private String f37269k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f37270l;

    static {
        f37266h = new C11846m();
        f37267i = new C11850n();
    }

    private C11842l(String str, boolean z) {
        this.f37269k = str;
        this.f37270l = z;
    }

    /* renamed from: a */
    public final String mo38820a() {
        return this.f37269k;
    }
}
