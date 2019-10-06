package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import p002b.p003c.p049c.C1166d;

public class BrowserActionsFallbackMenuView extends LinearLayout {

    /* renamed from: a */
    private final int f3790a = getResources().getDimensionPixelOffset(C1166d.browser_actions_context_menu_min_padding);

    /* renamed from: b */
    private final int f3791b = getResources().getDimensionPixelOffset(C1166d.browser_actions_context_menu_max_width);

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f3790a * 2), this.f3791b), 1073741824), heightMeasureSpec);
    }
}
