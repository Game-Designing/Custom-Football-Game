package android.support.design.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* renamed from: android.support.design.widget.V */
/* compiled from: StateListAnimator */
final class C0274V {

    /* renamed from: a */
    private final ArrayList<C0275a> f1063a = new ArrayList<>();

    /* renamed from: b */
    private C0275a f1064b = null;

    /* renamed from: c */
    ValueAnimator f1065c = null;

    /* renamed from: d */
    private final AnimatorListener f1066d = new C0273U(this);

    /* renamed from: android.support.design.widget.V$a */
    /* compiled from: StateListAnimator */
    static class C0275a {

        /* renamed from: a */
        final int[] f1067a;

        /* renamed from: b */
        final ValueAnimator f1068b;

        C0275a(int[] specs, ValueAnimator animator) {
            this.f1067a = specs;
            this.f1068b = animator;
        }
    }

    C0274V() {
    }

    /* renamed from: a */
    public void mo4630a(int[] specs, ValueAnimator animator) {
        C0275a tuple = new C0275a(specs, animator);
        animator.addListener(this.f1066d);
        this.f1063a.add(tuple);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4629a(int[] state) {
        C0275a match = null;
        int count = this.f1063a.size();
        int i = 0;
        while (true) {
            if (i >= count) {
                break;
            }
            C0275a tuple = (C0275a) this.f1063a.get(i);
            if (StateSet.stateSetMatches(tuple.f1067a, state)) {
                match = tuple;
                break;
            }
            i++;
        }
        C0275a aVar = this.f1064b;
        if (match != aVar) {
            if (aVar != null) {
                m1663b();
            }
            this.f1064b = match;
            if (match != null) {
                m1662a(match);
            }
        }
    }

    /* renamed from: a */
    private void m1662a(C0275a match) {
        this.f1065c = match.f1068b;
        this.f1065c.start();
    }

    /* renamed from: b */
    private void m1663b() {
        ValueAnimator valueAnimator = this.f1065c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f1065c = null;
        }
    }

    /* renamed from: a */
    public void mo4628a() {
        ValueAnimator valueAnimator = this.f1065c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f1065c = null;
        }
    }
}
