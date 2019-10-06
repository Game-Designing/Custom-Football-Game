package android.support.design.widget;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import p002b.p003c.p050d.C1168b;
import p002b.p003c.p050d.C1173g;

/* renamed from: android.support.design.widget.ia */
/* compiled from: ViewUtilsLollipop */
class C0297ia {

    /* renamed from: a */
    private static final int[] f1103a = {16843848};

    /* renamed from: a */
    static void m1691a(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    /* renamed from: a */
    static void m1693a(View view, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        Context context = view.getContext();
        TypedArray a = context.obtainStyledAttributes(attrs, f1103a, defStyleAttr, defStyleRes);
        try {
            if (a.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, a.getResourceId(0, 0)));
            }
        } finally {
            a.recycle();
        }
    }

    /* renamed from: a */
    static void m1692a(View view, float elevation) {
        int dur = view.getResources().getInteger(C1173g.app_bar_elevation_anim_duration);
        StateListAnimator sla = new StateListAnimator();
        String str = "elevation";
        sla.addState(new int[]{16842766, C1168b.state_collapsible, -C1168b.state_collapsed}, ObjectAnimator.ofFloat(view, str, new float[]{0.0f}).setDuration((long) dur));
        sla.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, str, new float[]{elevation}).setDuration((long) dur));
        sla.addState(new int[0], ObjectAnimator.ofFloat(view, str, new float[]{0.0f}).setDuration(0));
        view.setStateListAnimator(sla);
    }
}
