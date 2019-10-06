package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzf;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.internal.auth-api.zzi;
import com.google.android.gms.internal.auth-api.zzr;

public final class Auth {

    /* renamed from: a */
    public static final ClientKey<zzr> f19278a = new ClientKey<>();

    /* renamed from: b */
    public static final ClientKey<zzg> f19279b = new ClientKey<>();

    /* renamed from: c */
    private static final AbstractClientBuilder<zzr, AuthCredentialsOptions> f19280c = new C8607b();

    /* renamed from: d */
    private static final AbstractClientBuilder<zzg, GoogleSignInOptions> f19281d = new C8608c();
    @KeepForSdk
    @Deprecated

    /* renamed from: e */
    public static final Api<AuthProxyOptions> f19282e = AuthProxy.f19294c;

    /* renamed from: f */
    public static final Api<AuthCredentialsOptions> f19283f = new Api<>("Auth.CREDENTIALS_API", f19280c, f19278a);

    /* renamed from: g */
    public static final Api<GoogleSignInOptions> f19284g = new Api<>("Auth.GOOGLE_SIGN_IN_API", f19281d, f19279b);
    @KeepForSdk
    @Deprecated

    /* renamed from: h */
    public static final ProxyApi f19285h = AuthProxy.f19295d;

    /* renamed from: i */
    public static final CredentialsApi f19286i = new zzi();

    /* renamed from: j */
    public static final GoogleSignInApi f19287j = new zzf();

    @Deprecated
    public static class AuthCredentialsOptions implements Optional {

        /* renamed from: a */
        private static final AuthCredentialsOptions f19288a = new Builder().mo27095a();

        /* renamed from: b */
        private final String f19289b = null;

        /* renamed from: c */
        private final boolean f19290c;

        @Deprecated
        public static class Builder {

            /* renamed from: a */
            protected Boolean f19291a = Boolean.valueOf(false);

            /* renamed from: a */
            public AuthCredentialsOptions mo27095a() {
                return new AuthCredentialsOptions(this);
            }
        }

        public AuthCredentialsOptions(Builder builder) {
            this.f19290c = builder.f19291a.booleanValue();
        }

        /* renamed from: a */
        public final Bundle mo27094a() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", null);
            bundle.putBoolean("force_save_dialog", this.f19290c);
            return bundle;
        }
    }

    private Auth() {
    }
}
