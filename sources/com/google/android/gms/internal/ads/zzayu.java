package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.Map;

@zzard
public final class zzayu {

    /* renamed from: a */
    private static zzv f25006a;

    /* renamed from: b */
    private static final Object f25007b = new Object();
    @Deprecated

    /* renamed from: c */
    private static final zzayy<Void> f25008c = new C9746uc();

    public zzayu(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        m26255a(context);
    }

    /* renamed from: a */
    public static zzbbh<zzp> m26254a(String str) {
        zzbbr zzbbr = new zzbbr();
        f25006a.mo32300a(new zzaza(str, zzbbr));
        return zzbbr;
    }

    /* renamed from: a */
    public final zzbbh<String> mo30294a(int i, String str, Map<String, String> map, byte[] bArr) {
        String str2 = str;
        C9809xc xcVar = new C9809xc(null);
        C9767vc vcVar = new C9767vc(this, str2, xcVar);
        zzazx zzazx = new zzazx(null);
        C9788wc wcVar = new C9788wc(this, i, str, xcVar, vcVar, bArr, map, zzazx);
        if (zzazx.m26334a()) {
            try {
                zzazx.mo30317a(str2, "GET", wcVar.mo29244e(), wcVar.mo29245u());
            } catch (zza e) {
                zzbad.m26359d(e.getMessage());
            }
        }
        f25006a.mo32300a(wcVar);
        return xcVar;
    }

    /* renamed from: a */
    public final zzbbh<String> mo30295a(String str, Map<String, String> map) {
        return mo30294a(0, str, map, null);
    }

    @VisibleForTesting
    /* renamed from: a */
    private static zzv m26255a(Context context) {
        zzv zzv;
        zzv zzv2;
        synchronized (f25007b) {
            if (f25006a == null) {
                zzacu.m24782a(context);
                if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24212zd)).booleanValue()) {
                    zzv2 = zzayl.m26241a(context);
                } else {
                    zzv2 = new zzv(new zzan(new File(context.getCacheDir(), "volley")), new zzak((zzaj) new zzat()));
                    zzv2.mo32301a();
                }
                f25006a = zzv2;
            }
            zzv = f25006a;
        }
        return zzv;
    }
}
