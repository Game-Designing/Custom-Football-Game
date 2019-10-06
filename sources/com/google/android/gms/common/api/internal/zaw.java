package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.GoogleApiManager.zaa;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;

public final class zaw<O extends ApiOptions> extends GoogleApi<O> {

    /* renamed from: j */
    private final Client f19913j;

    /* renamed from: k */
    private final zaq f19914k;

    /* renamed from: l */
    private final ClientSettings f19915l;

    /* renamed from: m */
    private final AbstractClientBuilder<? extends zad, SignInOptions> f19916m;

    public zaw(Context context, Api<O> api, Looper looper, Client client, zaq zaq, ClientSettings clientSettings, AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder) {
        super(context, api, looper);
        this.f19913j = client;
        this.f19914k = zaq;
        this.f19915l = clientSettings;
        this.f19916m = abstractClientBuilder;
        this.f19563i.mo27471a((GoogleApi<?>) this);
    }

    /* renamed from: h */
    public final Client mo27635h() {
        return this.f19913j;
    }

    /* renamed from: a */
    public final Client mo27357a(Looper looper, zaa<O> zaa) {
        this.f19914k.mo27634a(zaa);
        return this.f19913j;
    }

    /* renamed from: a */
    public final zace mo27360a(Context context, Handler handler) {
        return new zace(context, handler, this.f19915l, this.f19916m);
    }
}
