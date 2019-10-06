package com.moat.analytics.mobile.inm;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.inm.p227a.p229b.C10932a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/* renamed from: com.moat.analytics.mobile.inm.ab */
class C10934ab {

    /* renamed from: a */
    private static final LinkedHashSet<String> f33420a = new LinkedHashSet<>();

    C10934ab() {
    }

    /* renamed from: a */
    static C10932a<WebView> m35960a(ViewGroup viewGroup, boolean z) {
        String str = "WebViewHound";
        if (viewGroup == null) {
            try {
                return C10932a.m35953a();
            } catch (Exception e) {
                return C10932a.m35953a();
            }
        } else if (viewGroup instanceof WebView) {
            return C10932a.m35954a((WebView) viewGroup);
        } else {
            LinkedList linkedList = new LinkedList();
            linkedList.add(viewGroup);
            Object obj = null;
            int i = 0;
            while (!linkedList.isEmpty() && i < 100) {
                i++;
                ViewGroup viewGroup2 = (ViewGroup) linkedList.poll();
                int childCount = viewGroup2.getChildCount();
                Object obj2 = obj;
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        obj = obj2;
                        break;
                    }
                    View childAt = viewGroup2.getChildAt(i2);
                    if (childAt instanceof WebView) {
                        C10969p.m36113a(3, str, (Object) childAt, "Found WebView");
                        if (z || m35961a(String.valueOf(childAt.hashCode()))) {
                            if (obj2 != null) {
                                C10969p.m36113a(3, str, (Object) childAt, "Ambiguous ad container: multiple WebViews reside within it.");
                                C10969p.m36116a("[ERROR] ", "WebAdTracker not created, ambiguous ad container: multiple WebViews reside within it");
                                obj = null;
                                break;
                            }
                            obj2 = (WebView) childAt;
                        }
                    }
                    if (childAt instanceof ViewGroup) {
                        linkedList.add((ViewGroup) childAt);
                    }
                    i2++;
                }
            }
            return C10932a.m35955b(obj);
        }
    }

    /* renamed from: a */
    private static boolean m35961a(String str) {
        try {
            boolean add = f33420a.add(str);
            if (f33420a.size() > 50) {
                Iterator it = f33420a.iterator();
                for (int i = 0; i < 25 && it.hasNext(); i++) {
                    it.next();
                    it.remove();
                }
            }
            C10969p.m36113a(3, "WebViewHound", (Object) null, add ? "Newly Found WebView" : "Already Found WebView");
            return add;
        } catch (Exception e) {
            C10960m.m36077a(e);
            return false;
        }
    }
}
