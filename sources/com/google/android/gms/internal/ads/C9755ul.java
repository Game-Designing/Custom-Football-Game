package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.ul */
final /* synthetic */ class C9755ul implements Callable {

    /* renamed from: a */
    private final zzcsv f23226a;

    C9755ul(zzcsv zzcsv) {
        this.f23226a = zzcsv;
    }

    public final Object call() {
        String str;
        String str2;
        String str3;
        zzcsv zzcsv = this.f23226a;
        zzk.zzlg();
        zzuu j = zzk.zzlk().mo30177i().mo30221j();
        Bundle bundle = null;
        if (!(j == null || j == null || (zzk.zzlk().mo30177i().mo30220i() && zzk.zzlk().mo30177i().mo30219h()))) {
            if (j.mo32293d()) {
                j.mo32288a();
            }
            zzuo c = j.mo32292c();
            if (c != null) {
                str2 = c.mo32268c();
                str = c.mo32269d();
                str3 = c.mo32270e();
                if (str2 != null) {
                    zzk.zzlk().mo30177i().mo30212c(str2);
                }
                if (str3 != null) {
                    zzk.zzlk().mo30177i().mo30215d(str3);
                }
            } else {
                str2 = zzk.zzlk().mo30177i().mo30206b();
                str3 = zzk.zzlk().mo30177i().mo30225n();
                str = null;
            }
            Bundle bundle2 = new Bundle(1);
            if (str3 != null && !zzk.zzlk().mo30177i().mo30219h()) {
                bundle2.putString("v_fp_vertical", str3);
            }
            if (str2 != null && !zzk.zzlk().mo30177i().mo30220i()) {
                bundle2.putString("fingerprint", str2);
                if (!str2.equals(str)) {
                    bundle2.putString("v_fp", str);
                }
            }
            if (!bundle2.isEmpty()) {
                bundle = bundle2;
            }
        }
        return new zzcsu(bundle);
    }
}
