package com.paypal.android.sdk;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* renamed from: com.paypal.android.sdk.ua */
final class C12011ua implements Callback {

    /* renamed from: a */
    private final C11703Aa f37783a;

    /* renamed from: b */
    private /* synthetic */ C11995qa f37784b;

    private C12011ua(C11995qa qaVar, C11703Aa aa) {
        this.f37784b = qaVar;
        this.f37783a = aa;
    }

    /* synthetic */ C12011ua(C11995qa qaVar, C11703Aa aa, byte b) {
        this(qaVar, aa);
    }

    /* renamed from: a */
    private String m39748a(String str) {
        Locale locale = Locale.US;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f37783a.mo38516n());
        sb.append(" PayPal Debug-ID: %s [%s, %s]");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.f37784b.f37672i.mo38525a());
        sb3.append(";");
        this.f37784b.f37672i;
        sb3.append("release");
        return String.format(locale, sb2, new Object[]{str, this.f37784b.f37668e, sb3.toString()});
    }

    public final void onFailure(Call call, IOException iOException) {
        String str = "paypal.sdk";
        try {
            this.f37783a.mo38504b(iOException.getMessage());
            String header = call.request().header("PayPal-Debug-Id");
            if (!TextUtils.isEmpty(header)) {
                Log.w(str, m39748a(header));
            }
            C11995qa.m39682a(this.f37784b, this.f37783a, (Response) null, iOException);
        } catch (Throwable th) {
            Log.e(str, "exception in response handler", th);
            throw th;
        }
    }

    public final void onResponse(Call call, Response response) {
        String str = "paypal.sdk";
        try {
            String header = response.header("paypal-debug-id");
            this.f37783a.mo38504b(response.body().string());
            if (!response.isSuccessful()) {
                if (!TextUtils.isEmpty(header)) {
                    Log.w(str, m39748a(header));
                }
                C11995qa.m39682a(this.f37784b, this.f37783a, response, (IOException) null);
                return;
            }
            this.f37783a.mo38506c(header);
            C11995qa.f37665b;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f37783a.mo38516n());
            sb.append(" success. response: ");
            sb.append(this.f37783a.mo38510g());
            if (!TextUtils.isEmpty(header)) {
                Log.w(str, m39748a(header));
            }
            if (this.f37783a.mo38519q()) {
                C11847ma.m39202b(this.f37783a);
            }
            this.f37784b.f37669f.mo38529a(this.f37783a);
        } catch (Throwable th) {
            Log.e(str, "exception in response handler", th);
            throw th;
        }
    }
}
