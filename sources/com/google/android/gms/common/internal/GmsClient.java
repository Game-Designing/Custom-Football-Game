package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Set;

@KeepForSdk
public abstract class GmsClient<T extends IInterface> extends BaseGmsClient<T> implements Client, GmsClientEventState {

    /* renamed from: C */
    private final ClientSettings f20089C;

    /* renamed from: D */
    private final Set<Scope> f20090D;

    /* renamed from: E */
    private final Account f20091E;

    @KeepForSdk
    protected GmsClient(Context context, Looper looper, int i, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        GmsClientSupervisor a = GmsClientSupervisor.m21825a(context);
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        Preconditions.m21857a(connectionCallbacks);
        ConnectionCallbacks connectionCallbacks2 = connectionCallbacks;
        Preconditions.m21857a(onConnectionFailedListener);
        this(context, looper, a, instance, i, clientSettings, connectionCallbacks2, onConnectionFailedListener);
    }

    @VisibleForTesting
    protected GmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailability googleApiAvailability, int i, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, gmsClientSupervisor, googleApiAvailability, i, m21811a(connectionCallbacks), m21812a(onConnectionFailedListener), clientSettings.mo27766g());
        this.f20089C = clientSettings;
        this.f20091E = clientSettings.mo27758a();
        this.f20090D = m21813b(clientSettings.mo27763d());
    }

    /* renamed from: b */
    private final Set<Scope> m21813b(Set<Scope> set) {
        Set<Scope> a = mo27779a(set);
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: a */
    public Set<Scope> mo27779a(Set<Scope> set) {
        return set;
    }

    public final Account getAccount() {
        return this.f20091E;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: j */
    public final ClientSettings mo27780j() {
        return this.f20089C;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final Set<Scope> mo27717f() {
        return this.f20090D;
    }

    /* renamed from: a */
    private static BaseConnectionCallbacks m21811a(ConnectionCallbacks connectionCallbacks) {
        if (connectionCallbacks == null) {
            return null;
        }
        return new C8703d(connectionCallbacks);
    }

    /* renamed from: a */
    private static BaseOnConnectionFailedListener m21812a(OnConnectionFailedListener onConnectionFailedListener) {
        if (onConnectionFailedListener == null) {
            return null;
        }
        return new C8704e(onConnectionFailedListener);
    }

    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }
}
