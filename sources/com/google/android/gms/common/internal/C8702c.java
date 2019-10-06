package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* renamed from: com.google.android.gms.common.internal.c */
final class C8702c extends DialogRedirect {

    /* renamed from: a */
    private final /* synthetic */ Intent f20145a;

    /* renamed from: b */
    private final /* synthetic */ LifecycleFragment f20146b;

    /* renamed from: c */
    private final /* synthetic */ int f20147c;

    C8702c(Intent intent, LifecycleFragment lifecycleFragment, int i) {
        this.f20145a = intent;
        this.f20146b = lifecycleFragment;
        this.f20147c = i;
    }

    /* renamed from: a */
    public final void mo27776a() {
        Intent intent = this.f20145a;
        if (intent != null) {
            this.f20146b.startActivityForResult(intent, this.f20147c);
        }
    }
}
