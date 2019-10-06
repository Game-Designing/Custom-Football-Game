package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;

@KeepForSdk
public class SignInClientImpl extends GmsClient<zaf> implements zad {

    /* renamed from: F */
    private final boolean f30592F;

    /* renamed from: G */
    private final ClientSettings f30593G;

    /* renamed from: H */
    private final Bundle f30594H;

    /* renamed from: I */
    private Integer f30595I;

    private SignInClientImpl(Context context, Looper looper, boolean z, ClientSettings clientSettings, Bundle bundle, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.f30592F = true;
        this.f30593G = clientSettings;
        this.f30594H = bundle;
        this.f30595I = clientSettings.mo27764e();
    }

    public SignInClientImpl(Context context, Looper looper, boolean z, ClientSettings clientSettings, SignInOptions signInOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, true, clientSettings, m32743a(clientSettings), connectionCallbacks, onConnectionFailedListener);
    }

    public boolean requiresSignIn() {
        return this.f30592F;
    }

    /* renamed from: a */
    public final void mo33152a(IAccountAccessor iAccountAccessor, boolean z) {
        try {
            ((zaf) getService()).mo33162a(iAccountAccessor, this.f30595I.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    /* renamed from: a */
    public final void mo33151a() {
        try {
            ((zaf) getService()).mo33164j(this.f30595I.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    /* renamed from: a */
    public final void mo33153a(zad zad) {
        Preconditions.m21858a(zad, (Object) "Expecting a valid ISignInCallbacks");
        try {
            Account c = this.f30593G.mo27762c();
            GoogleSignInAccount googleSignInAccount = null;
            if (BaseGmsClient.DEFAULT_ACCOUNT.equals(c.name)) {
                googleSignInAccount = Storage.m20992a(getContext()).mo27229b();
            }
            ((zaf) getService()).mo33163a(new zah(new ResolveAccountRequest(c, this.f30595I.intValue(), googleSignInAccount)), zad);
        } catch (RemoteException e) {
            String str = "SignInClientImpl";
            Log.w(str, "Remote service probably died when signIn is called");
            try {
                zad.mo27573a(new zaj(8));
            } catch (RemoteException e2) {
                Log.wtf(str, "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public String mo27246h() {
        return "com.google.android.gms.signin.service.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public String mo27243g() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Bundle mo27713d() {
        if (!getContext().getPackageName().equals(this.f30593G.mo27767h())) {
            this.f30594H.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f30593G.mo27767h());
        }
        return this.f30594H;
    }

    public final void connect() {
        connect(new LegacyClientCallbackAdapter());
    }

    @KeepForSdk
    /* renamed from: a */
    public static Bundle m32743a(ClientSettings clientSettings) {
        SignInOptions j = clientSettings.mo27769j();
        Integer e = clientSettings.mo27764e();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", clientSettings.mo27758a());
        if (e != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", e.intValue());
        }
        if (j != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", j.mo33149g());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", j.mo33148f());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", j.mo33146d());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", j.mo33147e());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", j.mo33144b());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", j.mo33150h());
            if (j.mo33143a() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", j.mo33143a().longValue());
            }
            if (j.mo33145c() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", j.mo33145c().longValue());
            }
        }
        return bundle;
    }

    public int getMinApkVersion() {
        return 12451000;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public /* synthetic */ IInterface mo27242a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof zaf) {
            return (zaf) queryLocalInterface;
        }
        return new zag(iBinder);
    }
}
