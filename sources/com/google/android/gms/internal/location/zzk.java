package com.google.android.gms.internal.location;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public class zzk extends GmsClient<zzao> {

    /* renamed from: F */
    private final String f29971F;

    /* renamed from: G */
    protected final zzbj<zzao> f29972G = new C9894h(this);

    public zzk(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, ClientSettings clientSettings) {
        super(context, looper, 23, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.f29971F = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public /* synthetic */ IInterface mo27242a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof zzao ? (zzao) queryLocalInterface : new zzap(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Bundle mo27713d() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.f29971F);
        return bundle;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public String mo27243g() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    public int getMinApkVersion() {
        return 11925000;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public String mo27246h() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }
}
