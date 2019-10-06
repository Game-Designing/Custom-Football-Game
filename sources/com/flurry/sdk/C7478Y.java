package com.flurry.sdk;

import android.content.Context;
import android.widget.Toast;

/* renamed from: com.flurry.sdk.Y */
class C7478Y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7440Q f14723a;

    /* renamed from: b */
    final /* synthetic */ C7490aa f14724b;

    C7478Y(C7490aa aaVar, C7440Q q) {
        this.f14724b = aaVar;
        this.f14723a = q;
    }

    public final void run() {
        Context context = C7379Fb.m16300a().f14432d;
        StringBuilder sb = new StringBuilder("PulseCallbackReportInfo HTTP Response Code: ");
        sb.append(this.f14723a.f14608f);
        sb.append(" for url: ");
        sb.append(this.f14723a.f14615m.f15063e);
        Toast.makeText(context, sb.toString(), 1).show();
    }
}
