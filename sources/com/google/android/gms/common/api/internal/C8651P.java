package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* renamed from: com.google.android.gms.common.api.internal.P */
final class C8651P extends zabr {

    /* renamed from: a */
    private final /* synthetic */ Dialog f19709a;

    /* renamed from: b */
    private final /* synthetic */ C8650O f19710b;

    C8651P(C8650O o, Dialog dialog) {
        this.f19710b = o;
        this.f19709a = dialog;
    }

    /* renamed from: a */
    public final void mo27539a() {
        this.f19710b.f19707b.mo27632g();
        if (this.f19709a.isShowing()) {
            this.f19709a.dismiss();
        }
    }
}
