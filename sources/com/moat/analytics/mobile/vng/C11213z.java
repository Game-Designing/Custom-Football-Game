package com.moat.analytics.mobile.vng;

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

/* renamed from: com.moat.analytics.mobile.vng.z */
class C11213z {

    /* renamed from: a */
    String f34197a = "{}";

    /* renamed from: b */
    private C11215a f34198b = new C11215a();

    /* renamed from: c */
    private JSONObject f34199c;

    /* renamed from: d */
    private Rect f34200d;

    /* renamed from: e */
    private Rect f34201e;

    /* renamed from: f */
    private JSONObject f34202f;

    /* renamed from: g */
    private JSONObject f34203g;

    /* renamed from: h */
    private Location f34204h;

    /* renamed from: i */
    private Map<String, Object> f34205i = new HashMap();

    /* renamed from: com.moat.analytics.mobile.vng.z$a */
    private static class C11215a {

        /* renamed from: a */
        Rect f34206a = new Rect(0, 0, 0, 0);

        /* renamed from: b */
        double f34207b = 0.0d;

        /* renamed from: c */
        double f34208c = 0.0d;

        C11215a() {
        }
    }

    C11213z() {
    }

    /* renamed from: a */
    static int m36882a(Rect rect, Set<Rect> set) {
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
    private static Rect m36883a(DisplayMetrics displayMetrics) {
        return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    /* renamed from: a */
    static Rect m36884a(View view) {
        return view != null ? m36899h(view) : new Rect(0, 0, 0, 0);
    }

    /* renamed from: a */
    private static C11215a m36885a(View view, Rect rect, boolean z, boolean z2, boolean z3) {
        C11215a aVar = new C11215a();
        int b = m36890b(rect);
        if (view != null && z && z2 && !z3 && b > 0) {
            Rect rect2 = new Rect(0, 0, 0, 0);
            if (view.getGlobalVisibleRect(rect2)) {
                int b2 = m36890b(rect2);
                if (b2 < b) {
                    C11185p.m36820b(2, "VisibilityInfo", null, "Ad is clipped");
                }
                HashSet hashSet = new HashSet();
                if (view.getRootView() instanceof ViewGroup) {
                    aVar.f34206a = rect2;
                    boolean a = m36889a(rect2, view, hashSet);
                    if (a) {
                        aVar.f34208c = 1.0d;
                    }
                    if (!a) {
                        int a2 = m36882a(rect2, (Set<Rect>) hashSet);
                        if (a2 > 0) {
                            double d = (double) a2;
                            double d2 = (double) b2;
                            Double.isNaN(d2);
                            double d3 = d2 * 1.0d;
                            Double.isNaN(d);
                            aVar.f34208c = d / d3;
                        }
                        double d4 = (double) (b2 - a2);
                        double d5 = (double) b;
                        Double.isNaN(d5);
                        double d6 = d5 * 1.0d;
                        Double.isNaN(d4);
                        aVar.f34207b = d4 / d6;
                    }
                }
            }
        }
        return aVar;
    }

    /* renamed from: a */
    private static Map<String, String> m36886a(Rect rect) {
        HashMap hashMap = new HashMap();
        hashMap.put("x", String.valueOf(rect.left));
        hashMap.put("y", String.valueOf(rect.top));
        hashMap.put("w", String.valueOf(rect.right - rect.left));
        hashMap.put("h", String.valueOf(rect.bottom - rect.top));
        return hashMap;
    }

    /* renamed from: a */
    private static Map<String, String> m36887a(Rect rect, DisplayMetrics displayMetrics) {
        return m36886a(m36891b(rect, displayMetrics));
    }

    /* renamed from: a */
    private static JSONObject m36888a(Location location) {
        Map b = m36892b(location);
        if (b == null) {
            return null;
        }
        return new JSONObject(b);
    }

    /* renamed from: a */
    private static boolean m36889a(Rect rect, View view, Set<Rect> set) {
        View rootView = view.getRootView();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(rootView);
        String str = "VisibilityInfo";
        C11185p.m36820b(2, str, view, "starting covering rect search");
        int i = 0;
        boolean z = false;
        while (!arrayDeque.isEmpty() && i < 250) {
            i++;
            View view2 = (View) arrayDeque.pollLast();
            if (view2.equals(view)) {
                C11185p.m36820b(2, str, rect, "found target");
                z = true;
            } else if (m36898g(view2)) {
                if ((view2 instanceof ViewGroup) && !(view2 instanceof ListView)) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        arrayDeque.add(viewGroup.getChildAt(childCount));
                    }
                }
                if (VERSION.SDK_INT < 21 ? z : !(view2.getElevation() <= view.getElevation() && (!z || view2.getElevation() != view.getElevation()))) {
                    Rect h = m36899h(view2);
                    if (h.setIntersect(rect, h)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Covered by ");
                        sb.append(view2.getClass().getSimpleName());
                        sb.append("-");
                        sb.append(h.toString());
                        C11185p.m36820b(2, str, view2, sb.toString());
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
    private static int m36890b(Rect rect) {
        return rect.width() * rect.height();
    }

    /* renamed from: b */
    private static Rect m36891b(Rect rect, DisplayMetrics displayMetrics) {
        float f = displayMetrics.density;
        if (f == 0.0f) {
            return rect;
        }
        return new Rect(Math.round(((float) rect.left) / f), Math.round(((float) rect.top) / f), Math.round(((float) rect.right) / f), Math.round(((float) rect.bottom) / f));
    }

    /* renamed from: b */
    private static Map<String, String> m36892b(Location location) {
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
    private static boolean m36893b(View view) {
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
    private static boolean m36894c(View view) {
        return view != null && view.hasWindowFocus();
    }

    /* renamed from: d */
    private static boolean m36895d(View view) {
        return view == null || !view.isShown();
    }

    /* renamed from: e */
    private static float m36896e(View view) {
        if (view == null) {
            return 0.0f;
        }
        return m36897f(view);
    }

    /* renamed from: f */
    private static float m36897f(View view) {
        float alpha = view.getAlpha();
        while (view != null && view.getParent() != null && ((double) alpha) != 0.0d && (view.getParent() instanceof View)) {
            alpha *= ((View) view.getParent()).getAlpha();
            view = (View) view.getParent();
        }
        return alpha;
    }

    /* renamed from: g */
    private static boolean m36898g(View view) {
        return view.isShown() && ((double) view.getAlpha()) > 0.0d;
    }

    /* renamed from: h */
    private static Rect m36899h(View view) {
        int[] iArr = {LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    /* renamed from: i */
    private static DisplayMetrics m36900i(View view) {
        if (VERSION.SDK_INT >= 17) {
            WeakReference<Activity> weakReference = C11144a.f34033a;
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
    public void mo36393a(String str, View view) {
        HashMap hashMap = new HashMap();
        String str2 = "{}";
        if (view != null) {
            try {
                DisplayMetrics i = m36900i(view);
                boolean b = m36893b(view);
                boolean c = m36894c(view);
                boolean d = m36895d(view);
                float e = m36896e(view);
                hashMap.put("dr", Float.valueOf(i.density));
                hashMap.put("dv", Double.valueOf(C11187s.m36823a()));
                hashMap.put("adKey", str);
                boolean z = false;
                hashMap.put("isAttached", Integer.valueOf(b ? 1 : 0));
                hashMap.put("inFocus", Integer.valueOf(c ? 1 : 0));
                hashMap.put("isHidden", Integer.valueOf(d ? 1 : 0));
                hashMap.put("opacity", Float.valueOf(e));
                Rect a = m36883a(i);
                Rect a2 = m36884a(view);
                C11215a a3 = m36885a(view, a2, b, c, d);
                if (this.f34199c == null || a3.f34207b != this.f34198b.f34207b || !a3.f34206a.equals(this.f34198b.f34206a) || a3.f34208c != this.f34198b.f34208c) {
                    this.f34198b = a3;
                    this.f34199c = new JSONObject(m36887a(this.f34198b.f34206a, i));
                    z = true;
                }
                hashMap.put("coveredPercent", Double.valueOf(a3.f34208c));
                if (this.f34203g == null || !a.equals(this.f34201e)) {
                    this.f34201e = a;
                    this.f34203g = new JSONObject(m36887a(a, i));
                    z = true;
                }
                if (this.f34202f == null || !a2.equals(this.f34200d)) {
                    this.f34200d = a2;
                    this.f34202f = new JSONObject(m36887a(a2, i));
                    z = true;
                }
                if (this.f34205i == null || !hashMap.equals(this.f34205i)) {
                    this.f34205i = hashMap;
                    z = true;
                }
                Location b2 = C11182o.m36794a().mo36373b();
                if (!C11182o.m36799a(b2, this.f34204h)) {
                    this.f34204h = b2;
                    z = true;
                }
                if (z) {
                    JSONObject jSONObject = new JSONObject(this.f34205i);
                    jSONObject.accumulate("screen", this.f34203g);
                    jSONObject.accumulate("view", this.f34202f);
                    jSONObject.accumulate("visible", this.f34199c);
                    jSONObject.accumulate("maybe", this.f34199c);
                    jSONObject.accumulate("visiblePercent", Double.valueOf(this.f34198b.f34207b));
                    if (b2 != null) {
                        jSONObject.accumulate("location", m36888a(b2));
                    }
                    this.f34197a = jSONObject.toString();
                    return;
                }
                String str3 = this.f34197a;
            } catch (Exception e2) {
                C11176m.m36783a(e2);
                this.f34197a = str2;
            }
        }
    }
}
