package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener;

/* renamed from: com.google.android.gms.common.api.internal.y */
final class C8685y implements BackgroundStateChangeListener {

    /* renamed from: a */
    private final /* synthetic */ GoogleApiManager f19782a;

    C8685y(GoogleApiManager googleApiManager) {
        this.f19782a = googleApiManager;
    }

    /* renamed from: a */
    public final void mo27444a(boolean z) {
        this.f19782a.f19661q.sendMessage(this.f19782a.f19661q.obtainMessage(1, Boolean.valueOf(z)));
    }
}
