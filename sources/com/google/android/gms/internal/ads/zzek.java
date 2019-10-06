package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import java.lang.reflect.InvocationTargetException;

public final class zzek extends zzfk {

    /* renamed from: i */
    private final Activity f28372i;

    /* renamed from: j */
    private final View f28373j;

    public zzek(zzdy zzdy, String str, String str2, C15005zza zza, int i, int i2, View view, Activity activity) {
        super(zzdy, str, str2, zza, i, 62);
        this.f28373j = view;
        this.f28372i = activity;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31743a() throws IllegalAccessException, InvocationTargetException {
        if (this.f28373j != null) {
            boolean booleanValue = ((Boolean) zzyt.m31536e().mo29599a(zzacu.f24121kc)).booleanValue();
            Object[] objArr = (Object[]) this.f28410f.invoke(null, new Object[]{this.f28373j, this.f28372i, Boolean.valueOf(booleanValue)});
            synchronized (this.f28409e) {
                this.f28409e.mo30766E(((Long) objArr[0]).longValue());
                this.f28409e.mo30767F(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.f28409e.mo30788e((String) objArr[2]);
                }
            }
        }
    }
}
