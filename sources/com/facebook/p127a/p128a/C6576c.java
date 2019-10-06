package com.facebook.p127a.p128a;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.facebook.C6787r;
import com.facebook.FacebookException;
import com.facebook.p127a.p128a.p129a.C6566a;
import com.facebook.p127a.p128a.p129a.C6566a.C6567a;
import com.facebook.p127a.p128a.p129a.C6574f;
import com.facebook.p127a.p130b.C6603i;
import java.lang.ref.WeakReference;

/* renamed from: com.facebook.a.a.c */
/* compiled from: CodelessLoggingEventListener */
public class C6576c {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f11928a = C6576c.class.getCanonicalName();

    /* renamed from: com.facebook.a.a.c$a */
    /* compiled from: CodelessLoggingEventListener */
    public static class C6577a extends AccessibilityDelegate {

        /* renamed from: a */
        private C6566a f11929a;

        /* renamed from: b */
        private WeakReference<View> f11930b;

        /* renamed from: c */
        private WeakReference<View> f11931c;

        /* renamed from: d */
        private int f11932d;

        /* renamed from: e */
        private AccessibilityDelegate f11933e;

        /* renamed from: f */
        private boolean f11934f = false;

        /* renamed from: g */
        protected boolean f11935g = false;

        public C6577a() {
        }

        public C6577a(C6566a mapping, View rootView, View hostView) {
            if (mapping != null && rootView != null && hostView != null) {
                this.f11933e = C6574f.m13027d(hostView);
                this.f11929a = mapping;
                this.f11930b = new WeakReference<>(hostView);
                this.f11931c = new WeakReference<>(rootView);
                C6567a type = mapping.mo19749c();
                int i = C6565a.f11884a[mapping.mo19749c().ordinal()];
                if (i == 1) {
                    this.f11932d = 1;
                } else if (i == 2) {
                    this.f11932d = 4;
                } else if (i == 3) {
                    this.f11932d = 16;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unsupported action type: ");
                    sb.append(type.toString());
                    throw new FacebookException(sb.toString());
                }
                this.f11934f = true;
            }
        }

        public void sendAccessibilityEvent(View host, int eventType) {
            if (eventType == -1) {
                Log.e(C6576c.f11928a, "Unsupported action type");
            }
            if (eventType == this.f11932d) {
                AccessibilityDelegate accessibilityDelegate = this.f11933e;
                if (accessibilityDelegate != null && !(accessibilityDelegate instanceof C6577a)) {
                    accessibilityDelegate.sendAccessibilityEvent(host, eventType);
                }
                m13039b();
            }
        }

        /* renamed from: b */
        private void m13039b() {
            String eventName = this.f11929a.mo19748b();
            Bundle parameters = C6579e.m13041a(this.f11929a, (View) this.f11931c.get(), (View) this.f11930b.get());
            String str = "_valueToSum";
            if (parameters.containsKey(str)) {
                parameters.putDouble(str, C6603i.m13107a(parameters.getString(str)));
            }
            parameters.putString("_is_fb_codeless", "1");
            C6787r.m13822l().execute(new C6575b(this, eventName, parameters));
        }

        /* renamed from: a */
        public boolean mo19754a() {
            return this.f11934f;
        }
    }

    /* renamed from: a */
    public static C6577a m13037a(C6566a mapping, View rootView, View hostView) {
        return new C6577a(mapping, rootView, hostView);
    }
}
