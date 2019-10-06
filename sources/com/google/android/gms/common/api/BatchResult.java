package com.google.android.gms.common.api;

public final class BatchResult implements Result {

    /* renamed from: a */
    private final Status f19551a;

    /* renamed from: b */
    private final PendingResult<?>[] f19552b;

    BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.f19551a = status;
        this.f19552b = pendingResultArr;
    }

    public final Status getStatus() {
        return this.f19551a;
    }
}
