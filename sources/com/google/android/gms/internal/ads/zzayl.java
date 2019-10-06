package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;

@zzard
public final class zzayl extends zzak {

    /* renamed from: e */
    private final Context f24989e;

    /* renamed from: a */
    public static zzv m26241a(Context context) {
        zzv zzv = new zzv(new zzan(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzayl(context, new zzat()));
        zzv.mo32301a();
        return zzv;
    }

    private zzayl(Context context, zzas zzas) {
        super(zzas);
        this.f24989e = context;
    }

    /* renamed from: a */
    public final zzp mo29752a(zzr<?> zzr) throws zzaf {
        if (zzr.mo32137v() && zzr.mo32130f() == 0) {
            if (Pattern.matches((String) zzyt.m31536e().mo29599a(zzacu.f23900Ad), zzr.mo32131g())) {
                zzyt.m31532a();
                if (zzazt.m26318c(this.f24989e, 13400000)) {
                    zzp a = new zzaii(this.f24989e).mo29752a(zzr);
                    if (a != null) {
                        String str = "Got gmscore asset response: ";
                        String valueOf = String.valueOf(zzr.mo32131g());
                        zzawz.m26003f(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                        return a;
                    }
                    String str2 = "Failed to get gmscore asset response: ";
                    String valueOf2 = String.valueOf(zzr.mo32131g());
                    zzawz.m26003f(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
                }
            }
        }
        return super.mo29752a(zzr);
    }
}
