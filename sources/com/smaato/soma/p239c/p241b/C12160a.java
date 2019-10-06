package com.smaato.soma.p239c.p241b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p000v4.content.C0510b;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.smaato.soma.C12056Ja;
import com.smaato.soma.p239c.p252i.C12278d;

/* renamed from: com.smaato.soma.c.b.a */
/* compiled from: CloseableAdLayout */
public class C12160a extends FrameLayout {

    /* renamed from: a */
    private Drawable f38118a;

    /* renamed from: b */
    private C12161a f38119b;

    /* renamed from: c */
    private C12162b f38120c;

    /* renamed from: d */
    private Rect f38121d;

    /* renamed from: e */
    private Rect f38122e;

    /* renamed from: f */
    private Rect f38123f;

    /* renamed from: g */
    private final int f38124g;

    /* renamed from: h */
    private final int f38125h;

    /* renamed from: i */
    private final int f38126i;

    /* renamed from: j */
    private boolean f38127j;

    /* renamed from: com.smaato.soma.c.b.a$a */
    /* compiled from: CloseableAdLayout */
    public interface C12161a {
        void onClose();
    }

    public C12160a(Context context) {
        this(context, null);
    }

    public C12160a(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public C12160a(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f38121d = new Rect();
        this.f38122e = new Rect();
        this.f38123f = new Rect();
        this.f38118a = C0510b.m2572c(context, C12056Ja.ic_browser_close_40dp);
        this.f38124g = C12278d.m40415a().mo39670a(50);
        this.f38125h = C12278d.m40415a().mo39670a(5);
        this.f38120c = C12162b.TOP_RIGHT;
        this.f38126i = ViewConfiguration.get(context).getScaledTouchSlop();
        setWillNotDraw(false);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.f38121d.set(0, 0, getWidth(), getHeight());
        mo39399a(this.f38120c, this.f38121d, this.f38122e);
        this.f38123f.set(this.f38122e);
        Rect rect = this.f38123f;
        int i = this.f38125h;
        rect.inset(i, i);
        mo39399a(this.f38120c, this.f38123f, this.f38122e);
        this.f38118a.setBounds(this.f38122e);
        if (this.f38118a.isVisible()) {
            this.f38118a.draw(canvas);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (event.getAction() != 0) {
            return false;
        }
        return m39997a((int) event.getX(), (int) event.getY(), 0);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!m39997a((int) event.getX(), (int) event.getY(), this.f38126i)) {
            super.onTouchEvent(event);
            this.f38127j = false;
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            this.f38127j = true;
        } else if (action != 1) {
            if (action == 3) {
                this.f38127j = false;
            }
        } else if (this.f38127j) {
            C12161a aVar = this.f38119b;
            if (aVar != null) {
                aVar.onClose();
            }
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void setCloseButtonVisibility(boolean isVisible) {
        if (this.f38118a.setVisible(isVisible, false)) {
            invalidate(this.f38122e);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setCustomClosePosition(C12162b customClosePosition) {
        this.f38120c = customClosePosition;
    }

    /* access modifiers changed from: 0000 */
    public void setOnCloseCallback(C12161a onCloseCallback) {
        this.f38119b = onCloseCallback;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo39399a(C12162b customClosePosition, Rect containerBounds, Rect outBounds) {
        int e = customClosePosition.mo39407e();
        int i = this.f38124g;
        Gravity.apply(e, i, i, containerBounds, outBounds);
    }

    /* renamed from: a */
    private boolean m39997a(int x, int y, int slop) {
        Rect rect = this.f38122e;
        return x >= rect.left - slop && y >= rect.top - slop && x < rect.right + slop && y < rect.bottom + slop;
    }
}
