package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions> {

    /* renamed from: a */
    private final AbstractClientBuilder<?, O> f19543a;

    /* renamed from: b */
    private final zaa<?, O> f19544b = null;

    /* renamed from: c */
    private final ClientKey<?> f19545c;

    /* renamed from: d */
    private final zab<?> f19546d;

    /* renamed from: e */
    private final String f19547e;

    @KeepForSdk
    @VisibleForTesting
    public static abstract class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
        @KeepForSdk
        /* renamed from: a */
        public abstract T mo27090a(Context context, Looper looper, ClientSettings clientSettings, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);
    }

    @KeepForSdk
    public interface AnyClient {
    }

    @KeepForSdk
    public static class AnyClientKey<C extends AnyClient> {
    }

    public interface ApiOptions {

        public interface HasAccountOptions extends HasOptions, NotRequiredOptions {
            Account getAccount();
        }

        public interface HasGoogleSignInAccountOptions extends HasOptions {
            /* renamed from: a */
            GoogleSignInAccount mo27329a();
        }

        public interface HasOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    @KeepForSdk
    @VisibleForTesting
    public static abstract class BaseClientBuilder<T extends AnyClient, O> {
        @KeepForSdk
        /* renamed from: a */
        public int mo27330a() {
            return MoPubClientPositioning.NO_REPEAT;
        }

        @KeepForSdk
        /* renamed from: a */
        public List<Scope> mo27117a(O o) {
            return Collections.emptyList();
        }
    }

    @KeepForSdk
    public interface Client extends AnyClient {
        @KeepForSdk
        void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks);

        @KeepForSdk
        void disconnect();

        @KeepForSdk
        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        @KeepForSdk
        Feature[] getAvailableFeatures();

        @KeepForSdk
        String getEndpointPackageName();

        @KeepForSdk
        int getMinApkVersion();

        @KeepForSdk
        void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set);

        @KeepForSdk
        IBinder getServiceBrokerBinder();

        @KeepForSdk
        Intent getSignInIntent();

        @KeepForSdk
        boolean isConnected();

        @KeepForSdk
        boolean isConnecting();

        @KeepForSdk
        void onUserSignOut(SignOutCallbacks signOutCallbacks);

        @KeepForSdk
        boolean providesSignIn();

        @KeepForSdk
        boolean requiresGooglePlayServices();

        @KeepForSdk
        boolean requiresSignIn();
    }

    @KeepForSdk
    @VisibleForTesting
    public static final class ClientKey<C extends Client> extends AnyClientKey<C> {
    }

    public interface SimpleClient<T extends IInterface> extends AnyClient {
        /* renamed from: a */
        T mo27343a(IBinder iBinder);

        /* renamed from: a */
        void mo27344a(int i, T t);

        /* renamed from: b */
        String mo27345b();

        /* renamed from: c */
        String mo27346c();
    }

    @VisibleForTesting
    public static abstract class zaa<T extends SimpleClient, O> extends BaseClientBuilder<T, O> {
    }

    @VisibleForTesting
    public static final class zab<C extends SimpleClient> extends AnyClientKey<C> {
    }

    public <C extends Client> Api(String str, AbstractClientBuilder<C, O> abstractClientBuilder, ClientKey<C> clientKey) {
        Preconditions.m21858a(abstractClientBuilder, (Object) "Cannot construct an Api with a null ClientBuilder");
        Preconditions.m21858a(clientKey, (Object) "Cannot construct an Api with a null ClientKey");
        this.f19547e = str;
        this.f19543a = abstractClientBuilder;
        this.f19545c = clientKey;
        this.f19546d = null;
    }

    /* renamed from: c */
    public final BaseClientBuilder<?, O> mo27326c() {
        return this.f19543a;
    }

    /* renamed from: d */
    public final AbstractClientBuilder<?, O> mo27327d() {
        Preconditions.m21868b(this.f19543a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f19543a;
    }

    /* renamed from: a */
    public final AnyClientKey<?> mo27324a() {
        ClientKey<?> clientKey = this.f19545c;
        if (clientKey != null) {
            return clientKey;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    /* renamed from: b */
    public final String mo27325b() {
        return this.f19547e;
    }
}
