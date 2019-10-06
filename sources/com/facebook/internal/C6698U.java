package com.facebook.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* renamed from: com.facebook.internal.U */
/* compiled from: WebDialog */
class C6698U implements OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ C6702Y f12233a;

    C6698U(C6702Y this$0) {
        this.f12233a = this$0;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f12233a.cancel();
    }
}
