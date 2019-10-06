package com.paypal.android.sdk;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* renamed from: com.paypal.android.sdk.ia */
final class C11831ia implements HostnameVerifier {
    C11831ia() {
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
