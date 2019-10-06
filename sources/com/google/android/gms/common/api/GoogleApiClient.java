package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zacm;
import com.google.android.gms.common.api.internal.zaj;
import com.google.android.gms.common.api.internal.zaq;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import p002b.p003c.p053g.p061f.C1253b;

@KeepForSdk
public abstract class GoogleApiClient {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Set<GoogleApiClient> f19570a = Collections.newSetFromMap(new WeakHashMap());

    @KeepForSdk
    public static final class Builder {

        /* renamed from: a */
        private Account f19571a;

        /* renamed from: b */
        private final Set<Scope> f19572b = new HashSet();

        /* renamed from: c */
        private final Set<Scope> f19573c = new HashSet();

        /* renamed from: d */
        private int f19574d;

        /* renamed from: e */
        private View f19575e;

        /* renamed from: f */
        private String f19576f;

        /* renamed from: g */
        private String f19577g;

        /* renamed from: h */
        private final Map<Api<?>, OptionalApiSettings> f19578h = new C1253b();

        /* renamed from: i */
        private boolean f19579i = false;

        /* renamed from: j */
        private final Context f19580j;

        /* renamed from: k */
        private final Map<Api<?>, ApiOptions> f19581k = new C1253b();

        /* renamed from: l */
        private LifecycleActivity f19582l;

        /* renamed from: m */
        private int f19583m = -1;

        /* renamed from: n */
        private OnConnectionFailedListener f19584n;

        /* renamed from: o */
        private Looper f19585o;

        /* renamed from: p */
        private GoogleApiAvailability f19586p = GoogleApiAvailability.getInstance();

        /* renamed from: q */
        private AbstractClientBuilder<? extends zad, SignInOptions> f19587q = zaa.f30606c;

        /* renamed from: r */
        private final ArrayList<ConnectionCallbacks> f19588r = new ArrayList<>();

        /* renamed from: s */
        private final ArrayList<OnConnectionFailedListener> f19589s = new ArrayList<>();

        /* renamed from: t */
        private boolean f19590t = false;

        @KeepForSdk
        public Builder(Context context) {
            this.f19580j = context;
            this.f19585o = context.getMainLooper();
            this.f19576f = context.getPackageName();
            this.f19577g = context.getClass().getName();
        }

        /* renamed from: a */
        public final Builder mo27390a(Handler handler) {
            Preconditions.m21858a(handler, (Object) "Handler must not be null");
            this.f19585o = handler.getLooper();
            return this;
        }

        /* renamed from: a */
        public final Builder mo27393a(ConnectionCallbacks connectionCallbacks) {
            Preconditions.m21858a(connectionCallbacks, (Object) "Listener must not be null");
            this.f19588r.add(connectionCallbacks);
            return this;
        }

        /* renamed from: a */
        public final Builder mo27394a(OnConnectionFailedListener onConnectionFailedListener) {
            Preconditions.m21858a(onConnectionFailedListener, (Object) "Listener must not be null");
            this.f19589s.add(onConnectionFailedListener);
            return this;
        }

        /* renamed from: a */
        public final Builder mo27391a(Api<? extends NotRequiredOptions> api) {
            Preconditions.m21858a(api, (Object) "Api must not be null");
            this.f19581k.put(api, null);
            List a = api.mo27326c().mo27117a(null);
            this.f19573c.addAll(a);
            this.f19572b.addAll(a);
            return this;
        }

        /* renamed from: a */
        public final <O extends HasOptions> Builder mo27392a(Api<O> api, O o) {
            Preconditions.m21858a(api, (Object) "Api must not be null");
            Preconditions.m21858a(o, (Object) "Null options are not permitted for this Api");
            this.f19581k.put(api, o);
            List a = api.mo27326c().mo27117a(o);
            this.f19573c.addAll(a);
            this.f19572b.addAll(a);
            return this;
        }

        @KeepForSdk
        @VisibleForTesting
        /* renamed from: b */
        public final ClientSettings mo27396b() {
            SignInOptions signInOptions;
            SignInOptions signInOptions2 = SignInOptions.f30583a;
            if (this.f19581k.containsKey(zaa.f30610g)) {
                signInOptions = (SignInOptions) this.f19581k.get(zaa.f30610g);
            } else {
                signInOptions = signInOptions2;
            }
            ClientSettings clientSettings = new ClientSettings(this.f19571a, this.f19572b, this.f19578h, this.f19574d, this.f19575e, this.f19576f, this.f19577g, signInOptions, false);
            return clientSettings;
        }

        /* renamed from: a */
        public final GoogleApiClient mo27395a() {
            Preconditions.m21864a(!this.f19581k.isEmpty(), (Object) "must call addApi() to add at least one API");
            ClientSettings b = mo27396b();
            Api api = null;
            Map f = b.mo27765f();
            C1253b bVar = new C1253b();
            C1253b bVar2 = new C1253b();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (Api api2 : this.f19581k.keySet()) {
                Object obj = this.f19581k.get(api2);
                boolean z2 = f.get(api2) != null;
                bVar.put(api2, Boolean.valueOf(z2));
                zaq zaq = new zaq(api2, z2);
                arrayList.add(zaq);
                AbstractClientBuilder d = api2.mo27327d();
                Api api3 = api2;
                Client a = d.mo27090a(this.f19580j, this.f19585o, b, obj, zaq, zaq);
                bVar2.put(api3.mo27324a(), a);
                if (d.mo27330a() == 1) {
                    z = obj != null;
                }
                if (a.providesSignIn()) {
                    if (api == null) {
                        api = api3;
                    } else {
                        String b2 = api3.mo27325b();
                        String b3 = api.mo27325b();
                        StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 21 + String.valueOf(b3).length());
                        sb.append(b2);
                        sb.append(" cannot be used with ");
                        sb.append(b3);
                        throw new IllegalStateException(sb.toString());
                    }
                }
            }
            if (api != null) {
                if (!z) {
                    Preconditions.m21869b(this.f19571a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.mo27325b());
                    Preconditions.m21869b(this.f19572b.equals(this.f19573c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.mo27325b());
                } else {
                    String b4 = api.mo27325b();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(b4).length() + 82);
                    sb2.append("With using ");
                    sb2.append(b4);
                    sb2.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                    throw new IllegalStateException(sb2.toString());
                }
            }
            zaaw zaaw = new zaaw(this.f19580j, new ReentrantLock(), this.f19585o, b, this.f19586p, this.f19587q, bVar, this.f19588r, this.f19589s, bVar2, this.f19583m, zaaw.m21483a((Iterable<Client>) bVar2.values(), true), arrayList, false);
            synchronized (GoogleApiClient.f19570a) {
                GoogleApiClient.f19570a.add(zaaw);
            }
            if (this.f19583m >= 0) {
                zaj.m21619b(this.f19582l).mo27627a(this.f19583m, zaaw, this.f19584n);
            }
            return zaaw;
        }
    }

    public interface ConnectionCallbacks {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    /* renamed from: a */
    public abstract ConnectionResult mo27375a();

    /* renamed from: a */
    public abstract void mo27378a(OnConnectionFailedListener onConnectionFailedListener);

    /* renamed from: a */
    public abstract void mo27380a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* renamed from: b */
    public abstract PendingResult<Status> mo27382b();

    /* renamed from: b */
    public abstract void mo27384b(OnConnectionFailedListener onConnectionFailedListener);

    /* renamed from: c */
    public abstract void mo27385c();

    /* renamed from: d */
    public abstract void mo27386d();

    @KeepForSdk
    /* renamed from: e */
    public static Set<GoogleApiClient> m21145e() {
        Set<GoogleApiClient> set;
        synchronized (f19570a) {
            set = f19570a;
        }
        return set;
    }

    @KeepForSdk
    /* renamed from: a */
    public <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T mo27377a(T t) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    /* renamed from: b */
    public <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T mo27383b(T t) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    /* renamed from: a */
    public <C extends Client> C mo27376a(AnyClientKey<C> anyClientKey) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    /* renamed from: f */
    public Context mo27387f() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    /* renamed from: g */
    public Looper mo27388g() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    /* renamed from: a */
    public boolean mo27381a(SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    /* renamed from: h */
    public void mo27389h() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public void mo27379a(zacm zacm) {
        throw new UnsupportedOperationException();
    }
}
