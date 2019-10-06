package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import p002b.p003c.p053g.p061f.C1253b;

public final class zax implements zabs {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Map<AnyClientKey<?>, zaw<?>> f19917a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<AnyClientKey<?>, zaw<?>> f19918b = new HashMap();

    /* renamed from: c */
    private final Map<Api<?>, Boolean> f19919c;

    /* renamed from: d */
    private final GoogleApiManager f19920d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zaaw f19921e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Lock f19922f;

    /* renamed from: g */
    private final Looper f19923g;

    /* renamed from: h */
    private final GoogleApiAvailabilityLight f19924h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Condition f19925i;

    /* renamed from: j */
    private final ClientSettings f19926j;

    /* renamed from: k */
    private final boolean f19927k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final boolean f19928l;

    /* renamed from: m */
    private final Queue<ApiMethodImpl<?, ?>> f19929m = new LinkedList();
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f19930n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Map<zai<?>, ConnectionResult> f19931o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Map<zai<?>, ConnectionResult> f19932p;

    /* renamed from: q */
    private C8661a f19933q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ConnectionResult f19934r;

    public zax(Context context, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<AnyClientKey<?>, Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList, zaaw zaaw, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.f19922f = lock;
        this.f19923g = looper;
        this.f19925i = lock.newCondition();
        this.f19924h = googleApiAvailabilityLight;
        this.f19921e = zaaw;
        this.f19919c = map2;
        this.f19926j = clientSettings;
        this.f19927k = z;
        HashMap hashMap = new HashMap();
        for (Api api : map2.keySet()) {
            hashMap.put(api.mo27324a(), api);
        }
        HashMap hashMap2 = new HashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            zaq zaq = (zaq) obj;
            hashMap2.put(zaq.f19910a, zaq);
        }
        boolean z5 = true;
        boolean z6 = false;
        boolean z7 = true;
        boolean z8 = false;
        for (Entry entry : map.entrySet()) {
            Api api2 = (Api) hashMap.get(entry.getKey());
            Client client = (Client) entry.getValue();
            if (!client.requiresGooglePlayServices()) {
                z2 = z6;
                z4 = z8;
                z3 = false;
            } else if (!((Boolean) this.f19919c.get(api2)).booleanValue()) {
                z3 = z7;
                z4 = true;
                z2 = true;
            } else {
                z3 = z7;
                z4 = z8;
                z2 = true;
            }
            zaw zaw = r1;
            zaw zaw2 = new zaw(context, api2, looper, client, (zaq) hashMap2.get(api2), clientSettings, abstractClientBuilder);
            this.f19917a.put((AnyClientKey) entry.getKey(), zaw);
            if (client.requiresSignIn()) {
                this.f19918b.put((AnyClientKey) entry.getKey(), zaw);
            }
            z8 = z4;
            z7 = z3;
            z6 = z2;
        }
        if (!z6 || z7 || z8) {
            z5 = false;
        }
        this.f19928l = z5;
        this.f19920d = GoogleApiManager.m21238c();
    }

    /* renamed from: b */
    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T mo27549b(T t) {
        if (this.f19927k && m21656c(t)) {
            return t;
        }
        if (!isConnected()) {
            this.f19929m.add(t);
            return t;
        }
        this.f19921e.f19836y.mo27621a(t);
        return ((zaw) this.f19917a.get(t.mo27450h())).mo27359a(t);
    }

    /* renamed from: a */
    public final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T mo27546a(T t) {
        AnyClientKey h = t.mo27450h();
        if (this.f19927k && m21656c(t)) {
            return t;
        }
        this.f19921e.f19836y.mo27621a(t);
        return ((zaw) this.f19917a.get(h)).mo27362b(t);
    }

    /* renamed from: c */
    private final <T extends ApiMethodImpl<? extends Result, ? extends AnyClient>> boolean m21656c(T t) {
        AnyClientKey h = t.mo27450h();
        ConnectionResult a = m21646a(h);
        if (a == null || a.mo27275a() != 4) {
            return false;
        }
        t.mo27448c(new Status(4, null, this.f19920d.mo27467a(((zaw) this.f19917a.get(h)).mo27368g(), System.identityHashCode(this.f19921e))));
        return true;
    }

    public final void connect() {
        this.f19922f.lock();
        try {
            if (!this.f19930n) {
                this.f19930n = true;
                this.f19931o = null;
                this.f19932p = null;
                this.f19933q = null;
                this.f19934r = null;
                this.f19920d.mo27478g();
                this.f19920d.mo27468a((Iterable<? extends GoogleApi<?>>) this.f19917a.values()).mo33175a(new HandlerExecutor(this.f19923g), new C8658X(this));
                this.f19922f.unlock();
            }
        } finally {
            this.f19922f.unlock();
        }
    }

    /* renamed from: c */
    public final ConnectionResult mo27551c() {
        connect();
        while (mo27637d()) {
            try {
                this.f19925i.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.f19510a;
        }
        ConnectionResult connectionResult = this.f19934r;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, null);
    }

    public final void disconnect() {
        this.f19922f.lock();
        try {
            this.f19930n = false;
            this.f19931o = null;
            this.f19932p = null;
            if (this.f19933q != null) {
                this.f19933q.mo27567a();
                this.f19933q = null;
            }
            this.f19934r = null;
            while (!this.f19929m.isEmpty()) {
                ApiMethodImpl apiMethodImpl = (ApiMethodImpl) this.f19929m.remove();
                apiMethodImpl.mo27452a((C8646L) null);
                apiMethodImpl.mo27350a();
            }
            this.f19925i.signalAll();
        } finally {
            this.f19922f.unlock();
        }
    }

    /* renamed from: a */
    public final ConnectionResult mo27636a(Api<?> api) {
        return m21646a(api.mo27324a());
    }

    /* renamed from: a */
    private final ConnectionResult m21646a(AnyClientKey<?> anyClientKey) {
        this.f19922f.lock();
        try {
            zaw zaw = (zaw) this.f19917a.get(anyClientKey);
            if (this.f19931o != null && zaw != null) {
                return (ConnectionResult) this.f19931o.get(zaw.mo27368g());
            }
            this.f19922f.unlock();
            return null;
        } finally {
            this.f19922f.unlock();
        }
    }

    public final boolean isConnected() {
        this.f19922f.lock();
        try {
            return this.f19931o != null && this.f19934r == null;
        } finally {
            this.f19922f.unlock();
        }
    }

    /* renamed from: d */
    public final boolean mo27637d() {
        this.f19922f.lock();
        try {
            return this.f19931o == null && this.f19930n;
        } finally {
            this.f19922f.unlock();
        }
    }

    /* renamed from: e */
    private final boolean m21658e() {
        this.f19922f.lock();
        try {
            if (this.f19930n) {
                if (this.f19927k) {
                    for (AnyClientKey a : this.f19918b.keySet()) {
                        ConnectionResult a2 = m21646a(a);
                        if (a2 != null) {
                            if (!a2.mo27281f()) {
                            }
                        }
                        this.f19922f.unlock();
                        return false;
                    }
                    this.f19922f.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            this.f19922f.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public final boolean mo27548a(SignInConnectionListener signInConnectionListener) {
        this.f19922f.lock();
        try {
            if (!this.f19930n || m21658e()) {
                this.f19922f.unlock();
                return false;
            }
            this.f19920d.mo27478g();
            this.f19933q = new C8661a(this, signInConnectionListener);
            this.f19920d.mo27468a((Iterable<? extends GoogleApi<?>>) this.f19918b.values()).mo33175a(new HandlerExecutor(this.f19923g), this.f19933q);
            this.f19922f.unlock();
            return true;
        } catch (Throwable th) {
            this.f19922f.unlock();
            throw th;
        }
    }

    /* renamed from: b */
    public final void mo27550b() {
        this.f19922f.lock();
        try {
            this.f19920d.mo27469a();
            if (this.f19933q != null) {
                this.f19933q.mo27567a();
                this.f19933q = null;
            }
            if (this.f19932p == null) {
                this.f19932p = new C1253b(this.f19918b.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            for (zaw g : this.f19918b.values()) {
                this.f19932p.put(g.mo27368g(), connectionResult);
            }
            if (this.f19931o != null) {
                this.f19931o.putAll(this.f19932p);
            }
        } finally {
            this.f19922f.unlock();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* renamed from: a */
    public final void mo27547a() {
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final void m21661f() {
        ClientSettings clientSettings = this.f19926j;
        if (clientSettings == null) {
            this.f19921e.f19828q = Collections.emptySet();
            return;
        }
        HashSet hashSet = new HashSet(clientSettings.mo27768i());
        Map f = this.f19926j.mo27765f();
        for (Api api : f.keySet()) {
            ConnectionResult a = mo27636a(api);
            if (a != null && a.mo27281f()) {
                hashSet.addAll(((OptionalApiSettings) f.get(api)).f20072a);
            }
        }
        this.f19921e.f19828q = hashSet;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public final void m21663g() {
        while (!this.f19929m.isEmpty()) {
            mo27546a((T) (ApiMethodImpl) this.f19929m.remove());
        }
        this.f19921e.mo27562a((Bundle) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m21650a(zaw<?> zaw, ConnectionResult connectionResult) {
        return !connectionResult.mo27281f() && !connectionResult.mo27279e() && ((Boolean) this.f19919c.get(zaw.mo27364c())).booleanValue() && zaw.mo27635h().requiresGooglePlayServices() && this.f19924h.mo27307c(connectionResult.mo27275a());
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public final ConnectionResult m21664h() {
        ConnectionResult connectionResult = null;
        ConnectionResult connectionResult2 = null;
        int i = 0;
        int i2 = 0;
        for (zaw zaw : this.f19917a.values()) {
            Api c = zaw.mo27364c();
            ConnectionResult connectionResult3 = (ConnectionResult) this.f19931o.get(zaw.mo27368g());
            if (!connectionResult3.mo27281f() && (!((Boolean) this.f19919c.get(c)).booleanValue() || connectionResult3.mo27279e() || this.f19924h.mo27307c(connectionResult3.mo27275a()))) {
                if (connectionResult3.mo27275a() != 4 || !this.f19927k) {
                    int a = c.mo27326c().mo27330a();
                    if (connectionResult == null || i > a) {
                        connectionResult = connectionResult3;
                        i = a;
                    }
                } else {
                    int a2 = c.mo27326c().mo27330a();
                    if (connectionResult2 == null || i2 > a2) {
                        connectionResult2 = connectionResult3;
                        i2 = a2;
                    }
                }
            }
        }
        if (connectionResult == null || connectionResult2 == null || i <= i2) {
            return connectionResult;
        }
        return connectionResult2;
    }
}
