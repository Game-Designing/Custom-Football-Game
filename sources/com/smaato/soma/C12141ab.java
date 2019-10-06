package com.smaato.soma;

import android.animation.ObjectAnimator;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* renamed from: com.smaato.soma.ab */
/* compiled from: ToasterBanner */
class C12141ab extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12366eb f38064a;

    C12141ab(C12366eb this$0) {
        this.f38064a = this$0;
    }

    public Void process() throws Exception {
        try {
            DisplayMetrics dm = new DisplayMetrics();
            ((WindowManager) this.f38064a.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(dm);
            int statusBarOffset = dm.heightPixels - this.f38064a.f38626b.getMeasuredHeight();
            int[] originalPos = new int[2];
            this.f38064a.getLocationOnScreen(originalPos);
            int yDest = (dm.heightPixels - this.f38064a.getMeasuredHeight()) - statusBarOffset;
            if (originalPos[1] < dm.heightPixels) {
                ObjectAnimator pullUp = ObjectAnimator.ofFloat(this.f38064a, "translationY", new float[]{(float) yDest, (float) this.f38064a.f38626b.getMeasuredHeight()});
                pullUp.setDuration(300);
                pullUp.addListener(new C12088_a(this));
                pullUp.start();
            }
        } catch (Exception e) {
        }
        return null;
    }
}
