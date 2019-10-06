package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;

/* renamed from: com.google.android.gms.common.api.internal.k */
final class C8671k extends C8683w {

    /* renamed from: b */
    private final /* synthetic */ ConnectionProgressReportCallbacks f19761b;

    C8671k(C8669i iVar, zabd zabd, ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.f19761b = connectionProgressReportCallbacks;
        super(zabd);
    }

    /* renamed from: a */
    public final void mo27570a() {
        this.f19761b.mo27483a(new ConnectionResult(16, null));
    }
}
