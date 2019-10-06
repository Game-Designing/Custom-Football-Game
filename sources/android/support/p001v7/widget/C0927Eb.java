package android.support.p001v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.p001v7.appcompat.C0793R;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.Eb */
/* compiled from: TooltipPopup */
class C0927Eb {

    /* renamed from: a */
    private final Context f2963a;

    /* renamed from: b */
    private final View f2964b;

    /* renamed from: c */
    private final TextView f2965c;

    /* renamed from: d */
    private final LayoutParams f2966d = new LayoutParams();

    /* renamed from: e */
    private final Rect f2967e = new Rect();

    /* renamed from: f */
    private final int[] f2968f = new int[2];

    /* renamed from: g */
    private final int[] f2969g = new int[2];

    C0927Eb(Context context) {
        this.f2963a = context;
        this.f2964b = LayoutInflater.from(this.f2963a).inflate(C0793R.layout.abc_tooltip, null);
        this.f2965c = (TextView) this.f2964b.findViewById(C0793R.C0794id.message);
        this.f2966d.setTitle(getClass().getSimpleName());
        this.f2966d.packageName = this.f2963a.getPackageName();
        LayoutParams layoutParams = this.f2966d;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = C0793R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7194a(View anchorView, int anchorX, int anchorY, boolean fromTouch, CharSequence tooltipText) {
        if (mo7195b()) {
            mo7193a();
        }
        this.f2965c.setText(tooltipText);
        m4440a(anchorView, anchorX, anchorY, fromTouch, this.f2966d);
        ((WindowManager) this.f2963a.getSystemService("window")).addView(this.f2964b, this.f2966d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7193a() {
        if (mo7195b()) {
            ((WindowManager) this.f2963a.getSystemService("window")).removeView(this.f2964b);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo7195b() {
        return this.f2964b.getParent() != null;
    }

    /* renamed from: a */
    private void m4440a(View anchorView, int anchorX, int anchorY, boolean fromTouch, LayoutParams outParams) {
        int offsetX;
        int offsetBelow;
        int offsetExtra;
        int statusBarHeight;
        LayoutParams layoutParams = outParams;
        layoutParams.token = anchorView.getApplicationWindowToken();
        int tooltipPreciseAnchorThreshold = this.f2963a.getResources().getDimensionPixelOffset(C0793R.dimen.tooltip_precise_anchor_threshold);
        if (anchorView.getWidth() >= tooltipPreciseAnchorThreshold) {
            offsetX = anchorX;
        } else {
            offsetX = anchorView.getWidth() / 2;
        }
        if (anchorView.getHeight() >= tooltipPreciseAnchorThreshold) {
            int offsetExtra2 = this.f2963a.getResources().getDimensionPixelOffset(C0793R.dimen.tooltip_precise_anchor_extra_offset);
            offsetBelow = anchorY + offsetExtra2;
            offsetExtra = anchorY - offsetExtra2;
        } else {
            offsetBelow = anchorView.getHeight();
            offsetExtra = 0;
        }
        layoutParams.gravity = 49;
        int tooltipOffset = this.f2963a.getResources().getDimensionPixelOffset(fromTouch ? C0793R.dimen.tooltip_y_offset_touch : C0793R.dimen.tooltip_y_offset_non_touch);
        View appView = m4439a(anchorView);
        if (appView == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        appView.getWindowVisibleDisplayFrame(this.f2967e);
        Rect rect = this.f2967e;
        if (rect.left < 0 && rect.top < 0) {
            Resources res = this.f2963a.getResources();
            int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId != 0) {
                statusBarHeight = res.getDimensionPixelSize(resourceId);
            } else {
                statusBarHeight = 0;
            }
            DisplayMetrics metrics = res.getDisplayMetrics();
            this.f2967e.set(0, statusBarHeight, metrics.widthPixels, metrics.heightPixels);
        }
        appView.getLocationOnScreen(this.f2969g);
        anchorView.getLocationOnScreen(this.f2968f);
        int[] iArr = this.f2968f;
        int i = iArr[0];
        int[] iArr2 = this.f2969g;
        iArr[0] = i - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + offsetX) - (appView.getWidth() / 2);
        int spec = MeasureSpec.makeMeasureSpec(0, 0);
        this.f2964b.measure(spec, spec);
        int tooltipHeight = this.f2964b.getMeasuredHeight();
        int[] iArr3 = this.f2968f;
        int yAbove = ((iArr3[1] + offsetExtra) - tooltipOffset) - tooltipHeight;
        int yBelow = iArr3[1] + offsetBelow + tooltipOffset;
        if (fromTouch) {
            if (yAbove >= 0) {
                layoutParams.y = yAbove;
            } else {
                layoutParams.y = yBelow;
            }
        } else if (yBelow + tooltipHeight <= this.f2967e.height()) {
            layoutParams.y = yBelow;
        } else {
            layoutParams.y = yAbove;
        }
    }

    /* renamed from: a */
    private static View m4439a(View anchorView) {
        View rootView = anchorView.getRootView();
        ViewGroup.LayoutParams lp = rootView.getLayoutParams();
        if ((lp instanceof LayoutParams) && ((LayoutParams) lp).type == 2) {
            return rootView;
        }
        for (Context context = anchorView.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
