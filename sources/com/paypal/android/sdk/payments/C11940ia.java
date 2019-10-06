package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.C11793ba;

/* renamed from: com.paypal.android.sdk.payments.ia */
final class C11940ia {

    /* renamed from: a */
    Integer f37559a;

    /* renamed from: b */
    String f37560b;

    C11940ia(PayPalService payPalService, String str, Integer num, String str2) {
        this.f37560b = str;
        this.f37559a = num;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo39120a() {
        Integer num = this.f37559a;
        return num != null && num.equals(Integer.valueOf(401));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final boolean mo39121b() {
        return mo39120a() && this.f37560b.equals("2fa_required");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final boolean mo39122c() {
        return this.f37560b.equals(C11793ba.SERVER_COMMUNICATION_ERROR.toString());
    }
}
