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
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zabe implements zabs, zar {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Lock f19839a;

    /* renamed from: b */
    private final Condition f19840b;

    /* renamed from: c */
    private final Context f19841c;

    /* renamed from: d */
    private final GoogleApiAvailabilityLight f19842d;

    /* renamed from: e */
    private final C8684x f19843e;

    /* renamed from: f */
    final Map<AnyClientKey<?>, Client> f19844f;

    /* renamed from: g */
    final Map<AnyClientKey<?>, ConnectionResult> f19845g = new HashMap();

    /* renamed from: h */
    private final ClientSettings f19846h;

    /* renamed from: i */
    private final Map<Api<?>, Boolean> f19847i;

    /* renamed from: j */
    private final AbstractClientBuilder<? extends zad, SignInOptions> f19848j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public volatile zabd f19849k;

    /* renamed from: l */
    private ConnectionResult f19850l = null;

    /* renamed from: m */
    int f19851m;

    /* renamed from: n */
    final zaaw f19852n;

    /* renamed from: o */
    final zabt f19853o;

    public zabe(Context context, zaaw zaaw, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<AnyClientKey<?>, Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList, zabt zabt) {
        this.f19841c = context;
        this.f19839a = lock;
        this.f19842d = googleApiAvailabilityLight;
        this.f19844f = map;
        this.f19846h = clientSettings;
        this.f19847i = map2;
        this.f19848j = abstractClientBuilder;
        this.f19852n = zaaw;
        this.f19853o = zabt;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((zaq) obj).mo27634a(this);
        }
        this.f19843e = new C8684x(this, looper);
        this.f19840b = lock.newCondition();
        this.f19849k = new zaav(this);
    }

    /* renamed from: b */
    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T mo27549b(T t) {
        t.mo27458f();
        return this.f19849k.mo27592b(t);
    }

    /* renamed from: a */
    public final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T mo27546a(T t) {
        t.mo27458f();
        return this.f19849k.mo27589a(t);
    }

    public final void connect() {
        this.f19849k.connect();
    }

    /* renamed from: c */
    public final ConnectionResult mo27551c() {
        connect();
        while (mo27608d()) {
            try {
                this.f19840b.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.f19510a;
        }
        ConnectionResult connectionResult = this.f19850l;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, null);
    }

    public final void disconnect() {
        if (this.f19849k.disconnect()) {
            this.f19845g.clear();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public final void mo27609e() {
        this.f19839a.lock();
        try {
            zaak zaak = new zaak(this, this.f19846h, this.f19847i, this.f19842d, this.f19848j, this.f19839a, this.f19841c);
            this.f19849k = zaak;
            this.f19849k.mo27590a();
            this.f19840b.signalAll();
        } finally {
            this.f19839a.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public final void mo27610f() {
        this.f19839a.lock();
        try {
            this.f19852n.mo27601l();
            this.f19849k = new zaah(this);
            this.f19849k.mo27590a();
            this.f19840b.signalAll();
        } finally {
            this.f19839a.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo27605a(ConnectionResult connectionResult) {
        this.f19839a.lock();
        try {
            this.f19850l = connectionResult;
            this.f19849k = new zaav(this);
            this.f19849k.mo27590a();
            this.f19840b.signalAll();
        } finally {
            this.f19839a.unlock();
        }
    }

    public final boolean isConnected() {
        return this.f19849k instanceof zaah;
    }

    /* renamed from: d */
    public final boolean mo27608d() {
        return this.f19849k instanceof zaak;
    }

    /* renamed from: a */
    public final boolean mo27548a(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    /* renamed from: b */
    public final void mo27550b() {
    }

    /* renamed from: a */
    public final void mo27547a() {
        if (isConnected()) {
            ((zaah) this.f19849k).mo27593b();
        }
    }

    /* renamed from: a */
    public final void mo27488a(ConnectionResult connectionResult, Api<?> api, boolean z) {
        this.f19839a.lock();
        try {
            this.f19849k.mo27591a(connectionResult, api, z);
        } finally {
            this.f19839a.unlock();
        }
    }

    public final void onConnected(Bundle bundle) {
        this.f19839a.lock();
        try {
            this.f19849k.onConnected(bundle);
        } finally {
            this.f19839a.unlock();
        }
    }

    public final void onConnectionSuspended(int i) {
        this.f19839a.lock();
        try {
            this.f19849k.onConnectionSuspended(i);
        } finally {
            this.f19839a.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo27606a(C8683w wVar) {
        this.f19843e.sendMessage(this.f19843e.obtainMessage(1, wVar));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo27607a(RuntimeException runtimeException) {
        this.f19843e.sendMessage(this.f19843e.obtainMessage(2, runtimeException));
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.f19849k);
        for (Api api : this.f19847i.keySet()) {
            printWriter.append(str).append(api.mo27325b()).println(":");
            ((Client) this.f19844f.get(api.mo27324a())).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }
}
