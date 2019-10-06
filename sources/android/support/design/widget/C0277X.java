package android.support.design.widget;

import android.content.Context;
import android.support.p001v7.widget.C0949Jb;
import android.support.p001v7.widget.C1104q;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* renamed from: android.support.design.widget.X */
/* compiled from: TextInputEditText */
public class C0277X extends C1104q {
    public C0277X(Context context) {
        super(context);
    }

    public C0277X(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public C0277X(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        InputConnection ic = super.onCreateInputConnection(outAttrs);
        if (ic != null && outAttrs.hintText == null) {
            ViewParent parent = getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                } else if (parent instanceof C0949Jb) {
                    outAttrs.hintText = ((C0949Jb) parent).getHint();
                    break;
                } else {
                    parent = parent.getParent();
                }
            }
        }
        return ic;
    }
}
