package com.moat.analytics.mobile.iro;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.iro.base.functional.Optional;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/* renamed from: com.moat.analytics.mobile.iro.v */
final class C11064v {

    /* renamed from: ˎ */
    private static LinkedHashSet<String> f33818 = new LinkedHashSet<>();

    C11064v() {
    }

    /* renamed from: ˋ */
    static Optional<WebView> m36406(ViewGroup viewGroup, boolean z) {
        String str = "WebViewHound";
        if (viewGroup == null) {
            try {
                return Optional.empty();
            } catch (Exception e) {
                return Optional.empty();
            }
        } else if (viewGroup instanceof WebView) {
            return Optional.m36239of((WebView) viewGroup);
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
                        C11011b.m36234(3, str, childAt, "Found WebView");
                        if (z || m36407(String.valueOf(childAt.hashCode()))) {
                            if (obj2 != null) {
                                C11011b.m36234(3, str, childAt, "Ambiguous ad container: multiple WebViews reside within it.");
                                C11011b.m36232("[ERROR] ", "WebAdTracker not created, ambiguous ad container: multiple WebViews reside within it");
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
            return Optional.ofNullable(obj);
        }
    }

    /* renamed from: ॱ */
    private static boolean m36407(String str) {
        try {
            boolean add = f33818.add(str);
            if (f33818.size() > 50) {
                Iterator it = f33818.iterator();
                for (int i = 0; i < 25 && it.hasNext(); i++) {
                    it.next();
                    it.remove();
                }
            }
            C11011b.m36234(3, "WebViewHound", null, add ? "Newly Found WebView" : "Already Found WebView");
            return add;
        } catch (Exception e) {
            C11043o.m36351(e);
            return false;
        }
    }
}
