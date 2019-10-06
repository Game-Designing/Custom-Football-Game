package com.google.android.gms.internal.safetynet;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public final class zzx extends GmsClient<zzi> {

    /* renamed from: F */
    private final Context f30448F;

    public zzx(Context context, Looper looper, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 45, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.f30448F = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ IInterface mo27242a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
        return queryLocalInterface instanceof zzi ? (zzi) queryLocalInterface : new zzj(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public final String mo27243g() {
        return "com.google.android.gms.safetynet.internal.ISafetyNetService";
    }

    public final int getMinApkVersion() {
        return 12200000;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public final String mo27246h() {
        return "com.google.android.gms.safetynet.service.START";
    }
}
