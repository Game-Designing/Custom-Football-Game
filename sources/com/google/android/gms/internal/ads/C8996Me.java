package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.JsPromptResult;

/* renamed from: com.google.android.gms.internal.ads.Me */
final class C8996Me implements OnCancelListener {

    /* renamed from: a */
    private final /* synthetic */ JsPromptResult f21472a;

    C8996Me(JsPromptResult jsPromptResult) {
        this.f21472a = jsPromptResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f21472a.cancel();
    }
}
