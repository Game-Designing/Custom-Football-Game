package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState;

/* renamed from: com.google.android.gms.common.api.internal.q */
final class C8677q implements GmsClientEventState {

    /* renamed from: a */
    private final /* synthetic */ zaaw f19769a;

    C8677q(zaaw zaaw) {
        this.f19769a = zaaw;
    }

    public final boolean isConnected() {
        return this.f19769a.mo27599j();
    }

    public final Bundle getConnectionHint() {
        return null;
    }
}
