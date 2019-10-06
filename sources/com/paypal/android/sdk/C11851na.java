package com.paypal.android.sdk;

import java.util.List;
import java.util.Map.Entry;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: com.paypal.android.sdk.na */
public class C11851na implements Interceptor {

    /* renamed from: a */
    private static final String f37278a = C11851na.class.getSimpleName();

    public Response intercept(Chain chain) {
        Request request = chain.request();
        for (Entry entry : request.headers().toMultimap().entrySet()) {
            for (String str : (List) entry.getValue()) {
                StringBuilder sb = new StringBuilder();
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append(str);
            }
        }
        return chain.proceed(request);
    }
}
