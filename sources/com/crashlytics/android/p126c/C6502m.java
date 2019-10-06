package com.crashlytics.android.p126c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.crashlytics.android.c.m */
/* compiled from: CrashPromptDialog */
class C6502m implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C6505a f11673a;

    /* renamed from: b */
    final /* synthetic */ C6506b f11674b;

    C6502m(C6505a aVar, C6506b bVar) {
        this.f11673a = aVar;
        this.f11674b = bVar;
    }

    public void onClick(DialogInterface dialog, int id) {
        this.f11673a.mo19504a(true);
        this.f11674b.mo19587a(true);
        dialog.dismiss();
    }
}
