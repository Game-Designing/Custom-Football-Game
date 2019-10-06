package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zaj;
import com.google.android.gms.signin.zad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class zaak implements zabd {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zabe f19791a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Lock f19792b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f19793c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final GoogleApiAvailabilityLight f19794d;

    /* renamed from: e */
    private ConnectionResult f19795e;

    /* renamed from: f */
    private int f19796f;

    /* renamed from: g */
    private int f19797g = 0;

    /* renamed from: h */
    private int f19798h;

    /* renamed from: i */
    private final Bundle f19799i = new Bundle();

    /* renamed from: j */
    private final Set<AnyClientKey> f19800j = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public zad f19801k;

    /* renamed from: l */
    private boolean f19802l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f19803m;

    /* renamed from: n */
    private boolean f19804n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public IAccountAccessor f19805o;

    /* renamed from: p */
    private boolean f19806p;

    /* renamed from: q */
    private boolean f19807q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final ClientSettings f19808r;

    /* renamed from: s */
    private final Map<Api<?>, Boolean> f19809s;

    /* renamed from: t */
    private final AbstractClientBuilder<? extends zad, SignInOptions> f19810t;

    /* renamed from: u */
    private ArrayList<Future<?>> f19811u = new ArrayList<>();

    public zaak(zabe zabe, ClientSettings clientSettings, Map<Api<?>, Boolean> map, GoogleApiAvailabilityLight googleApiAvailabilityLight, AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, Lock lock, Context context) {
        this.f19791a = zabe;
        this.f19808r = clientSettings;
        this.f19809s = map;
        this.f19794d = googleApiAvailabilityLight;
        this.f19810t = abstractClientBuilder;
        this.f19792b = lock;
        this.f19793c = context;
    }

    /* renamed from: a */
    public final void mo27590a() {
        this.f19791a.f19845g.clear();
        this.f19803m = false;
        this.f19795e = null;
        this.f19797g = 0;
        this.f19802l = true;
        this.f19804n = false;
        this.f19806p = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api api : this.f19809s.keySet()) {
            Client client = (Client) this.f19791a.f19844f.get(api.mo27324a());
            z |= api.mo27326c().mo27330a() == 1;
            boolean booleanValue = ((Boolean) this.f19809s.get(api)).booleanValue();
            if (client.requiresSignIn()) {
                this.f19803m = true;
                if (booleanValue) {
                    this.f19800j.add(api.mo27324a());
                } else {
                    this.f19802l = false;
                }
            }
            hashMap.put(client, new C8668h(this, api, booleanValue));
        }
        if (z) {
            this.f19803m = false;
        }
        if (this.f19803m) {
            this.f19808r.mo27760a(Integer.valueOf(System.identityHashCode(this.f19791a.f19852n)));
            C8675o oVar = new C8675o(this, null);
            AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder = this.f19810t;
            Context context = this.f19793c;
            Looper g = this.f19791a.f19852n.mo27388g();
            ClientSettings clientSettings = this.f19808r;
            this.f19801k = (zad) abstractClientBuilder.mo27090a(context, g, clientSettings, clientSettings.mo27769j(), oVar, oVar);
        }
        this.f19798h = this.f19791a.f19844f.size();
        this.f19811u.add(zabh.m21543a().submit(new C8669i(this, hashMap)));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final boolean m21458b() {
        this.f19798h--;
        int i = this.f19798h;
        if (i > 0) {
            return false;
        }
        if (i < 0) {
            String str = "GoogleApiClientConnecting";
            Log.w(str, this.f19791a.f19852n.mo27603n());
            Log.wtf(str, "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            m21456b(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.f19795e;
        if (connectionResult == null) {
            return true;
        }
        this.f19791a.f19851m = this.f19796f;
        m21456b(connectionResult);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21449a(zaj zaj) {
        if (m21451a(0)) {
            ConnectionResult a = zaj.mo33168a();
            if (a.mo27281f()) {
                ResolveAccountResponse c = zaj.mo33169c();
                ConnectionResult c2 = c.mo27818c();
                if (!c2.mo27281f()) {
                    String valueOf = String.valueOf(c2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                    sb.append("Sign-in succeeded with resolve account failure: ");
                    sb.append(valueOf);
                    Log.wtf("GoogleApiClientConnecting", sb.toString(), new Exception());
                    m21456b(c2);
                    return;
                }
                this.f19804n = true;
                this.f19805o = c.mo27817a();
                this.f19806p = c.mo27819d();
                this.f19807q = c.mo27820e();
                m21461c();
            } else if (m21452a(a)) {
                m21464e();
                m21461c();
            } else {
                m21456b(a);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m21461c() {
        if (this.f19798h == 0) {
            if (!this.f19803m || this.f19804n) {
                ArrayList arrayList = new ArrayList();
                this.f19797g = 1;
                this.f19798h = this.f19791a.f19844f.size();
                for (AnyClientKey anyClientKey : this.f19791a.f19844f.keySet()) {
                    if (!this.f19791a.f19845g.containsKey(anyClientKey)) {
                        arrayList.add((Client) this.f19791a.f19844f.get(anyClientKey));
                    } else if (m21458b()) {
                        m21463d();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.f19811u.add(zabh.m21543a().submit(new C8672l(this, arrayList)));
                }
            }
        }
    }

    public final void onConnected(Bundle bundle) {
        if (m21451a(1)) {
            if (bundle != null) {
                this.f19799i.putAll(bundle);
            }
            if (m21458b()) {
                m21463d();
            }
        }
    }

    /* renamed from: a */
    public final void mo27591a(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (m21451a(1)) {
            m21457b(connectionResult, api, z);
            if (m21458b()) {
                m21463d();
            }
        }
    }

    /* renamed from: d */
    private final void m21463d() {
        this.f19791a.mo27610f();
        zabh.m21543a().execute(new C8667g(this));
        zad zad = this.f19801k;
        if (zad != null) {
            if (this.f19806p) {
                zad.mo33152a(this.f19805o, this.f19807q);
            }
            m21450a(false);
        }
        for (AnyClientKey anyClientKey : this.f19791a.f19845g.keySet()) {
            ((Client) this.f19791a.f19844f.get(anyClientKey)).disconnect();
        }
        this.f19791a.f19853o.mo27562a(this.f19799i.isEmpty() ? null : this.f19799i);
    }

    /* renamed from: b */
    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T mo27592b(T t) {
        this.f19791a.f19852n.f19820i.add(t);
        return t;
    }

    /* renamed from: a */
    public final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T mo27589a(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void connect() {
    }

    public final boolean disconnect() {
        m21467f();
        m21450a(true);
        this.f19791a.mo27605a((ConnectionResult) null);
        return true;
    }

    public final void onConnectionSuspended(int i) {
        m21456b(new ConnectionResult(8, null));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r7 != false) goto L_0x0026;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m21457b(com.google.android.gms.common.ConnectionResult r5, com.google.android.gms.common.api.Api<?> r6, boolean r7) {
        /*
            r4 = this;
            com.google.android.gms.common.api.Api$BaseClientBuilder r0 = r6.mo27326c()
            int r0 = r0.mo27330a()
            r1 = 0
            r2 = 1
            if (r7 == 0) goto L_0x0026
            boolean r7 = r5.mo27279e()
            if (r7 == 0) goto L_0x0015
            r7 = 1
            goto L_0x0024
        L_0x0015:
            com.google.android.gms.common.GoogleApiAvailabilityLight r7 = r4.f19794d
            int r3 = r5.mo27275a()
            android.content.Intent r7 = r7.mo27311a(r3)
            if (r7 == 0) goto L_0x0023
            r7 = 1
            goto L_0x0024
        L_0x0023:
            r7 = 0
        L_0x0024:
            if (r7 == 0) goto L_0x002f
        L_0x0026:
            com.google.android.gms.common.ConnectionResult r7 = r4.f19795e
            if (r7 == 0) goto L_0x0030
            int r7 = r4.f19796f
            if (r0 >= r7) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            goto L_0x0031
        L_0x0030:
            r1 = 1
        L_0x0031:
            if (r1 == 0) goto L_0x0037
            r4.f19795e = r5
            r4.f19796f = r0
        L_0x0037:
            com.google.android.gms.common.api.internal.zabe r7 = r4.f19791a
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.ConnectionResult> r7 = r7.f19845g
            com.google.android.gms.common.api.Api$AnyClientKey r6 = r6.mo27324a()
            r7.put(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zaak.m21457b(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.Api, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final void m21464e() {
        this.f19803m = false;
        this.f19791a.f19852n.f19828q = Collections.emptySet();
        for (AnyClientKey anyClientKey : this.f19800j) {
            if (!this.f19791a.f19845g.containsKey(anyClientKey)) {
                this.f19791a.f19845g.put(anyClientKey, new ConnectionResult(17, null));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m21452a(ConnectionResult connectionResult) {
        return this.f19802l && !connectionResult.mo27279e();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m21456b(ConnectionResult connectionResult) {
        m21467f();
        m21450a(!connectionResult.mo27279e());
        this.f19791a.mo27605a(connectionResult);
        this.f19791a.f19853o.mo27563a(connectionResult);
    }

    /* renamed from: a */
    private final void m21450a(boolean z) {
        zad zad = this.f19801k;
        if (zad != null) {
            if (zad.isConnected() && z) {
                this.f19801k.mo33151a();
            }
            this.f19801k.disconnect();
            if (this.f19808r.mo27770k()) {
                this.f19801k = null;
            }
            this.f19805o = null;
        }
    }

    /* renamed from: f */
    private final void m21467f() {
        ArrayList<Future<?>> arrayList = this.f19811u;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Future) obj).cancel(true);
        }
        this.f19811u.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public final Set<Scope> m21468g() {
        ClientSettings clientSettings = this.f19808r;
        if (clientSettings == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(clientSettings.mo27768i());
        Map f = this.f19808r.mo27765f();
        for (Api api : f.keySet()) {
            if (!this.f19791a.f19845g.containsKey(api.mo27324a())) {
                hashSet.addAll(((OptionalApiSettings) f.get(api)).f20072a);
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m21451a(int i) {
        if (this.f19797g == i) {
            return true;
        }
        String str = "GoogleApiClientConnecting";
        Log.w(str, this.f19791a.f19852n.mo27603n());
        String valueOf = String.valueOf(this);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
        sb.append("Unexpected callback in ");
        sb.append(valueOf);
        Log.w(str, sb.toString());
        int i2 = this.f19798h;
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("mRemainingConnections=");
        sb2.append(i2);
        Log.w(str, sb2.toString());
        String b = m21455b(this.f19797g);
        String b2 = m21455b(i);
        StringBuilder sb3 = new StringBuilder(String.valueOf(b).length() + 70 + String.valueOf(b2).length());
        sb3.append("GoogleApiClient connecting is in step ");
        sb3.append(b);
        sb3.append(" but received callback for step ");
        sb3.append(b2);
        Log.wtf(str, sb3.toString(), new Exception());
        m21456b(new ConnectionResult(8, null));
        return false;
    }

    /* renamed from: b */
    private static String m21455b(int i) {
        if (i == 0) {
            return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
        }
        if (i != 1) {
            return "UNKNOWN";
        }
        return "STEP_GETTING_REMOTE_SERVICE";
    }
}
