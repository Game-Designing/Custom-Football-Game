package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public abstract class PendingResult<R extends Result> {

    @KeepForSdk
    public interface StatusListener {
        @KeepForSdk
        /* renamed from: a */
        void mo27403a(Status status);
    }

    /* renamed from: a */
    public abstract R mo27400a(long j, TimeUnit timeUnit);

    /* renamed from: a */
    public abstract void mo27350a();

    /* renamed from: a */
    public abstract void mo27402a(ResultCallback<? super R> resultCallback);

    @KeepForSdk
    /* renamed from: a */
    public void mo27401a(StatusListener statusListener) {
        throw new UnsupportedOperationException();
    }
}
