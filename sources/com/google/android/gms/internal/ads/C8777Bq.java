package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads.Bq */
final class C8777Bq {

    /* renamed from: a */
    static zzdbq f20522a;

    /* renamed from: a */
    static boolean m22322a(zzdy zzdy) throws IllegalAccessException, InvocationTargetException {
        if (f20522a != null) {
            return true;
        }
        String str = (String) zzyt.m31536e().mo29599a(zzacu.f24157qc);
        if (str == null || str.length() == 0) {
            if (zzdy == null) {
                str = null;
            } else {
                Method a = zzdy.mo31710a("zu6uZ8u7nNJHsIXbotuBCEBd9hieUh9UBKC94dMPsF422AtJb3FisPSqZI3W+06A", "tm6XtP5M5qvCs+TffoCZhF/AF3Fx7Ow8iqgApPbgXSw=");
                if (a == null) {
                    str = null;
                } else {
                    str = (String) a.invoke(null, new Object[0]);
                }
            }
            if (str == null) {
                return false;
            }
        }
        try {
            try {
                zzdbu a2 = zzdbz.m29167a(zzcg.m28403a(str, true));
                zzdbl.m29135a(zzddc.f27814a);
                zzdcf.m29191a((zzdcc<P>) new zzddg<P>());
                f20522a = (zzdbq) zzdcf.m29184a(zzdcf.m29181a(a2, null, zzdbq.class));
                if (f20522a != null) {
                    return true;
                }
                return false;
            } catch (GeneralSecurityException e) {
                return false;
            }
        } catch (IllegalArgumentException e2) {
            return false;
        }
    }
}
