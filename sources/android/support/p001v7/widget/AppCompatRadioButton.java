package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.p000v4.widget.C0673D;
import android.support.p001v7.appcompat.C0793R;
import android.util.AttributeSet;
import android.widget.RadioButton;
import p002b.p003c.p062h.p064b.p065a.C1282b;

/* renamed from: android.support.v7.widget.AppCompatRadioButton */
public class AppCompatRadioButton extends RadioButton implements C0673D {

    /* renamed from: a */
    private final C1093o f2916a;

    /* renamed from: b */
    private final C0928F f2917b;

    public AppCompatRadioButton(Context context) {
        this(context, null);
    }

    public AppCompatRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, C0793R.attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(C1103pb.m5450a(context), attrs, defStyleAttr);
        this.f2916a = new C1093o(this);
        this.f2916a.mo8556a(attrs, defStyleAttr);
        this.f2917b = new C0928F(this);
        this.f2917b.mo7202a(attrs, defStyleAttr);
    }

    public void setButtonDrawable(Drawable buttonDrawable) {
        super.setButtonDrawable(buttonDrawable);
        C1093o oVar = this.f2916a;
        if (oVar != null) {
            oVar.mo8559d();
        }
    }

    public void setButtonDrawable(int resId) {
        setButtonDrawable(C1282b.m6000b(getContext(), resId));
    }

    public int getCompoundPaddingLeft() {
        int value = super.getCompoundPaddingLeft();
        C1093o oVar = this.f2916a;
        return oVar != null ? oVar.mo8552a(value) : value;
    }

    public void setSupportButtonTintList(ColorStateList tint) {
        C1093o oVar = this.f2916a;
        if (oVar != null) {
            oVar.mo8554a(tint);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        C1093o oVar = this.f2916a;
        if (oVar != null) {
            return oVar.mo8557b();
        }
        return null;
    }

    public void setSupportButtonTintMode(Mode tintMode) {
        C1093o oVar = this.f2916a;
        if (oVar != null) {
            oVar.mo8555a(tintMode);
        }
    }

    public Mode getSupportButtonTintMode() {
        C1093o oVar = this.f2916a;
        if (oVar != null) {
            return oVar.mo8558c();
        }
        return null;
    }
}
