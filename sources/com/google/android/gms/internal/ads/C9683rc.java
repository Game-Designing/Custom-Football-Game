package com.google.android.gms.internal.ads;

import android.app.AlertDialog.Builder;
import android.content.Context;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;

/* renamed from: com.google.android.gms.internal.ads.rc */
final class C9683rc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f22930a;

    /* renamed from: b */
    private final /* synthetic */ String f22931b;

    /* renamed from: c */
    private final /* synthetic */ boolean f22932c;

    /* renamed from: d */
    private final /* synthetic */ boolean f22933d;

    C9683rc(zzayi zzayi, Context context, String str, boolean z, boolean z2) {
        this.f22930a = context;
        this.f22931b = str;
        this.f22932c = z;
        this.f22933d = z2;
    }

    public final void run() {
        Builder builder = new Builder(this.f22930a);
        builder.setMessage(this.f22931b);
        if (this.f22932c) {
            builder.setTitle("Error");
        } else {
            builder.setTitle("Info");
        }
        String str = "Dismiss";
        if (this.f22933d) {
            builder.setNeutralButton(str, null);
        } else {
            builder.setPositiveButton(CtaButton.DEFAULT_CTA_TEXT, new C9704sc(this));
            builder.setNegativeButton(str, null);
        }
        builder.create().show();
    }
}
