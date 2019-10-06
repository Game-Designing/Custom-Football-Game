package android.support.p000v4.app;

import android.graphics.Rect;
import android.support.p000v4.view.C0646w;
import android.support.p000v4.view.C0659z;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: android.support.v4.app.V */
/* compiled from: FragmentTransitionImpl */
public abstract class C0441V {
    /* renamed from: a */
    public abstract Object mo4726a(Object obj, Object obj2, Object obj3);

    /* renamed from: a */
    public abstract void mo4727a(ViewGroup viewGroup, Object obj);

    /* renamed from: a */
    public abstract void mo4728a(Object obj, Rect rect);

    /* renamed from: a */
    public abstract void mo4729a(Object obj, View view);

    /* renamed from: a */
    public abstract void mo4730a(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: a */
    public abstract void mo4731a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    /* renamed from: a */
    public abstract void mo4732a(Object obj, ArrayList<View> arrayList);

    /* renamed from: a */
    public abstract void mo4733a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: a */
    public abstract boolean mo4734a(Object obj);

    /* renamed from: b */
    public abstract Object mo4735b(Object obj);

    /* renamed from: b */
    public abstract Object mo4736b(Object obj, Object obj2, Object obj3);

    /* renamed from: b */
    public abstract void mo4737b(Object obj, View view);

    /* renamed from: b */
    public abstract void mo4738b(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: b */
    public abstract void mo4739b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: c */
    public abstract Object mo4740c(Object obj);

    /* renamed from: c */
    public abstract void mo4741c(Object obj, View view);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5085a(View view, Rect epicenter) {
        int[] loc = new int[2];
        view.getLocationOnScreen(loc);
        epicenter.set(loc[0], loc[1], loc[0] + view.getWidth(), loc[1] + view.getHeight());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ArrayList<String> mo5084a(ArrayList<View> sharedElementsIn) {
        ArrayList<String> names = new ArrayList<>();
        int numSharedElements = sharedElementsIn.size();
        for (int i = 0; i < numSharedElements; i++) {
            View view = (View) sharedElementsIn.get(i);
            names.add(C0646w.m2979m(view));
            C0646w.m2960a(view, (String) null);
        }
        return names;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5086a(View sceneRoot, ArrayList<View> sharedElementsOut, ArrayList<View> sharedElementsIn, ArrayList<String> inNames, Map<String, String> nameOverrides) {
        int numSharedElements = sharedElementsIn.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < numSharedElements; i++) {
            View view = (View) sharedElementsOut.get(i);
            String name = C0646w.m2979m(view);
            arrayList.add(name);
            if (name != null) {
                C0646w.m2960a(view, (String) null);
                String inName = (String) nameOverrides.get(name);
                int j = 0;
                while (true) {
                    if (j >= numSharedElements) {
                        break;
                    } else if (inName.equals(inNames.get(j))) {
                        C0646w.m2960a((View) sharedElementsIn.get(j), name);
                        break;
                    } else {
                        j++;
                    }
                }
            }
        }
        C0438S s = new C0438S(this, numSharedElements, sharedElementsIn, inNames, sharedElementsOut, arrayList);
        C0464da.m2363a(sceneRoot, s);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5089a(ArrayList<View> transitioningViews, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (C0659z.m3096a(viewGroup)) {
                transitioningViews.add(viewGroup);
                return;
            }
            int count = viewGroup.getChildCount();
            for (int i = 0; i < count; i++) {
                mo5089a(transitioningViews, viewGroup.getChildAt(i));
            }
            return;
        }
        transitioningViews.add(view);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5090a(Map<String, View> namedViews, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = C0646w.m2979m(view);
            if (transitionName != null) {
                namedViews.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int count = viewGroup.getChildCount();
                for (int i = 0; i < count; i++) {
                    mo5090a(namedViews, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5087a(View sceneRoot, ArrayList<View> sharedElementsIn, Map<String, String> nameOverrides) {
        C0464da.m2363a(sceneRoot, new C0439T(this, sharedElementsIn, nameOverrides));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5088a(ViewGroup sceneRoot, ArrayList<View> sharedElementsIn, Map<String, String> nameOverrides) {
        C0464da.m2363a(sceneRoot, new C0440U(this, sharedElementsIn, nameOverrides));
    }

    /* renamed from: a */
    protected static void m2261a(List<View> views, View startView) {
        int startIndex = views.size();
        if (!m2263a(views, startView, startIndex)) {
            views.add(startView);
            for (int index = startIndex; index < views.size(); index++) {
                View view = (View) views.get(index);
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int childIndex = 0; childIndex < childCount; childIndex++) {
                        View child = viewGroup.getChildAt(childIndex);
                        if (!m2263a(views, child, startIndex)) {
                            views.add(child);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m2263a(List<View> views, View view, int maxIndex) {
        for (int i = 0; i < maxIndex; i++) {
            if (views.get(i) == view) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    protected static boolean m2262a(List list) {
        return list == null || list.isEmpty();
    }

    /* renamed from: a */
    static String m2260a(Map<String, String> map, String value) {
        for (Entry<String, String> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        return null;
    }
}
