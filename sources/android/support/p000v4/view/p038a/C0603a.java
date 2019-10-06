package android.support.p000v4.view.p038a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.a.a */
/* compiled from: AccessibilityEventCompat */
public final class C0603a {
    /* renamed from: a */
    public static void m2809a(AccessibilityEvent event, int changeTypes) {
        if (VERSION.SDK_INT >= 19) {
            event.setContentChangeTypes(changeTypes);
        }
    }

    /* renamed from: a */
    public static int m2808a(AccessibilityEvent event) {
        if (VERSION.SDK_INT >= 19) {
            return event.getContentChangeTypes();
        }
        return 0;
    }
}
