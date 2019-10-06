package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;

/* renamed from: com.google.android.gms.internal.ads.Ne */
final class C9017Ne implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ JsPromptResult f21508a;

    C9017Ne(JsPromptResult jsPromptResult) {
        this.f21508a = jsPromptResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f21508a.cancel();
    }
}
