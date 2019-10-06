package com.inmobi.rendering.mraid;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.inmobi.commons.core.utilities.p225b.C10692c;
import com.inmobi.rendering.CustomView;
import com.inmobi.rendering.RenderView;

/* renamed from: com.inmobi.rendering.mraid.f */
/* compiled from: MraidResizeProcessor */
public final class C10783f {

    /* renamed from: d */
    private static final String f32947d = C10783f.class.getSimpleName();

    /* renamed from: a */
    public RenderView f32948a;

    /* renamed from: b */
    public ViewGroup f32949b;

    /* renamed from: c */
    public int f32950c;

    public C10783f(RenderView renderView) {
        this.f32948a = renderView;
    }

    /* renamed from: a */
    public final void mo34786a() {
        if (this.f32949b == null) {
            this.f32949b = (ViewGroup) this.f32948a.getParent();
            this.f32950c = this.f32949b.indexOfChild(this.f32948a);
        }
        C10786h resizeProperties = this.f32948a.getResizeProperties();
        FrameLayout frameLayout = new FrameLayout(this.f32948a.getContainerContext());
        LayoutParams layoutParams = new LayoutParams(this.f32948a.getWidth(), this.f32948a.getHeight());
        frameLayout.setId(65535);
        this.f32949b.addView(frameLayout, this.f32950c, layoutParams);
        this.f32949b.removeView(this.f32948a);
        float f = C10692c.m35104a().f32629c;
        int i = (int) ((((float) resizeProperties.f32959b) * f) + 0.5f);
        int i2 = (int) ((((float) resizeProperties.f32960c) * f) + 0.5f);
        FrameLayout frameLayout2 = (FrameLayout) this.f32949b.getRootView().findViewById(16908290);
        FrameLayout frameLayout3 = new FrameLayout(this.f32948a.getContainerContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(this.f32948a.getContainerContext());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i, i2);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i, i2);
        frameLayout3.setId(65534);
        if (this.f32948a.getParent() != null) {
            ((ViewGroup) this.f32948a.getParent()).removeAllViews();
        }
        relativeLayout.addView(this.f32948a, layoutParams4);
        String str = resizeProperties.f32958a;
        float f2 = C10692c.m35104a().f32629c;
        CustomView customView = new CustomView(this.f32948a.getContainerContext(), f2, 1);
        customView.setId(65531);
        customView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                C10783f.this.f32948a.mo33680b();
            }
        });
        String str2 = "center";
        String str3 = "bottom-left";
        String str4 = "top-center";
        String str5 = "bottom-center";
        String str6 = "bottom-right";
        String str7 = "top-right";
        if (str == null || str.length() == 0) {
            str = str7;
        } else if (!str.equals("top-left") && !str.equals(str7) && !str.equals(str3) && !str.equals(str6) && !str.equals(str4) && !str.equals(str5) && !str.equals(str2)) {
            str = str7;
        }
        int i3 = (int) (f2 * 50.0f);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(i3, i3);
        if (str.equals(str7) || str.equals(str6)) {
            layoutParams5.addRule(11);
        }
        if (str.equals(str6) || str.equals(str3) || str.equals(str5)) {
            layoutParams5.addRule(12);
            layoutParams5.addRule(4);
        }
        if (str.equals(str5) || str.equals(str4) || str.equals(str2)) {
            layoutParams5.addRule(13);
        }
        if (str.equals(str4)) {
            layoutParams5.addRule(10);
        }
        relativeLayout.addView(customView, layoutParams5);
        frameLayout3.addView(relativeLayout, layoutParams3);
        frameLayout2.addView(frameLayout3, layoutParams2);
        float f3 = C10692c.m35104a().f32629c;
        int i4 = (int) ((((float) resizeProperties.f32959b) * f3) + 0.5f);
        int i5 = (int) ((((float) resizeProperties.f32960c) * f3) + 0.5f);
        int i6 = (int) ((((float) resizeProperties.f32961d) * f3) + 0.5f);
        int i7 = (int) ((((float) resizeProperties.f32962e) * f3) + 0.5f);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        this.f32949b.getLocationOnScreen(iArr);
        frameLayout2.getLocationOnScreen(iArr2);
        iArr[1] = iArr[1] - iArr2[1];
        iArr[0] = iArr[0] - iArr2[0];
        iArr[0] = iArr[0] + i6;
        iArr[1] = iArr[1] + i7;
        if (!resizeProperties.f32963f) {
            if (i4 > frameLayout2.getWidth() - iArr[0]) {
                iArr[0] = frameLayout2.getWidth() - i4;
            }
            if (i5 > frameLayout2.getHeight() - iArr[1]) {
                iArr[1] = frameLayout2.getHeight() - i5;
            }
            if (iArr[0] < 0) {
                iArr[0] = 0;
            }
            if (iArr[1] < 0) {
                iArr[1] = 0;
            }
        }
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(i4, i5);
        layoutParams6.leftMargin = iArr[0];
        layoutParams6.topMargin = iArr[1];
        layoutParams6.gravity = 8388611;
        frameLayout3.setLayoutParams(layoutParams6);
        frameLayout3.setBackgroundColor(0);
    }
}
