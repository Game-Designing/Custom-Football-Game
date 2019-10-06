package com.moat.analytics.mobile.sma;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.sma.p230a.p232b.C11076a;
import java.util.LinkedList;

/* renamed from: com.moat.analytics.mobile.sma.ab */
class C11078ab {
    C11078ab() {
    }

    /* renamed from: a */
    static C11076a<WebView> m36448a(ViewGroup viewGroup) {
        if (viewGroup instanceof WebView) {
            return C11076a.m36442a((WebView) viewGroup);
        }
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
                    if (obj2 != null) {
                        C11111p.m36577a(3, "WebViewHound", (Object) childAt, "Ambiguous ad container: multiple WebViews reside within it.");
                        C11111p.m36579a("[ERROR] ", "WebAdTracker not created, ambiguous ad container: multiple WebViews reside within it");
                        obj = null;
                        break;
                    }
                    obj2 = (WebView) childAt;
                }
                if (childAt instanceof ViewGroup) {
                    linkedList.add((ViewGroup) childAt);
                }
                i2++;
            }
        }
        return C11076a.m36443b(obj);
    }
}
