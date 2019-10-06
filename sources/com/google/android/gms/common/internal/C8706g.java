package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.common.internal.PendingResultUtil.zaa;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.common.internal.g */
final class C8706g implements StatusListener {

    /* renamed from: a */
    private final /* synthetic */ PendingResult f20150a;

    /* renamed from: b */
    private final /* synthetic */ TaskCompletionSource f20151b;

    /* renamed from: c */
    private final /* synthetic */ ResultConverter f20152c;

    /* renamed from: d */
    private final /* synthetic */ zaa f20153d;

    C8706g(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, ResultConverter resultConverter, zaa zaa) {
        this.f20150a = pendingResult;
        this.f20151b = taskCompletionSource;
        this.f20152c = resultConverter;
        this.f20153d = zaa;
    }

    /* renamed from: a */
    public final void mo27403a(Status status) {
        if (status.mo27421e()) {
            this.f20151b.mo33182a(this.f20152c.mo27190a(this.f20150a.mo27400a(0, TimeUnit.MILLISECONDS)));
            return;
        }
        this.f20151b.mo33181a((Exception) this.f20153d.mo27812a(status));
    }
}
