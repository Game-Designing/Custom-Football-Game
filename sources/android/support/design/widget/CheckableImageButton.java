package android.support.design.widget;

import android.content.Context;
import android.support.p000v4.view.C0616c;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.widget.C1110s;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageButton;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public class CheckableImageButton extends C1110s implements Checkable {

    /* renamed from: c */
    private static final int[] f873c = {16842912};

    /* renamed from: d */
    private boolean f874d;

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attrs) {
        this(context, attrs, C0793R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        C0646w.m2955a((View) this, (C0616c) new C0319x(this));
    }

    public void setChecked(boolean checked) {
        if (this.f874d != checked) {
            this.f874d = checked;
            refreshDrawableState();
            sendAccessibilityEvent(Opcodes.ACC_STRICT);
        }
    }

    public boolean isChecked() {
        return this.f874d;
    }

    public void toggle() {
        setChecked(!this.f874d);
    }

    public int[] onCreateDrawableState(int extraSpace) {
        if (this.f874d) {
            return ImageButton.mergeDrawableStates(super.onCreateDrawableState(f873c.length + extraSpace), f873c);
        }
        return super.onCreateDrawableState(extraSpace);
    }
}
