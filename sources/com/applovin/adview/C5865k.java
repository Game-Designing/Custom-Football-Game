package com.applovin.adview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.applovin.adview.k */
class C5865k implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinConfirmationActivity f10205a;

    C5865k(AppLovinConfirmationActivity appLovinConfirmationActivity) {
        this.f10205a = appLovinConfirmationActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f10205a.finish();
    }
}
