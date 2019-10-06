package com.crashlytics.android.p126c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.crashlytics.android.c.k */
/* compiled from: CrashPromptDialog */
class C6498k implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C6506b f11668a;

    C6498k(C6506b bVar) {
        this.f11668a = bVar;
    }

    public void onClick(DialogInterface dialog, int which) {
        this.f11668a.mo19587a(true);
        dialog.dismiss();
    }
}
