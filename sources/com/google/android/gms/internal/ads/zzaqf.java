package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;

@zzard
public final class zzaqf extends RemoteCreator<zzaqj> {
    public zzaqf() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    /* renamed from: a */
    public final zzaqg mo30002a(Activity activity) {
        String str = "Could not create remote AdOverlay.";
        try {
            IBinder o = ((zzaqj) mo27982a((Context) activity)).mo30003o(ObjectWrapper.m22188a(activity));
            if (o == null) {
                return null;
            }
            IInterface queryLocalInterface = o.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            if (queryLocalInterface instanceof zzaqg) {
                return (zzaqg) queryLocalInterface;
            }
            return new zzaqi(o);
        } catch (RemoteException e) {
            zzbad.m26358c(str, e);
            return null;
        } catch (RemoteCreatorException e2) {
            zzbad.m26358c(str, e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ Object mo27827a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (queryLocalInterface instanceof zzaqj) {
            return (zzaqj) queryLocalInterface;
        }
        return new zzaqk(iBinder);
    }
}
