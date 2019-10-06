package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import com.google.android.gms.internal.ads.zzbp.zza.zzf;
import com.google.android.gms.internal.ads.zzbp.zza.zzf.C15007zza;
import java.lang.reflect.InvocationTargetException;

public final class zzfh extends zzfk {

    /* renamed from: i */
    private final View f28396i;

    public zzfh(zzdy zzdy, String str, String str2, C15005zza zza, int i, int i2, View view) {
        super(zzdy, str, str2, zza, i, 57);
        this.f28396i = view;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31743a() throws IllegalAccessException, InvocationTargetException {
        if (this.f28396i != null) {
            Boolean bool = (Boolean) zzyt.m31536e().mo29599a(zzacu.f24193wc);
            DisplayMetrics displayMetrics = this.f28406b.mo31709a().getResources().getDisplayMetrics();
            zzeg zzeg = new zzeg((String) this.f28410f.invoke(null, new Object[]{this.f28396i, displayMetrics, bool}));
            C15007zza l = zzf.m27583l();
            l.mo30835a(zzeg.f28355b.longValue()).mo30836b(zzeg.f28356c.longValue()).mo30837c(zzeg.f28357d.longValue());
            if (bool.booleanValue()) {
                l.mo30838d(zzeg.f28358e.longValue());
            }
            this.f28409e.mo30772a((zzf) l.mo31612g());
        }
    }
}
