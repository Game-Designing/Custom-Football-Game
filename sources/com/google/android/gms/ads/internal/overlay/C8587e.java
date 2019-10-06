package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzayb;

@VisibleForTesting
@zzard
/* renamed from: com.google.android.gms.ads.internal.overlay.e */
final class C8587e extends RelativeLayout {
    @VisibleForTesting

    /* renamed from: a */
    private zzayb f19080a;
    @VisibleForTesting

    /* renamed from: b */
    boolean f19081b;

    public C8587e(Context context, String str, String str2) {
        super(context);
        this.f19080a = new zzayb(context, str);
        this.f19080a.mo30276d(str2);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f19081b) {
            this.f19080a.mo30268a(motionEvent);
        }
        return false;
    }
}
