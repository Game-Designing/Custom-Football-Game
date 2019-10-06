package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public interface GoogleSignInApi {
    /* renamed from: a */
    GoogleSignInResult mo27186a(Intent intent);

    /* renamed from: a */
    PendingResult<Status> mo27187a(GoogleApiClient googleApiClient);

    /* renamed from: b */
    Intent mo27188b(GoogleApiClient googleApiClient);

    /* renamed from: c */
    PendingResult<Status> mo27189c(GoogleApiClient googleApiClient);
}
