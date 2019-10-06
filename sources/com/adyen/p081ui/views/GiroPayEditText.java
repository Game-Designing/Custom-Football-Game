package com.adyen.p081ui.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

/* renamed from: com.adyen.ui.views.GiroPayEditText */
public class GiroPayEditText extends EditText {

    /* renamed from: a */
    private Drawable f9549a = null;

    /* renamed from: b */
    private C5638a f9550b;

    /* renamed from: com.adyen.ui.views.GiroPayEditText$a */
    public interface C5638a {
        /* renamed from: a */
        void mo17744a();
    }

    public GiroPayEditText(Context context) {
        super(context);
    }

    public GiroPayEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GiroPayEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public GiroPayEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!(event.getAction() != 0 || this.f9549a == null || this.f9550b == null)) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            if (x >= (getWidth() - this.f9549a.getBounds().width()) - 15 && x <= (getWidth() - getPaddingRight()) + 15 && y >= getPaddingTop() - 15 && y <= (getHeight() - getPaddingBottom()) + 15) {
                this.f9550b.mo17744a();
                event.setAction(3);
                return false;
            }
        }
        return super.onTouchEvent(event);
    }

    /* renamed from: a */
    public void mo17808a(Drawable drawable, C5638a listener) {
        this.f9549a = drawable;
        this.f9550b = listener;
        setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
    }
}
