package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public class zabu extends zal {

    /* renamed from: f */
    private TaskCompletionSource<Void> f19858f;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo27586a(ConnectionResult connectionResult, int i) {
        this.f19858f.mo33181a((Exception) ApiExceptionUtil.m21721a(new Status(connectionResult.mo27275a(), connectionResult.mo27277c(), connectionResult.mo27278d())));
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final void mo27587f() {
        int isGooglePlayServicesAvailable = this.f19909e.isGooglePlayServicesAvailable(this.f19696a.mo27522a());
        if (isGooglePlayServicesAvailable == 0) {
            this.f19858f.mo33182a(null);
            return;
        }
        if (!this.f19858f.mo33180a().mo33178c()) {
            mo27631b(new ConnectionResult(isGooglePlayServicesAvailable, null), 0);
        }
    }

    /* renamed from: b */
    public void mo27517b() {
        super.mo27517b();
        this.f19858f.mo33183b((Exception) new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }
}
