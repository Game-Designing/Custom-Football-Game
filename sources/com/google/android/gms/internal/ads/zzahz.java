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
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@zzard
public final class zzahz extends zzc<zzaig> {
    zzahz(Context context, Looper looper, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(zzasq.m25744b(context), looper, Opcodes.IF_ACMPNE, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    /* renamed from: h */
    public final String mo27246h() {
        return "com.google.android.gms.ads.service.HTTP";
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    /* renamed from: g */
    public final String mo27243g() {
        return "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService";
    }

    /* renamed from: j */
    public final zzaig mo27780j() throws DeadObjectException {
        return (zzaig) super.getService();
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    /* renamed from: a */
    public final /* synthetic */ IInterface mo27242a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
        if (queryLocalInterface instanceof zzaig) {
            return (zzaig) queryLocalInterface;
        }
        return new zzaih(iBinder);
    }
}
