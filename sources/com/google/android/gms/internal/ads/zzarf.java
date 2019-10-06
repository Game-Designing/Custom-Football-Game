package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
public final class zzarf extends zzc<zzarm> {
    public zzarf(Context context, Looper looper, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(zzasq.m25744b(context), looper, 8, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    /* renamed from: h */
    public final String mo27246h() {
        return "com.google.android.gms.ads.service.START";
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    /* renamed from: g */
    public final String mo27243g() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    /* renamed from: j */
    public final zzarm mo27780j() throws DeadObjectException {
        return (zzarm) super.getService();
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    /* renamed from: a */
    public final /* synthetic */ IInterface mo27242a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        if (queryLocalInterface instanceof zzarm) {
            return (zzarm) queryLocalInterface;
        }
        return new zzaro(iBinder);
    }
}
