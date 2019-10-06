package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzyt;

@zzard
public final class zzp extends FrameLayout implements OnClickListener {

    /* renamed from: a */
    private final ImageButton f19113a;

    /* renamed from: b */
    private final zzx f19114b;

    public zzp(Context context, C8590h hVar, zzx zzx) {
        super(context);
        this.f19114b = zzx;
        setOnClickListener(this);
        this.f19113a = new ImageButton(context);
        this.f19113a.setImageResource(17301527);
        this.f19113a.setBackgroundColor(0);
        this.f19113a.setOnClickListener(this);
        ImageButton imageButton = this.f19113a;
        zzyt.m31532a();
        int a = zzazt.m26302a(context, hVar.f19085a);
        zzyt.m31532a();
        int a2 = zzazt.m26302a(context, 0);
        zzyt.m31532a();
        int a3 = zzazt.m26302a(context, hVar.f19086b);
        zzyt.m31532a();
        imageButton.setPadding(a, a2, a3, zzazt.m26302a(context, hVar.f19088d));
        this.f19113a.setContentDescription("Interstitial close button");
        ImageButton imageButton2 = this.f19113a;
        zzyt.m31532a();
        int a4 = zzazt.m26302a(context, hVar.f19089e + hVar.f19085a + hVar.f19086b);
        zzyt.m31532a();
        addView(imageButton2, new LayoutParams(a4, zzazt.m26302a(context, hVar.f19089e + hVar.f19088d), 17));
    }

    public final void onClick(View view) {
        zzx zzx = this.f19114b;
        if (zzx != null) {
            zzx.zztf();
        }
    }

    public final void zzaf(boolean z) {
        if (z) {
            this.f19113a.setVisibility(8);
        } else {
            this.f19113a.setVisibility(0);
        }
    }
}
