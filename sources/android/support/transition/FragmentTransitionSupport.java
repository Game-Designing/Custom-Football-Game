package android.support.transition;

import android.graphics.Rect;
import android.support.p000v4.app.C0441V;
import android.support.transition.C0334M.C0336b;
import android.support.transition.C0334M.C0337c;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class FragmentTransitionSupport extends C0441V {
    /* renamed from: a */
    public boolean mo4734a(Object transition) {
        return transition instanceof C0334M;
    }

    /* renamed from: b */
    public Object mo4735b(Object transition) {
        if (transition != null) {
            return ((C0334M) transition).clone();
        }
        return null;
    }

    /* renamed from: c */
    public Object mo4740c(Object transition) {
        if (transition == null) {
            return null;
        }
        C0344T transitionSet = new C0344T();
        transitionSet.mo4796b((C0334M) transition);
        return transitionSet;
    }

    /* renamed from: b */
    public void mo4738b(Object transitionObj, View nonExistentView, ArrayList<View> sharedViews) {
        C0344T transition = (C0344T) transitionObj;
        List<View> views = transition.mo4779o();
        views.clear();
        int count = sharedViews.size();
        for (int i = 0; i < count; i++) {
            C0441V.m2261a(views, (View) sharedViews.get(i));
        }
        views.add(nonExistentView);
        sharedViews.add(nonExistentView);
        mo4732a((Object) transition, sharedViews);
    }

    /* renamed from: c */
    public void mo4741c(Object transitionObj, View view) {
        if (view != null) {
            C0334M transition = (C0334M) transitionObj;
            Rect epicenter = new Rect();
            mo5085a(view, epicenter);
            transition.mo4756a((C0336b) new C0392s(this, epicenter));
        }
    }

    /* renamed from: a */
    public void mo4732a(Object transitionObj, ArrayList<View> views) {
        C0334M transition = (C0334M) transitionObj;
        if (transition != null) {
            if (transition instanceof C0344T) {
                C0344T set = (C0344T) transition;
                int numTransitions = set.mo4797s();
                for (int i = 0; i < numTransitions; i++) {
                    mo4732a((Object) set.mo4794a(i), views);
                }
            } else if (!m1744a(transition) && C0441V.m2262a((List) transition.mo4779o())) {
                int numViews = views.size();
                for (int i2 = 0; i2 < numViews; i2++) {
                    transition.mo4751a((View) views.get(i2));
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m1744a(C0334M transition) {
        return !C0441V.m2262a(transition.mo4776l()) || !C0441V.m2262a(transition.mo4777m()) || !C0441V.m2262a(transition.mo4778n());
    }

    /* renamed from: b */
    public Object mo4736b(Object transition1, Object transition2, Object transition3) {
        C0344T transitionSet = new C0344T();
        if (transition1 != null) {
            transitionSet.mo4796b((C0334M) transition1);
        }
        if (transition2 != null) {
            transitionSet.mo4796b((C0334M) transition2);
        }
        if (transition3 != null) {
            transitionSet.mo4796b((C0334M) transition3);
        }
        return transitionSet;
    }

    /* renamed from: a */
    public void mo4730a(Object exitTransitionObj, View fragmentView, ArrayList<View> exitingViews) {
        ((C0334M) exitTransitionObj).mo4750a((C0337c) new C0396t(this, fragmentView, exitingViews));
    }

    /* renamed from: a */
    public Object mo4726a(Object exitTransitionObj, Object enterTransitionObj, Object sharedElementTransitionObj) {
        C0334M staggered = null;
        C0334M exitTransition = (C0334M) exitTransitionObj;
        C0334M enterTransition = (C0334M) enterTransitionObj;
        C0334M sharedElementTransition = (C0334M) sharedElementTransitionObj;
        if (exitTransition != null && enterTransition != null) {
            C0344T t = new C0344T();
            t.mo4796b(exitTransition);
            t.mo4796b(enterTransition);
            staggered = t.mo4795b(1);
        } else if (exitTransition != null) {
            staggered = exitTransition;
        } else if (enterTransition != null) {
            staggered = enterTransition;
        }
        if (sharedElementTransition == null) {
            return staggered;
        }
        C0344T together = new C0344T();
        if (staggered != null) {
            together.mo4796b(staggered);
        }
        together.mo4796b(sharedElementTransition);
        return together;
    }

    /* renamed from: a */
    public void mo4727a(ViewGroup sceneRoot, Object transition) {
        C0340P.m1824a(sceneRoot, (C0334M) transition);
    }

    /* renamed from: a */
    public void mo4731a(Object overallTransitionObj, Object enterTransition, ArrayList<View> enteringViews, Object exitTransition, ArrayList<View> exitingViews, Object sharedElementTransition, ArrayList<View> sharedElementsIn) {
        C0334M overallTransition = (C0334M) overallTransitionObj;
        C0398u uVar = new C0398u(this, enterTransition, enteringViews, exitTransition, exitingViews, sharedElementTransition, sharedElementsIn);
        overallTransition.mo4750a((C0337c) uVar);
    }

    /* renamed from: b */
    public void mo4739b(Object sharedElementTransitionObj, ArrayList<View> sharedElementsOut, ArrayList<View> sharedElementsIn) {
        C0344T sharedElementTransition = (C0344T) sharedElementTransitionObj;
        if (sharedElementTransition != null) {
            sharedElementTransition.mo4779o().clear();
            sharedElementTransition.mo4779o().addAll(sharedElementsIn);
            mo4733a((Object) sharedElementTransition, sharedElementsOut, sharedElementsIn);
        }
    }

    /* renamed from: a */
    public void mo4733a(Object transitionObj, ArrayList<View> oldTargets, ArrayList<View> newTargets) {
        C0334M transition = (C0334M) transitionObj;
        if (transition instanceof C0344T) {
            C0344T set = (C0344T) transition;
            int numTransitions = set.mo4797s();
            for (int i = 0; i < numTransitions; i++) {
                mo4733a((Object) set.mo4794a(i), oldTargets, newTargets);
            }
        } else if (!m1744a(transition)) {
            List<View> targets = transition.mo4779o();
            if (targets.size() == oldTargets.size() && targets.containsAll(oldTargets)) {
                int targetCount = newTargets == null ? 0 : newTargets.size();
                for (int i2 = 0; i2 < targetCount; i2++) {
                    transition.mo4751a((View) newTargets.get(i2));
                }
                for (int i3 = oldTargets.size() - 1; i3 >= 0; i3--) {
                    transition.mo4771d((View) oldTargets.get(i3));
                }
            }
        }
    }

    /* renamed from: a */
    public void mo4729a(Object transitionObj, View view) {
        if (transitionObj != null) {
            ((C0334M) transitionObj).mo4751a(view);
        }
    }

    /* renamed from: b */
    public void mo4737b(Object transitionObj, View view) {
        if (transitionObj != null) {
            ((C0334M) transitionObj).mo4771d(view);
        }
    }

    /* renamed from: a */
    public void mo4728a(Object transitionObj, Rect epicenter) {
        if (transitionObj != null) {
            ((C0334M) transitionObj).mo4756a((C0336b) new C0400v(this, epicenter));
        }
    }
}
