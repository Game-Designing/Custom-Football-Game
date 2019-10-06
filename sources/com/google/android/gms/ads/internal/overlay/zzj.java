package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzbgz;

@VisibleForTesting
@zzard
public final class zzj {
    public final int index;
    public final ViewGroup parent;
    public final LayoutParams zzdkh;
    public final Context zzlj;

    public zzj(zzbgz zzbgz) throws C8586d {
        this.zzdkh = zzbgz.getLayoutParams();
        ViewParent parent2 = zzbgz.getParent();
        this.zzlj = zzbgz.mo28751f();
        if (parent2 == null || !(parent2 instanceof ViewGroup)) {
            throw new C8586d("Could not get the parent of the WebView for an overlay.");
        }
        this.parent = (ViewGroup) parent2;
        this.index = this.parent.indexOfChild(zzbgz.getView());
        this.parent.removeView(zzbgz.getView());
        zzbgz.mo28749e(true);
    }
}
