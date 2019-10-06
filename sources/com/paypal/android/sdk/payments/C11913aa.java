package com.paypal.android.sdk.payments;

import android.content.Context;
import android.content.Intent;
import com.paypal.android.sdk.C11723Fa;
import com.paypal.android.sdk.C11749Na;
import com.paypal.android.sdk.C11758Qa;
import com.paypal.android.sdk.C11788a;
import com.paypal.android.sdk.C11828hb;
import com.paypal.android.sdk.C11844lb;

/* renamed from: com.paypal.android.sdk.payments.aa */
final class C11913aa implements Runnable {

    /* renamed from: a */
    private /* synthetic */ Context f37497a;

    C11913aa(Context context) {
        this.f37497a = context;
    }

    public final void run() {
        PayPalService.f37409a;
        Context context = this.f37497a;
        new C11867Da();
        C11788a aVar = new C11788a(context, "AndroidBasePrefs", new C11723Fa());
        C11828hb.m39168a(aVar);
        C11844lb.m39199a(aVar);
        for (String str : new C11916ba(this)) {
            C11758Qa qa = new C11758Qa(aVar, str);
            qa.mo38618b();
            qa.mo38619c();
            C11749Na.m38904b(str);
        }
        C11919c.m39521a(this.f37497a).mo39083a(new Intent("com.paypal.android.sdk.clearAllUserData"));
        PayPalService.f37409a;
    }
}
