package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.internal.ads.zzbk.zza;
import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import com.google.android.gms.internal.ads.zzbp.zza.zzc;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class zzde extends zzdf {

    /* renamed from: D */
    private static final String f27825D = zzde.class.getSimpleName();

    /* renamed from: E */
    private Info f27826E;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C15005zza mo31392a(Context context, View view, Activity activity) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31403a(zzdy zzdy, Context context, C15005zza zza, zza zza2) {
        if (zzdy.f28336n) {
            Info info = this.f27826E;
            if (info != null) {
                String id = info.getId();
                if (!TextUtils.isEmpty(id)) {
                    zza.mo30790f(zzef.m30166a(id));
                    zza.mo30770a(zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                    zza.mo30776a(this.f27826E.isLimitAdTrackingEnabled());
                }
                this.f27826E = null;
            }
        } else {
            zzdf.m29307a(mo31404b(zzdy, context, zza, zza2));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final List<Callable<Void>> mo31404b(zzdy zzdy, Context context, C15005zza zza, zza zza2) {
        ArrayList arrayList = new ArrayList();
        if (zzdy.mo31716d() == null) {
            return arrayList;
        }
        zzdy zzdy2 = zzdy;
        zzes zzes = new zzes(zzdy2, "3pegtvj7nkb7e3rwh5b+3dnQATJj6aqtaosJ3DkOYPzNGN2w+CoarbJEsY1UQgeA", "/kRTFQbKQx44ublaFMNQ8yNL6QxOrgEofiWDpZSH6zA=", zza, zzdy.mo31715c(), 24);
        arrayList.add(zzes);
        return arrayList;
    }
}
