package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.signin.internal.SignInClientImpl;

public final class zaa {

    /* renamed from: a */
    private static final ClientKey<SignInClientImpl> f30604a = new ClientKey<>();
    @ShowFirstParty

    /* renamed from: b */
    private static final ClientKey<SignInClientImpl> f30605b = new ClientKey<>();

    /* renamed from: c */
    public static final AbstractClientBuilder<SignInClientImpl, SignInOptions> f30606c = new C10039a();

    /* renamed from: d */
    private static final AbstractClientBuilder<SignInClientImpl, Object> f30607d = new C10040b();

    /* renamed from: e */
    private static final Scope f30608e = new Scope("profile");

    /* renamed from: f */
    private static final Scope f30609f = new Scope("email");

    /* renamed from: g */
    public static final Api<SignInOptions> f30610g = new Api<>("SignIn.API", f30606c, f30604a);

    /* renamed from: h */
    private static final Api<Object> f30611h = new Api<>("SignIn.INTERNAL_API", f30607d, f30605b);
}
