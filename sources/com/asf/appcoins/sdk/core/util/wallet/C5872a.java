package com.asf.appcoins.sdk.core.util.wallet;

import android.app.AlertDialog.Builder;
import android.content.Context;
import com.asf.appcoins.sdk.core.C5871R;
import p320f.p321a.C13811w;
import p320f.p321a.C13813y;

/* renamed from: com.asf.appcoins.sdk.core.util.wallet.a */
/* compiled from: lambda */
public final /* synthetic */ class C5872a implements C13813y {

    /* renamed from: a */
    private final /* synthetic */ Context f10212a;

    /* renamed from: b */
    private final /* synthetic */ String f10213b;

    public /* synthetic */ C5872a(Context context, String str) {
        this.f10212a = context;
        this.f10213b = str;
    }

    /* renamed from: a */
    public final void mo18351a(C13811w wVar) {
        new Builder(this.f10212a).setTitle(C5871R.string.wallet_missing).setMessage(this.f10213b).setPositiveButton(C5871R.string.install, new C5874c(wVar)).setNegativeButton(C5871R.string.skip, new C5875d(wVar)).setIcon(17301543).show();
    }
}
