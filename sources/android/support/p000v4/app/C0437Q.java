package android.support.p000v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.app.Q */
/* compiled from: FragmentTransitionCompat21 */
class C0437Q extends C0441V {
    C0437Q() {
    }

    /* renamed from: a */
    public boolean mo4734a(Object transition) {
        return transition instanceof Transition;
    }

    /* renamed from: b */
    public Object mo4735b(Object transition) {
        if (transition != null) {
            return ((Transition) transition).clone();
        }
        return null;
    }

    /* renamed from: c */
    public Object mo4740c(Object transition) {
        if (transition == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) transition);
        return transitionSet;
    }

    /* renamed from: b */
    public void mo4738b(Object transitionObj, View nonExistentView, ArrayList<View> sharedViews) {
        TransitionSet transition = (TransitionSet) transitionObj;
        List<View> views = transition.getTargets();
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
            Transition transition = (Transition) transitionObj;
            Rect epicenter = new Rect();
            mo5085a(view, epicenter);
            transition.setEpicenterCallback(new C0433M(this, epicenter));
        }
    }

    /* renamed from: a */
    public void mo4732a(Object transitionObj, ArrayList<View> views) {
        Transition transition = (Transition) transitionObj;
        if (transition != null) {
            if (transition instanceof TransitionSet) {
                TransitionSet set = (TransitionSet) transition;
                int numTransitions = set.getTransitionCount();
                for (int i = 0; i < numTransitions; i++) {
                    mo4732a((Object) set.getTransitionAt(i), views);
                }
            } else if (!m2243a(transition) && C0441V.m2262a((List) transition.getTargets())) {
                int numViews = views.size();
                for (int i2 = 0; i2 < numViews; i2++) {
                    transition.addTarget((View) views.get(i2));
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m2243a(Transition transition) {
        return !C0441V.m2262a(transition.getTargetIds()) || !C0441V.m2262a(transition.getTargetNames()) || !C0441V.m2262a(transition.getTargetTypes());
    }

    /* renamed from: b */
    public Object mo4736b(Object transition1, Object transition2, Object transition3) {
        TransitionSet transitionSet = new TransitionSet();
        if (transition1 != null) {
            transitionSet.addTransition((Transition) transition1);
        }
        if (transition2 != null) {
            transitionSet.addTransition((Transition) transition2);
        }
        if (transition3 != null) {
            transitionSet.addTransition((Transition) transition3);
        }
        return transitionSet;
    }

    /* renamed from: a */
    public void mo4730a(Object exitTransitionObj, View fragmentView, ArrayList<View> exitingViews) {
        ((Transition) exitTransitionObj).addListener(new C0434N(this, fragmentView, exitingViews));
    }

    /* renamed from: a */
    public Object mo4726a(Object exitTransitionObj, Object enterTransitionObj, Object sharedElementTransitionObj) {
        Transition staggered = null;
        Transition exitTransition = (Transition) exitTransitionObj;
        Transition enterTransition = (Transition) enterTransitionObj;
        Transition sharedElementTransition = (Transition) sharedElementTransitionObj;
        if (exitTransition != null && enterTransition != null) {
            staggered = new TransitionSet().addTransition(exitTransition).addTransition(enterTransition).setOrdering(1);
        } else if (exitTransition != null) {
            staggered = exitTransition;
        } else if (enterTransition != null) {
            staggered = enterTransition;
        }
        if (sharedElementTransition == null) {
            return staggered;
        }
        TransitionSet together = new TransitionSet();
        if (staggered != null) {
            together.addTransition(staggered);
        }
        together.addTransition(sharedElementTransition);
        return together;
    }

    /* renamed from: a */
    public void mo4727a(ViewGroup sceneRoot, Object transition) {
        TransitionManager.beginDelayedTransition(sceneRoot, (Transition) transition);
    }

    /* renamed from: a */
    public void mo4731a(Object overallTransitionObj, Object enterTransition, ArrayList<View> enteringViews, Object exitTransition, ArrayList<View> exitingViews, Object sharedElementTransition, ArrayList<View> sharedElementsIn) {
        Transition overallTransition = (Transition) overallTransitionObj;
        C0435O o = new C0435O(this, enterTransition, enteringViews, exitTransition, exitingViews, sharedElementTransition, sharedElementsIn);
        overallTransition.addListener(o);
    }

    /* renamed from: b */
    public void mo4739b(Object sharedElementTransitionObj, ArrayList<View> sharedElementsOut, ArrayList<View> sharedElementsIn) {
        TransitionSet sharedElementTransition = (TransitionSet) sharedElementTransitionObj;
        if (sharedElementTransition != null) {
            sharedElementTransition.getTargets().clear();
            sharedElementTransition.getTargets().addAll(sharedElementsIn);
            mo4733a((Object) sharedElementTransition, sharedElementsOut, sharedElementsIn);
        }
    }

    /* renamed from: a */
    public void mo4733a(Object transitionObj, ArrayList<View> oldTargets, ArrayList<View> newTargets) {
        Transition transition = (Transition) transitionObj;
        if (transition instanceof TransitionSet) {
            TransitionSet set = (TransitionSet) transition;
            int numTransitions = set.getTransitionCount();
            for (int i = 0; i < numTransitions; i++) {
                mo4733a((Object) set.getTransitionAt(i), oldTargets, newTargets);
            }
        } else if (!m2243a(transition)) {
            List<View> targets = transition.getTargets();
            if (targets != null && targets.size() == oldTargets.size() && targets.containsAll(oldTargets)) {
                int targetCount = newTargets == null ? 0 : newTargets.size();
                for (int i2 = 0; i2 < targetCount; i2++) {
                    transition.addTarget((View) newTargets.get(i2));
                }
                for (int i3 = oldTargets.size() - 1; i3 >= 0; i3--) {
                    transition.removeTarget((View) oldTargets.get(i3));
                }
            }
        }
    }

    /* renamed from: a */
    public void mo4729a(Object transitionObj, View view) {
        if (transitionObj != null) {
            ((Transition) transitionObj).addTarget(view);
        }
    }

    /* renamed from: b */
    public void mo4737b(Object transitionObj, View view) {
        if (transitionObj != null) {
            ((Transition) transitionObj).removeTarget(view);
        }
    }

    /* renamed from: a */
    public void mo4728a(Object transitionObj, Rect epicenter) {
        if (transitionObj != null) {
            ((Transition) transitionObj).setEpicenterCallback(new C0436P(this, epicenter));
        }
    }
}
