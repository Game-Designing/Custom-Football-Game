package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.Intent;
import android.text.style.URLSpan;
import android.view.View;

/* renamed from: com.paypal.android.sdk.payments.b */
final class C11915b extends URLSpan {

    /* renamed from: a */
    private Activity f37498a;

    /* renamed from: b */
    private Class f37499b;

    /* renamed from: c */
    private C11920ca f37500c;

    /* renamed from: d */
    private C11939i f37501d;

    C11915b(URLSpan uRLSpan, Activity activity, Class cls, C11920ca caVar, C11939i iVar) {
        super(uRLSpan.getURL());
        this.f37498a = activity;
        this.f37499b = cls;
        this.f37500c = caVar;
        this.f37501d = iVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.f37498a, this.f37499b);
        intent.putExtra("com.paypal.details.scope", this.f37501d);
        this.f37500c.mo39084a();
        this.f37498a.startActivity(intent);
    }
}
