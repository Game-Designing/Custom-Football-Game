package android.support.transition;

import android.support.p000v4.view.C0646w;
import android.support.transition.C0334M.C0337c;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import p002b.p003c.p053g.p061f.C1253b;

/* renamed from: android.support.transition.P */
/* compiled from: TransitionManager */
public class C0340P {

    /* renamed from: a */
    private static C0334M f1202a = new C0361e();

    /* renamed from: b */
    private static ThreadLocal<WeakReference<C1253b<ViewGroup, ArrayList<C0334M>>>> f1203b = new ThreadLocal<>();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static ArrayList<ViewGroup> f1204c = new ArrayList<>();

    /* renamed from: android.support.transition.P$a */
    /* compiled from: TransitionManager */
    private static class C0341a implements OnPreDrawListener, OnAttachStateChangeListener {

        /* renamed from: a */
        C0334M f1205a;

        /* renamed from: b */
        ViewGroup f1206b;

        C0341a(C0334M transition, ViewGroup sceneRoot) {
            this.f1205a = transition;
            this.f1206b = sceneRoot;
        }

        /* renamed from: a */
        private void m1828a() {
            this.f1206b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f1206b.removeOnAttachStateChangeListener(this);
        }

        public void onViewAttachedToWindow(View v) {
        }

        public void onViewDetachedFromWindow(View v) {
            m1828a();
            C0340P.f1204c.remove(this.f1206b);
            ArrayList<Transition> runningTransitions = (ArrayList) C0340P.m1825b().get(this.f1206b);
            if (runningTransitions != null && runningTransitions.size() > 0) {
                Iterator it = runningTransitions.iterator();
                while (it.hasNext()) {
                    ((C0334M) it.next()).mo4773e(this.f1206b);
                }
            }
            this.f1205a.mo4760a(true);
        }

        public boolean onPreDraw() {
            m1828a();
            if (!C0340P.f1204c.remove(this.f1206b)) {
                return true;
            }
            ArrayMap<ViewGroup, ArrayList<Transition>> runningTransitions = C0340P.m1825b();
            ArrayList arrayList = (ArrayList) runningTransitions.get(this.f1206b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                runningTransitions.put(this.f1206b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f1205a);
            this.f1205a.mo4750a((C0337c) new C0339O(this, runningTransitions));
            this.f1205a.mo4759a(this.f1206b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((C0334M) it.next()).mo4773e(this.f1206b);
                }
            }
            this.f1205a.mo4757a(this.f1206b);
            return true;
        }
    }

    /* renamed from: b */
    static C1253b<ViewGroup, ArrayList<C0334M>> m1825b() {
        WeakReference weakReference = (WeakReference) f1203b.get();
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference(new C1253b<>());
            f1203b.set(weakReference);
        }
        return (C1253b) weakReference.get();
    }

    /* renamed from: b */
    private static void m1826b(ViewGroup sceneRoot, C0334M transition) {
        if (transition != null && sceneRoot != null) {
            C0341a listener = new C0341a(transition, sceneRoot);
            sceneRoot.addOnAttachStateChangeListener(listener);
            sceneRoot.getViewTreeObserver().addOnPreDrawListener(listener);
        }
    }

    /* renamed from: c */
    private static void m1827c(ViewGroup sceneRoot, C0334M transition) {
        ArrayList<Transition> runningTransitions = (ArrayList) m1825b().get(sceneRoot);
        if (runningTransitions != null && runningTransitions.size() > 0) {
            Iterator it = runningTransitions.iterator();
            while (it.hasNext()) {
                ((C0334M) it.next()).mo4769c((View) sceneRoot);
            }
        }
        if (transition != null) {
            transition.mo4759a(sceneRoot, true);
        }
        C0330I previousScene = C0330I.m1762a(sceneRoot);
        if (previousScene != null) {
            previousScene.mo4744a();
        }
    }

    /* renamed from: a */
    public static void m1824a(ViewGroup sceneRoot, C0334M transition) {
        if (!f1204c.contains(sceneRoot) && C0646w.m2987u(sceneRoot)) {
            f1204c.add(sceneRoot);
            if (transition == null) {
                transition = f1202a;
            }
            C0334M transitionClone = transition.clone();
            m1827c(sceneRoot, transitionClone);
            C0330I.m1763a(sceneRoot, null);
            m1826b(sceneRoot, transitionClone);
        }
    }
}
