package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.C0645v;
import android.support.p000v4.widget.C0687b;
import android.support.p001v7.appcompat.C0793R;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.AppCompatButton */
public class AppCompatButton extends Button implements C0645v, C0687b {

    /* renamed from: a */
    private final C1079l f2912a;

    /* renamed from: b */
    private final C0928F f2913b;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    public AppCompatButton(Context context, AttributeSet attrs) {
        this(context, attrs, C0793R.attr.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(C1103pb.m5450a(context), attrs, defStyleAttr);
        this.f2912a = new C1079l(this);
        this.f2912a.mo8511a(attrs, defStyleAttr);
        this.f2913b = C0928F.m4444a((TextView) this);
        this.f2913b.mo7202a(attrs, defStyleAttr);
        this.f2913b.mo7196a();
    }

    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        C1079l lVar = this.f2912a;
        if (lVar != null) {
            lVar.mo8507a(resId);
        }
    }

    public void setBackgroundDrawable(Drawable background) {
        super.setBackgroundDrawable(background);
        C1079l lVar = this.f2912a;
        if (lVar != null) {
            lVar.mo8510a(background);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList tint) {
        C1079l lVar = this.f2912a;
        if (lVar != null) {
            lVar.mo8513b(tint);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1079l lVar = this.f2912a;
        if (lVar != null) {
            return lVar.mo8512b();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(Mode tintMode) {
        C1079l lVar = this.f2912a;
        if (lVar != null) {
            lVar.mo8509a(tintMode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        C1079l lVar = this.f2912a;
        if (lVar != null) {
            return lVar.mo8514c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1079l lVar = this.f2912a;
        if (lVar != null) {
            lVar.mo8506a();
        }
        C0928F f = this.f2913b;
        if (f != null) {
            f.mo7196a();
        }
    }

    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        C0928F f = this.f2913b;
        if (f != null) {
            f.mo7200a(context, resId);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(Button.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        C0928F f = this.f2913b;
        if (f != null) {
            f.mo7204a(changed, left, top, right, bottom);
        }
    }

    public void setTextSize(int unit, float size) {
        if (C0687b.f2011a) {
            super.setTextSize(unit, size);
            return;
        }
        C0928F f = this.f2913b;
        if (f != null) {
            f.mo7198a(unit, size);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        C0928F f = this.f2913b;
        if (f != null && !C0687b.f2011a && f.mo7212h()) {
            this.f2913b.mo7206b();
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int autoSizeTextType) {
        if (C0687b.f2011a) {
            super.setAutoSizeTextTypeWithDefaults(autoSizeTextType);
            return;
        }
        C0928F f = this.f2913b;
        if (f != null) {
            f.mo7197a(autoSizeTextType);
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int autoSizeMinTextSize, int autoSizeMaxTextSize, int autoSizeStepGranularity, int unit) throws IllegalArgumentException {
        if (C0687b.f2011a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(autoSizeMinTextSize, autoSizeMaxTextSize, autoSizeStepGranularity, unit);
            return;
        }
        C0928F f = this.f2913b;
        if (f != null) {
            f.mo7199a(autoSizeMinTextSize, autoSizeMaxTextSize, autoSizeStepGranularity, unit);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] presetSizes, int unit) throws IllegalArgumentException {
        if (C0687b.f2011a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(presetSizes, unit);
            return;
        }
        C0928F f = this.f2913b;
        if (f != null) {
            f.mo7205a(presetSizes, unit);
        }
    }

    public int getAutoSizeTextType() {
        int i = 0;
        if (C0687b.f2011a) {
            if (super.getAutoSizeTextType() == 1) {
                i = 1;
            }
            return i;
        }
        C0928F f = this.f2913b;
        if (f != null) {
            return f.mo7211g();
        }
        return 0;
    }

    public int getAutoSizeStepGranularity() {
        if (C0687b.f2011a) {
            return super.getAutoSizeStepGranularity();
        }
        C0928F f = this.f2913b;
        if (f != null) {
            return f.mo7209e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (C0687b.f2011a) {
            return super.getAutoSizeMinTextSize();
        }
        C0928F f = this.f2913b;
        if (f != null) {
            return f.mo7208d();
        }
        return -1;
    }

    public int getAutoSizeMaxTextSize() {
        if (C0687b.f2011a) {
            return super.getAutoSizeMaxTextSize();
        }
        C0928F f = this.f2913b;
        if (f != null) {
            return f.mo7207c();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (C0687b.f2011a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C0928F f = this.f2913b;
        if (f != null) {
            return f.mo7210f();
        }
        return new int[0];
    }

    public void setSupportAllCaps(boolean allCaps) {
        C0928F f = this.f2913b;
        if (f != null) {
            f.mo7203a(allCaps);
        }
    }
}
