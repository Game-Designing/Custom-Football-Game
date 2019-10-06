package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class zzf implements GoogleSignInApi {
    /* renamed from: b */
    public final Intent mo27188b(GoogleApiClient googleApiClient) {
        return zzh.m21026a(googleApiClient.mo27387f(), m21017d(googleApiClient));
    }

    /* renamed from: c */
    public final PendingResult<Status> mo27189c(GoogleApiClient googleApiClient) {
        return zzh.m21028a(googleApiClient, googleApiClient.mo27387f(), false);
    }

    /* renamed from: a */
    public final PendingResult<Status> mo27187a(GoogleApiClient googleApiClient) {
        return zzh.m21030b(googleApiClient, googleApiClient.mo27387f(), false);
    }

    /* renamed from: a */
    public final GoogleSignInResult mo27186a(Intent intent) {
        return zzh.m21027a(intent);
    }

    /* renamed from: d */
    private static GoogleSignInOptions m21017d(GoogleApiClient googleApiClient) {
        return ((zzg) googleApiClient.mo27376a((AnyClientKey<C>) Auth.f19279b)).mo27247k();
    }
}
