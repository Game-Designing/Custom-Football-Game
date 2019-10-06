package com.google.android.gms.location;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.internal.location.zzaf;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzbk;
import com.google.android.gms.internal.location.zzq;

public class LocationServices {

    /* renamed from: a */
    private static final ClientKey<zzaz> f30503a = new ClientKey<>();

    /* renamed from: b */
    private static final AbstractClientBuilder<zzaz, NoOptions> f30504b = new C10030b();

    /* renamed from: c */
    public static final Api<NoOptions> f30505c = new Api<>("LocationServices.API", f30504b, f30503a);
    @Deprecated

    /* renamed from: d */
    public static final FusedLocationProviderApi f30506d = new zzq();
    @Deprecated

    /* renamed from: e */
    public static final GeofencingApi f30507e = new zzaf();
    @Deprecated

    /* renamed from: f */
    public static final SettingsApi f30508f = new zzbk();

    public static abstract class zza<R extends Result> extends ApiMethodImpl<R, zzaz> {
    }

    private LocationServices() {
    }

    /* renamed from: a */
    public static FusedLocationProviderClient m32675a(Context context) {
        return new FusedLocationProviderClient(context);
    }
}
