package com.paypal.android.sdk.payments;

import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnClickListener;
import com.paypal.android.sdk.C11756Pb;
import com.paypal.android.sdk.C11761Rb;
import com.paypal.android.sdk.C11799cc;
import java.util.List;

/* renamed from: com.paypal.android.sdk.payments.p */
final class C11960p implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C11799cc f37597a;

    /* renamed from: b */
    final /* synthetic */ List f37598b;

    /* renamed from: c */
    final /* synthetic */ LoginActivity f37599c;

    C11960p(LoginActivity loginActivity, C11799cc ccVar, List list) {
        this.f37599c = loginActivity;
        this.f37597a = ccVar;
        this.f37598b = list;
    }

    public final void onClick(View view) {
        Builder builder = new Builder(view.getContext());
        builder.setTitle(C11756Pb.m38949a(C11761Rb.TWO_FACTOR_AUTH_ENTER_MOBILE_NUMBER)).setAdapter(this.f37597a, new C11963q(this));
        builder.create().show();
    }
}
