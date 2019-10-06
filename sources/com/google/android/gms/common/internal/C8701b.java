package com.google.android.gms.common.internal;

import android.content.Intent;
import android.support.p000v4.app.Fragment;

/* renamed from: com.google.android.gms.common.internal.b */
final class C8701b extends DialogRedirect {

    /* renamed from: a */
    private final /* synthetic */ Intent f20142a;

    /* renamed from: b */
    private final /* synthetic */ Fragment f20143b;

    /* renamed from: c */
    private final /* synthetic */ int f20144c;

    C8701b(Intent intent, Fragment fragment, int i) {
        this.f20142a = intent;
        this.f20143b = fragment;
        this.f20144c = i;
    }

    /* renamed from: a */
    public final void mo27776a() {
        Intent intent = this.f20142a;
        if (intent != null) {
            this.f20143b.startActivityForResult(intent, this.f20144c);
        }
    }
}
