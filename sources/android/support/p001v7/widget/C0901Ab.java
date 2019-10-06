package android.support.p001v7.widget;

import android.os.Build.VERSION;
import android.view.View;

/* renamed from: android.support.v7.widget.Ab */
/* compiled from: TooltipCompat */
public class C0901Ab {
    /* renamed from: a */
    public static void m4307a(View view, CharSequence tooltipText) {
        if (VERSION.SDK_INT >= 26) {
            view.setTooltipText(tooltipText);
        } else {
            C0924Db.m4432a(view, tooltipText);
        }
    }
}
