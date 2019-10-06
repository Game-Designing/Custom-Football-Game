package com.crashlytics.android.p126c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.crashlytics.android.c.l */
/* compiled from: CrashPromptDialog */
class C6500l implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C6506b f11672a;

    C6500l(C6506b bVar) {
        this.f11672a = bVar;
    }

    public void onClick(DialogInterface dialog, int id) {
        this.f11672a.mo19587a(false);
        dialog.dismiss();
    }
}
