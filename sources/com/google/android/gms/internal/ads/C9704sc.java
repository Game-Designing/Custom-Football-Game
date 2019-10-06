package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;

/* renamed from: com.google.android.gms.internal.ads.sc */
final class C9704sc implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ C9683rc f22949a;

    C9704sc(C9683rc rcVar) {
        this.f22949a = rcVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzk.zzlg();
        zzaxi.m26110a(this.f22949a.f22930a, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
