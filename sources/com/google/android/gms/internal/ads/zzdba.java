package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

public final class zzdba extends zzc<zzdbf> {
    public zzdba(Context context, Looper looper, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(context, looper, 116, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public final String mo27246h() {
        return "com.google.android.gms.gass.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public final String mo27243g() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    /* renamed from: j */
    public final zzdbf mo27780j() throws DeadObjectException {
        return (zzdbf) super.getService();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ IInterface mo27242a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
        if (queryLocalInterface instanceof zzdbf) {
            return (zzdbf) queryLocalInterface;
        }
        return new zzdbg(iBinder);
    }
}
