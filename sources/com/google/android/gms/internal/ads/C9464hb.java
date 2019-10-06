package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzk;

/* renamed from: com.google.android.gms.internal.ads.hb */
final class C9464hb implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ zzapo f22400a;

    C9464hb(zzapo zzapo) {
        this.f22400a = zzapo;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent a = this.f22400a.mo29973a();
        zzk.zzlg();
        zzaxi.m26109a(this.f22400a.f24528d, a);
    }
}
