package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

public abstract class ResultTransform<R extends Result, S extends Result> {
    /* renamed from: a */
    public abstract PendingResult<S> mo27410a(R r);

    /* renamed from: a */
    public Status mo27411a(Status status) {
        return status;
    }
}
