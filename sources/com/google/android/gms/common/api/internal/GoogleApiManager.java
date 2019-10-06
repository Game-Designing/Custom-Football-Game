package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.signin.zad;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import p002b.p003c.p053g.p061f.C1253b;
import p002b.p003c.p053g.p061f.C1255d;
import p005cm.aptoide.p006pt.database.realm.Notification;

@KeepForSdk
public class GoogleApiManager implements Callback {

    /* renamed from: a */
    public static final Status f19645a = new Status(4, "Sign-out occurred while this API call was in progress.");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Status f19646b = new Status(4, "The user must be signed in to make this API call.");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Object f19647c = new Object();

    /* renamed from: d */
    private static GoogleApiManager f19648d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f19649e = 5000;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f19650f = 120000;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f19651g = 10000;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final Context f19652h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final GoogleApiAvailability f19653i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final GoogleApiAvailabilityCache f19654j;

    /* renamed from: k */
    private final AtomicInteger f19655k = new AtomicInteger(1);

    /* renamed from: l */
    private final AtomicInteger f19656l = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final Map<zai<?>, zaa<?>> f19657m = new ConcurrentHashMap(5, 0.75f, 1);
    /* access modifiers changed from: private */

    /* renamed from: n */
    public zaae f19658n = null;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final Set<zai<?>> f19659o = new C1255d();

    /* renamed from: p */
    private final Set<zai<?>> f19660p = new C1255d();
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final Handler f19661q;

    /* renamed from: com.google.android.gms.common.api.internal.GoogleApiManager$a */
    private static class C8640a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final zai<?> f19662a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final Feature f19663b;

        private C8640a(zai<?> zai, Feature feature) {
            this.f19662a = zai;
            this.f19663b = feature;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof C8640a)) {
                return false;
            }
            C8640a aVar = (C8640a) obj;
            if (!Objects.m21851a(this.f19662a, aVar.f19662a) || !Objects.m21851a(this.f19663b, aVar.f19663b)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return Objects.m21849a(this.f19662a, this.f19663b);
        }

        public final String toString() {
            return Objects.m21850a((Object) this).mo27810a(Notification.KEY, this.f19662a).mo27810a("feature", this.f19663b).toString();
        }

        /* synthetic */ C8640a(zai zai, Feature feature, C8685y yVar) {
            this(zai, feature);
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.GoogleApiManager$b */
    private class C8641b implements zach, ConnectionProgressReportCallbacks {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Client f19664a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final zai<?> f19665b;

        /* renamed from: c */
        private IAccountAccessor f19666c = null;

        /* renamed from: d */
        private Set<Scope> f19667d = null;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public boolean f19668e = false;

        public C8641b(Client client, zai<?> zai) {
            this.f19664a = client;
            this.f19665b = zai;
        }

        /* renamed from: a */
        public final void mo27483a(ConnectionResult connectionResult) {
            GoogleApiManager.this.f19661q.post(new C8637E(this, connectionResult));
        }

        /* renamed from: b */
        public final void mo27485b(ConnectionResult connectionResult) {
            ((zaa) GoogleApiManager.this.f19657m.get(this.f19665b)).mo27487a(connectionResult);
        }

        /* renamed from: a */
        public final void mo27484a(IAccountAccessor iAccountAccessor, Set<Scope> set) {
            if (iAccountAccessor == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                mo27485b(new ConnectionResult(4));
                return;
            }
            this.f19666c = iAccountAccessor;
            this.f19667d = set;
            m21263a();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final void m21263a() {
            if (this.f19668e) {
                IAccountAccessor iAccountAccessor = this.f19666c;
                if (iAccountAccessor != null) {
                    this.f19664a.getRemoteService(iAccountAccessor, this.f19667d);
                }
            }
        }
    }

    public class zaa<O extends ApiOptions> implements ConnectionCallbacks, OnConnectionFailedListener, zar {

        /* renamed from: a */
        private final Queue<zab> f19670a = new LinkedList();
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final Client f19671b;

        /* renamed from: c */
        private final AnyClient f19672c;

        /* renamed from: d */
        private final zai<O> f19673d;

        /* renamed from: e */
        private final zaab f19674e;

        /* renamed from: f */
        private final Set<zak> f19675f = new HashSet();

        /* renamed from: g */
        private final Map<ListenerKey<?>, zabw> f19676g = new HashMap();

        /* renamed from: h */
        private final int f19677h;

        /* renamed from: i */
        private final zace f19678i;

        /* renamed from: j */
        private boolean f19679j;

        /* renamed from: k */
        private final List<C8640a> f19680k = new ArrayList();

        /* renamed from: l */
        private ConnectionResult f19681l = null;

        public zaa(GoogleApi<O> googleApi) {
            this.f19671b = googleApi.mo27357a(GoogleApiManager.this.f19661q.getLooper(), this);
            Client client = this.f19671b;
            if (client instanceof SimpleClientAdapter) {
                this.f19672c = ((SimpleClientAdapter) client).mo27247k();
            } else {
                this.f19672c = client;
            }
            this.f19673d = googleApi.mo27368g();
            this.f19674e = new zaab();
            this.f19677h = googleApi.mo27366e();
            if (this.f19671b.requiresSignIn()) {
                this.f19678i = googleApi.mo27360a(GoogleApiManager.this.f19652h, GoogleApiManager.this.f19661q);
            } else {
                this.f19678i = null;
            }
        }

        public final void onConnected(Bundle bundle) {
            if (Looper.myLooper() == GoogleApiManager.this.f19661q.getLooper()) {
                m21284n();
            } else {
                GoogleApiManager.this.f19661q.post(new C8686z(this));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: n */
        public final void m21284n() {
            mo27500j();
            m21282c(ConnectionResult.f19510a);
            m21287q();
            Iterator it = this.f19676g.values().iterator();
            while (it.hasNext()) {
                zabw zabw = (zabw) it.next();
                if (m21270a(zabw.f19862a.mo27544c()) != null) {
                    it.remove();
                } else {
                    try {
                        zabw.f19862a.mo27542a(this.f19672c, new TaskCompletionSource());
                    } catch (DeadObjectException e) {
                        onConnectionSuspended(1);
                        this.f19671b.disconnect();
                    } catch (RemoteException e2) {
                        it.remove();
                    }
                }
            }
            m21286p();
            m21288r();
        }

        public final void onConnectionSuspended(int i) {
            if (Looper.myLooper() == GoogleApiManager.this.f19661q.getLooper()) {
                m21285o();
            } else {
                GoogleApiManager.this.f19661q.post(new C8632A(this));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: o */
        public final void m21285o() {
            mo27500j();
            this.f19679j = true;
            this.f19674e.mo27585c();
            GoogleApiManager.this.f19661q.sendMessageDelayed(Message.obtain(GoogleApiManager.this.f19661q, 9, this.f19673d), GoogleApiManager.this.f19649e);
            GoogleApiManager.this.f19661q.sendMessageDelayed(Message.obtain(GoogleApiManager.this.f19661q, 11, this.f19673d), GoogleApiManager.this.f19650f);
            GoogleApiManager.this.f19654j.mo27801a();
        }

        /* renamed from: a */
        public final void mo27487a(ConnectionResult connectionResult) {
            Preconditions.m21860a(GoogleApiManager.this.f19661q);
            this.f19671b.disconnect();
            onConnectionFailed(connectionResult);
        }

        /* renamed from: b */
        private final boolean m21279b(ConnectionResult connectionResult) {
            synchronized (GoogleApiManager.f19647c) {
                if (GoogleApiManager.this.f19658n == null || !GoogleApiManager.this.f19659o.contains(this.f19673d)) {
                    return false;
                }
                GoogleApiManager.this.f19658n.mo27631b(connectionResult, this.f19677h);
                return true;
            }
        }

        /* renamed from: a */
        public final void mo27488a(ConnectionResult connectionResult, Api<?> api, boolean z) {
            if (Looper.myLooper() == GoogleApiManager.this.f19661q.getLooper()) {
                onConnectionFailed(connectionResult);
            } else {
                GoogleApiManager.this.f19661q.post(new C8633B(this, connectionResult));
            }
        }

        public final void onConnectionFailed(ConnectionResult connectionResult) {
            Preconditions.m21860a(GoogleApiManager.this.f19661q);
            zace zace = this.f19678i;
            if (zace != null) {
                zace.mo27618b();
            }
            mo27500j();
            GoogleApiManager.this.f19654j.mo27801a();
            m21282c(connectionResult);
            if (connectionResult.mo27275a() == 4) {
                mo27489a(GoogleApiManager.f19646b);
            } else if (this.f19670a.isEmpty()) {
                this.f19681l = connectionResult;
            } else {
                if (!m21279b(connectionResult) && !GoogleApiManager.this.mo27476b(connectionResult, this.f19677h)) {
                    if (connectionResult.mo27275a() == 18) {
                        this.f19679j = true;
                    }
                    if (this.f19679j) {
                        GoogleApiManager.this.f19661q.sendMessageDelayed(Message.obtain(GoogleApiManager.this.f19661q, 9, this.f19673d), GoogleApiManager.this.f19649e);
                        return;
                    }
                    String a = this.f19673d.mo27623a();
                    StringBuilder sb = new StringBuilder(String.valueOf(a).length() + 38);
                    sb.append("API: ");
                    sb.append(a);
                    sb.append(" is not available on this device.");
                    mo27489a(new Status(17, sb.toString()));
                }
            }
        }

        /* renamed from: p */
        private final void m21286p() {
            ArrayList arrayList = new ArrayList(this.f19670a);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                zab zab = (zab) obj;
                if (!this.f19671b.isConnected()) {
                    return;
                }
                if (m21280b(zab)) {
                    this.f19670a.remove(zab);
                }
            }
        }

        /* renamed from: a */
        public final void mo27490a(zab zab) {
            Preconditions.m21860a(GoogleApiManager.this.f19661q);
            if (!this.f19671b.isConnected()) {
                this.f19670a.add(zab);
                ConnectionResult connectionResult = this.f19681l;
                if (connectionResult == null || !connectionResult.mo27279e()) {
                    mo27486a();
                } else {
                    onConnectionFailed(this.f19681l);
                }
            } else if (m21280b(zab)) {
                m21288r();
            } else {
                this.f19670a.add(zab);
            }
        }

        /* renamed from: h */
        public final void mo27498h() {
            Preconditions.m21860a(GoogleApiManager.this.f19661q);
            mo27489a(GoogleApiManager.f19645a);
            this.f19674e.mo27584b();
            for (ListenerKey zah : (ListenerKey[]) this.f19676g.keySet().toArray(new ListenerKey[this.f19676g.size()])) {
                mo27490a((zab) new zah(zah, new TaskCompletionSource()));
            }
            m21282c(new ConnectionResult(4));
            if (this.f19671b.isConnected()) {
                this.f19671b.onUserSignOut(new C8635C(this));
            }
        }

        /* renamed from: f */
        public final Client mo27496f() {
            return this.f19671b;
        }

        /* renamed from: i */
        public final Map<ListenerKey<?>, zabw> mo27499i() {
            return this.f19676g;
        }

        /* renamed from: j */
        public final void mo27500j() {
            Preconditions.m21860a(GoogleApiManager.this.f19661q);
            this.f19681l = null;
        }

        /* renamed from: k */
        public final ConnectionResult mo27501k() {
            Preconditions.m21860a(GoogleApiManager.this.f19661q);
            return this.f19681l;
        }

        /* renamed from: b */
        private final boolean m21280b(zab zab) {
            if (!(zab instanceof zac)) {
                m21283c(zab);
                return true;
            }
            zac zac = (zac) zab;
            Feature a = m21270a(zac.mo27614b(this));
            if (a == null) {
                m21283c(zab);
                return true;
            }
            if (zac.mo27615c(this)) {
                C8640a aVar = new C8640a(this.f19673d, a, null);
                int indexOf = this.f19680k.indexOf(aVar);
                if (indexOf >= 0) {
                    C8640a aVar2 = (C8640a) this.f19680k.get(indexOf);
                    GoogleApiManager.this.f19661q.removeMessages(15, aVar2);
                    GoogleApiManager.this.f19661q.sendMessageDelayed(Message.obtain(GoogleApiManager.this.f19661q, 15, aVar2), GoogleApiManager.this.f19649e);
                } else {
                    this.f19680k.add(aVar);
                    GoogleApiManager.this.f19661q.sendMessageDelayed(Message.obtain(GoogleApiManager.this.f19661q, 15, aVar), GoogleApiManager.this.f19649e);
                    GoogleApiManager.this.f19661q.sendMessageDelayed(Message.obtain(GoogleApiManager.this.f19661q, 16, aVar), GoogleApiManager.this.f19650f);
                    ConnectionResult connectionResult = new ConnectionResult(2, null);
                    if (!m21279b(connectionResult)) {
                        GoogleApiManager.this.mo27476b(connectionResult, this.f19677h);
                    }
                }
            } else {
                zac.mo27534a((RuntimeException) new UnsupportedApiCallException(a));
            }
            return false;
        }

        /* renamed from: c */
        private final void m21283c(zab zab) {
            zab.mo27604a(this.f19674e, mo27494d());
            try {
                zab.mo27533a(this);
            } catch (DeadObjectException e) {
                onConnectionSuspended(1);
                this.f19671b.disconnect();
            }
        }

        /* renamed from: a */
        public final void mo27489a(Status status) {
            Preconditions.m21860a(GoogleApiManager.this.f19661q);
            for (zab a : this.f19670a) {
                a.mo27532a(status);
            }
            this.f19670a.clear();
        }

        /* renamed from: e */
        public final void mo27495e() {
            Preconditions.m21860a(GoogleApiManager.this.f19661q);
            if (this.f19679j) {
                mo27486a();
            }
        }

        /* renamed from: q */
        private final void m21287q() {
            if (this.f19679j) {
                GoogleApiManager.this.f19661q.removeMessages(11, this.f19673d);
                GoogleApiManager.this.f19661q.removeMessages(9, this.f19673d);
                this.f19679j = false;
            }
        }

        /* renamed from: g */
        public final void mo27497g() {
            Status status;
            Preconditions.m21860a(GoogleApiManager.this.f19661q);
            if (this.f19679j) {
                m21287q();
                if (GoogleApiManager.this.f19653i.isGooglePlayServicesAvailable(GoogleApiManager.this.f19652h) == 18) {
                    status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
                } else {
                    status = new Status(8, "API failed to connect while resuming due to an unknown error.");
                }
                mo27489a(status);
                this.f19671b.disconnect();
            }
        }

        /* renamed from: r */
        private final void m21288r() {
            GoogleApiManager.this.f19661q.removeMessages(12, this.f19673d);
            GoogleApiManager.this.f19661q.sendMessageDelayed(GoogleApiManager.this.f19661q.obtainMessage(12, this.f19673d), GoogleApiManager.this.f19651g);
        }

        /* renamed from: l */
        public final boolean mo27502l() {
            return m21275a(true);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final boolean m21275a(boolean z) {
            Preconditions.m21860a(GoogleApiManager.this.f19661q);
            if (!this.f19671b.isConnected() || this.f19676g.size() != 0) {
                return false;
            }
            if (this.f19674e.mo27583a()) {
                if (z) {
                    m21288r();
                }
                return false;
            }
            this.f19671b.disconnect();
            return true;
        }

        /* renamed from: a */
        public final void mo27486a() {
            Preconditions.m21860a(GoogleApiManager.this.f19661q);
            if (!this.f19671b.isConnected() && !this.f19671b.isConnecting()) {
                int a = GoogleApiManager.this.f19654j.mo27800a(GoogleApiManager.this.f19652h, this.f19671b);
                if (a != 0) {
                    onConnectionFailed(new ConnectionResult(a, null));
                    return;
                }
                C8641b bVar = new C8641b(this.f19671b, this.f19673d);
                if (this.f19671b.requiresSignIn()) {
                    this.f19678i.mo27617a((zach) bVar);
                }
                this.f19671b.connect(bVar);
            }
        }

        /* renamed from: a */
        public final void mo27491a(zak zak) {
            Preconditions.m21860a(GoogleApiManager.this.f19661q);
            this.f19675f.add(zak);
        }

        /* renamed from: c */
        private final void m21282c(ConnectionResult connectionResult) {
            for (zak zak : this.f19675f) {
                String str = null;
                if (Objects.m21851a(connectionResult, ConnectionResult.f19510a)) {
                    str = this.f19671b.getEndpointPackageName();
                }
                zak.mo27629a(this.f19673d, connectionResult, str);
            }
            this.f19675f.clear();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public final boolean mo27493c() {
            return this.f19671b.isConnected();
        }

        /* renamed from: d */
        public final boolean mo27494d() {
            return this.f19671b.requiresSignIn();
        }

        /* renamed from: b */
        public final int mo27492b() {
            return this.f19677h;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: m */
        public final zad mo27503m() {
            zace zace = this.f19678i;
            if (zace == null) {
                return null;
            }
            return zace.mo27616a();
        }

        /* renamed from: a */
        private final Feature m21270a(Feature[] featureArr) {
            if (featureArr == null || featureArr.length == 0) {
                return null;
            }
            Feature[] availableFeatures = this.f19671b.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            C1253b bVar = new C1253b(availableFeatures.length);
            for (Feature feature : availableFeatures) {
                bVar.put(feature.mo27288a(), Long.valueOf(feature.mo27289c()));
            }
            for (Feature feature2 : featureArr) {
                if (!bVar.containsKey(feature2.mo27288a()) || ((Long) bVar.get(feature2.mo27288a())).longValue() < feature2.mo27289c()) {
                    return feature2;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final void m21271a(C8640a aVar) {
            if (this.f19680k.contains(aVar) && !this.f19679j) {
                if (!this.f19671b.isConnected()) {
                    mo27486a();
                    return;
                }
                m21286p();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public final void m21276b(C8640a aVar) {
            if (this.f19680k.remove(aVar)) {
                GoogleApiManager.this.f19661q.removeMessages(15, aVar);
                GoogleApiManager.this.f19661q.removeMessages(16, aVar);
                Feature b = aVar.f19663b;
                ArrayList arrayList = new ArrayList(this.f19670a.size());
                for (zab zab : this.f19670a) {
                    if (zab instanceof zac) {
                        Feature[] b2 = ((zac) zab).mo27614b(this);
                        if (b2 != null && ArrayUtils.m22069a((T[]) b2, b)) {
                            arrayList.add(zab);
                        }
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    zab zab2 = (zab) obj;
                    this.f19670a.remove(zab2);
                    zab2.mo27534a((RuntimeException) new UnsupportedApiCallException(b));
                }
            }
        }
    }

    /* renamed from: a */
    public static GoogleApiManager m21233a(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (f19647c) {
            if (f19648d == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                f19648d = new GoogleApiManager(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.getInstance());
            }
            googleApiManager = f19648d;
        }
        return googleApiManager;
    }

    /* renamed from: c */
    public static GoogleApiManager m21238c() {
        GoogleApiManager googleApiManager;
        synchronized (f19647c) {
            Preconditions.m21858a(f19648d, (Object) "Must guarantee manager is non-null before using getInstance");
            googleApiManager = f19648d;
        }
        return googleApiManager;
    }

    @KeepForSdk
    /* renamed from: b */
    public static void m21235b() {
        synchronized (f19647c) {
            if (f19648d != null) {
                GoogleApiManager googleApiManager = f19648d;
                googleApiManager.f19656l.incrementAndGet();
                googleApiManager.f19661q.sendMessageAtFrontOfQueue(googleApiManager.f19661q.obtainMessage(10));
            }
        }
    }

    @KeepForSdk
    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.f19652h = context;
        this.f19661q = new zap(looper, this);
        this.f19653i = googleApiAvailability;
        this.f19654j = new GoogleApiAvailabilityCache(googleApiAvailability);
        Handler handler = this.f19661q;
        handler.sendMessage(handler.obtainMessage(6));
    }

    /* renamed from: d */
    public final int mo27477d() {
        return this.f19655k.getAndIncrement();
    }

    /* renamed from: a */
    public final void mo27471a(GoogleApi<?> googleApi) {
        Handler handler = this.f19661q;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }

    /* renamed from: b */
    private final void m21236b(GoogleApi<?> googleApi) {
        zai g = googleApi.mo27368g();
        zaa zaa2 = (zaa) this.f19657m.get(g);
        if (zaa2 == null) {
            zaa2 = new zaa(googleApi);
            this.f19657m.put(g, zaa2);
        }
        if (zaa2.mo27494d()) {
            this.f19660p.add(g);
        }
        zaa2.mo27486a();
    }

    /* renamed from: a */
    public final void mo27474a(zaae zaae) {
        synchronized (f19647c) {
            if (this.f19658n != zaae) {
                this.f19658n = zaae;
                this.f19659o.clear();
            }
            this.f19659o.addAll(zaae.mo27588h());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo27475b(zaae zaae) {
        synchronized (f19647c) {
            if (this.f19658n == zaae) {
                this.f19658n = null;
                this.f19659o.clear();
            }
        }
    }

    /* renamed from: a */
    public final Task<Map<zai<?>, String>> mo27468a(Iterable<? extends GoogleApi<?>> iterable) {
        zak zak = new zak(iterable);
        Handler handler = this.f19661q;
        handler.sendMessage(handler.obtainMessage(2, zak));
        return zak.mo27628a();
    }

    /* renamed from: g */
    public final void mo27478g() {
        Handler handler = this.f19661q;
        handler.sendMessage(handler.obtainMessage(3));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo27469a() {
        this.f19656l.incrementAndGet();
        Handler handler = this.f19661q;
        handler.sendMessage(handler.obtainMessage(10));
    }

    /* renamed from: a */
    public final <O extends ApiOptions> void mo27472a(GoogleApi<O> googleApi, int i, ApiMethodImpl<? extends Result, AnyClient> apiMethodImpl) {
        zae zae = new zae(i, apiMethodImpl);
        Handler handler = this.f19661q;
        handler.sendMessage(handler.obtainMessage(4, new zabv(zae, this.f19656l.get(), googleApi)));
    }

    /* renamed from: a */
    public final <O extends ApiOptions, ResultT> void mo27473a(GoogleApi<O> googleApi, int i, TaskApiCall<AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        zag zag = new zag(i, taskApiCall, taskCompletionSource, statusExceptionMapper);
        Handler handler = this.f19661q;
        handler.sendMessage(handler.obtainMessage(4, new zabv(zag, this.f19656l.get(), googleApi)));
    }

    public boolean handleMessage(Message message) {
        zaa zaa2;
        int i = message.what;
        long j = 300000;
        String str = "GoogleApiManager";
        switch (i) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j = 10000;
                }
                this.f19651g = j;
                this.f19661q.removeMessages(12);
                for (zai zai : this.f19657m.keySet()) {
                    Handler handler = this.f19661q;
                    handler.sendMessageDelayed(handler.obtainMessage(12, zai), this.f19651g);
                }
                break;
            case 2:
                zak zak = (zak) message.obj;
                Iterator it = zak.mo27630b().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        zai zai2 = (zai) it.next();
                        zaa zaa3 = (zaa) this.f19657m.get(zai2);
                        if (zaa3 == null) {
                            zak.mo27629a(zai2, new ConnectionResult(13), null);
                            break;
                        } else if (zaa3.mo27493c()) {
                            zak.mo27629a(zai2, ConnectionResult.f19510a, zaa3.mo27496f().getEndpointPackageName());
                        } else if (zaa3.mo27501k() != null) {
                            zak.mo27629a(zai2, zaa3.mo27501k(), null);
                        } else {
                            zaa3.mo27491a(zak);
                            zaa3.mo27486a();
                        }
                    }
                }
            case 3:
                for (zaa zaa4 : this.f19657m.values()) {
                    zaa4.mo27500j();
                    zaa4.mo27486a();
                }
                break;
            case 4:
            case 8:
            case 13:
                zabv zabv = (zabv) message.obj;
                zaa zaa5 = (zaa) this.f19657m.get(zabv.f19861c.mo27368g());
                if (zaa5 == null) {
                    m21236b(zabv.f19861c);
                    zaa5 = (zaa) this.f19657m.get(zabv.f19861c.mo27368g());
                }
                if (zaa5.mo27494d() && this.f19656l.get() != zabv.f19860b) {
                    zabv.f19859a.mo27532a(f19645a);
                    zaa5.mo27498h();
                    break;
                } else {
                    zaa5.mo27490a(zabv.f19859a);
                    break;
                }
            case 5:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator it2 = this.f19657m.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        zaa2 = (zaa) it2.next();
                        if (zaa2.mo27492b() == i2) {
                        }
                    } else {
                        zaa2 = null;
                    }
                }
                if (zaa2 == null) {
                    StringBuilder sb = new StringBuilder(76);
                    sb.append("Could not find API instance ");
                    sb.append(i2);
                    sb.append(" while trying to fail enqueued calls.");
                    Log.wtf(str, sb.toString(), new Exception());
                    break;
                } else {
                    String b = this.f19653i.mo27303b(connectionResult.mo27275a());
                    String c = connectionResult.mo27277c();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(b).length() + 69 + String.valueOf(c).length());
                    sb2.append("Error resolution was canceled by the user, original error message: ");
                    sb2.append(b);
                    sb2.append(": ");
                    sb2.append(c);
                    zaa2.mo27489a(new Status(17, sb2.toString()));
                    break;
                }
            case 6:
                if (PlatformVersion.m22107a() && (this.f19652h.getApplicationContext() instanceof Application)) {
                    BackgroundDetector.m21197a((Application) this.f19652h.getApplicationContext());
                    BackgroundDetector.m21196a().mo27431a((BackgroundStateChangeListener) new C8685y(this));
                    if (!BackgroundDetector.m21196a().mo27432a(true)) {
                        this.f19651g = 300000;
                        break;
                    }
                }
                break;
            case 7:
                m21236b((GoogleApi) message.obj);
                break;
            case 9:
                if (this.f19657m.containsKey(message.obj)) {
                    ((zaa) this.f19657m.get(message.obj)).mo27495e();
                    break;
                }
                break;
            case 10:
                for (zai remove : this.f19660p) {
                    ((zaa) this.f19657m.remove(remove)).mo27498h();
                }
                this.f19660p.clear();
                break;
            case 11:
                if (this.f19657m.containsKey(message.obj)) {
                    ((zaa) this.f19657m.get(message.obj)).mo27497g();
                    break;
                }
                break;
            case 12:
                if (this.f19657m.containsKey(message.obj)) {
                    ((zaa) this.f19657m.get(message.obj)).mo27502l();
                    break;
                }
                break;
            case 14:
                C8664d dVar = (C8664d) message.obj;
                zai b2 = dVar.mo27569b();
                if (this.f19657m.containsKey(b2)) {
                    dVar.mo27568a().mo33182a(Boolean.valueOf(((zaa) this.f19657m.get(b2)).m21275a(false)));
                    break;
                } else {
                    dVar.mo27568a().mo33182a(Boolean.valueOf(false));
                    break;
                }
            case 15:
                C8640a aVar = (C8640a) message.obj;
                if (this.f19657m.containsKey(aVar.f19662a)) {
                    ((zaa) this.f19657m.get(aVar.f19662a)).m21271a(aVar);
                    break;
                }
                break;
            case 16:
                C8640a aVar2 = (C8640a) message.obj;
                if (this.f19657m.containsKey(aVar2.f19662a)) {
                    ((zaa) this.f19657m.get(aVar2.f19662a)).m21276b(aVar2);
                    break;
                }
                break;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i);
                Log.w(str, sb3.toString());
                return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final PendingIntent mo27467a(zai<?> zai, int i) {
        zaa zaa2 = (zaa) this.f19657m.get(zai);
        if (zaa2 == null) {
            return null;
        }
        zad m = zaa2.mo27503m();
        if (m == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f19652h, i, m.getSignInIntent(), 134217728);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final boolean mo27476b(ConnectionResult connectionResult, int i) {
        return this.f19653i.mo27302a(this.f19652h, connectionResult, i);
    }

    /* renamed from: a */
    public final void mo27470a(ConnectionResult connectionResult, int i) {
        if (!mo27476b(connectionResult, i)) {
            Handler handler = this.f19661q;
            handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
        }
    }
}
