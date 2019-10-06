package com.asf.appcoins.sdk.core.util.wallet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import p320f.p321a.C13811w;

/* renamed from: com.asf.appcoins.sdk.core.util.wallet.c */
/* compiled from: lambda */
public final /* synthetic */ class C5874c implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ C13811w f10215a;

    public /* synthetic */ C5874c(C13811w wVar) {
        this.f10215a = wVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f10215a.onSuccess(Boolean.valueOf(true));
    }
}
