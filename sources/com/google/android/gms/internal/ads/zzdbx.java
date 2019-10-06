package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzdbx {

    /* renamed from: a */
    private static final CopyOnWriteArrayList<zzdbw> f27772a = new CopyOnWriteArrayList<>();

    /* renamed from: a */
    public static zzdbw m29165a(String str) throws GeneralSecurityException {
        Iterator it = f27772a.iterator();
        while (it.hasNext()) {
            zzdbw zzdbw = (zzdbw) it.next();
            if (zzdbw.mo31379a(str)) {
                return zzdbw;
            }
        }
        String str2 = "No KMS client does support: ";
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }
}
