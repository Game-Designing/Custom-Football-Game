package com.moat.analytics.mobile.vng;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.vng.p233a.p235b.C11147a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.moat.analytics.mobile.vng.ab */
class C11149ab {

    /* renamed from: com.moat.analytics.mobile.vng.ab$a */
    private static class C11151a implements Iterable<View> {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final ViewGroup f34040a;

        /* renamed from: com.moat.analytics.mobile.vng.ab$a$a */
        private class C11152a implements Iterator<View> {

            /* renamed from: b */
            private int f34042b;

            private C11152a() {
                this.f34042b = -1;
            }

            /* renamed from: a */
            public View next() {
                this.f34042b++;
                return C11151a.this.f34040a.getChildAt(this.f34042b);
            }

            public boolean hasNext() {
                return this.f34042b + 1 < C11151a.this.f34040a.getChildCount();
            }

            public void remove() {
                throw new UnsupportedOperationException("Not implemented. Under development.");
            }
        }

        private C11151a(ViewGroup viewGroup) {
            this.f34040a = viewGroup;
        }

        public Iterator<View> iterator() {
            return new C11152a();
        }
    }

    C11149ab() {
    }

    /* renamed from: a */
    static C11147a<WebView> m36689a(ViewGroup viewGroup) {
        Object obj;
        View view;
        if (viewGroup instanceof WebView) {
            return C11147a.m36683a((WebView) viewGroup);
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(viewGroup);
        HashSet hashSet = new HashSet();
        int i = 0;
        loop0:
        while (true) {
            obj = null;
            while (!linkedList.isEmpty() && i < 100) {
                i++;
                Iterator it = new C11151a((ViewGroup) linkedList.poll()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        view = (View) it.next();
                        if (view instanceof WebView) {
                            if (obj != null) {
                                break;
                            }
                            obj = (WebView) view;
                        }
                        if (view instanceof ViewGroup) {
                            ViewGroup viewGroup2 = (ViewGroup) view;
                            if (!hashSet.contains(viewGroup2)) {
                                hashSet.add(viewGroup2);
                                linkedList.add(viewGroup2);
                            }
                        }
                    }
                }
            }
            C11185p.m36817a(3, "WebViewHound", (Object) view, "Ambiguous ad container: multiple WebViews reside within it.");
            C11185p.m36819a("[ERROR] ", "WebAdTracker not created, ambiguous ad container: multiple WebViews reside within it");
        }
        return C11147a.m36684b(obj);
    }
}
