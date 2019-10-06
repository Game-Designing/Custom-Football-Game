package com.smaato.soma.p239c.p254k;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.RadioGroup;

/* renamed from: com.smaato.soma.c.k.k */
/* compiled from: CustomWebView */
class C12296k implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RadioGroup f38468a;

    /* renamed from: b */
    final /* synthetic */ C12297l f38469b;

    C12296k(C12297l this$1, RadioGroup radioGroup) {
        this.f38469b = this$1;
        this.f38468a = radioGroup;
    }

    public void onClick(DialogInterface dialog, int whichButton) {
        new C12295j(this).execute();
    }
}
