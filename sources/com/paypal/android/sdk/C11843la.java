package com.paypal.android.sdk;

import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;

/* renamed from: com.paypal.android.sdk.la */
public final class C11843la implements Interceptor {

    /* renamed from: a */
    private final String f37271a;

    public C11843la(String str) {
        this.f37271a = str == null ? null : str.replaceAll("[^\\x00-\\x7F]", "");
    }

    public final Response intercept(Chain chain) {
        String str = "User-Agent";
        return chain.proceed(chain.request().newBuilder().removeHeader(str).addHeader(str, this.f37271a).build());
    }
}
