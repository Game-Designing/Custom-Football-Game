package com.moat.analytics.mobile.sma;

import android.app.Activity;
import android.graphics.Rect;
import android.location.Location;
import android.os.Build.VERSION;
import android.support.p001v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.sma.z */
class C11139z {

    /* renamed from: a */
    String f34010a = "{}";

    /* renamed from: b */
    private C11141a f34011b = new C11141a();

    /* renamed from: c */
    private JSONObject f34012c;

    /* renamed from: d */
    private Rect f34013d;

    /* renamed from: e */
    private Rect f34014e;

    /* renamed from: f */
    private JSONObject f34015f;

    /* renamed from: g */
    private JSONObject f34016g;

    /* renamed from: h */
    private Location f34017h;

    /* renamed from: i */
    private Map<String, Object> f34018i = new HashMap();

    /* renamed from: com.moat.analytics.mobile.sma.z$a */
    private static class C11141a {

        /* renamed from: a */
        Rect f34019a = new Rect(0, 0, 0, 0);

        /* renamed from: b */
        double f34020b = 0.0d;

        /* renamed from: c */
        double f34021c = 0.0d;

        C11141a() {
        }
    }

    C11139z() {
    }

    /* renamed from: a */
    static int m36642a(Rect rect, Set<Rect> set) {
        int i = 0;
        if (set.isEmpty()) {
            return 0;
        }
        ArrayList<Rect> arrayList = new ArrayList<>();
        arrayList.addAll(set);
        Collections.sort(arrayList, new Comparator<Rect>() {
            /* renamed from: a */
            public int compare(Rect rect, Rect rect2) {
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
    private static Rect m36643a(DisplayMetrics displayMetrics) {
        return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    /* renamed from: a */
    static Rect m36644a(View view) {
        return view != null ? m36659h(view) : new Rect(0, 0, 0, 0);
    }

    /* renamed from: a */
    private static C11141a m36645a(View view, Rect rect, boolean z, boolean z2, boolean z3) {
        C11141a aVar = new C11141a();
        int b = m36650b(rect);
        if (view != null && z && z2 && !z3 && b > 0) {
            Rect rect2 = new Rect(0, 0, 0, 0);
            if (view.getGlobalVisibleRect(rect2)) {
                int b2 = m36650b(rect2);
                if (b2 < b) {
                    C11111p.m36580b(2, "VisibilityInfo", null, "Ad is clipped");
                }
                HashSet hashSet = new HashSet();
                if (view.getRootView() instanceof ViewGroup) {
                    aVar.f34019a = rect2;
                    boolean a = m36649a(rect2, view, hashSet);
                    if (a) {
                        aVar.f34021c = 1.0d;
                    }
                    if (!a) {
                        int a2 = m36642a(rect2, (Set<Rect>) hashSet);
                        if (a2 > 0) {
                            double d = (double) a2;
                            double d2 = (double) b2;
                            Double.isNaN(d2);
                            double d3 = d2 * 1.0d;
                            Double.isNaN(d);
                            aVar.f34021c = d / d3;
                        }
                        double d4 = (double) (b2 - a2);
                        double d5 = (double) b;
                        Double.isNaN(d5);
                        double d6 = d5 * 1.0d;
                        Double.isNaN(d4);
                        aVar.f34020b = d4 / d6;
                    }
                }
            }
        }
        return aVar;
    }

    /* renamed from: a */
    private static Map<String, String> m36646a(Rect rect) {
        HashMap hashMap = new HashMap();
        hashMap.put("x", String.valueOf(rect.left));
        hashMap.put("y", String.valueOf(rect.top));
        hashMap.put("w", String.valueOf(rect.right - rect.left));
        hashMap.put("h", String.valueOf(rect.bottom - rect.top));
        return hashMap;
    }

    /* renamed from: a */
    private static Map<String, String> m36647a(Rect rect, DisplayMetrics displayMetrics) {
        return m36646a(m36651b(rect, displayMetrics));
    }

    /* renamed from: a */
    private static JSONObject m36648a(Location location) {
        Map b = m36652b(location);
        if (b == null) {
            return null;
        }
        return new JSONObject(b);
    }

    /* renamed from: a */
    private static boolean m36649a(Rect rect, View view, Set<Rect> set) {
        View rootView = view.getRootView();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(rootView);
        String str = "VisibilityInfo";
        C11111p.m36580b(2, str, view, "starting covering rect search");
        int i = 0;
        boolean z = false;
        while (!arrayDeque.isEmpty() && i < 250) {
            i++;
            View view2 = (View) arrayDeque.pollLast();
            if (view2.equals(view)) {
                C11111p.m36580b(2, str, rect, "found target");
                z = true;
            } else if (m36658g(view2)) {
                if ((view2 instanceof ViewGroup) && !(view2 instanceof ListView)) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        arrayDeque.add(viewGroup.getChildAt(childCount));
                    }
                }
                if (VERSION.SDK_INT < 21 ? z : !(view2.getElevation() <= view.getElevation() && (!z || view2.getElevation() != view.getElevation()))) {
                    Rect h = m36659h(view2);
                    if (h.setIntersect(rect, h)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Covered by ");
                        sb.append(view2.getClass().getSimpleName());
                        sb.append("-");
                        sb.append(h.toString());
                        C11111p.m36580b(2, str, view2, sb.toString());
                        set.add(h);
                        if (h.contains(rect)) {
                            return true;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    /* renamed from: b */
    private static int m36650b(Rect rect) {
        return rect.width() * rect.height();
    }

    /* renamed from: b */
    private static Rect m36651b(Rect rect, DisplayMetrics displayMetrics) {
        float f = displayMetrics.density;
        if (f == 0.0f) {
            return rect;
        }
        return new Rect(Math.round(((float) rect.left) / f), Math.round(((float) rect.top) / f), Math.round(((float) rect.right) / f), Math.round(((float) rect.bottom) / f));
    }

    /* renamed from: b */
    private static Map<String, String> m36652b(Location location) {
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
    private static boolean m36653b(View view) {
        boolean z = true;
        if (VERSION.SDK_INT >= 19) {
            if (view == null || !view.isAttachedToWindow()) {
                z = false;
            }
            return z;
        }
        if (view == null || view.getWindowToken() == null) {
            z = false;
        }
        return z;
    }

    /* renamed from: c */
    private static boolean m36654c(View view) {
        return view != null && view.hasWindowFocus();
    }

    /* renamed from: d */
    private static boolean m36655d(View view) {
        return view == null || !view.isShown();
    }

    /* renamed from: e */
    private static float m36656e(View view) {
        if (view == null) {
            return 0.0f;
        }
        return m36657f(view);
    }

    /* renamed from: f */
    private static float m36657f(View view) {
        float alpha = view.getAlpha();
        while (view != null && view.getParent() != null && ((double) alpha) != 0.0d && (view.getParent() instanceof View)) {
            alpha *= ((View) view.getParent()).getAlpha();
            view = (View) view.getParent();
        }
        return alpha;
    }

    /* renamed from: g */
    private static boolean m36658g(View view) {
        return view.isShown() && ((double) view.getAlpha()) > 0.0d;
    }

    /* renamed from: h */
    private static Rect m36659h(View view) {
        int[] iArr = {LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    /* renamed from: i */
    private static DisplayMetrics m36660i(View view) {
        if (VERSION.SDK_INT >= 17) {
            WeakReference<Activity> weakReference = C11073a.f33849a;
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
    public void mo36261a(String str, View view) {
        HashMap hashMap = new HashMap();
        String str2 = "{}";
        if (view != null) {
            try {
                DisplayMetrics i = m36660i(view);
                boolean b = m36653b(view);
                boolean c = m36654c(view);
                boolean d = m36655d(view);
                float e = m36656e(view);
                hashMap.put("dr", Float.valueOf(i.density));
                hashMap.put("dv", Double.valueOf(C11113s.m36583a()));
                hashMap.put("adKey", str);
                boolean z = false;
                hashMap.put("isAttached", Integer.valueOf(b ? 1 : 0));
                hashMap.put("inFocus", Integer.valueOf(c ? 1 : 0));
                hashMap.put("isHidden", Integer.valueOf(d ? 1 : 0));
                hashMap.put("opacity", Float.valueOf(e));
                Rect a = m36643a(i);
                Rect a2 = m36644a(view);
                C11141a a3 = m36645a(view, a2, b, c, d);
                if (this.f34012c == null || a3.f34020b != this.f34011b.f34020b || !a3.f34019a.equals(this.f34011b.f34019a) || a3.f34021c != this.f34011b.f34021c) {
                    this.f34011b = a3;
                    this.f34012c = new JSONObject(m36647a(this.f34011b.f34019a, i));
                    z = true;
                }
                hashMap.put("coveredPercent", Double.valueOf(a3.f34021c));
                if (this.f34016g == null || !a.equals(this.f34014e)) {
                    this.f34014e = a;
                    this.f34016g = new JSONObject(m36647a(a, i));
                    z = true;
                }
                if (this.f34015f == null || !a2.equals(this.f34013d)) {
                    this.f34013d = a2;
                    this.f34015f = new JSONObject(m36647a(a2, i));
                    z = true;
                }
                if (this.f34018i == null || !hashMap.equals(this.f34018i)) {
                    this.f34018i = hashMap;
                    z = true;
                }
                Location b2 = C11108o.m36554a().mo36241b();
                if (!C11108o.m36559a(b2, this.f34017h)) {
                    this.f34017h = b2;
                    z = true;
                }
                if (z) {
                    JSONObject jSONObject = new JSONObject(this.f34018i);
                    jSONObject.accumulate("screen", this.f34016g);
                    jSONObject.accumulate("view", this.f34015f);
                    jSONObject.accumulate("visible", this.f34012c);
                    jSONObject.accumulate("maybe", this.f34012c);
                    jSONObject.accumulate("visiblePercent", Double.valueOf(this.f34011b.f34020b));
                    if (b2 != null) {
                        jSONObject.accumulate("location", m36648a(b2));
                    }
                    this.f34010a = jSONObject.toString();
                    return;
                }
                String str3 = this.f34010a;
            } catch (Exception e2) {
                C11102m.m36543a(e2);
                this.f34010a = str2;
            }
        }
    }
}
