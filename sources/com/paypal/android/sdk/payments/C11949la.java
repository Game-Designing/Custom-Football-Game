package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.C11743La;
import com.paypal.android.sdk.C11765T;
import com.paypal.android.sdk.C11774W;
import java.util.GregorianCalendar;

/* renamed from: com.paypal.android.sdk.payments.la */
final class C11949la {

    /* renamed from: a */
    private final PayPalService f37575a;

    /* renamed from: b */
    private final String f37576b = Integer.toString((new GregorianCalendar().getTimeZone().getRawOffset() / 1000) / 60);

    public C11949la(PayPalService payPalService) {
        this.f37575a = payPalService;
    }

    /* renamed from: a */
    public final C11743La mo39126a() {
        return this.f37575a.mo38978c();
    }

    /* renamed from: a */
    public final void mo39127a(C11774W w) {
        this.f37575a.mo38959a(w);
    }

    /* renamed from: b */
    public final String mo39128b() {
        return this.f37575a.mo38981f();
    }

    /* renamed from: c */
    public final C11765T mo39129c() {
        return this.f37575a.mo38976b();
    }

    /* renamed from: d */
    public final String mo39130d() {
        return this.f37575a.mo38980e();
    }

    /* renamed from: e */
    public final String mo39131e() {
        return this.f37576b;
    }

    /* renamed from: f */
    public final String mo39132f() {
        return this.f37575a.mo39003v();
    }
}
