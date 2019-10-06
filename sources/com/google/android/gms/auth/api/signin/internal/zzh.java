package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.logging.Logger;

public final class zzh {

    /* renamed from: a */
    private static Logger f19490a = new Logger("GoogleSignInCommon", new String[0]);

    /* renamed from: a */
    public static Intent m21026a(Context context, GoogleSignInOptions googleSignInOptions) {
        f19490a.mo27870a("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        String str = "config";
        bundle.putParcelable(str, signInConfiguration);
        intent.putExtra(str, bundle);
        return intent;
    }

    /* renamed from: a */
    public static PendingResult<Status> m21028a(GoogleApiClient googleApiClient, Context context, boolean z) {
        f19490a.mo27870a("Signing out", new Object[0]);
        m21029a(context);
        if (z) {
            return PendingResults.m21175a(Status.f19597a, googleApiClient);
        }
        return googleApiClient.mo27383b(new C8619a(googleApiClient));
    }

    /* renamed from: b */
    public static PendingResult<Status> m21030b(GoogleApiClient googleApiClient, Context context, boolean z) {
        f19490a.mo27870a("Revoking access", new Object[0]);
        String d = Storage.m20992a(context).mo27231d();
        m21029a(context);
        if (z) {
            return zzd.m21013a(d);
        }
        return googleApiClient.mo27383b(new C8621c(googleApiClient));
    }

    /* renamed from: a */
    private static void m21029a(Context context) {
        zzp.m21031a(context).mo27249a();
        for (GoogleApiClient h : GoogleApiClient.m21145e()) {
            h.mo27389h();
        }
        GoogleApiManager.m21235b();
    }

    /* renamed from: a */
    public static GoogleSignInResult m21027a(Intent intent) {
        if (intent != null) {
            String str = "googleSignInStatus";
            String str2 = "googleSignInAccount";
            if (intent.hasExtra(str) || intent.hasExtra(str2)) {
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra(str2);
                Status status = (Status) intent.getParcelableExtra(str);
                if (googleSignInAccount != null) {
                    status = Status.f19597a;
                }
                return new GoogleSignInResult(googleSignInAccount, status);
            }
        }
        return null;
    }
}
