package com.google.android.gms.auth.account;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.internal.auth.zzh;
import com.google.android.gms.internal.auth.zzr;

public class WorkAccount {

    /* renamed from: a */
    private static final ClientKey<zzr> f19274a = new ClientKey<>();

    /* renamed from: b */
    private static final AbstractClientBuilder<zzr, NoOptions> f19275b = new C8601a();

    /* renamed from: c */
    public static final Api<NoOptions> f19276c = new Api<>("WorkAccount.API", f19275b, f19274a);
    @Deprecated

    /* renamed from: d */
    public static final WorkAccountApi f19277d = new zzh();

    private WorkAccount() {
    }
}
