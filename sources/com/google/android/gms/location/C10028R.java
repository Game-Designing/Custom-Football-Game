package com.google.android.gms.location;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.google.android.gms.location.R */
public final class C10028R {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f30525a;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m32683a() {
        boolean[] zArr = f30525a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8132876748097460738L, "com/google/android/gms/location/R", 1);
        f30525a = probes;
        return probes;
    }

    private C10028R() {
        m32683a()[0] = true;
    }
}
