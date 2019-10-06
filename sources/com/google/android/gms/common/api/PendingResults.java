package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public final class PendingResults {

    /* renamed from: com.google.android.gms.common.api.PendingResults$a */
    private static final class C8630a<R extends Result> extends BasePendingResult<R> {

        /* renamed from: q */
        private final R f19591q;

        public C8630a(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.f19591q = r;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final R mo27233a(Status status) {
            return this.f19591q;
        }
    }

    @KeepForSdk
    /* renamed from: a */
    public static PendingResult<Status> m21175a(Status status, GoogleApiClient googleApiClient) {
        Preconditions.m21858a(status, (Object) "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(googleApiClient);
        statusPendingResult.mo27451a(status);
        return statusPendingResult;
    }

    @KeepForSdk
    /* renamed from: a */
    public static <R extends Result> PendingResult<R> m21174a(R r, GoogleApiClient googleApiClient) {
        Preconditions.m21858a(r, (Object) "Result must not be null");
        Preconditions.m21864a(!r.getStatus().mo27421e(), (Object) "Status code must not be SUCCESS");
        C8630a aVar = new C8630a(googleApiClient, r);
        aVar.mo27451a(r);
        return aVar;
    }

    @KeepForSdk
    private PendingResults() {
    }
}
