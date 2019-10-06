package com.adyen.p081ui.views.loadinganimation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.HashMap;

/* renamed from: com.adyen.ui.views.loadinganimation.c */
/* compiled from: ThreeDotsLoadingAnimation */
public class C5654c extends C5652a {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int[] f9587f = {60, 60, 255};

    /* renamed from: a */
    public void mo17845a(Canvas canvas, Paint paint) {
        float radius = (((float) mo17846b()) - (14.0f * 2.0f)) / 6.0f;
        float x = (((float) mo17846b()) / 2.0f) - ((radius * 2.0f) + 14.0f);
        float y = ((float) mo17843a()) / 2.0f;
        for (int i = 0; i < 3; i++) {
            canvas.save();
            canvas.translate((radius * 2.0f * ((float) i)) + x + (((float) i) * 14.0f), y);
            paint.setAlpha(this.f9587f[i]);
            canvas.drawCircle(0.0f, 0.0f, radius, paint);
            canvas.restore();
        }
    }

    /* renamed from: c */
    public HashMap<ValueAnimator, AnimatorUpdateListener> mo17847c() {
        HashMap<ValueAnimator, AnimatorUpdateListener> animators = new HashMap<>();
        int[] delays = {300, 600, 0};
        for (int i = 0; i < 3; i++) {
            int index = i;
            ValueAnimator alphaAnim = ValueAnimator.ofInt(new int[]{255, 60, 60});
            alphaAnim.setDuration(900);
            alphaAnim.setRepeatCount(-1);
            alphaAnim.setStartDelay((long) delays[i]);
            animators.put(alphaAnim, new C5653b(this, index));
        }
        return animators;
    }
}
