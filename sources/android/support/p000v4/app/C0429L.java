package android.support.p000v4.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.p000v4.view.C0646w;
import android.support.v4.app.FragmentTransition.FragmentContainerTransition;
import android.support.v4.util.ArrayMap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import p002b.p003c.p053g.p061f.C1253b;

/* renamed from: android.support.v4.app.L */
/* compiled from: FragmentTransition */
class C0429L {

    /* renamed from: a */
    private static final int[] f1450a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    /* renamed from: b */
    private static final C0441V f1451b = (VERSION.SDK_INT >= 21 ? new C0437Q() : null);

    /* renamed from: c */
    private static final C0441V f1452c = m2186a();

    /* renamed from: android.support.v4.app.L$a */
    /* compiled from: FragmentTransition */
    static class C0430a {

        /* renamed from: a */
        public Fragment f1453a;

        /* renamed from: b */
        public boolean f1454b;

        /* renamed from: c */
        public C0467f f1455c;

        /* renamed from: d */
        public Fragment f1456d;

        /* renamed from: e */
        public boolean f1457e;

        /* renamed from: f */
        public C0467f f1458f;

        C0430a() {
        }
    }

    /* renamed from: a */
    private static C0441V m2186a() {
        try {
            return (C0441V) Class.forName("android.support.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    static void m2198a(C0409A fragmentManager, ArrayList<C0467f> records, ArrayList<Boolean> isRecordPop, int startIndex, int endIndex, boolean isReordered) {
        if (fragmentManager.f1364r >= 1) {
            SparseArray<FragmentContainerTransition> transitioningFragments = new SparseArray<>();
            for (int i = startIndex; i < endIndex; i++) {
                C0467f record = (C0467f) records.get(i);
                if (((Boolean) isRecordPop.get(i)).booleanValue()) {
                    m2216b(record, transitioningFragments, isReordered);
                } else {
                    m2204a(record, transitioningFragments, isReordered);
                }
            }
            if (transitioningFragments.size() != 0) {
                View nonExistentView = new View(fragmentManager.f1365s.mo5227c());
                int numContainers = transitioningFragments.size();
                for (int i2 = 0; i2 < numContainers; i2++) {
                    int containerId = transitioningFragments.keyAt(i2);
                    ArrayMap<String, String> nameOverrides = m2189a(containerId, records, isRecordPop, startIndex, endIndex);
                    C0430a containerTransition = (C0430a) transitioningFragments.valueAt(i2);
                    if (isReordered) {
                        m2214b(fragmentManager, containerId, containerTransition, nonExistentView, (C1253b<String, String>) nameOverrides);
                    } else {
                        m2197a(fragmentManager, containerId, containerTransition, nonExistentView, (C1253b<String, String>) nameOverrides);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static C1253b<String, String> m2189a(int containerId, ArrayList<C0467f> records, ArrayList<Boolean> isRecordPop, int startIndex, int endIndex) {
        ArrayList<String> sources;
        ArrayList<String> targets;
        ArrayMap<String, String> nameOverrides = new C1253b<>();
        for (int recordNum = endIndex - 1; recordNum >= startIndex; recordNum--) {
            C0467f record = (C0467f) records.get(recordNum);
            if (record.mo5156b(containerId)) {
                boolean isPop = ((Boolean) isRecordPop.get(recordNum)).booleanValue();
                ArrayList<String> arrayList = record.f1592r;
                if (arrayList != null) {
                    int numSharedElements = arrayList.size();
                    if (isPop) {
                        targets = record.f1592r;
                        sources = record.f1593s;
                    } else {
                        sources = record.f1592r;
                        targets = record.f1593s;
                    }
                    for (int i = 0; i < numSharedElements; i++) {
                        String sourceName = (String) sources.get(i);
                        String targetName = (String) targets.get(i);
                        String previousTarget = (String) nameOverrides.remove(targetName);
                        if (previousTarget != null) {
                            nameOverrides.put(sourceName, previousTarget);
                        } else {
                            nameOverrides.put(sourceName, targetName);
                        }
                    }
                }
            }
        }
        return nameOverrides;
    }

    /* renamed from: b */
    private static void m2214b(C0409A fragmentManager, int containerId, C0430a fragments, View nonExistentView, C1253b<String, String> nameOverrides) {
        ViewGroup sceneRoot;
        Object exitTransition;
        C0409A a = fragmentManager;
        C0430a aVar = fragments;
        View view = nonExistentView;
        if (a.f1366t.mo227a()) {
            sceneRoot = (ViewGroup) a.f1366t.mo221a(containerId);
        } else {
            int i = containerId;
            sceneRoot = null;
        }
        if (sceneRoot != null) {
            Fragment inFragment = aVar.f1453a;
            Fragment outFragment = aVar.f1456d;
            C0441V impl = m2187a(outFragment, inFragment);
            if (impl != null) {
                boolean inIsPop = aVar.f1454b;
                boolean outIsPop = aVar.f1457e;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Object enterTransition = m2192a(impl, inFragment, inIsPop);
                Object exitTransition2 = m2211b(impl, outFragment, outIsPop);
                ArrayList arrayList3 = arrayList2;
                ArrayList arrayList4 = arrayList;
                boolean z = outIsPop;
                boolean inIsPop2 = inIsPop;
                Object enterTransition2 = enterTransition;
                C0441V impl2 = impl;
                Object sharedElementTransition = m2212b(impl, sceneRoot, nonExistentView, nameOverrides, fragments, arrayList3, arrayList4, enterTransition2, exitTransition2);
                if (enterTransition2 == null && sharedElementTransition == null) {
                    exitTransition = exitTransition2;
                    if (exitTransition == null) {
                        return;
                    }
                } else {
                    exitTransition = exitTransition2;
                }
                ArrayList<View> exitingViews = m2213b(impl2, exitTransition, outFragment, arrayList3, view);
                ArrayList arrayList5 = arrayList4;
                ArrayList<View> enteringViews = m2213b(impl2, enterTransition2, inFragment, arrayList5, view);
                m2217b(enteringViews, 4);
                ArrayList<View> enteringViews2 = enteringViews;
                ArrayList arrayList6 = arrayList5;
                ArrayList<View> exitingViews2 = exitingViews;
                Object transition = m2194a(impl2, enterTransition2, exitTransition, sharedElementTransition, inFragment, inIsPop2);
                if (transition != null) {
                    m2201a(impl2, exitTransition, outFragment, exitingViews2);
                    ArrayList<String> inNames = impl2.mo5084a(arrayList6);
                    Object transition2 = transition;
                    Object obj = exitTransition;
                    Object obj2 = enterTransition2;
                    impl2.mo4731a(transition, enterTransition2, enteringViews2, exitTransition, exitingViews2, sharedElementTransition, arrayList6);
                    impl2.mo4727a(sceneRoot, transition2);
                    impl2.mo5086a(sceneRoot, arrayList3, arrayList6, inNames, nameOverrides);
                    m2217b(enteringViews2, 0);
                    impl2.mo4739b(sharedElementTransition, arrayList3, arrayList6);
                } else {
                    Object obj3 = exitTransition;
                    Object obj4 = enterTransition2;
                    ArrayList arrayList7 = enteringViews2;
                    ArrayList arrayList8 = arrayList3;
                }
            }
        }
    }

    /* renamed from: a */
    private static void m2201a(C0441V impl, Object exitTransition, Fragment exitingFragment, ArrayList<View> exitingViews) {
        if (exitingFragment != null && exitTransition != null && exitingFragment.mAdded && exitingFragment.mHidden && exitingFragment.mHiddenChanged) {
            exitingFragment.setHideReplaced(true);
            impl.mo4730a(exitTransition, exitingFragment.getView(), exitingViews);
            C0464da.m2363a(exitingFragment.mContainer, new C0425H(exitingViews));
        }
    }

    /* renamed from: a */
    private static void m2197a(C0409A fragmentManager, int containerId, C0430a fragments, View nonExistentView, C1253b<String, String> nameOverrides) {
        ViewGroup sceneRoot;
        Object exitTransition;
        Object exitTransition2;
        C0409A a = fragmentManager;
        C0430a aVar = fragments;
        View view = nonExistentView;
        C1253b<String, String> bVar = nameOverrides;
        if (a.f1366t.mo227a()) {
            sceneRoot = (ViewGroup) a.f1366t.mo221a(containerId);
        } else {
            int i = containerId;
            sceneRoot = null;
        }
        if (sceneRoot != null) {
            Fragment inFragment = aVar.f1453a;
            Fragment outFragment = aVar.f1456d;
            C0441V impl = m2187a(outFragment, inFragment);
            if (impl != null) {
                boolean inIsPop = aVar.f1454b;
                boolean outIsPop = aVar.f1457e;
                Object enterTransition = m2192a(impl, inFragment, inIsPop);
                Object exitTransition3 = m2211b(impl, outFragment, outIsPop);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = arrayList;
                Object exitTransition4 = exitTransition3;
                Object enterTransition2 = enterTransition;
                boolean z = outIsPop;
                boolean z2 = inIsPop;
                C0441V impl2 = impl;
                Fragment outFragment2 = outFragment;
                Object sharedElementTransition = m2193a(impl, sceneRoot, nonExistentView, nameOverrides, fragments, arrayList3, arrayList2, enterTransition2, exitTransition4);
                Object enterTransition3 = enterTransition2;
                if (enterTransition3 == null && sharedElementTransition == null) {
                    exitTransition = exitTransition4;
                    if (exitTransition == null) {
                        return;
                    }
                } else {
                    exitTransition = exitTransition4;
                }
                ArrayList arrayList4 = arrayList3;
                ArrayList<View> sharedElementsOut = m2213b(impl2, exitTransition, outFragment2, arrayList4, view);
                if (sharedElementsOut == null || sharedElementsOut.isEmpty()) {
                    exitTransition2 = null;
                } else {
                    exitTransition2 = exitTransition;
                }
                impl2.mo4729a(enterTransition3, view);
                Object transition = m2194a(impl2, enterTransition3, exitTransition2, sharedElementTransition, inFragment, aVar.f1454b);
                if (transition != null) {
                    ArrayList<View> enteringViews = new ArrayList<>();
                    impl2.mo4731a(transition, enterTransition3, enteringViews, exitTransition2, sharedElementsOut, sharedElementTransition, arrayList2);
                    Object transition2 = transition;
                    ArrayList arrayList5 = arrayList4;
                    Object obj = enterTransition3;
                    m2200a(impl2, sceneRoot, inFragment, nonExistentView, arrayList2, enterTransition3, enteringViews, exitTransition2, sharedElementsOut);
                    ArrayList arrayList6 = arrayList2;
                    impl2.mo5087a((View) sceneRoot, arrayList6, (Map<String, String>) bVar);
                    impl2.mo4727a(sceneRoot, transition2);
                    impl2.mo5088a(sceneRoot, arrayList6, (Map<String, String>) bVar);
                } else {
                    ArrayList arrayList7 = arrayList4;
                    Object obj2 = enterTransition3;
                    ArrayList arrayList8 = arrayList2;
                }
            }
        }
    }

    /* renamed from: a */
    private static void m2200a(C0441V impl, ViewGroup sceneRoot, Fragment inFragment, View nonExistentView, ArrayList<View> sharedElementsIn, Object enterTransition, ArrayList<View> enteringViews, Object exitTransition, ArrayList<View> exitingViews) {
        C0426I i = new C0426I(enterTransition, impl, nonExistentView, inFragment, sharedElementsIn, enteringViews, exitingViews, exitTransition);
        ViewGroup viewGroup = sceneRoot;
        C0464da.m2363a(sceneRoot, i);
    }

    /* renamed from: a */
    private static C0441V m2187a(Fragment outFragment, Fragment inFragment) {
        ArrayList<Object> transitions = new ArrayList<>();
        if (outFragment != null) {
            Object exitTransition = outFragment.getExitTransition();
            if (exitTransition != null) {
                transitions.add(exitTransition);
            }
            Object returnTransition = outFragment.getReturnTransition();
            if (returnTransition != null) {
                transitions.add(returnTransition);
            }
            Object sharedReturnTransition = outFragment.getSharedElementReturnTransition();
            if (sharedReturnTransition != null) {
                transitions.add(sharedReturnTransition);
            }
        }
        if (inFragment != null) {
            Object enterTransition = inFragment.getEnterTransition();
            if (enterTransition != null) {
                transitions.add(enterTransition);
            }
            Object reenterTransition = inFragment.getReenterTransition();
            if (reenterTransition != null) {
                transitions.add(reenterTransition);
            }
            Object sharedEnterTransition = inFragment.getSharedElementEnterTransition();
            if (sharedEnterTransition != null) {
                transitions.add(sharedEnterTransition);
            }
        }
        if (transitions.isEmpty()) {
            return null;
        }
        C0441V v = f1451b;
        if (v != null && m2208a(v, (List<Object>) transitions)) {
            return f1451b;
        }
        C0441V v2 = f1452c;
        if (v2 != null && m2208a(v2, (List<Object>) transitions)) {
            return f1452c;
        }
        if (f1451b == null && f1452c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    /* renamed from: a */
    private static boolean m2208a(C0441V impl, List<Object> transitions) {
        int size = transitions.size();
        for (int i = 0; i < size; i++) {
            if (!impl.mo4734a(transitions.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static Object m2191a(C0441V impl, Fragment inFragment, Fragment outFragment, boolean isPop) {
        Object obj;
        if (inFragment == null || outFragment == null) {
            return null;
        }
        if (isPop) {
            obj = outFragment.getSharedElementReturnTransition();
        } else {
            obj = inFragment.getSharedElementEnterTransition();
        }
        return impl.mo4740c(impl.mo4735b(obj));
    }

    /* renamed from: a */
    private static Object m2192a(C0441V impl, Fragment inFragment, boolean isPop) {
        Object obj;
        if (inFragment == null) {
            return null;
        }
        if (isPop) {
            obj = inFragment.getReenterTransition();
        } else {
            obj = inFragment.getEnterTransition();
        }
        return impl.mo4735b(obj);
    }

    /* renamed from: b */
    private static Object m2211b(C0441V impl, Fragment outFragment, boolean isPop) {
        Object obj;
        if (outFragment == null) {
            return null;
        }
        if (isPop) {
            obj = outFragment.getReturnTransition();
        } else {
            obj = outFragment.getExitTransition();
        }
        return impl.mo4735b(obj);
    }

    /* renamed from: b */
    private static Object m2212b(C0441V impl, ViewGroup sceneRoot, View nonExistentView, C1253b<String, String> nameOverrides, C0430a fragments, ArrayList<View> sharedElementsOut, ArrayList<View> sharedElementsIn, Object enterTransition, Object exitTransition) {
        Object sharedElementTransition;
        Object sharedElementTransition2;
        Object sharedElementTransition3;
        Rect epicenter;
        View epicenterView;
        C1253b bVar;
        C0441V v = impl;
        View view = nonExistentView;
        C1253b<String, String> bVar2 = nameOverrides;
        C0430a aVar = fragments;
        ArrayList<View> arrayList = sharedElementsOut;
        ArrayList<View> arrayList2 = sharedElementsIn;
        Object obj = enterTransition;
        Fragment inFragment = aVar.f1453a;
        Fragment outFragment = aVar.f1456d;
        if (inFragment != null) {
            inFragment.getView().setVisibility(0);
        }
        if (inFragment == null) {
            ViewGroup viewGroup = sceneRoot;
            Fragment fragment = outFragment;
        } else if (outFragment == null) {
            ViewGroup viewGroup2 = sceneRoot;
            Fragment fragment2 = outFragment;
        } else {
            boolean inIsPop = aVar.f1454b;
            if (nameOverrides.isEmpty()) {
                sharedElementTransition = null;
            } else {
                sharedElementTransition = m2191a(v, inFragment, outFragment, inIsPop);
            }
            C1253b c = m2218c(v, bVar2, sharedElementTransition, aVar);
            C1253b b = m2210b(v, bVar2, sharedElementTransition, aVar);
            if (nameOverrides.isEmpty()) {
                if (c != null) {
                    c.clear();
                }
                if (b != null) {
                    b.clear();
                }
                sharedElementTransition2 = null;
            } else {
                m2207a(arrayList, c, (Collection<String>) nameOverrides.keySet());
                m2207a(arrayList2, b, nameOverrides.values());
                sharedElementTransition2 = sharedElementTransition;
            }
            if (obj == null && exitTransition == null && sharedElementTransition2 == null) {
                return null;
            }
            m2215b(inFragment, outFragment, inIsPop, c, true);
            if (sharedElementTransition2 != null) {
                arrayList2.add(view);
                v.mo4738b(sharedElementTransition2, view, arrayList);
                boolean outIsPop = aVar.f1457e;
                boolean outIsPop2 = outIsPop;
                sharedElementTransition3 = sharedElementTransition2;
                bVar = b;
                C1253b bVar3 = c;
                m2202a(impl, sharedElementTransition2, exitTransition, c, outIsPop2, aVar.f1458f);
                Rect epicenter2 = new Rect();
                View epicenterView2 = m2209b(bVar, aVar, obj, inIsPop);
                if (epicenterView2 != null) {
                    v.mo4728a(obj, epicenter2);
                }
                epicenter = epicenter2;
                epicenterView = epicenterView2;
            } else {
                sharedElementTransition3 = sharedElementTransition2;
                bVar = b;
                C1253b bVar4 = c;
                epicenter = null;
                epicenterView = null;
            }
            C0427J j = r0;
            boolean z = inIsPop;
            Fragment fragment3 = outFragment;
            C0427J j2 = new C0427J(inFragment, outFragment, inIsPop, bVar, epicenterView, impl, epicenter);
            C0464da.m2363a(sceneRoot, j);
            return sharedElementTransition3;
        }
        return null;
    }

    /* renamed from: a */
    private static void m2207a(ArrayList<View> views, C1253b<String, View> sharedElements, Collection<String> nameOverridesSet) {
        for (int i = sharedElements.size() - 1; i >= 0; i--) {
            View view = (View) sharedElements.mo9162d(i);
            if (nameOverridesSet.contains(C0646w.m2979m(view))) {
                views.add(view);
            }
        }
    }

    /* renamed from: a */
    private static Object m2193a(C0441V impl, ViewGroup sceneRoot, View nonExistentView, C1253b<String, String> nameOverrides, C0430a fragments, ArrayList<View> sharedElementsOut, ArrayList<View> sharedElementsIn, Object enterTransition, Object exitTransition) {
        Object sharedElementTransition;
        Object sharedElementTransition2;
        Rect inEpicenter;
        C0441V v = impl;
        C0430a aVar = fragments;
        ArrayList<View> arrayList = sharedElementsOut;
        Object obj = enterTransition;
        Fragment inFragment = aVar.f1453a;
        Fragment outFragment = aVar.f1456d;
        if (inFragment == null) {
            ViewGroup viewGroup = sceneRoot;
            Fragment fragment = outFragment;
            Fragment fragment2 = inFragment;
        } else if (outFragment == null) {
            ViewGroup viewGroup2 = sceneRoot;
            Fragment fragment3 = outFragment;
            Fragment fragment4 = inFragment;
        } else {
            boolean inIsPop = aVar.f1454b;
            if (nameOverrides.isEmpty()) {
                sharedElementTransition = null;
            } else {
                sharedElementTransition = m2191a(v, inFragment, outFragment, inIsPop);
            }
            C1253b c = m2218c(v, nameOverrides, sharedElementTransition, aVar);
            if (nameOverrides.isEmpty()) {
                sharedElementTransition2 = null;
            } else {
                arrayList.addAll(c.values());
                sharedElementTransition2 = sharedElementTransition;
            }
            if (obj == null && exitTransition == null && sharedElementTransition2 == null) {
                return null;
            }
            m2215b(inFragment, outFragment, inIsPop, c, true);
            if (sharedElementTransition2 != null) {
                Rect inEpicenter2 = new Rect();
                v.mo4738b(sharedElementTransition2, nonExistentView, arrayList);
                boolean outIsPop = aVar.f1457e;
                boolean outIsPop2 = outIsPop;
                C1253b bVar = c;
                Rect inEpicenter3 = inEpicenter2;
                m2202a(impl, sharedElementTransition2, exitTransition, c, outIsPop2, aVar.f1458f);
                if (obj != null) {
                    v.mo4728a(obj, inEpicenter3);
                }
                inEpicenter = inEpicenter3;
            } else {
                C1253b bVar2 = c;
                inEpicenter = null;
            }
            Object sharedElementTransition3 = sharedElementTransition2;
            C0428K k = r0;
            boolean z = inIsPop;
            Fragment fragment5 = outFragment;
            Fragment fragment6 = inFragment;
            C0428K k2 = new C0428K(impl, nameOverrides, sharedElementTransition2, fragments, sharedElementsIn, nonExistentView, inFragment, outFragment, inIsPop, sharedElementsOut, enterTransition, inEpicenter);
            C0464da.m2363a(sceneRoot, k);
            return sharedElementTransition3;
        }
        return null;
    }

    /* renamed from: c */
    private static C1253b<String, View> m2218c(C0441V impl, C1253b<String, String> nameOverrides, Object sharedElementTransition, C0430a fragments) {
        ArrayList<String> names;
        C0469fa sharedElementCallback;
        if (nameOverrides.isEmpty() || sharedElementTransition == null) {
            nameOverrides.clear();
            return null;
        }
        Fragment outFragment = fragments.f1456d;
        ArrayMap<String, View> outSharedElements = new C1253b<>();
        impl.mo5090a((Map<String, View>) outSharedElements, outFragment.getView());
        C0467f outTransaction = fragments.f1458f;
        if (fragments.f1457e) {
            sharedElementCallback = outFragment.getEnterTransitionCallback();
            names = outTransaction.f1593s;
        } else {
            sharedElementCallback = outFragment.getExitTransitionCallback();
            names = outTransaction.f1592r;
        }
        outSharedElements.mo9025a(names);
        if (sharedElementCallback != null) {
            sharedElementCallback.mo5168a((List<String>) names, (Map<String, View>) outSharedElements);
            for (int i = names.size() - 1; i >= 0; i--) {
                String name = (String) names.get(i);
                View view = (View) outSharedElements.get(name);
                if (view == null) {
                    nameOverrides.remove(name);
                } else if (!name.equals(C0646w.m2979m(view))) {
                    nameOverrides.put(C0646w.m2979m(view), (String) nameOverrides.remove(name));
                }
            }
        } else {
            nameOverrides.mo9025a(outSharedElements.keySet());
        }
        return outSharedElements;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static C1253b<String, View> m2210b(C0441V impl, C1253b<String, String> nameOverrides, Object sharedElementTransition, C0430a fragments) {
        ArrayList<String> names;
        C0469fa sharedElementCallback;
        Fragment inFragment = fragments.f1453a;
        View fragmentView = inFragment.getView();
        if (nameOverrides.isEmpty() || sharedElementTransition == null || fragmentView == null) {
            nameOverrides.clear();
            return null;
        }
        ArrayMap<String, View> inSharedElements = new C1253b<>();
        impl.mo5090a((Map<String, View>) inSharedElements, fragmentView);
        C0467f inTransaction = fragments.f1455c;
        if (fragments.f1454b) {
            sharedElementCallback = inFragment.getExitTransitionCallback();
            names = inTransaction.f1592r;
        } else {
            sharedElementCallback = inFragment.getEnterTransitionCallback();
            names = inTransaction.f1593s;
        }
        if (names != null) {
            inSharedElements.mo9025a(names);
            inSharedElements.mo9025a(nameOverrides.values());
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.mo5168a((List<String>) names, (Map<String, View>) inSharedElements);
            for (int i = names.size() - 1; i >= 0; i--) {
                String name = (String) names.get(i);
                View view = (View) inSharedElements.get(name);
                if (view == null) {
                    String key = m2195a(nameOverrides, name);
                    if (key != null) {
                        nameOverrides.remove(key);
                    }
                } else if (!name.equals(C0646w.m2979m(view))) {
                    String key2 = m2195a(nameOverrides, name);
                    if (key2 != null) {
                        nameOverrides.put(key2, C0646w.m2979m(view));
                    }
                }
            }
        } else {
            m2205a(nameOverrides, (C1253b<String, View>) inSharedElements);
        }
        return inSharedElements;
    }

    /* renamed from: a */
    private static String m2195a(C1253b<String, String> map, String value) {
        int numElements = map.size();
        for (int i = 0; i < numElements; i++) {
            if (value.equals(map.mo9162d(i))) {
                return (String) map.mo9157b(i);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static View m2209b(C1253b<String, View> inSharedElements, C0430a fragments, Object enterTransition, boolean inIsPop) {
        String targetName;
        C0467f inTransaction = fragments.f1455c;
        if (!(enterTransition == null || inSharedElements == null)) {
            ArrayList<String> arrayList = inTransaction.f1592r;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (inIsPop) {
                    targetName = (String) inTransaction.f1592r.get(0);
                } else {
                    targetName = (String) inTransaction.f1593s.get(0);
                }
                return (View) inSharedElements.get(targetName);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m2202a(C0441V impl, Object sharedElementTransition, Object exitTransition, C1253b<String, View> outSharedElements, boolean outIsPop, C0467f outTransaction) {
        String sourceName;
        ArrayList<String> arrayList = outTransaction.f1592r;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (outIsPop) {
                sourceName = (String) outTransaction.f1593s.get(0);
            } else {
                sourceName = (String) outTransaction.f1592r.get(0);
            }
            View outEpicenterView = (View) outSharedElements.get(sourceName);
            impl.mo4741c(sharedElementTransition, outEpicenterView);
            if (exitTransition != null) {
                impl.mo4741c(exitTransition, outEpicenterView);
            }
        }
    }

    /* renamed from: a */
    private static void m2205a(C1253b<String, String> nameOverrides, C1253b<String, View> namedViews) {
        for (int i = nameOverrides.size() - 1; i >= 0; i--) {
            if (!namedViews.containsKey((String) nameOverrides.mo9162d(i))) {
                nameOverrides.mo9158c(i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m2215b(Fragment inFragment, Fragment outFragment, boolean isPop, C1253b<String, View> sharedElements, boolean isStart) {
        C0469fa sharedElementCallback;
        if (isPop) {
            sharedElementCallback = outFragment.getEnterTransitionCallback();
        } else {
            sharedElementCallback = inFragment.getEnterTransitionCallback();
        }
        if (sharedElementCallback != null) {
            ArrayList<View> views = new ArrayList<>();
            ArrayList<String> names = new ArrayList<>();
            int count = sharedElements == null ? 0 : sharedElements.size();
            for (int i = 0; i < count; i++) {
                names.add(sharedElements.mo9157b(i));
                views.add(sharedElements.mo9162d(i));
            }
            if (isStart) {
                sharedElementCallback.mo5169b(names, views, null);
            } else {
                sharedElementCallback.mo5167a((List<String>) names, (List<View>) views, null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static ArrayList<View> m2213b(C0441V impl, Object transition, Fragment fragment, ArrayList<View> sharedElements, View nonExistentView) {
        ArrayList<View> viewList = null;
        if (transition != null) {
            viewList = new ArrayList<>();
            View root = fragment.getView();
            if (root != null) {
                impl.mo5089a(viewList, root);
            }
            if (sharedElements != null) {
                viewList.removeAll(sharedElements);
            }
            if (!viewList.isEmpty()) {
                viewList.add(nonExistentView);
                impl.mo4732a(transition, viewList);
            }
        }
        return viewList;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m2217b(ArrayList<View> views, int visibility) {
        if (views != null) {
            for (int i = views.size() - 1; i >= 0; i--) {
                ((View) views.get(i)).setVisibility(visibility);
            }
        }
    }

    /* renamed from: a */
    private static Object m2194a(C0441V impl, Object enterTransition, Object exitTransition, Object sharedElementTransition, Fragment inFragment, boolean isPop) {
        boolean z;
        boolean overlap = true;
        if (!(enterTransition == null || exitTransition == null || inFragment == null)) {
            if (isPop) {
                z = inFragment.getAllowReturnTransitionOverlap();
            } else {
                z = inFragment.getAllowEnterTransitionOverlap();
            }
            overlap = z;
        }
        if (overlap) {
            return impl.mo4736b(exitTransition, enterTransition, sharedElementTransition);
        }
        return impl.mo4726a(exitTransition, enterTransition, sharedElementTransition);
    }

    /* renamed from: a */
    public static void m2204a(C0467f transaction, SparseArray<C0430a> transitioningFragments, boolean isReordered) {
        int numOps = transaction.f1576b.size();
        for (int opNum = 0; opNum < numOps; opNum++) {
            m2203a(transaction, (C0468a) transaction.f1576b.get(opNum), transitioningFragments, false, isReordered);
        }
    }

    /* renamed from: b */
    public static void m2216b(C0467f transaction, SparseArray<C0430a> transitioningFragments, boolean isReordered) {
        if (transaction.f1575a.f1366t.mo227a()) {
            for (int opNum = transaction.f1576b.size() - 1; opNum >= 0; opNum--) {
                m2203a(transaction, (C0468a) transaction.f1576b.get(opNum), transitioningFragments, true, isReordered);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00d4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0114  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m2203a(android.support.p000v4.app.C0467f r22, android.support.p000v4.app.C0467f.C0468a r23, android.util.SparseArray<android.support.p000v4.app.C0429L.C0430a> r24, boolean r25, boolean r26) {
        /*
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            android.support.v4.app.Fragment r10 = r1.f1597b
            if (r10 != 0) goto L_0x000d
            return
        L_0x000d:
            int r11 = r10.mContainerId
            if (r11 != 0) goto L_0x0012
            return
        L_0x0012:
            if (r3 == 0) goto L_0x001b
            int[] r4 = f1450a
            int r5 = r1.f1596a
            r4 = r4[r5]
            goto L_0x001d
        L_0x001b:
            int r4 = r1.f1596a
        L_0x001d:
            r12 = r4
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 1
            if (r12 == r9) goto L_0x00a6
            r13 = 3
            if (r12 == r13) goto L_0x0079
            r13 = 4
            if (r12 == r13) goto L_0x0057
            r13 = 5
            if (r12 == r13) goto L_0x003c
            r13 = 6
            if (r12 == r13) goto L_0x0079
            r13 = 7
            if (r12 == r13) goto L_0x00a6
            r13 = r4
            r15 = r5
            r16 = r6
            r14 = r7
            goto L_0x00bb
        L_0x003c:
            if (r26 == 0) goto L_0x004d
            boolean r13 = r10.mHiddenChanged
            if (r13 == 0) goto L_0x004b
            boolean r13 = r10.mHidden
            if (r13 != 0) goto L_0x004b
            boolean r13 = r10.mAdded
            if (r13 == 0) goto L_0x004b
            r8 = 1
        L_0x004b:
            r4 = r8
            goto L_0x004f
        L_0x004d:
            boolean r4 = r10.mHidden
        L_0x004f:
            r7 = 1
            r13 = r4
            r15 = r5
            r16 = r6
            r14 = r7
            goto L_0x00bb
        L_0x0057:
            if (r26 == 0) goto L_0x0068
            boolean r13 = r10.mHiddenChanged
            if (r13 == 0) goto L_0x0066
            boolean r13 = r10.mAdded
            if (r13 == 0) goto L_0x0066
            boolean r13 = r10.mHidden
            if (r13 == 0) goto L_0x0066
            r8 = 1
        L_0x0066:
            r6 = r8
            goto L_0x0072
        L_0x0068:
            boolean r13 = r10.mAdded
            if (r13 == 0) goto L_0x0071
            boolean r13 = r10.mHidden
            if (r13 != 0) goto L_0x0071
            r8 = 1
        L_0x0071:
            r6 = r8
        L_0x0072:
            r5 = 1
            r13 = r4
            r15 = r5
            r16 = r6
            r14 = r7
            goto L_0x00bb
        L_0x0079:
            if (r26 == 0) goto L_0x0095
            boolean r13 = r10.mAdded
            if (r13 != 0) goto L_0x0092
            android.view.View r13 = r10.mView
            if (r13 == 0) goto L_0x0092
            int r13 = r13.getVisibility()
            if (r13 != 0) goto L_0x0092
            float r13 = r10.mPostponedAlpha
            r14 = 0
            int r13 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r13 < 0) goto L_0x0092
            r8 = 1
            goto L_0x0093
        L_0x0092:
        L_0x0093:
            r6 = r8
            goto L_0x009f
        L_0x0095:
            boolean r13 = r10.mAdded
            if (r13 == 0) goto L_0x009e
            boolean r13 = r10.mHidden
            if (r13 != 0) goto L_0x009e
            r8 = 1
        L_0x009e:
            r6 = r8
        L_0x009f:
            r5 = 1
            r13 = r4
            r15 = r5
            r16 = r6
            r14 = r7
            goto L_0x00bb
        L_0x00a6:
            if (r26 == 0) goto L_0x00ab
            boolean r4 = r10.mIsNewlyAdded
            goto L_0x00b5
        L_0x00ab:
            boolean r13 = r10.mAdded
            if (r13 != 0) goto L_0x00b4
            boolean r13 = r10.mHidden
            if (r13 != 0) goto L_0x00b4
            r8 = 1
        L_0x00b4:
            r4 = r8
        L_0x00b5:
            r7 = 1
            r13 = r4
            r15 = r5
            r16 = r6
            r14 = r7
        L_0x00bb:
            java.lang.Object r4 = r2.get(r11)
            android.support.v4.app.L$a r4 = (android.support.p000v4.app.C0429L.C0430a) r4
            if (r13 == 0) goto L_0x00d0
            android.support.v4.app.L$a r4 = m2185a(r4, r2, r11)
            r4.f1453a = r10
            r4.f1454b = r3
            r4.f1455c = r0
            r8 = r4
            goto L_0x00d1
        L_0x00d0:
            r8 = r4
        L_0x00d1:
            r7 = 0
            if (r26 != 0) goto L_0x010f
            if (r14 == 0) goto L_0x010f
            if (r8 == 0) goto L_0x00de
            android.support.v4.app.Fragment r4 = r8.f1456d
            if (r4 != r10) goto L_0x00de
            r8.f1456d = r7
        L_0x00de:
            android.support.v4.app.A r6 = r0.f1575a
            int r4 = r10.mState
            if (r4 >= r9) goto L_0x0109
            int r4 = r6.f1364r
            if (r4 < r9) goto L_0x0109
            boolean r4 = r0.f1594t
            if (r4 != 0) goto L_0x0109
            r6.mo4959g(r10)
            r9 = 1
            r17 = 0
            r18 = 0
            r19 = 0
            r4 = r6
            r5 = r10
            r20 = r6
            r6 = r9
            r9 = r7
            r7 = r17
            r21 = r8
            r8 = r18
            r1 = r9
            r9 = r19
            r4.mo4917a(r5, r6, r7, r8, r9)
            goto L_0x0112
        L_0x0109:
            r20 = r6
            r1 = r7
            r21 = r8
            goto L_0x0112
        L_0x010f:
            r1 = r7
            r21 = r8
        L_0x0112:
            if (r16 == 0) goto L_0x0129
            r4 = r21
            if (r4 == 0) goto L_0x011c
            android.support.v4.app.Fragment r5 = r4.f1456d
            if (r5 != 0) goto L_0x012b
        L_0x011c:
            android.support.v4.app.L$a r8 = m2185a(r4, r2, r11)
            r8.f1456d = r10
            r8.f1457e = r3
            r8.f1458f = r0
            r4 = r8
            goto L_0x012b
        L_0x0129:
            r4 = r21
        L_0x012b:
            if (r26 != 0) goto L_0x0137
            if (r15 == 0) goto L_0x0137
            if (r4 == 0) goto L_0x0137
            android.support.v4.app.Fragment r5 = r4.f1453a
            if (r5 != r10) goto L_0x0137
            r4.f1453a = r1
        L_0x0137:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.C0429L.m2203a(android.support.v4.app.f, android.support.v4.app.f$a, android.util.SparseArray, boolean, boolean):void");
    }

    /* renamed from: a */
    private static C0430a m2185a(C0430a containerTransition, SparseArray<C0430a> transitioningFragments, int containerId) {
        if (containerTransition != null) {
            return containerTransition;
        }
        C0430a containerTransition2 = new C0430a();
        transitioningFragments.put(containerId, containerTransition2);
        return containerTransition2;
    }
}
