package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.graphics.Rect;
import android.location.Location;
import android.os.Build.VERSION;
import android.support.p001v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.inm.z */
class C10999z {

    /* renamed from: a */
    String f33601a = "{}";

    /* renamed from: b */
    private C11003c f33602b = new C11003c();

    /* renamed from: c */
    private JSONObject f33603c;

    /* renamed from: d */
    private Rect f33604d;

    /* renamed from: e */
    private Rect f33605e;

    /* renamed from: f */
    private JSONObject f33606f;

    /* renamed from: g */
    private JSONObject f33607g;

    /* renamed from: h */
    private Location f33608h;

    /* renamed from: i */
    private Map<String, Object> f33609i = new HashMap();

    /* renamed from: com.moat.analytics.mobile.inm.z$a */
    static class C11001a {

        /* renamed from: a */
        int f33610a = 0;

        /* renamed from: b */
        final Set<Rect> f33611b = new HashSet();

        /* renamed from: c */
        boolean f33612c = false;

        C11001a() {
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.z$b */
    private static class C11002b {

        /* renamed from: a */
        final View f33613a;

        /* renamed from: b */
        final Rect f33614b;

        C11002b(View view, C11002b bVar) {
            Rect b;
            this.f33613a = view;
            if (bVar != null) {
                Rect rect = bVar.f33614b;
                b = C10999z.m36204b(view, rect.left, rect.top);
            } else {
                b = C10999z.m36215k(view);
            }
            this.f33614b = b;
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.z$c */
    private static class C11003c {

        /* renamed from: a */
        Rect f33615a = new Rect(0, 0, 0, 0);

        /* renamed from: b */
        double f33616b = 0.0d;

        /* renamed from: c */
        double f33617c = 0.0d;

        C11003c() {
        }
    }

    C10999z() {
    }

    /* renamed from: a */
    static int m36189a(Rect rect, Set<Rect> set) {
        int i = 0;
        if (set.isEmpty()) {
            return 0;
        }
        ArrayList<Rect> arrayList = new ArrayList<>();
        arrayList.addAll(set);
        Collections.sort(arrayList, new Comparator<Rect>() {
            /* renamed from: a */
            public final int compare(Rect rect, Rect rect2) {
                return Integer.valueOf(rect.top).compareTo(Integer.valueOf(rect2.top));
            }
        });
        ArrayList arrayList2 = new ArrayList();
        for (Rect rect2 : arrayList) {
            arrayList2.add(Integer.valueOf(rect2.left));
            arrayList2.add(Integer.valueOf(rect2.right));
        }
        Collections.sort(arrayList2);
        int i2 = 0;
        while (i < arrayList2.size() - 1) {
            int i3 = i + 1;
            if (!((Integer) arrayList2.get(i)).equals(arrayList2.get(i3))) {
                Rect rect3 = new Rect(((Integer) arrayList2.get(i)).intValue(), rect.top, ((Integer) arrayList2.get(i3)).intValue(), rect.bottom);
                int i4 = rect.top;
                for (Rect rect4 : arrayList) {
                    if (Rect.intersects(rect4, rect3)) {
                        if (rect4.bottom > i4) {
                            i2 += rect3.width() * (rect4.bottom - Math.max(i4, rect4.top));
                            i4 = rect4.bottom;
                        }
                        if (rect4.bottom == rect3.bottom) {
                            break;
                        }
                    }
                }
            }
            i = i3;
        }
        return i2;
    }

    /* renamed from: a */
    private static Rect m36190a(DisplayMetrics displayMetrics) {
        return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    /* renamed from: a */
    static Rect m36191a(View view) {
        return view != null ? m36215k(view) : new Rect(0, 0, 0, 0);
    }

    /* renamed from: a */
    static C11001a m36193a(Rect rect, View view) {
        String str = "VisibilityInfo";
        C11001a aVar = new C11001a();
        try {
            ArrayDeque i = m36213i(view);
            if (i != null) {
                if (!i.isEmpty()) {
                    C10969p.m36117b(2, str, view, "starting covering rect search");
                    C11002b bVar = null;
                    loop0:
                    while (true) {
                        if (i.isEmpty()) {
                            break;
                        }
                        View view2 = (View) i.pollLast();
                        C11002b bVar2 = new C11002b(view2, bVar);
                        if (view2.getParent() != null && (view2.getParent() instanceof ViewGroup)) {
                            ViewGroup viewGroup = (ViewGroup) view2.getParent();
                            int childCount = viewGroup.getChildCount();
                            boolean z = false;
                            for (int i2 = 0; i2 < childCount; i2++) {
                                if (aVar.f33610a >= 500) {
                                    C10969p.m36113a(3, str, (Object) null, "Short-circuiting cover retrieval, reached max");
                                    break loop0;
                                }
                                View childAt = viewGroup.getChildAt(i2);
                                if (childAt == view2) {
                                    z = true;
                                } else {
                                    aVar.f33610a++;
                                    if (m36200a(childAt, view2, z)) {
                                        m36206b(new C11002b(childAt, bVar), rect, aVar);
                                        if (aVar.f33612c) {
                                            return aVar;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            continue;
                        }
                        bVar = bVar2;
                    }
                    return aVar;
                }
            }
            return aVar;
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
    }

    /* renamed from: a */
    private static C11003c m36194a(View view, Rect rect, boolean z, boolean z2, boolean z3) {
        C11003c cVar = new C11003c();
        int b = m36201b(rect);
        if (view != null && z && z2 && !z3 && b > 0) {
            Rect rect2 = new Rect(0, 0, 0, 0);
            if (m36199a(view, rect2)) {
                int b2 = m36201b(rect2);
                if (b2 < b) {
                    C10969p.m36117b(2, "VisibilityInfo", null, "Ad is clipped");
                }
                if (view.getRootView() instanceof ViewGroup) {
                    cVar.f33615a = rect2;
                    C11001a a = m36193a(rect2, view);
                    if (a.f33612c) {
                        cVar.f33617c = 1.0d;
                    } else {
                        int a2 = m36189a(rect2, a.f33611b);
                        if (a2 > 0) {
                            double d = (double) a2;
                            double d2 = (double) b2;
                            Double.isNaN(d2);
                            double d3 = d2 * 1.0d;
                            Double.isNaN(d);
                            cVar.f33617c = d / d3;
                        }
                        double d4 = (double) (b2 - a2);
                        double d5 = (double) b;
                        Double.isNaN(d5);
                        double d6 = d5 * 1.0d;
                        Double.isNaN(d4);
                        cVar.f33616b = d4 / d6;
                    }
                }
            }
        }
        return cVar;
    }

    /* renamed from: a */
    private static Map<String, String> m36195a(Rect rect) {
        HashMap hashMap = new HashMap();
        hashMap.put("x", String.valueOf(rect.left));
        hashMap.put("y", String.valueOf(rect.top));
        hashMap.put("w", String.valueOf(rect.right - rect.left));
        hashMap.put("h", String.valueOf(rect.bottom - rect.top));
        return hashMap;
    }

    /* renamed from: a */
    private static Map<String, String> m36196a(Rect rect, DisplayMetrics displayMetrics) {
        return m36195a(m36202b(rect, displayMetrics));
    }

    /* renamed from: a */
    private static JSONObject m36197a(Location location) {
        Map b = m36205b(location);
        if (b == null) {
            return null;
        }
        return new JSONObject(b);
    }

    /* renamed from: a */
    private static void m36198a(C11002b bVar, Rect rect, C11001a aVar) {
        Rect rect2 = bVar.f33614b;
        if (rect2.setIntersect(rect, rect2)) {
            if (VERSION.SDK_INT >= 22) {
                Rect rect3 = new Rect(0, 0, 0, 0);
                if (m36199a(bVar.f33613a, rect3)) {
                    Rect rect4 = bVar.f33614b;
                    if (rect4.setIntersect(rect3, rect4)) {
                        rect2 = rect4;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (C10984w.m36151a().f33563c) {
                View view = bVar.f33613a;
                C10969p.m36117b(2, "VisibilityInfo", view, String.format(Locale.ROOT, "Covered by %s-%s alpha=%f", new Object[]{view.getClass().getName(), rect2.toString(), Float.valueOf(bVar.f33613a.getAlpha())}));
            }
            aVar.f33611b.add(rect2);
            if (rect2.contains(rect)) {
                aVar.f33612c = true;
            }
        }
    }

    /* renamed from: a */
    private static boolean m36199a(View view, Rect rect) {
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        int[] iArr = {LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET};
        view.getLocationInWindow(iArr);
        int[] iArr2 = {LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET};
        view.getLocationOnScreen(iArr2);
        rect.offset(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
        return true;
    }

    /* renamed from: a */
    private static boolean m36200a(View view, View view2, boolean z) {
        return z ? VERSION.SDK_INT < 21 || view.getZ() >= view2.getZ() : VERSION.SDK_INT >= 21 && view.getZ() > view2.getZ();
    }

    /* renamed from: b */
    private static int m36201b(Rect rect) {
        return rect.width() * rect.height();
    }

    /* renamed from: b */
    private static Rect m36202b(Rect rect, DisplayMetrics displayMetrics) {
        float f = displayMetrics.density;
        if (f == 0.0f) {
            return rect;
        }
        return new Rect(Math.round(((float) rect.left) / f), Math.round(((float) rect.top) / f), Math.round(((float) rect.right) / f), Math.round(((float) rect.bottom) / f));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Rect m36204b(View view, int i, int i2) {
        int left = i + view.getLeft();
        int top = i2 + view.getTop();
        return new Rect(left, top, view.getWidth() + left, view.getHeight() + top);
    }

    /* renamed from: b */
    private static Map<String, String> m36205b(Location location) {
        if (location == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("latitude", Double.toString(location.getLatitude()));
        hashMap.put("longitude", Double.toString(location.getLongitude()));
        hashMap.put("timestamp", Long.toString(location.getTime()));
        hashMap.put("horizontalAccuracy", Float.toString(location.getAccuracy()));
        return hashMap;
    }

    /* renamed from: b */
    private static void m36206b(C11002b bVar, Rect rect, C11001a aVar) {
        boolean z;
        if (m36212h(bVar.f33613a)) {
            View view = bVar.f33613a;
            if (view instanceof ViewGroup) {
                int i = 0;
                z = !ViewGroup.class.equals(view.getClass().getSuperclass()) || !m36214j(bVar.f33613a);
                ViewGroup viewGroup = (ViewGroup) bVar.f33613a;
                int childCount = viewGroup.getChildCount();
                while (i < childCount) {
                    int i2 = aVar.f33610a + 1;
                    aVar.f33610a = i2;
                    if (i2 <= 500) {
                        m36206b(new C11002b(viewGroup.getChildAt(i), bVar), rect, aVar);
                        if (!aVar.f33612c) {
                            i++;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } else {
                z = true;
            }
            if (z) {
                m36198a(bVar, rect, aVar);
            }
        }
    }

    /* renamed from: c */
    private static boolean m36207c(View view) {
        return VERSION.SDK_INT >= 19 ? view != null && view.isAttachedToWindow() : (view == null || view.getWindowToken() == null) ? false : true;
    }

    /* renamed from: d */
    private static boolean m36208d(View view) {
        return view != null && view.hasWindowFocus();
    }

    /* renamed from: e */
    private static boolean m36209e(View view) {
        return view == null || !view.isShown();
    }

    /* renamed from: f */
    private static float m36210f(View view) {
        if (view == null) {
            return 0.0f;
        }
        return m36211g(view);
    }

    /* renamed from: g */
    private static float m36211g(View view) {
        float alpha = view.getAlpha();
        while (view != null && view.getParent() != null && ((double) alpha) != 0.0d && (view.getParent() instanceof View)) {
            alpha *= ((View) view.getParent()).getAlpha();
            view = (View) view.getParent();
        }
        return alpha;
    }

    /* renamed from: h */
    private static boolean m36212h(View view) {
        return view.isShown() && ((double) view.getAlpha()) > 0.0d;
    }

    /* renamed from: i */
    private static ArrayDeque<View> m36213i(View view) {
        ArrayDeque<View> arrayDeque = new ArrayDeque<>();
        int i = 0;
        View view2 = view;
        while (true) {
            if (view2.getParent() == null && view2 != view.getRootView()) {
                break;
            }
            i++;
            if (i <= 50) {
                arrayDeque.add(view2);
                if (!(view2.getParent() instanceof View)) {
                    break;
                }
                view2 = (View) view2.getParent();
            } else {
                C10969p.m36113a(3, "VisibilityInfo", (Object) null, "Short-circuiting chain retrieval, reached max");
                break;
            }
        }
        return arrayDeque;
    }

    /* renamed from: j */
    private static boolean m36214j(View view) {
        return VERSION.SDK_INT < 19 || view.getBackground() == null || view.getBackground().getAlpha() == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public static Rect m36215k(View view) {
        int[] iArr = {LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET};
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    /* renamed from: l */
    private static DisplayMetrics m36216l(View view) {
        if (VERSION.SDK_INT >= 17) {
            WeakReference<Activity> weakReference = C10929a.f33413a;
            if (weakReference != null) {
                Activity activity = (Activity) weakReference.get();
                if (activity != null) {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
                    return displayMetrics;
                }
            }
        }
        return view.getContext().getResources().getDisplayMetrics();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35983a(String str, View view) {
        HashMap hashMap = new HashMap();
        String str2 = "{}";
        if (view != null) {
            try {
                DisplayMetrics l = m36216l(view);
                boolean c = m36207c(view);
                boolean d = m36208d(view);
                boolean e = m36209e(view);
                float f = m36210f(view);
                hashMap.put("dr", Float.valueOf(l.density));
                hashMap.put("dv", Double.valueOf(C10972s.m36121a()));
                hashMap.put("adKey", str);
                boolean z = false;
                hashMap.put("isAttached", Integer.valueOf(c ? 1 : 0));
                hashMap.put("inFocus", Integer.valueOf(d ? 1 : 0));
                hashMap.put("isHidden", Integer.valueOf(e ? 1 : 0));
                hashMap.put("opacity", Float.valueOf(f));
                Rect a = m36190a(l);
                Rect a2 = m36191a(view);
                C11003c a3 = m36194a(view, a2, c, d, e);
                if (this.f33603c == null || a3.f33616b != this.f33602b.f33616b || !a3.f33615a.equals(this.f33602b.f33615a) || a3.f33617c != this.f33602b.f33617c) {
                    this.f33602b = a3;
                    this.f33603c = new JSONObject(m36196a(this.f33602b.f33615a, l));
                    z = true;
                }
                hashMap.put("coveredPercent", Double.valueOf(a3.f33617c));
                if (this.f33607g == null || !a.equals(this.f33605e)) {
                    this.f33605e = a;
                    this.f33607g = new JSONObject(m36196a(a, l));
                    z = true;
                }
                if (this.f33606f == null || !a2.equals(this.f33604d)) {
                    this.f33604d = a2;
                    this.f33606f = new JSONObject(m36196a(a2, l));
                    z = true;
                }
                if (this.f33609i == null || !hashMap.equals(this.f33609i)) {
                    this.f33609i = hashMap;
                    z = true;
                }
                Location b = C10966o.m36089a().mo35961b();
                if (!C10966o.m36094a(b, this.f33608h)) {
                    this.f33608h = b;
                    z = true;
                }
                if (z) {
                    JSONObject jSONObject = new JSONObject(this.f33609i);
                    jSONObject.accumulate("screen", this.f33607g);
                    jSONObject.accumulate("view", this.f33606f);
                    jSONObject.accumulate("visible", this.f33603c);
                    jSONObject.accumulate("maybe", this.f33603c);
                    jSONObject.accumulate("visiblePercent", Double.valueOf(this.f33602b.f33616b));
                    if (b != null) {
                        jSONObject.accumulate("location", m36197a(b));
                    }
                    this.f33601a = jSONObject.toString();
                }
            } catch (Exception e2) {
                C10960m.m36077a(e2);
                this.f33601a = str2;
            }
        }
    }
}
