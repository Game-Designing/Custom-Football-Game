package android.support.p001v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.p001v7.widget.C1076ka.C1077a;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* renamed from: android.support.v7.widget.FitWindowsLinearLayout */
public class FitWindowsLinearLayout extends LinearLayout implements C1076ka {

    /* renamed from: a */
    private C1077a f2982a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnFitSystemWindowsListener(C1077a listener) {
        this.f2982a = listener;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect insets) {
        C1077a aVar = this.f2982a;
        if (aVar != null) {
            aVar.mo6274a(insets);
        }
        return super.fitSystemWindows(insets);
    }
}
