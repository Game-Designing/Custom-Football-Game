package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

public final class zabp<O extends ApiOptions> extends zaag {

    /* renamed from: c */
    private final GoogleApi<O> f19855c;

    public zabp(GoogleApi<O> googleApi) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f19855c = googleApi;
    }

    /* renamed from: a */
    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T mo27377a(T t) {
        return this.f19855c.mo27359a(t);
    }

    /* renamed from: b */
    public final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T mo27383b(T t) {
        return this.f19855c.mo27362b(t);
    }

    /* renamed from: g */
    public final Looper mo27388g() {
        return this.f19855c.mo27367f();
    }

    /* renamed from: a */
    public final void mo27379a(zacm zacm) {
    }

    /* renamed from: f */
    public final Context mo27387f() {
        return this.f19855c.mo27365d();
    }
}
