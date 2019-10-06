package com.google.android.gms.safetynet;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.internal.safetynet.zzk;
import com.google.android.gms.internal.safetynet.zzx;
import com.google.android.gms.internal.safetynet.zzy;

public final class SafetyNet {

    /* renamed from: a */
    private static final ClientKey<zzx> f30567a = new ClientKey<>();

    /* renamed from: b */
    private static final AbstractClientBuilder<zzx, NoOptions> f30568b = new C10038a();
    @Deprecated

    /* renamed from: c */
    public static final Api<NoOptions> f30569c = new Api<>("SafetyNet.API", f30568b, f30567a);
    @Deprecated

    /* renamed from: d */
    public static final SafetyNetApi f30570d = new zzk();

    /* renamed from: e */
    private static final zzo f30571e = new zzy();

    private SafetyNet() {
    }

    /* renamed from: a */
    public static SafetyNetClient m32726a(Context context) {
        return new SafetyNetClient(context);
    }
}
