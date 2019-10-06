package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@zzard
public abstract class zzva {

    /* renamed from: a */
    private static MessageDigest f29523a = null;

    /* renamed from: b */
    protected Object f29524b = new Object();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract byte[] mo32305a(String str);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final MessageDigest mo32304a() {
        synchronized (this.f29524b) {
            if (f29523a != null) {
                MessageDigest messageDigest = f29523a;
                return messageDigest;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    f29523a = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException e) {
                }
            }
            MessageDigest messageDigest2 = f29523a;
            return messageDigest2;
        }
    }
}
