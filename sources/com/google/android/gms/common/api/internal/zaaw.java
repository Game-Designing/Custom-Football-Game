package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zaaw extends GoogleApiClient implements zabt {

    /* renamed from: b */
    private final Lock f19813b;

    /* renamed from: c */
    private boolean f19814c;

    /* renamed from: d */
    private final GmsClientEventManager f19815d;

    /* renamed from: e */
    private zabs f19816e = null;

    /* renamed from: f */
    private final int f19817f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Context f19818g;

    /* renamed from: h */
    private final Looper f19819h;
    @VisibleForTesting

    /* renamed from: i */
    final Queue<ApiMethodImpl<?, ?>> f19820i = new LinkedList();

    /* renamed from: j */
    private volatile boolean f19821j;

    /* renamed from: k */
    private long f19822k;

    /* renamed from: l */
    private long f19823l;

    /* renamed from: m */
    private final C8681u f19824m;

    /* renamed from: n */
    private final GoogleApiAvailability f19825n;
    @VisibleForTesting

    /* renamed from: o */
    private zabq f19826o;

    /* renamed from: p */
    final Map<AnyClientKey<?>, Client> f19827p;

    /* renamed from: q */
    Set<Scope> f19828q;

    /* renamed from: r */
    private final ClientSettings f19829r;

    /* renamed from: s */
    private final Map<Api<?>, Boolean> f19830s;

    /* renamed from: t */
    private final AbstractClientBuilder<? extends zad, SignInOptions> f19831t;

    /* renamed from: u */
    private final ListenerHolders f19832u;

    /* renamed from: v */
    private final ArrayList<zaq> f19833v;

    /* renamed from: w */
    private Integer f19834w;

    /* renamed from: x */
    Set<zacm> f19835x;

    /* renamed from: y */
    final zacp f19836y;

    /* renamed from: z */
    private final GmsClientEventState f19837z;

    public zaaw(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, Map<Api<?>, Boolean> map, List<ConnectionCallbacks> list, List<OnConnectionFailedListener> list2, Map<AnyClientKey<?>, Client> map2, int i, int i2, ArrayList<zaq> arrayList, boolean z) {
        Looper looper2 = looper;
        this.f19822k = ClientLibraryUtils.m22073a() ? 10000 : 120000;
        this.f19823l = 5000;
        this.f19828q = new HashSet();
        this.f19832u = new ListenerHolders();
        this.f19834w = null;
        this.f19835x = null;
        this.f19837z = new C8677q(this);
        this.f19818g = context;
        this.f19813b = lock;
        this.f19814c = false;
        this.f19815d = new GmsClientEventManager(looper, this.f19837z);
        this.f19819h = looper2;
        this.f19824m = new C8681u(this, looper);
        this.f19825n = googleApiAvailability;
        this.f19817f = i;
        if (this.f19817f >= 0) {
            this.f19834w = Integer.valueOf(i2);
        }
        this.f19830s = map;
        this.f19827p = map2;
        this.f19833v = arrayList;
        this.f19836y = new zacp(this.f19827p);
        for (ConnectionCallbacks a : list) {
            this.f19815d.mo27785a(a);
        }
        for (OnConnectionFailedListener a2 : list2) {
            this.f19815d.mo27786a(a2);
        }
        this.f19829r = clientSettings;
        this.f19831t = abstractClientBuilder;
    }

    /* renamed from: a */
    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T mo27377a(T t) {
        Preconditions.m21864a(t.mo27450h() != null, (Object) "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.f19827p.containsKey(t.mo27450h());
        String b = t.mo27449g() != null ? t.mo27449g().mo27325b() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(b).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(b);
        sb.append(" required for this call.");
        Preconditions.m21864a(containsKey, (Object) sb.toString());
        this.f19813b.lock();
        try {
            if (this.f19816e == null) {
                this.f19820i.add(t);
                return t;
            }
            T b2 = this.f19816e.mo27549b(t);
            this.f19813b.unlock();
            return b2;
        } finally {
            this.f19813b.unlock();
        }
    }

    /* renamed from: b */
    public final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T mo27383b(T t) {
        Preconditions.m21864a(t.mo27450h() != null, (Object) "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.f19827p.containsKey(t.mo27450h());
        String b = t.mo27449g() != null ? t.mo27449g().mo27325b() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(b).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(b);
        sb.append(" required for this call.");
        Preconditions.m21864a(containsKey, (Object) sb.toString());
        this.f19813b.lock();
        try {
            if (this.f19816e == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            } else if (this.f19821j) {
                this.f19820i.add(t);
                while (!this.f19820i.isEmpty()) {
                    ApiMethodImpl apiMethodImpl = (ApiMethodImpl) this.f19820i.remove();
                    this.f19836y.mo27621a(apiMethodImpl);
                    apiMethodImpl.mo27448c(Status.f19599c);
                }
                return t;
            } else {
                T a = this.f19816e.mo27546a(t);
                this.f19813b.unlock();
                return a;
            }
        } finally {
            this.f19813b.unlock();
        }
    }

    /* renamed from: a */
    public final <C extends Client> C mo27376a(AnyClientKey<C> anyClientKey) {
        C c = (Client) this.f19827p.get(anyClientKey);
        Preconditions.m21858a(c, (Object) "Appropriate Api was not requested.");
        return c;
    }

    /* renamed from: c */
    public final void mo27385c() {
        this.f19813b.lock();
        try {
            boolean z = false;
            if (this.f19817f >= 0) {
                if (this.f19834w != null) {
                    z = true;
                }
                Preconditions.m21868b(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f19834w == null) {
                this.f19834w = Integer.valueOf(m21483a((Iterable<Client>) this.f19827p.values(), false));
            } else if (this.f19834w.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            mo27598a(this.f19834w.intValue());
        } finally {
            this.f19813b.unlock();
        }
    }

    /* renamed from: a */
    public final void mo27598a(int i) {
        this.f19813b.lock();
        boolean z = true;
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Illegal sign-in mode: ");
            sb.append(i);
            Preconditions.m21864a(z, (Object) sb.toString());
            m21487b(i);
            m21492p();
        } finally {
            this.f19813b.unlock();
        }
    }

    /* renamed from: a */
    public final ConnectionResult mo27375a() {
        boolean z = true;
        Preconditions.m21868b(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.f19813b.lock();
        try {
            if (this.f19817f >= 0) {
                if (this.f19834w == null) {
                    z = false;
                }
                Preconditions.m21868b(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f19834w == null) {
                this.f19834w = Integer.valueOf(m21483a((Iterable<Client>) this.f19827p.values(), false));
            } else if (this.f19834w.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m21487b(this.f19834w.intValue());
            this.f19815d.mo27787b();
            return this.f19816e.mo27551c();
        } finally {
            this.f19813b.unlock();
        }
    }

    /* renamed from: d */
    public final void mo27386d() {
        this.f19813b.lock();
        try {
            this.f19836y.mo27620a();
            if (this.f19816e != null) {
                this.f19816e.disconnect();
            }
            this.f19832u.mo27531a();
            for (ApiMethodImpl apiMethodImpl : this.f19820i) {
                apiMethodImpl.mo27452a((C8646L) null);
                apiMethodImpl.mo27350a();
            }
            this.f19820i.clear();
            if (this.f19816e != null) {
                mo27601l();
                this.f19815d.mo27781a();
                this.f19813b.unlock();
            }
        } finally {
            this.f19813b.unlock();
        }
    }

    /* renamed from: k */
    public final void mo27600k() {
        mo27386d();
        mo27385c();
    }

    /* renamed from: b */
    public final PendingResult<Status> mo27382b() {
        Preconditions.m21868b(mo27599j(), "GoogleApiClient is not connected yet.");
        Preconditions.m21868b(this.f19834w.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult(this);
        if (this.f19827p.containsKey(Common.f20168a)) {
            m21484a(this, statusPendingResult, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient a = new Builder(this.f19818g).mo27391a(Common.f20170c).mo27393a((ConnectionCallbacks) new C8678r(this, atomicReference, statusPendingResult)).mo27394a((OnConnectionFailedListener) new C8679s(this, statusPendingResult)).mo27390a((Handler) this.f19824m).mo27395a();
            atomicReference.set(a);
            a.mo27385c();
        }
        return statusPendingResult;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21484a(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z) {
        Common.f20171d.mo27847a(googleApiClient).mo27402a((ResultCallback<? super R>) new C8680t<Object>(this, statusPendingResult, z, googleApiClient));
    }

    /* renamed from: j */
    public final boolean mo27599j() {
        zabs zabs = this.f19816e;
        return zabs != null && zabs.isConnected();
    }

    /* renamed from: b */
    private final void m21487b(int i) {
        Integer num = this.f19834w;
        if (num == null) {
            this.f19834w = Integer.valueOf(i);
        } else if (num.intValue() != i) {
            String c = m21490c(i);
            String c2 = m21490c(this.f19834w.intValue());
            StringBuilder sb = new StringBuilder(String.valueOf(c).length() + 51 + String.valueOf(c2).length());
            sb.append("Cannot use sign-in mode: ");
            sb.append(c);
            sb.append(". Mode was already set to ");
            sb.append(c2);
            throw new IllegalStateException(sb.toString());
        }
        if (this.f19816e == null) {
            boolean z = false;
            boolean z2 = false;
            for (Client client : this.f19827p.values()) {
                if (client.requiresSignIn()) {
                    z = true;
                }
                if (client.providesSignIn()) {
                    z2 = true;
                }
            }
            int intValue = this.f19834w.intValue();
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue != 3) {
                    }
                } else if (z) {
                    if (this.f19814c) {
                        zax zax = new zax(this.f19818g, this.f19813b, this.f19819h, this.f19825n, this.f19827p, this.f19829r, this.f19830s, this.f19831t, this.f19833v, this, true);
                        this.f19816e = zax;
                        return;
                    }
                    this.f19816e = C8653S.m21354a(this.f19818g, this, this.f19813b, this.f19819h, this.f19825n, this.f19827p, this.f19829r, this.f19830s, this.f19831t, this.f19833v);
                    return;
                }
            } else if (!z) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            } else if (z2) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            if (!this.f19814c || z2) {
                zabe zabe = new zabe(this.f19818g, this, this.f19813b, this.f19819h, this.f19825n, this.f19827p, this.f19829r, this.f19830s, this.f19831t, this.f19833v, this);
                this.f19816e = zabe;
                return;
            }
            zax zax2 = new zax(this.f19818g, this.f19813b, this.f19819h, this.f19825n, this.f19827p, this.f19829r, this.f19830s, this.f19831t, this.f19833v, this, false);
            this.f19816e = zax2;
        }
    }

    /* renamed from: p */
    private final void m21492p() {
        this.f19815d.mo27787b();
        this.f19816e.connect();
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public final void m21491o() {
        this.f19813b.lock();
        try {
            if (this.f19821j) {
                m21492p();
            }
        } finally {
            this.f19813b.unlock();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public final void m21493q() {
        this.f19813b.lock();
        try {
            if (mo27601l()) {
                m21492p();
            }
        } finally {
            this.f19813b.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public final boolean mo27601l() {
        if (!this.f19821j) {
            return false;
        }
        this.f19821j = false;
        this.f19824m.removeMessages(2);
        this.f19824m.removeMessages(1);
        zabq zabq = this.f19826o;
        if (zabq != null) {
            zabq.mo27611a();
            this.f19826o = null;
        }
        return true;
    }

    /* renamed from: a */
    public final void mo27378a(OnConnectionFailedListener onConnectionFailedListener) {
        this.f19815d.mo27786a(onConnectionFailedListener);
    }

    /* renamed from: b */
    public final void mo27384b(OnConnectionFailedListener onConnectionFailedListener) {
        this.f19815d.mo27788b(onConnectionFailedListener);
    }

    /* renamed from: a */
    public final void mo27562a(Bundle bundle) {
        while (!this.f19820i.isEmpty()) {
            mo27383b((T) (ApiMethodImpl) this.f19820i.remove());
        }
        this.f19815d.mo27783a(bundle);
    }

    /* renamed from: a */
    public final void mo27563a(ConnectionResult connectionResult) {
        if (!this.f19825n.mo27315b(this.f19818g, connectionResult.mo27275a())) {
            mo27601l();
        }
        if (!this.f19821j) {
            this.f19815d.mo27784a(connectionResult);
            this.f19815d.mo27781a();
        }
    }

    /* renamed from: a */
    public final void mo27561a(int i, boolean z) {
        if (i == 1 && !z && !this.f19821j) {
            this.f19821j = true;
            if (this.f19826o == null && !ClientLibraryUtils.m22073a()) {
                this.f19826o = this.f19825n.mo27300a(this.f19818g.getApplicationContext(), (zabr) new C8682v(this));
            }
            C8681u uVar = this.f19824m;
            uVar.sendMessageDelayed(uVar.obtainMessage(1), this.f19822k);
            C8681u uVar2 = this.f19824m;
            uVar2.sendMessageDelayed(uVar2.obtainMessage(2), this.f19823l);
        }
        this.f19836y.mo27622b();
        this.f19815d.mo27782a(i);
        this.f19815d.mo27781a();
        if (i == 2) {
            m21492p();
        }
    }

    /* renamed from: f */
    public final Context mo27387f() {
        return this.f19818g;
    }

    /* renamed from: g */
    public final Looper mo27388g() {
        return this.f19819h;
    }

    /* renamed from: a */
    public final boolean mo27381a(SignInConnectionListener signInConnectionListener) {
        zabs zabs = this.f19816e;
        return zabs != null && zabs.mo27548a(signInConnectionListener);
    }

    /* renamed from: h */
    public final void mo27389h() {
        zabs zabs = this.f19816e;
        if (zabs != null) {
            zabs.mo27550b();
        }
    }

    /* renamed from: a */
    public final void mo27379a(zacm zacm) {
        this.f19813b.lock();
        try {
            String str = "GoogleApiClientImpl";
            if (this.f19835x == null) {
                Log.wtf(str, "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.f19835x.remove(zacm)) {
                Log.wtf(str, "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!mo27602m()) {
                this.f19816e.mo27547a();
            }
        } finally {
            this.f19813b.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public final boolean mo27602m() {
        this.f19813b.lock();
        try {
            if (this.f19835x == null) {
                this.f19813b.unlock();
                return false;
            }
            boolean z = !this.f19835x.isEmpty();
            this.f19813b.unlock();
            return z;
        } catch (Throwable th) {
            this.f19813b.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public final String mo27603n() {
        StringWriter stringWriter = new StringWriter();
        mo27380a("", (FileDescriptor) null, new PrintWriter(stringWriter), (String[]) null);
        return stringWriter.toString();
    }

    /* renamed from: a */
    public final void mo27380a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.f19818g);
        printWriter.append(str).append("mResuming=").print(this.f19821j);
        printWriter.append(" mWorkQueue.size()=").print(this.f19820i.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f19836y.f19882c.size());
        zabs zabs = this.f19816e;
        if (zabs != null) {
            zabs.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    /* renamed from: a */
    public static int m21483a(Iterable<Client> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Client client : iterable) {
            if (client.requiresSignIn()) {
                z2 = true;
            }
            if (client.providesSignIn()) {
                z3 = true;
            }
        }
        if (!z2) {
            return 3;
        }
        if (!z3 || !z) {
            return 1;
        }
        return 2;
    }

    /* renamed from: c */
    private static String m21490c(int i) {
        if (i == 1) {
            return "SIGN_IN_MODE_REQUIRED";
        }
        if (i == 2) {
            return "SIGN_IN_MODE_OPTIONAL";
        }
        if (i != 3) {
            return "UNKNOWN";
        }
        return "SIGN_IN_MODE_NONE";
    }
}
