package com.google.android.gms.common.api.internal;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.common.api.internal.t */
final class C8680t implements ResultCallback<Status> {

    /* renamed from: a */
    private final /* synthetic */ StatusPendingResult f19774a;

    /* renamed from: b */
    private final /* synthetic */ boolean f19775b;

    /* renamed from: c */
    private final /* synthetic */ GoogleApiClient f19776c;

    /* renamed from: d */
    private final /* synthetic */ zaaw f19777d;

    C8680t(zaaw zaaw, StatusPendingResult statusPendingResult, boolean z, GoogleApiClient googleApiClient) {
        this.f19777d = zaaw;
        this.f19774a = statusPendingResult;
        this.f19775b = z;
        this.f19776c = googleApiClient;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27408a(Result result) {
        Status status = (Status) result;
        Storage.m20992a(this.f19777d.f19818g).mo27232e();
        if (status.mo27421e() && this.f19777d.mo27599j()) {
            this.f19777d.mo27600k();
        }
        this.f19774a.mo27451a(status);
        if (this.f19775b) {
            this.f19776c.mo27386d();
        }
    }
}
