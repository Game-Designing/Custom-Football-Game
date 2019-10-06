package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsResult;

/* renamed from: com.google.android.gms.internal.ads.Ke */
final class C8954Ke implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ JsResult f21393a;

    C8954Ke(JsResult jsResult) {
        this.f21393a = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f21393a.cancel();
    }
}
