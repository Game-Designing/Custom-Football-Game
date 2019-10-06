package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
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
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import p002b.p003c.p053g.p061f.C1253b;

/* renamed from: com.google.android.gms.common.api.internal.S */
final class C8653S implements zabs {

    /* renamed from: a */
    private final Context f19715a;

    /* renamed from: b */
    private final zaaw f19716b;

    /* renamed from: c */
    private final Looper f19717c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zabe f19718d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zabe f19719e;

    /* renamed from: f */
    private final Map<AnyClientKey<?>, zabe> f19720f;

    /* renamed from: g */
    private final Set<SignInConnectionListener> f19721g = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: h */
    private final Client f19722h;

    /* renamed from: i */
    private Bundle f19723i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ConnectionResult f19724j = null;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ConnectionResult f19725k = null;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f19726l = false;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final Lock f19727m;

    /* renamed from: n */
    private int f19728n = 0;

    /* renamed from: a */
    public static C8653S m21354a(Context context, zaaw zaaw, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<AnyClientKey<?>, Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList) {
        Map<Api<?>, Boolean> map3 = map2;
        C1253b bVar = new C1253b();
        C1253b bVar2 = new C1253b();
        Client client = null;
        for (Entry entry : map.entrySet()) {
            Client client2 = (Client) entry.getValue();
            if (client2.providesSignIn()) {
                client = client2;
            }
            if (client2.requiresSignIn()) {
                bVar.put((AnyClientKey) entry.getKey(), client2);
            } else {
                bVar2.put((AnyClientKey) entry.getKey(), client2);
            }
        }
        Preconditions.m21868b(!bVar.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        C1253b bVar3 = new C1253b();
        C1253b bVar4 = new C1253b();
        for (Api api : map2.keySet()) {
            AnyClientKey a = api.mo27324a();
            if (bVar.containsKey(a)) {
                bVar3.put(api, (Boolean) map3.get(api));
            } else if (bVar2.containsKey(a)) {
                bVar4.put(api, (Boolean) map3.get(api));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            zaq zaq = (zaq) obj;
            if (bVar3.containsKey(zaq.f19910a)) {
                arrayList2.add(zaq);
            } else if (bVar4.containsKey(zaq.f19910a)) {
                arrayList3.add(zaq);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        C8653S s = new C8653S(context, zaaw, lock, looper, googleApiAvailabilityLight, bVar, bVar2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, bVar3, bVar4);
        return s;
    }

    private C8653S(Context context, zaaw zaaw, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<AnyClientKey<?>, Client> map, Map<AnyClientKey<?>, Client> map2, ClientSettings clientSettings, AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, Client client, ArrayList<zaq> arrayList, ArrayList<zaq> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.f19715a = context;
        this.f19716b = zaaw;
        this.f19727m = lock;
        this.f19717c = looper;
        this.f19722h = client;
        Context context2 = context;
        Lock lock2 = lock;
        Looper looper2 = looper;
        GoogleApiAvailabilityLight googleApiAvailabilityLight2 = googleApiAvailabilityLight;
        zabe zabe = r3;
        zabe zabe2 = new zabe(context2, this.f19716b, lock2, looper2, googleApiAvailabilityLight2, map2, null, map4, null, arrayList2, new C8655U(this, null));
        this.f19718d = zabe;
        zabe zabe3 = new zabe(context2, this.f19716b, lock2, looper2, googleApiAvailabilityLight2, map, clientSettings, map3, abstractClientBuilder, arrayList, new C8656V(this, null));
        this.f19719e = zabe3;
        C1253b bVar = new C1253b();
        for (AnyClientKey put : map2.keySet()) {
            bVar.put(put, this.f19718d);
        }
        for (AnyClientKey put2 : map.keySet()) {
            bVar.put(put2, this.f19719e);
        }
        this.f19720f = Collections.unmodifiableMap(bVar);
    }

    /* renamed from: b */
    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T mo27549b(T t) {
        if (!m21365c((ApiMethodImpl<? extends Result, ? extends AnyClient>) t)) {
            return this.f19718d.mo27549b(t);
        }
        if (!m21373h()) {
            return this.f19719e.mo27549b(t);
        }
        t.mo27448c(new Status(4, null, m21368e()));
        return t;
    }

    /* renamed from: a */
    public final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T mo27546a(T t) {
        if (!m21365c((ApiMethodImpl<? extends Result, ? extends AnyClient>) t)) {
            return this.f19718d.mo27546a(t);
        }
        if (!m21373h()) {
            return this.f19719e.mo27546a(t);
        }
        t.mo27448c(new Status(4, null, m21368e()));
        return t;
    }

    public final void connect() {
        this.f19728n = 2;
        this.f19726l = false;
        this.f19725k = null;
        this.f19724j = null;
        this.f19718d.connect();
        this.f19719e.connect();
    }

    /* renamed from: c */
    public final ConnectionResult mo27551c() {
        throw new UnsupportedOperationException();
    }

    public final void disconnect() {
        this.f19725k = null;
        this.f19724j = null;
        this.f19728n = 0;
        this.f19718d.disconnect();
        this.f19719e.disconnect();
        m21372g();
    }

    public final boolean isConnected() {
        this.f19727m.lock();
        try {
            boolean z = true;
            if (!this.f19718d.isConnected() || (!this.f19719e.isConnected() && !m21373h() && this.f19728n != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.f19727m.unlock();
        }
    }

    /* renamed from: d */
    public final boolean mo27553d() {
        this.f19727m.lock();
        try {
            return this.f19728n == 2;
        } finally {
            this.f19727m.unlock();
        }
    }

    /* renamed from: a */
    public final boolean mo27548a(SignInConnectionListener signInConnectionListener) {
        this.f19727m.lock();
        try {
            if ((mo27553d() || isConnected()) && !this.f19719e.isConnected()) {
                this.f19721g.add(signInConnectionListener);
                if (this.f19728n == 0) {
                    this.f19728n = 1;
                }
                this.f19725k = null;
                this.f19719e.connect();
                return true;
            }
            this.f19727m.unlock();
            return false;
        } finally {
            this.f19727m.unlock();
        }
    }

    /* renamed from: a */
    public final void mo27547a() {
        this.f19718d.mo27547a();
        this.f19719e.mo27547a();
    }

    /* renamed from: b */
    public final void mo27550b() {
        this.f19727m.lock();
        try {
            boolean d = mo27553d();
            this.f19719e.disconnect();
            this.f19725k = new ConnectionResult(4);
            if (d) {
                new zap(this.f19717c).post(new C8654T(this));
            } else {
                m21372g();
            }
        } finally {
            this.f19727m.unlock();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final void m21371f() {
        if (m21364b(this.f19724j)) {
            if (m21364b(this.f19725k) || m21373h()) {
                int i = this.f19728n;
                if (i != 1) {
                    if (i != 2) {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        this.f19728n = 0;
                        return;
                    }
                    this.f19716b.mo27562a(this.f19723i);
                }
                m21372g();
                this.f19728n = 0;
                return;
            }
            ConnectionResult connectionResult = this.f19725k;
            if (connectionResult != null) {
                if (this.f19728n == 1) {
                    m21372g();
                    return;
                }
                m21358a(connectionResult);
                this.f19718d.disconnect();
            }
        } else if (this.f19724j == null || !m21364b(this.f19725k)) {
            ConnectionResult connectionResult2 = this.f19724j;
            if (connectionResult2 != null) {
                ConnectionResult connectionResult3 = this.f19725k;
                if (connectionResult3 != null) {
                    if (this.f19719e.f19851m < this.f19718d.f19851m) {
                        connectionResult2 = connectionResult3;
                    }
                    m21358a(connectionResult2);
                }
            }
        } else {
            this.f19719e.disconnect();
            m21358a(this.f19724j);
        }
    }

    /* renamed from: a */
    private final void m21358a(ConnectionResult connectionResult) {
        int i = this.f19728n;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.f19728n = 0;
            }
            this.f19716b.mo27563a(connectionResult);
        }
        m21372g();
        this.f19728n = 0;
    }

    /* renamed from: g */
    private final void m21372g() {
        for (SignInConnectionListener onComplete : this.f19721g) {
            onComplete.onComplete();
        }
        this.f19721g.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21356a(int i, boolean z) {
        this.f19716b.mo27561a(i, z);
        this.f19725k = null;
        this.f19724j = null;
    }

    /* renamed from: h */
    private final boolean m21373h() {
        ConnectionResult connectionResult = this.f19725k;
        return connectionResult != null && connectionResult.mo27275a() == 4;
    }

    /* renamed from: c */
    private final boolean m21365c(ApiMethodImpl<? extends Result, ? extends AnyClient> apiMethodImpl) {
        AnyClientKey h = apiMethodImpl.mo27450h();
        Preconditions.m21864a(this.f19720f.containsKey(h), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        return ((zabe) this.f19720f.get(h)).equals(this.f19719e);
    }

    /* renamed from: e */
    private final PendingIntent m21368e() {
        if (this.f19722h == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f19715a, System.identityHashCode(this.f19716b), this.f19722h.getSignInIntent(), 134217728);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21357a(Bundle bundle) {
        Bundle bundle2 = this.f19723i;
        if (bundle2 == null) {
            this.f19723i = bundle;
            return;
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    /* renamed from: b */
    private static boolean m21364b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.mo27281f();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = ":";
        printWriter.append(str).append("authClient").println(str2);
        String str3 = "  ";
        this.f19719e.dump(String.valueOf(str).concat(str3), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(str2);
        this.f19718d.dump(String.valueOf(str).concat(str3), fileDescriptor, printWriter, strArr);
    }
}
