package com.paypal.android.sdk;

import android.text.TextUtils;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: com.paypal.android.sdk.Ma */
public class C11746Ma implements Interceptor {

    /* renamed from: a */
    private static final String f36752a = C11746Ma.class.getSimpleName();

    /* renamed from: b */
    private final String f36753b;

    public C11746Ma(String str) {
        this.f36753b = str;
    }

    /* renamed from: a */
    private static String m38896a(String str, String str2) {
        String str3 = "HmacSHA1";
        Mac instance = Mac.getInstance(str3);
        instance.init(new SecretKeySpec(str.getBytes(), str3));
        instance.update(str2.getBytes());
        byte[] doFinal = instance.doFinal();
        StringBuilder sb = new StringBuilder();
        for (byte valueOf : doFinal) {
            sb.append(String.format("%02x", new Object[]{Byte.valueOf(valueOf)}));
        }
        return sb.toString();
    }

    public Response intercept(Chain chain) {
        String str = "PayPal-Item-Id";
        Request request = chain.request();
        String format = String.format("Trace: [%s] %s, %s", new Object[]{this.f36753b, "\"%08.8x: Operation = %80s Duration: %8.2f Iterations: %+4d\"", "memorySize * 8 + offset"});
        try {
            Headers headers = request.headers();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < headers.size(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(headers.name(i));
                sb.append(": ");
                sb.append(headers.value(i));
                arrayList.add(sb.toString());
            }
            Collections.sort(arrayList);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(TextUtils.join(";", arrayList.toArray()));
            sb2.append(request.body());
            return chain.proceed(request.newBuilder().removeHeader(str).addHeader(str, m38896a(format, sb2.toString())).build());
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            return chain.proceed(request);
        }
    }
}
