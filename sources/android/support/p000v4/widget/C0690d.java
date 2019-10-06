package android.support.p000v4.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* renamed from: android.support.v4.widget.d */
/* compiled from: CircularProgressDrawable */
class C0690d implements AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ C0693a f2017a;

    /* renamed from: b */
    final /* synthetic */ C0692f f2018b;

    C0690d(C0692f this$0, C0693a aVar) {
        this.f2018b = this$0;
        this.f2017a = aVar;
    }

    public void onAnimationUpdate(ValueAnimator animation) {
        float interpolatedTime = ((Float) animation.getAnimatedValue()).floatValue();
        this.f2018b.m3273b(interpolatedTime, this.f2017a);
        this.f2018b.m3269a(interpolatedTime, this.f2017a, false);
        this.f2018b.invalidateSelf();
    }
}
