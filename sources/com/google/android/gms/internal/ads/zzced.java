package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.common.util.PlatformVersion;

@TargetApi(19)
public final class zzced {

    /* renamed from: a */
    private Context f26469a;

    /* renamed from: b */
    private PopupWindow f26470b;

    /* renamed from: a */
    public final void mo31135a(Context context, View view) {
        if (PlatformVersion.m22112f() && !PlatformVersion.m22114h()) {
            this.f26470b = m28324b(context, view);
            if (this.f26470b == null) {
                context = null;
            }
            this.f26469a = context;
        }
    }

    /* renamed from: a */
    public final void mo31134a() {
        Context context = this.f26469a;
        if (context != null && this.f26470b != null) {
            if (!(context instanceof Activity) || !((Activity) context).isDestroyed()) {
                if (this.f26470b.isShowing()) {
                    this.f26470b.dismiss();
                }
                this.f26469a = null;
                this.f26470b = null;
                return;
            }
            this.f26469a = null;
            this.f26470b = null;
        }
    }

    /* renamed from: b */
    private static PopupWindow m28324b(Context context, View view) {
        Window window;
        if (context instanceof Activity) {
            window = ((Activity) context).getWindow();
        } else {
            window = null;
        }
        if (window == null || window.getDecorView() == null || ((Activity) context).isDestroyed()) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        frameLayout.addView(view, -1, -1);
        PopupWindow popupWindow = new PopupWindow(frameLayout, 1, 1, false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setClippingEnabled(false);
        zzbad.m26352a("Displaying the 1x1 popup off the screen.");
        try {
            popupWindow.showAtLocation(window.getDecorView(), 0, -1, -1);
            return popupWindow;
        } catch (Exception e) {
            return null;
        }
    }
}
