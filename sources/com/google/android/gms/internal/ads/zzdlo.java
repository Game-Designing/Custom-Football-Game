package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

public final class zzdlo {

    /* renamed from: a */
    private static final ThreadLocal<SecureRandom> f27963a = new C9389do();

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static SecureRandom m29628b() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    /* renamed from: a */
    public static byte[] m29627a(int i) {
        byte[] bArr = new byte[i];
        ((SecureRandom) f27963a.get()).nextBytes(bArr);
        return bArr;
    }
}
