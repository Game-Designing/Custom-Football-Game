package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzk;
import java.util.List;

public final class zzcrd implements zzcuz<Bundle> {

    /* renamed from: a */
    private final Context f27264a;

    /* renamed from: b */
    private final zzyd f27265b;

    /* renamed from: c */
    private final List<Parcelable> f27266c;

    public zzcrd(Context context, zzyd zzyd, List<Parcelable> list) {
        this.f27264a = context;
        this.f27265b = zzyd;
        this.f27266c = list;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzk.zzlg();
        bundle.putString("activity", zzaxi.m26138f(this.f27264a));
        Bundle bundle2 = new Bundle();
        bundle2.putInt("width", this.f27265b.f29772e);
        bundle2.putInt("height", this.f27265b.f29769b);
        bundle.putBundle("size", bundle2);
        if (this.f27266c.size() > 0) {
            List<Parcelable> list = this.f27266c;
            bundle.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
        }
    }
}
