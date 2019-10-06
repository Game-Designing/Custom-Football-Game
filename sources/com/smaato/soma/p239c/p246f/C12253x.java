package com.smaato.soma.p239c.p246f;

import android.content.Context;
import com.smaato.soma.p239c.p246f.p247a.C12212a;

/* renamed from: com.smaato.soma.c.f.x */
/* compiled from: SomaGdprFetcher */
public class C12253x {
    /* renamed from: a */
    public static boolean m40318a(Context context) {
        boolean z = true;
        if (m40320c(context)) {
            return true;
        }
        if (C12243o.m40286b(context).length() == 0) {
            return false;
        }
        if (!C12243o.m40284a(context)) {
            return true;
        }
        if (!C12243o.m40285a(context, 1) || !C12243o.m40287b(context, 82)) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    public static boolean m40319b(Context context) {
        boolean z = true;
        if (m40320c(context)) {
            return true;
        }
        if (C12243o.m40286b(context).length() == 0) {
            return false;
        }
        if (!C12243o.m40284a(context)) {
            return true;
        }
        if (!C12243o.m40285a(context, 1) || !C12243o.m40285a(context, 3) || !C12243o.m40287b(context, 82)) {
            z = false;
        }
        return z;
    }

    /* renamed from: c */
    private static boolean m40320c(Context context) {
        return C12212a.CMPGDPRDisabled.mo39543e().equals(C12243o.m40289d(context)) || C12212a.CMPGDPRUnknown.mo39543e().equals(C12243o.m40289d(context));
    }
}
