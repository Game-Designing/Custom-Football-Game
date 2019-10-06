package android.support.p001v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.p001v7.widget.C1076ka.C1077a;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* renamed from: android.support.v7.widget.FitWindowsFrameLayout */
public class FitWindowsFrameLayout extends FrameLayout implements C1076ka {

    /* renamed from: a */
    private C1077a f2981a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnFitSystemWindowsListener(C1077a listener) {
        this.f2981a = listener;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect insets) {
        C1077a aVar = this.f2981a;
        if (aVar != null) {
            aVar.mo6274a(insets);
        }
        return super.fitSystemWindows(insets);
    }
}
