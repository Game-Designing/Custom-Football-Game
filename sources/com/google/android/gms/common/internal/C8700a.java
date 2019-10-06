package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* renamed from: com.google.android.gms.common.internal.a */
final class C8700a extends DialogRedirect {

    /* renamed from: a */
    private final /* synthetic */ Intent f20139a;

    /* renamed from: b */
    private final /* synthetic */ Activity f20140b;

    /* renamed from: c */
    private final /* synthetic */ int f20141c;

    C8700a(Intent intent, Activity activity, int i) {
        this.f20139a = intent;
        this.f20140b = activity;
        this.f20141c = i;
    }

    /* renamed from: a */
    public final void mo27776a() {
        Intent intent = this.f20139a;
        if (intent != null) {
            this.f20140b.startActivityForResult(intent, this.f20141c);
        }
    }
}
