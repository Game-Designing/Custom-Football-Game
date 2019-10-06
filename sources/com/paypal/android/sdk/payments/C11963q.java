package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.q */
final class C11963q implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ C11960p f37602a;

    C11963q(C11960p pVar) {
        this.f37602a = pVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f37602a.f37599c.f37335o = i;
        this.f37602a.f37597a.mo38710a(i);
        this.f37602a.f37599c.f37336p.f37097r.mo38714a((String) this.f37602a.f37598b.get(i));
    }
}
