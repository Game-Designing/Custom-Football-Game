package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

public final class Batch extends BasePendingResult<BatchResult> {

    /* renamed from: q */
    private final PendingResult<?>[] f19550q;

    public static final class Builder {
    }

    /* renamed from: a */
    public final void mo27350a() {
        super.mo27350a();
        for (PendingResult<?> a : this.f19550q) {
            a.mo27350a();
        }
    }

    /* renamed from: a */
    public final BatchResult m21123a(Status status) {
        return new BatchResult(status, this.f19550q);
    }
}
