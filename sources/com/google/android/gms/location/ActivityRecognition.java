package com.google.android.gms.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zze;

public class ActivityRecognition {

    /* renamed from: a */
    private static final ClientKey<zzaz> f30449a = new ClientKey<>();

    /* renamed from: b */
    private static final AbstractClientBuilder<zzaz, NoOptions> f30450b = new C10029a();

    /* renamed from: c */
    public static final Api<NoOptions> f30451c = new Api<>("ActivityRecognition.API", f30450b, f30449a);
    @Deprecated

    /* renamed from: d */
    public static final ActivityRecognitionApi f30452d = new zze();

    public static abstract class zza<R extends Result> extends ApiMethodImpl<R, zzaz> {
    }

    private ActivityRecognition() {
    }
}
