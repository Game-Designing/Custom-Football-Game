package android.support.transition;

import android.animation.TimeInterpolator;
import android.support.transition.C0334M.C0336b;
import android.support.transition.C0334M.C0337c;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.transition.T */
/* compiled from: TransitionSet */
public class C0344T extends C0334M {

    /* renamed from: K */
    private ArrayList<C0334M> f1209K = new ArrayList<>();

    /* renamed from: L */
    private boolean f1210L = true;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public int f1211M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public boolean f1212N = false;

    /* renamed from: android.support.transition.T$a */
    /* compiled from: TransitionSet */
    static class C0345a extends C0338N {

        /* renamed from: a */
        C0344T f1213a;

        C0345a(C0344T transitionSet) {
            this.f1213a = transitionSet;
        }

        /* renamed from: c */
        public void mo4786c(C0334M transition) {
            if (!this.f1213a.f1212N) {
                this.f1213a.mo4782r();
                this.f1213a.f1212N = true;
            }
        }

        /* renamed from: d */
        public void mo4787d(C0334M transition) {
            C0344T.m1836c(this.f1213a);
            if (this.f1213a.f1211M == 0) {
                this.f1213a.f1212N = false;
                this.f1213a.mo4754a();
            }
            transition.mo4764b((C0337c) this);
        }
    }

    /* renamed from: c */
    static /* synthetic */ int m1836c(C0344T x0) {
        int i = x0.f1211M - 1;
        x0.f1211M = i;
        return i;
    }

    /* renamed from: b */
    public C0344T mo4795b(int ordering) {
        if (ordering == 0) {
            this.f1210L = true;
        } else if (ordering == 1) {
            this.f1210L = false;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid parameter for TransitionSet ordering: ");
            sb.append(ordering);
            throw new AndroidRuntimeException(sb.toString());
        }
        return this;
    }

    /* renamed from: b */
    public C0344T mo4796b(C0334M transition) {
        this.f1209K.add(transition);
        transition.f1189u = this;
        long j = this.f1174f;
        if (j >= 0) {
            transition.mo4748a(j);
        }
        return this;
    }

    /* renamed from: s */
    public int mo4797s() {
        return this.f1209K.size();
    }

    /* renamed from: a */
    public C0334M mo4794a(int index) {
        if (index < 0 || index >= this.f1209K.size()) {
            return null;
        }
        return (C0334M) this.f1209K.get(index);
    }

    /* renamed from: a */
    public C0344T m1842a(long duration) {
        super.mo4748a(duration);
        if (this.f1174f >= 0) {
            int numTransitions = this.f1209K.size();
            for (int i = 0; i < numTransitions; i++) {
                ((C0334M) this.f1209K.get(i)).mo4748a(duration);
            }
        }
        return this;
    }

    /* renamed from: b */
    public C0344T m1853b(long startDelay) {
        super.mo4763b(startDelay);
        return this;
    }

    /* renamed from: a */
    public C0344T mo4749a(TimeInterpolator interpolator) {
        super.mo4749a(interpolator);
        return this;
    }

    /* renamed from: a */
    public C0344T m1845a(View target) {
        for (int i = 0; i < this.f1209K.size(); i++) {
            ((C0334M) this.f1209K.get(i)).mo4751a(target);
        }
        super.mo4751a(target);
        return this;
    }

    /* renamed from: a */
    public C0344T m1844a(C0337c listener) {
        super.mo4750a(listener);
        return this;
    }

    /* renamed from: d */
    public C0344T m1860d(View target) {
        for (int i = 0; i < this.f1209K.size(); i++) {
            ((C0334M) this.f1209K.get(i)).mo4771d(target);
        }
        super.mo4771d(target);
        return this;
    }

    /* renamed from: b */
    public C0344T m1854b(C0337c listener) {
        super.mo4764b(listener);
        return this;
    }

    /* renamed from: t */
    private void m1837t() {
        C0345a listener = new C0345a(this);
        Iterator it = this.f1209K.iterator();
        while (it.hasNext()) {
            ((C0334M) it.next()).mo4750a((C0337c) listener);
        }
        this.f1211M = this.f1209K.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4758a(ViewGroup sceneRoot, C0348W startValues, C0348W endValues, ArrayList<C0347V> startValuesList, ArrayList<C0347V> endValuesList) {
        long startDelay = mo4775k();
        int numTransitions = this.f1209K.size();
        for (int i = 0; i < numTransitions; i++) {
            C0334M childTransition = (C0334M) this.f1209K.get(i);
            if (startDelay > 0 && (this.f1210L || i == 0)) {
                long childStartDelay = childTransition.mo4775k();
                if (childStartDelay > 0) {
                    childTransition.mo4763b(startDelay + childStartDelay);
                } else {
                    childTransition.mo4763b(startDelay);
                }
            }
            childTransition.mo4758a(sceneRoot, startValues, endValues, startValuesList, endValuesList);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void mo4781q() {
        if (this.f1209K.isEmpty()) {
            mo4782r();
            mo4754a();
            return;
        }
        m1837t();
        if (!this.f1210L) {
            for (int i = 1; i < this.f1209K.size(); i++) {
                ((C0334M) this.f1209K.get(i - 1)).mo4750a((C0337c) new C0343S(this, (C0334M) this.f1209K.get(i)));
            }
            C0334M firstTransition = (C0334M) this.f1209K.get(0);
            if (firstTransition != null) {
                firstTransition.mo4781q();
            }
        } else {
            Iterator it = this.f1209K.iterator();
            while (it.hasNext()) {
                ((C0334M) it.next()).mo4781q();
            }
        }
    }

    /* renamed from: c */
    public void mo4154c(C0347V transitionValues) {
        if (mo4767b(transitionValues.f1215b)) {
            Iterator it = this.f1209K.iterator();
            while (it.hasNext()) {
                C0334M childTransition = (C0334M) it.next();
                if (childTransition.mo4767b(transitionValues.f1215b)) {
                    childTransition.mo4154c(transitionValues);
                    transitionValues.f1216c.add(childTransition);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo4153a(C0347V transitionValues) {
        if (mo4767b(transitionValues.f1215b)) {
            Iterator it = this.f1209K.iterator();
            while (it.hasNext()) {
                C0334M childTransition = (C0334M) it.next();
                if (childTransition.mo4767b(transitionValues.f1215b)) {
                    childTransition.mo4153a(transitionValues);
                    transitionValues.f1216c.add(childTransition);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4766b(C0347V transitionValues) {
        super.mo4766b(transitionValues);
        int numTransitions = this.f1209K.size();
        for (int i = 0; i < numTransitions; i++) {
            ((C0334M) this.f1209K.get(i)).mo4766b(transitionValues);
        }
    }

    /* renamed from: c */
    public void mo4769c(View sceneRoot) {
        super.mo4769c(sceneRoot);
        int numTransitions = this.f1209K.size();
        for (int i = 0; i < numTransitions; i++) {
            ((C0334M) this.f1209K.get(i)).mo4769c(sceneRoot);
        }
    }

    /* renamed from: e */
    public void mo4773e(View sceneRoot) {
        super.mo4773e(sceneRoot);
        int numTransitions = this.f1209K.size();
        for (int i = 0; i < numTransitions; i++) {
            ((C0334M) this.f1209K.get(i)).mo4773e(sceneRoot);
        }
    }

    /* renamed from: a */
    public void mo4756a(C0336b epicenterCallback) {
        super.mo4756a(epicenterCallback);
        int numTransitions = this.f1209K.size();
        for (int i = 0; i < numTransitions; i++) {
            ((C0334M) this.f1209K.get(i)).mo4756a(epicenterCallback);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo4753a(String indent) {
        String result = super.mo4753a(indent);
        for (int i = 0; i < this.f1209K.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(result);
            sb.append("\n");
            C0334M m = (C0334M) this.f1209K.get(i);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(indent);
            sb2.append("  ");
            sb.append(m.mo4753a(sb2.toString()));
            result = sb.toString();
        }
        return result;
    }

    public C0334M clone() {
        C0344T clone = (C0344T) super.clone();
        clone.f1209K = new ArrayList<>();
        int numTransitions = this.f1209K.size();
        for (int i = 0; i < numTransitions; i++) {
            clone.mo4796b(((C0334M) this.f1209K.get(i)).clone());
        }
        return clone;
    }
}
