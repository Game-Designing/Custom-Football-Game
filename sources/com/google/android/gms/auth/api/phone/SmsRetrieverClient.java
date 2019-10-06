package com.google.android.gms.auth.api.phone;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.internal.auth-api-phone.zzi;

public abstract class SmsRetrieverClient extends GoogleApi<NoOptions> implements SmsRetrieverApi {

    /* renamed from: j */
    private static final ClientKey<zzi> f19386j = new ClientKey<>();

    /* renamed from: k */
    private static final AbstractClientBuilder<zzi, NoOptions> f19387k = new C8612a();

    /* renamed from: l */
    private static final Api<NoOptions> f19388l = new Api<>("SmsRetriever.API", f19387k, f19386j);
}
