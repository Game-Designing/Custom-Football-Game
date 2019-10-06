package android.support.p000v4.view.p038a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityRecord;

/* renamed from: android.support.v4.view.a.d */
/* compiled from: AccessibilityRecordCompat */
public class C0608d {
    /* renamed from: a */
    public static void m2851a(AccessibilityRecord record, int maxScrollX) {
        if (VERSION.SDK_INT >= 15) {
            record.setMaxScrollX(maxScrollX);
        }
    }

    /* renamed from: b */
    public static void m2852b(AccessibilityRecord record, int maxScrollY) {
        if (VERSION.SDK_INT >= 15) {
            record.setMaxScrollY(maxScrollY);
        }
    }
}
