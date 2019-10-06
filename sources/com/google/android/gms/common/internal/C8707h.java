package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;

/* renamed from: com.google.android.gms.common.internal.h */
final class C8707h implements ResultConverter<R, T> {

    /* renamed from: a */
    private final /* synthetic */ Response f20154a;

    C8707h(Response response) {
        this.f20154a = response;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo27190a(Result result) {
        this.f20154a.mo27406a(result);
        return this.f20154a;
    }
}
