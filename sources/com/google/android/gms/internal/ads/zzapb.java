package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;

@zzard
public class zzapb {
    /* renamed from: a */
    public static zzaov m25606a(String str) throws RemoteException {
        try {
            return new zzapc((RtbAdapter) Class.forName(str, false, zzapb.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Throwable th) {
            throw new RemoteException();
        }
    }
}
