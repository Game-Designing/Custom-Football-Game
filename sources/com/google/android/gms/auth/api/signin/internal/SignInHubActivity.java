package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.C0442W.C0443a;
import android.support.p000v4.content.C0511c;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import p005cm.aptoide.p006pt.account.AccountAnalytics;

@KeepName
public class SignInHubActivity extends C0014p {

    /* renamed from: a */
    private static boolean f19471a = false;

    /* renamed from: b */
    private boolean f19472b = false;

    /* renamed from: c */
    private SignInConfiguration f19473c;

    /* renamed from: d */
    private boolean f19474d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f19475e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Intent f19476f;

    /* renamed from: com.google.android.gms.auth.api.signin.internal.SignInHubActivity$a */
    private class C8618a implements C0443a<Void> {
        private C8618a() {
        }

        public final C0511c<Void> onCreateLoader(int i, Bundle bundle) {
            return new zze(SignInHubActivity.this, GoogleApiClient.m21145e());
        }

        /* renamed from: a */
        public final void mo5091a(C0511c<Void> cVar) {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5092a(C0511c cVar, Object obj) {
            SignInHubActivity signInHubActivity = SignInHubActivity.this;
            signInHubActivity.setResult(signInHubActivity.f19475e, SignInHubActivity.this.f19476f);
            SignInHubActivity.this.finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            m20987a(12500);
            return;
        }
        String str = "com.google.android.gms.auth.GOOGLE_SIGN_IN";
        String str2 = "AuthSignInClient";
        if (action.equals(str) || action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            String str3 = "config";
            this.f19473c = (SignInConfiguration) intent.getBundleExtra(str3).getParcelable(str3);
            if (this.f19473c == null) {
                Log.e(str2, "Activity started with invalid configuration.");
                setResult(0);
                finish();
                return;
            }
            if (!(bundle == null)) {
                this.f19474d = bundle.getBoolean("signingInGoogleApiClients");
                if (this.f19474d) {
                    this.f19475e = bundle.getInt("signInResultCode");
                    this.f19476f = (Intent) bundle.getParcelable("signInResultData");
                    m20986a();
                }
            } else if (f19471a) {
                setResult(0);
                m20987a(12502);
            } else {
                f19471a = true;
                Intent intent2 = new Intent(action);
                if (action.equals(str)) {
                    intent2.setPackage("com.google.android.gms");
                } else {
                    intent2.setPackage(getPackageName());
                }
                intent2.putExtra(str3, this.f19473c);
                try {
                    startActivityForResult(intent2, 40962);
                } catch (ActivityNotFoundException e) {
                    this.f19472b = true;
                    Log.w(str2, "Could not launch sign in Intent. Google Play Service is probably being updated...");
                    m20987a(17);
                }
            }
        } else {
            String str4 = "Unknown action: ";
            String valueOf = String.valueOf(intent.getAction());
            Log.e(str2, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f19474d);
        if (this.f19474d) {
            bundle.putInt("signInResultCode", this.f19475e);
            bundle.putParcelable("signInResultData", this.f19476f);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!this.f19472b) {
            setResult(0);
            if (i == 40962) {
                if (intent != null) {
                    String str = "signInAccount";
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra(str);
                    if (signInAccount == null || signInAccount.mo27213a() == null) {
                        String str2 = "errorCode";
                        if (intent.hasExtra(str2)) {
                            int intExtra = intent.getIntExtra(str2, 8);
                            if (intExtra == 13) {
                                intExtra = AccountAnalytics.UNKNOWN_STATUS_CODE;
                            }
                            m20987a(intExtra);
                            return;
                        }
                    } else {
                        GoogleSignInAccount a = signInAccount.mo27213a();
                        zzp.m21031a(this).mo27250a(this.f19473c.mo27222a(), a);
                        intent.removeExtra(str);
                        intent.putExtra("googleSignInAccount", a);
                        this.f19474d = true;
                        this.f19475e = i2;
                        this.f19476f = intent;
                        m20986a();
                        return;
                    }
                }
                m20987a(8);
            }
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    /* renamed from: a */
    private final void m20986a() {
        getSupportLoaderManager().mo5050a(0, null, new C8618a());
        f19471a = false;
    }

    /* renamed from: a */
    private final void m20987a(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f19471a = false;
    }
}
