package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Views;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.mopub.nativeads.zb */
/* compiled from: SpinningProgressView */
class C11663zb extends ViewGroup {

    /* renamed from: a */
    private final ProgressBar f36273a;

    /* renamed from: b */
    private int f36274b;

    C11663zb(Context context) {
        super(context);
        LayoutParams params = new LayoutParams(-1, -1);
        params.gravity = 17;
        setLayoutParams(params);
        setVisibility(8);
        setBackgroundColor(CtaButton.BACKGROUND_COLOR);
        getBackground().setAlpha(Opcodes.GETFIELD);
        this.f36273a = new ProgressBar(context);
        this.f36274b = Dips.asIntPixels(25.0f, getContext());
        this.f36273a.setIndeterminate(true);
        addView(this.f36273a);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed) {
            int centerX = (left + right) / 2;
            int centerY = (top + bottom) / 2;
            ProgressBar progressBar = this.f36273a;
            int i = this.f36274b;
            progressBar.layout(centerX - i, centerY - i, centerX + i, i + centerY);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo38196a(View view) {
        Preconditions.checkNotNull(view);
        View rootView = view.getRootView();
        if (rootView == null || !(rootView instanceof ViewGroup)) {
            return false;
        }
        ViewGroup rootViewGroup = (ViewGroup) rootView;
        setVisibility(0);
        setMeasuredDimension(rootView.getWidth(), rootView.getHeight());
        rootViewGroup.addView(this);
        forceLayout();
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo38195a() {
        Views.removeFromParent(this);
        setVisibility(8);
        return true;
    }
}
