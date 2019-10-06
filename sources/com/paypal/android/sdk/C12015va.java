package com.paypal.android.sdk;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* renamed from: com.paypal.android.sdk.va */
final class C12015va implements Callback {

    /* renamed from: a */
    private final C11703Aa f37792a;

    private C12015va(C11995qa qaVar, C11703Aa aa) {
        this.f37792a = aa;
    }

    /* synthetic */ C12015va(C11995qa qaVar, C11703Aa aa, byte b) {
        this(qaVar, aa);
    }

    public final void onFailure(Call call, IOException iOException) {
        this.f37792a.mo38504b(iOException.getMessage());
        C11995qa.f37665b;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f37792a.mo38516n());
        sb.append(" failure: ");
        sb.append(iOException.getMessage());
    }

    public final void onResponse(Call call, Response response) {
        this.f37792a.mo38504b(response.body().string());
        C11995qa.f37665b;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f37792a.mo38516n());
        sb.append(" success");
    }
}
