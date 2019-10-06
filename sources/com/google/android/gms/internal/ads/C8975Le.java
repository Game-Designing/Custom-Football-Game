package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsResult;

/* renamed from: com.google.android.gms.internal.ads.Le */
final class C8975Le implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ JsResult f21423a;

    C8975Le(JsResult jsResult) {
        this.f21423a = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f21423a.confirm();
    }
}
