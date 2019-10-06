package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager.zaa;
import com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks;

/* renamed from: com.google.android.gms.common.api.internal.C */
final class C8635C implements SignOutCallbacks {

    /* renamed from: a */
    final /* synthetic */ zaa f19636a;

    C8635C(zaa zaa) {
        this.f19636a = zaa;
    }

    /* renamed from: a */
    public final void mo27462a() {
        GoogleApiManager.this.f19661q.post(new C8636D(this));
    }
}
