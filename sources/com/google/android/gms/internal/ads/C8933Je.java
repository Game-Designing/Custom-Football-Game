package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.JsResult;

/* renamed from: com.google.android.gms.internal.ads.Je */
final class C8933Je implements OnCancelListener {

    /* renamed from: a */
    private final /* synthetic */ JsResult f21283a;

    C8933Je(JsResult jsResult) {
        this.f21283a = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f21283a.cancel();
    }
}
