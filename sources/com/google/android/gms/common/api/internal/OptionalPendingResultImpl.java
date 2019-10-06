package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {

    /* renamed from: a */
    private final BasePendingResult<R> f19708a;

    /* renamed from: a */
    public final R mo27400a(long j, TimeUnit timeUnit) {
        return this.f19708a.mo27400a(j, timeUnit);
    }

    /* renamed from: a */
    public final void mo27350a() {
        this.f19708a.mo27350a();
    }

    /* renamed from: a */
    public final void mo27402a(ResultCallback<? super R> resultCallback) {
        this.f19708a.mo27402a(resultCallback);
    }

    /* renamed from: a */
    public final void mo27401a(StatusListener statusListener) {
        this.f19708a.mo27401a(statusListener);
    }
}
