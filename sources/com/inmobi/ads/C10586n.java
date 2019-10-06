package com.inmobi.ads;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.inmobi.ads.C10441ba.C10442a;
import com.inmobi.ads.NativeContainerLayout.C10324a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.inmobi.ads.n */
/* compiled from: AnimationManager */
public class C10586n {

    /* renamed from: c */
    private static final String f32252c = C10586n.class.getSimpleName();

    /* renamed from: a */
    List<C10589a> f32253a = new ArrayList();

    /* renamed from: b */
    boolean f32254b = false;

    /* renamed from: com.inmobi.ads.n$a */
    /* compiled from: AnimationManager */
    class C10589a {

        /* renamed from: a */
        Animator f32261a;

        /* renamed from: b */
        long f32262b;

        /* renamed from: c */
        boolean f32263c;

        C10589a(Animator animator) {
            this.f32261a = animator;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final List<C10589a> mo34385a(final View view, C10400ak akVar) {
        LinkedList linkedList = new LinkedList();
        try {
            float c = (float) NativeViewFactory.m33765c(akVar.f31610c.f31635c.x);
            float c2 = (float) NativeViewFactory.m33765c(akVar.f31610c.f31636d.x);
            if (c != c2) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) ((int) c), (float) ((int) c2)});
                final C10324a aVar = (C10324a) view.getLayoutParams();
                ofFloat.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        aVar.f31350a = ((Float) valueAnimator.getAnimatedValue()).intValue();
                        view.setLayoutParams(aVar);
                        view.requestLayout();
                    }
                });
                linkedList.add(m34721a((Animator) ofFloat, akVar));
            }
            float c3 = (float) NativeViewFactory.m33765c(akVar.f31610c.f31635c.y);
            float c4 = (float) NativeViewFactory.m33765c(akVar.f31610c.f31636d.y);
            if (c3 != c4) {
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{(float) ((int) c3), (float) ((int) c4)});
                final C10324a aVar2 = (C10324a) view.getLayoutParams();
                ofFloat2.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        aVar2.f31351b = ((Float) valueAnimator.getAnimatedValue()).intValue();
                        view.setLayoutParams(aVar2);
                        view.requestLayout();
                    }
                });
                linkedList.add(m34721a((Animator) ofFloat2, akVar));
            }
            float c5 = (float) NativeViewFactory.m33765c(akVar.f31610c.f31633a.x);
            float c6 = (float) NativeViewFactory.m33765c(akVar.f31610c.f31634b.x);
            if (c5 != c6) {
                linkedList.add(m34721a(m34720a(view, "scaleX", c5, c6), akVar));
            }
            float c7 = (float) NativeViewFactory.m33765c(akVar.f31610c.f31633a.y);
            float c8 = (float) NativeViewFactory.m33765c(akVar.f31610c.f31634b.y);
            if (c7 != c8) {
                linkedList.add(m34721a(m34720a(view, "scaleY", c7, c8), akVar));
            }
        } catch (Exception e) {
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        return linkedList;
    }

    /* renamed from: a */
    private C10589a m34721a(Animator animator, C10400ak akVar) {
        animator.setDuration(0);
        animator.setStartDelay(0);
        C10441ba g = akVar.f31610c.mo34097g();
        if (g != null) {
            C10442a aVar = g.f31760a;
            C10442a aVar2 = g.f31761b;
            if (aVar2 != null) {
                animator.setDuration(aVar2.mo34144a() * 1000);
            }
            if (aVar != null) {
                animator.setStartDelay(aVar.mo34144a() * 1000);
            }
        }
        return new C10589a(animator);
    }

    /* renamed from: a */
    private static Animator m34720a(View view, String str, float f, float f2) {
        float f3 = f2 / f;
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        return ObjectAnimator.ofFloat(view, str, new float[]{f3});
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34386a(List<C10589a> list) {
        if (list != null) {
            for (C10589a aVar : list) {
                if (!aVar.f32263c) {
                    ValueAnimator valueAnimator = (ValueAnimator) aVar.f32261a;
                    valueAnimator.setCurrentPlayTime(aVar.f32262b);
                    valueAnimator.start();
                }
                if (!this.f32253a.contains(aVar)) {
                    this.f32253a.add(aVar);
                }
            }
        }
    }
}
