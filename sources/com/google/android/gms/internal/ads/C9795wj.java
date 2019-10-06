package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.gms.internal.ads.wj */
final class C9795wj implements Runnable {
    private C9795wj() {
    }

    public final void run() {
        try {
            C9318aj.f22089b = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        } finally {
            C9318aj.f22092e.countDown();
        }
    }
}
