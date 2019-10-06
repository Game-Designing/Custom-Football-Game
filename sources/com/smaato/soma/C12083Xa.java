package com.smaato.soma;

import android.animation.ObjectAnimator;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;

/* renamed from: com.smaato.soma.Xa */
/* compiled from: ToasterBanner */
class C12083Xa extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12366eb f37951a;

    C12083Xa(C12366eb this$0) {
        this.f37951a = this$0;
    }

    public Void process() throws Exception {
        ((LayoutParams) this.f37951a.f38628d.getLayoutParams()).addRule(12);
        this.f37951a.f38628d.requestLayout();
        this.f37951a.setVisibility(0);
        this.f37951a.f38628d.setVisibility(0);
        this.f37951a.f38627c.setVisibility(0);
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) this.f37951a.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(dm);
        int statusBarOffset = dm.heightPixels - this.f37951a.f38626b.getMeasuredHeight();
        this.f37951a.getLocationOnScreen(new int[2]);
        int yDest = (dm.heightPixels - this.f37951a.getMeasuredHeight()) - statusBarOffset;
        C12366eb ebVar = this.f37951a;
        ObjectAnimator pullUp = ObjectAnimator.ofFloat(ebVar, "translationY", new float[]{(float) ebVar.f38626b.getMeasuredHeight(), (float) (yDest - 20)});
        pullUp.setDuration(300);
        pullUp.start();
        pullUp.addListener(new C12081Wa(this, yDest));
        return null;
    }
}
