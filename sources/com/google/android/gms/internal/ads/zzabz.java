package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

@zzard
public final class zzabz extends zzaap {

    /* renamed from: b */
    private final OnAdMetadataChangedListener f23875b;

    public zzabz(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.f23875b = onAdMetadataChangedListener;
    }

    public final void onAdMetadataChanged() throws RemoteException {
        OnAdMetadataChangedListener onAdMetadataChangedListener = this.f23875b;
        if (onAdMetadataChangedListener != null) {
            onAdMetadataChangedListener.onAdMetadataChanged();
        }
    }
}
