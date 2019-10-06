package com.mopub.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;

public class CloseableLayout extends FrameLayout {

    /* renamed from: a */
    private final int f34259a;

    /* renamed from: b */
    private OnCloseListener f34260b;

    /* renamed from: c */
    private final StateListDrawable f34261c;

    /* renamed from: d */
    private ClosePosition f34262d;

    /* renamed from: e */
    private final int f34263e;

    /* renamed from: f */
    private final int f34264f;

    /* renamed from: g */
    private final int f34265g;

    /* renamed from: h */
    private boolean f34266h;

    /* renamed from: i */
    private final Rect f34267i;

    /* renamed from: j */
    private final Rect f34268j;

    /* renamed from: k */
    private final Rect f34269k;

    /* renamed from: l */
    private final Rect f34270l;

    /* renamed from: m */
    private boolean f34271m;

    /* renamed from: n */
    private C11222a f34272n;

    public enum ClosePosition {
        TOP_LEFT(51),
        TOP_CENTER(49),
        TOP_RIGHT(53),
        CENTER(17),
        BOTTOM_LEFT(83),
        BOTTOM_CENTER(81),
        BOTTOM_RIGHT(85);
        

        /* renamed from: b */
        private final int f34274b;

        private ClosePosition(int mGravity) {
            this.f34274b = mGravity;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public int mo36508e() {
            return this.f34274b;
        }
    }

    public interface OnCloseListener {
        void onClose();
    }

    /* renamed from: com.mopub.common.CloseableLayout$a */
    private final class C11222a implements Runnable {
        private C11222a() {
        }

        public void run() {
            CloseableLayout.this.setClosePressed(false);
        }
    }

    public CloseableLayout(Context context) {
        this(context, null, 0);
    }

    public CloseableLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CloseableLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f34267i = new Rect();
        this.f34268j = new Rect();
        this.f34269k = new Rect();
        this.f34270l = new Rect();
        this.f34261c = new StateListDrawable();
        this.f34262d = ClosePosition.TOP_RIGHT;
        this.f34261c.addState(FrameLayout.SELECTED_STATE_SET, Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.createDrawable(context));
        this.f34261c.addState(FrameLayout.EMPTY_STATE_SET, Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.createDrawable(context));
        this.f34261c.setState(FrameLayout.EMPTY_STATE_SET);
        this.f34261c.setCallback(this);
        this.f34259a = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f34263e = Dips.asIntPixels(50.0f, context);
        this.f34264f = Dips.asIntPixels(30.0f, context);
        this.f34265g = Dips.asIntPixels(8.0f, context);
        setWillNotDraw(false);
        this.f34271m = true;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.f34260b = onCloseListener;
    }

    public void setClosePosition(ClosePosition closePosition) {
        Preconditions.checkNotNull(closePosition);
        this.f34262d = closePosition;
        this.f34266h = true;
        invalidate();
    }

    public void setCloseVisible(boolean visible) {
        if (this.f34261c.setVisible(visible, false)) {
            invalidate(this.f34268j);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        this.f34266h = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f34266h) {
            this.f34266h = false;
            this.f34267i.set(0, 0, getWidth(), getHeight());
            applyCloseRegionBounds(this.f34262d, this.f34267i, this.f34268j);
            this.f34270l.set(this.f34268j);
            Rect rect = this.f34270l;
            int i = this.f34265g;
            rect.inset(i, i);
            m36955a(this.f34262d, this.f34270l, this.f34269k);
            this.f34261c.setBounds(this.f34269k);
        }
        if (this.f34261c.isVisible()) {
            this.f34261c.draw(canvas);
        }
    }

    public void applyCloseRegionBounds(ClosePosition closePosition, Rect bounds, Rect closeBounds) {
        m36954a(closePosition, this.f34263e, bounds, closeBounds);
    }

    /* renamed from: a */
    private void m36955a(ClosePosition closePosition, Rect bounds, Rect outBounds) {
        m36954a(closePosition, this.f34264f, bounds, outBounds);
    }

    /* renamed from: a */
    private void m36954a(ClosePosition closePosition, int size, Rect bounds, Rect outBounds) {
        Gravity.apply(closePosition.mo36508e(), size, size, bounds, outBounds);
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (event.getAction() != 0) {
            return false;
        }
        return mo36493a((int) event.getX(), (int) event.getY(), 0);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!mo36493a((int) event.getX(), (int) event.getY(), this.f34259a) || !mo36495b()) {
            setClosePressed(false);
            super.onTouchEvent(event);
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            setClosePressed(true);
        } else if (action != 1) {
            if (action == 3) {
                setClosePressed(false);
            }
        } else if (mo36492a()) {
            if (this.f34272n == null) {
                this.f34272n = new C11222a();
            }
            postDelayed(this.f34272n, (long) ViewConfiguration.getPressedStateDuration());
            m36957c();
        }
        return true;
    }

    public void setCloseAlwaysInteractable(boolean closeAlwaysInteractable) {
        this.f34271m = closeAlwaysInteractable;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: b */
    public boolean mo36495b() {
        return this.f34271m || this.f34261c.isVisible();
    }

    /* access modifiers changed from: private */
    public void setClosePressed(boolean pressed) {
        if (pressed != mo36492a()) {
            this.f34261c.setState(pressed ? FrameLayout.SELECTED_STATE_SET : FrameLayout.EMPTY_STATE_SET);
            invalidate(this.f34268j);
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public boolean mo36492a() {
        return this.f34261c.getState() == FrameLayout.SELECTED_STATE_SET;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public boolean mo36493a(int x, int y, int slop) {
        Rect rect = this.f34268j;
        return x >= rect.left - slop && y >= rect.top - slop && x < rect.right + slop && y < rect.bottom + slop;
    }

    /* renamed from: c */
    private void m36957c() {
        playSoundEffect(0);
        OnCloseListener onCloseListener = this.f34260b;
        if (onCloseListener != null) {
            onCloseListener.onClose();
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public void setCloseBounds(Rect closeBounds) {
        this.f34268j.set(closeBounds);
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public Rect getCloseBounds() {
        return this.f34268j;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public void setCloseBoundChanged(boolean changed) {
        this.f34266h = changed;
    }

    @VisibleForTesting
    public boolean isCloseVisible() {
        return this.f34261c.isVisible();
    }
}
