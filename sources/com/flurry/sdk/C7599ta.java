package com.flurry.sdk;

import android.content.Context;
import android.widget.Toast;

/* renamed from: com.flurry.sdk.ta */
class C7599ta implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f15077a;

    /* renamed from: b */
    final /* synthetic */ C7604ua f15078b;

    C7599ta(C7604ua uaVar, int i) {
        this.f15078b = uaVar;
        this.f15077a = i;
    }

    public final void run() {
        Context context = C7379Fb.m16300a().f14432d;
        StringBuilder sb = new StringBuilder("SD HTTP Response Code: ");
        sb.append(this.f15077a);
        Toast.makeText(context, sb.toString(), 0).show();
    }
}
