package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaab;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzaem;
import com.google.android.gms.internal.ads.zzaer;
import com.google.android.gms.internal.ads.zzamp;
import com.google.android.gms.internal.ads.zzaqg;
import com.google.android.gms.internal.ads.zzaqq;
import com.google.android.gms.internal.ads.zzasw;
import com.google.android.gms.internal.ads.zzatt;
import com.google.android.gms.internal.ads.zzbjm;
import com.google.android.gms.internal.ads.zzbzi;
import com.google.android.gms.internal.ads.zzbzj;
import com.google.android.gms.internal.ads.zzcpo;
import com.google.android.gms.internal.ads.zzcpt;
import com.google.android.gms.internal.ads.zzcqd;
import com.google.android.gms.internal.ads.zzcqf;
import com.google.android.gms.internal.ads.zzcqj;
import com.google.android.gms.internal.ads.zzyd;
import com.google.android.gms.internal.ads.zzzf;
import com.google.android.gms.internal.ads.zzzk;
import com.google.android.gms.internal.ads.zzzw;
import java.util.HashMap;

public class ClientApi2 extends zzzw {
    public final zzzk zza(IObjectWrapper iObjectWrapper, zzyd zzyd, String str, zzamp zzamp, int i) {
        Context context = (Context) ObjectWrapper.m22187H(iObjectWrapper);
        return new zzcpt(zzbjm.m27099a(context, zzamp, i), context, zzyd, str);
    }

    public final zzzk zzb(IObjectWrapper iObjectWrapper, zzyd zzyd, String str, zzamp zzamp, int i) {
        Context context = (Context) ObjectWrapper.m22187H(iObjectWrapper);
        return new zzcqd(zzbjm.m27099a(context, zzamp, i), context, zzyd, str);
    }

    public final zzzf zza(IObjectWrapper iObjectWrapper, String str, zzamp zzamp, int i) {
        Context context = (Context) ObjectWrapper.m22187H(iObjectWrapper);
        return new zzcpo(zzbjm.m27099a(context, zzamp, i), context, str);
    }

    public final zzaem zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzbzj((FrameLayout) ObjectWrapper.m22187H(iObjectWrapper), (FrameLayout) ObjectWrapper.m22187H(iObjectWrapper2));
    }

    public final zzasw zza(IObjectWrapper iObjectWrapper, zzamp zzamp, int i) {
        Context context = (Context) ObjectWrapper.m22187H(iObjectWrapper);
        return new zzcqj(zzbjm.m27099a(context, zzamp, i), context);
    }

    public final zzaqg zzf(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.m22187H(iObjectWrapper);
        AdOverlayInfoParcel zzc = AdOverlayInfoParcel.zzc(activity.getIntent());
        if (zzc == null) {
            return new zzs(activity);
        }
        int i = zzc.zzdkr;
        if (i == 1) {
            return new zzr(activity);
        }
        if (i == 2) {
            return new zzy(activity);
        }
        if (i == 3) {
            return new zzz(activity);
        }
        if (i != 4) {
            return new zzs(activity);
        }
        return new zzt(activity, zzc);
    }

    public final zzaab zza(IObjectWrapper iObjectWrapper, int i) {
        return zzbjm.m27098a((Context) ObjectWrapper.m22187H(iObjectWrapper), i).mo30697e();
    }

    public final zzzk zza(IObjectWrapper iObjectWrapper, zzyd zzyd, String str, int i) {
        return new zzabp();
    }

    public final zzaer zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzbzi((View) ObjectWrapper.m22187H(iObjectWrapper), (HashMap) ObjectWrapper.m22187H(iObjectWrapper2), (HashMap) ObjectWrapper.m22187H(iObjectWrapper3));
    }

    public final zzatt zzb(IObjectWrapper iObjectWrapper, String str, zzamp zzamp, int i) {
        Context context = (Context) ObjectWrapper.m22187H(iObjectWrapper);
        return new zzcqf(zzbjm.m27099a(context, zzamp, i), context, str);
    }

    public final zzaab zzg(IObjectWrapper iObjectWrapper) {
        return null;
    }

    public final zzaqq zzh(IObjectWrapper iObjectWrapper) {
        return null;
    }
}
