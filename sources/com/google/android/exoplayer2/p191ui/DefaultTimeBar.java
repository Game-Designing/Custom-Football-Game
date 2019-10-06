package com.google.android.exoplayer2.p191ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import com.google.android.exoplayer2.p191ui.C8449h.C8450a;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.ui.DefaultTimeBar */
public class DefaultTimeBar extends View implements C8449h {

    /* renamed from: A */
    private long f18496A;

    /* renamed from: B */
    private int f18497B;

    /* renamed from: C */
    private boolean f18498C;

    /* renamed from: D */
    private long f18499D;

    /* renamed from: E */
    private long f18500E;

    /* renamed from: F */
    private long f18501F;

    /* renamed from: G */
    private long f18502G;

    /* renamed from: H */
    private int f18503H;

    /* renamed from: I */
    private long[] f18504I;

    /* renamed from: J */
    private boolean[] f18505J;

    /* renamed from: a */
    private final Rect f18506a = new Rect();

    /* renamed from: b */
    private final Rect f18507b = new Rect();

    /* renamed from: c */
    private final Rect f18508c = new Rect();

    /* renamed from: d */
    private final Rect f18509d = new Rect();

    /* renamed from: e */
    private final Paint f18510e = new Paint();

    /* renamed from: f */
    private final Paint f18511f = new Paint();

    /* renamed from: g */
    private final Paint f18512g = new Paint();

    /* renamed from: h */
    private final Paint f18513h = new Paint();

    /* renamed from: i */
    private final Paint f18514i = new Paint();

    /* renamed from: j */
    private final Paint f18515j = new Paint();

    /* renamed from: k */
    private final Drawable f18516k;

    /* renamed from: l */
    private final int f18517l;

    /* renamed from: m */
    private final int f18518m;

    /* renamed from: n */
    private final int f18519n;

    /* renamed from: o */
    private final int f18520o;

    /* renamed from: p */
    private final int f18521p;

    /* renamed from: q */
    private final int f18522q;

    /* renamed from: r */
    private final int f18523r;

    /* renamed from: s */
    private final int f18524s;

    /* renamed from: t */
    private final StringBuilder f18525t;

    /* renamed from: u */
    private final Formatter f18526u;

    /* renamed from: v */
    private final Runnable f18527v;

    /* renamed from: w */
    private final CopyOnWriteArraySet<C8450a> f18528w;

    /* renamed from: x */
    private final int[] f18529x;

    /* renamed from: y */
    private final Point f18530y;

    /* renamed from: z */
    private int f18531z;

    public DefaultTimeBar(Context context, AttributeSet attrs) {
        AttributeSet attributeSet = attrs;
        super(context, attrs);
        this.f18515j.setAntiAlias(true);
        this.f18528w = new CopyOnWriteArraySet<>();
        this.f18529x = new int[2];
        this.f18530y = new Point();
        Resources res = context.getResources();
        DisplayMetrics displayMetrics = res.getDisplayMetrics();
        this.f18524s = m20102a(displayMetrics, -50);
        int defaultBarHeight = m20102a(displayMetrics, 4);
        int defaultTouchTargetHeight = m20102a(displayMetrics, 26);
        int defaultAdMarkerWidth = m20102a(displayMetrics, 4);
        int defaultScrubberEnabledSize = m20102a(displayMetrics, 12);
        int defaultScrubberDisabledSize = m20102a(displayMetrics, 0);
        int defaultScrubberDraggedSize = m20102a(displayMetrics, 16);
        if (attributeSet != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(attributeSet, C8447f.DefaultTimeBar, 0, 0);
            try {
                this.f18516k = a.getDrawable(C8447f.DefaultTimeBar_scrubber_drawable);
                if (this.f18516k != null) {
                    try {
                        m20109a(this.f18516k);
                        defaultTouchTargetHeight = Math.max(this.f18516k.getMinimumHeight(), defaultTouchTargetHeight);
                    } catch (Throwable th) {
                        th = th;
                        Resources resources = res;
                        a.recycle();
                        throw th;
                    }
                }
                this.f18517l = a.getDimensionPixelSize(C8447f.DefaultTimeBar_bar_height, defaultBarHeight);
                this.f18518m = a.getDimensionPixelSize(C8447f.DefaultTimeBar_touch_target_height, defaultTouchTargetHeight);
                this.f18519n = a.getDimensionPixelSize(C8447f.DefaultTimeBar_ad_marker_width, defaultAdMarkerWidth);
                this.f18520o = a.getDimensionPixelSize(C8447f.DefaultTimeBar_scrubber_enabled_size, defaultScrubberEnabledSize);
                this.f18521p = a.getDimensionPixelSize(C8447f.DefaultTimeBar_scrubber_disabled_size, defaultScrubberDisabledSize);
                this.f18522q = a.getDimensionPixelSize(C8447f.DefaultTimeBar_scrubber_dragged_size, defaultScrubberDraggedSize);
                int playedColor = a.getInt(C8447f.DefaultTimeBar_played_color, -1);
                int scrubberColor = a.getInt(C8447f.DefaultTimeBar_scrubber_color, m20114c(playedColor));
                int bufferedColor = a.getInt(C8447f.DefaultTimeBar_buffered_color, m20101a(playedColor));
                int unplayedColor = a.getInt(C8447f.DefaultTimeBar_unplayed_color, m20116d(playedColor));
                int adMarkerColor = a.getInt(C8447f.DefaultTimeBar_ad_marker_color, -1291845888);
                Resources resources2 = res;
                try {
                    int playedAdMarkerColor = a.getInt(C8447f.DefaultTimeBar_played_ad_marker_color, m20111b(adMarkerColor));
                    this.f18510e.setColor(playedColor);
                    this.f18515j.setColor(scrubberColor);
                    this.f18511f.setColor(bufferedColor);
                    this.f18512g.setColor(unplayedColor);
                    this.f18513h.setColor(adMarkerColor);
                    this.f18514i.setColor(playedAdMarkerColor);
                    a.recycle();
                } catch (Throwable th2) {
                    th = th2;
                    a.recycle();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                Resources resources3 = res;
                a.recycle();
                throw th;
            }
        } else {
            this.f18517l = defaultBarHeight;
            this.f18518m = defaultTouchTargetHeight;
            this.f18519n = defaultAdMarkerWidth;
            this.f18520o = defaultScrubberEnabledSize;
            this.f18521p = defaultScrubberDisabledSize;
            this.f18522q = defaultScrubberDraggedSize;
            this.f18510e.setColor(-1);
            this.f18515j.setColor(m20114c(-1));
            this.f18511f.setColor(m20101a(-1));
            this.f18512g.setColor(m20116d(-1));
            this.f18513h.setColor(-1291845888);
            this.f18516k = null;
        }
        this.f18525t = new StringBuilder();
        this.f18526u = new Formatter(this.f18525t, Locale.getDefault());
        this.f18527v = new C8442a(this);
        Drawable drawable = this.f18516k;
        if (drawable != null) {
            this.f18523r = (drawable.getMinimumWidth() + 1) / 2;
        } else {
            this.f18523r = (Math.max(this.f18521p, Math.max(this.f18520o, this.f18522q)) + 1) / 2;
        }
        this.f18500E = -9223372036854775807L;
        this.f18496A = -9223372036854775807L;
        this.f18531z = 20;
        setFocusable(true);
        if (C8509F.f18793a >= 16) {
            m20112b();
        }
    }

    /* renamed from: a */
    public /* synthetic */ void mo25875a() {
        m20106a(false);
    }

    public void setPlayedColor(int playedColor) {
        this.f18510e.setColor(playedColor);
        invalidate(this.f18506a);
    }

    public void setScrubberColor(int scrubberColor) {
        this.f18515j.setColor(scrubberColor);
        invalidate(this.f18506a);
    }

    public void setBufferedColor(int bufferedColor) {
        this.f18511f.setColor(bufferedColor);
        invalidate(this.f18506a);
    }

    public void setUnplayedColor(int unplayedColor) {
        this.f18512g.setColor(unplayedColor);
        invalidate(this.f18506a);
    }

    public void setAdMarkerColor(int adMarkerColor) {
        this.f18513h.setColor(adMarkerColor);
        invalidate(this.f18506a);
    }

    public void setPlayedAdMarkerColor(int playedAdMarkerColor) {
        this.f18514i.setColor(playedAdMarkerColor);
        invalidate(this.f18506a);
    }

    public void setKeyTimeIncrement(long time) {
        C8514e.m20488a(time > 0);
        this.f18531z = -1;
        this.f18496A = time;
    }

    public void setKeyCountIncrement(int count) {
        C8514e.m20488a(count > 0);
        this.f18531z = count;
        this.f18496A = -9223372036854775807L;
    }

    public void setPosition(long position) {
        this.f18501F = position;
        setContentDescription(getProgressText());
        m20117d();
    }

    public void setBufferedPosition(long bufferedPosition) {
        this.f18502G = bufferedPosition;
        m20117d();
    }

    public void setDuration(long duration) {
        this.f18500E = duration;
        if (this.f18498C && duration == -9223372036854775807L) {
            m20106a(true);
        }
        m20117d();
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (this.f18498C && !enabled) {
            m20106a(true);
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        m20113b(canvas);
        m20105a(canvas);
        canvas.restore();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r4 != 3) goto L_0x0093;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            boolean r0 = r8.isEnabled()
            r1 = 0
            if (r0 == 0) goto L_0x0094
            long r2 = r8.f18500E
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0011
            goto L_0x0094
        L_0x0011:
            android.graphics.Point r0 = r8.m20103a(r9)
            int r2 = r0.x
            int r3 = r0.y
            int r4 = r9.getAction()
            r5 = 1
            if (r4 == 0) goto L_0x0077
            r6 = 3
            if (r4 == r5) goto L_0x0068
            r7 = 2
            if (r4 == r7) goto L_0x0029
            if (r4 == r6) goto L_0x0068
            goto L_0x0093
        L_0x0029:
            boolean r4 = r8.f18498C
            if (r4 == 0) goto L_0x0093
            int r1 = r8.f18524s
            if (r3 >= r1) goto L_0x003d
            int r1 = r8.f18497B
            int r4 = r2 - r1
            int r6 = r4 / 3
            int r1 = r1 + r6
            float r1 = (float) r1
            r8.m20104a(r1)
            goto L_0x0043
        L_0x003d:
            r8.f18497B = r2
            float r1 = (float) r2
            r8.m20104a(r1)
        L_0x0043:
            long r6 = r8.getScrubberPosition()
            r8.f18499D = r6
            java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.ui.h$a> r1 = r8.f18528w
            java.util.Iterator r1 = r1.iterator()
        L_0x004f:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0061
            java.lang.Object r4 = r1.next()
            com.google.android.exoplayer2.ui.h$a r4 = (com.google.android.exoplayer2.p191ui.C8449h.C8450a) r4
            long r6 = r8.f18499D
            r4.mo25914a(r8, r6)
            goto L_0x004f
        L_0x0061:
            r8.m20117d()
            r8.invalidate()
            return r5
        L_0x0068:
            boolean r4 = r8.f18498C
            if (r4 == 0) goto L_0x0093
            int r4 = r9.getAction()
            if (r4 != r6) goto L_0x0073
            r1 = 1
        L_0x0073:
            r8.m20106a(r1)
            return r5
        L_0x0077:
            float r4 = (float) r2
            float r6 = (float) r3
            boolean r4 = r8.m20107a(r4, r6)
            if (r4 == 0) goto L_0x0093
            float r1 = (float) r2
            r8.m20104a(r1)
            r8.m20115c()
            long r6 = r8.getScrubberPosition()
            r8.f18499D = r6
            r8.m20117d()
            r8.invalidate()
            return r5
        L_0x0093:
            return r1
        L_0x0094:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p191ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (m20108a(r0) == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        removeCallbacks(r6.f18527v);
        postDelayed(r6.f18527v, 1000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r7, android.view.KeyEvent r8) {
        /*
            r6 = this;
            boolean r0 = r6.isEnabled()
            if (r0 == 0) goto L_0x0036
            long r0 = r6.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r7 == r2) goto L_0x0027
            switch(r7) {
                case 21: goto L_0x0013;
                case 22: goto L_0x0014;
                case 23: goto L_0x0027;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0036
        L_0x0013:
            long r0 = -r0
        L_0x0014:
            boolean r2 = r6.m20108a(r0)
            if (r2 == 0) goto L_0x0036
            java.lang.Runnable r2 = r6.f18527v
            r6.removeCallbacks(r2)
            java.lang.Runnable r2 = r6.f18527v
            r4 = 1000(0x3e8, double:4.94E-321)
            r6.postDelayed(r2, r4)
            return r3
        L_0x0027:
            boolean r2 = r6.f18498C
            if (r2 == 0) goto L_0x0036
            java.lang.Runnable r2 = r6.f18527v
            r6.removeCallbacks(r2)
            java.lang.Runnable r2 = r6.f18527v
            r2.run()
            return r3
        L_0x0036:
            boolean r0 = super.onKeyDown(r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p191ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        m20118e();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f18516k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int height = heightMode == 0 ? this.f18518m : heightMode == 1073741824 ? heightSize : Math.min(this.f18518m, heightSize);
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), height);
        m20118e();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int width = right - left;
        int barY = ((bottom - top) - this.f18518m) / 2;
        int seekLeft = getPaddingLeft();
        int seekRight = width - getPaddingRight();
        int i = this.f18518m;
        int progressY = ((i - this.f18517l) / 2) + barY;
        this.f18506a.set(seekLeft, barY, seekRight, i + barY);
        Rect rect = this.f18507b;
        Rect rect2 = this.f18506a;
        int i2 = rect2.left;
        int i3 = this.f18523r;
        rect.set(i2 + i3, progressY, rect2.right - i3, this.f18517l + progressY);
        m20117d();
    }

    public void onRtlPropertiesChanged(int layoutDirection) {
        Drawable drawable = this.f18516k;
        if (drawable != null && m20110a(drawable, layoutDirection)) {
            invalidate();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        if (event.getEventType() == 4) {
            event.getText().add(getProgressText());
        }
        event.setClassName("android.widget.SeekBar");
    }

    @TargetApi(21)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName("android.widget.SeekBar");
        info.setContentDescription(getProgressText());
        if (this.f18500E > 0) {
            int i = C8509F.f18793a;
            if (i >= 21) {
                info.addAction(AccessibilityAction.ACTION_SCROLL_FORWARD);
                info.addAction(AccessibilityAction.ACTION_SCROLL_BACKWARD);
            } else if (i >= 16) {
                info.addAction(Opcodes.ACC_SYNTHETIC);
                info.addAction(Opcodes.ACC_ANNOTATION);
            }
        }
    }

    @TargetApi(16)
    public boolean performAccessibilityAction(int action, Bundle args) {
        if (super.performAccessibilityAction(action, args)) {
            return true;
        }
        if (this.f18500E <= 0) {
            return false;
        }
        if (action == 8192) {
            if (m20108a(-getPositionIncrement())) {
                m20106a(false);
            }
        } else if (action != 4096) {
            return false;
        } else {
            if (m20108a(getPositionIncrement())) {
                m20106a(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    @TargetApi(16)
    /* renamed from: b */
    private void m20112b() {
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    /* renamed from: c */
    private void m20115c() {
        this.f18498C = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator it = this.f18528w.iterator();
        while (it.hasNext()) {
            ((C8450a) it.next()).mo25916b(this, getScrubberPosition());
        }
    }

    /* renamed from: a */
    private void m20106a(boolean canceled) {
        this.f18498C = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator it = this.f18528w.iterator();
        while (it.hasNext()) {
            ((C8450a) it.next()).mo25915a(this, getScrubberPosition(), canceled);
        }
    }

    /* renamed from: d */
    private void m20117d() {
        this.f18508c.set(this.f18507b);
        this.f18509d.set(this.f18507b);
        long newScrubberTime = this.f18498C ? this.f18499D : this.f18501F;
        if (this.f18500E > 0) {
            int bufferedPixelWidth = (int) ((((long) this.f18507b.width()) * this.f18502G) / this.f18500E);
            Rect rect = this.f18508c;
            Rect rect2 = this.f18507b;
            rect.right = Math.min(rect2.left + bufferedPixelWidth, rect2.right);
            int scrubberPixelPosition = (int) ((((long) this.f18507b.width()) * newScrubberTime) / this.f18500E);
            Rect rect3 = this.f18509d;
            Rect rect4 = this.f18507b;
            rect3.right = Math.min(rect4.left + scrubberPixelPosition, rect4.right);
        } else {
            Rect rect5 = this.f18508c;
            int i = this.f18507b.left;
            rect5.right = i;
            this.f18509d.right = i;
        }
        invalidate(this.f18506a);
    }

    /* renamed from: a */
    private void m20104a(float xPosition) {
        Rect rect = this.f18509d;
        int i = (int) xPosition;
        Rect rect2 = this.f18507b;
        rect.right = C8509F.m20433a(i, rect2.left, rect2.right);
    }

    /* renamed from: a */
    private Point m20103a(MotionEvent motionEvent) {
        getLocationOnScreen(this.f18529x);
        this.f18530y.set(((int) motionEvent.getRawX()) - this.f18529x[0], ((int) motionEvent.getRawY()) - this.f18529x[1]);
        return this.f18530y;
    }

    private long getScrubberPosition() {
        if (this.f18507b.width() <= 0 || this.f18500E == -9223372036854775807L) {
            return 0;
        }
        return (((long) this.f18509d.width()) * this.f18500E) / ((long) this.f18507b.width());
    }

    /* renamed from: a */
    private boolean m20107a(float x, float y) {
        return this.f18506a.contains((int) x, (int) y);
    }

    /* renamed from: b */
    private void m20113b(Canvas canvas) {
        DefaultTimeBar defaultTimeBar = this;
        int progressBarHeight = defaultTimeBar.f18507b.height();
        int barTop = defaultTimeBar.f18507b.centerY() - (progressBarHeight / 2);
        int barBottom = barTop + progressBarHeight;
        if (defaultTimeBar.f18500E <= 0) {
            Rect rect = defaultTimeBar.f18507b;
            canvas.drawRect((float) rect.left, (float) barTop, (float) rect.right, (float) barBottom, defaultTimeBar.f18512g);
            return;
        }
        Rect rect2 = defaultTimeBar.f18508c;
        int bufferedLeft = rect2.left;
        int bufferedRight = rect2.right;
        int progressLeft = Math.max(Math.max(defaultTimeBar.f18507b.left, bufferedRight), defaultTimeBar.f18509d.right);
        int i = defaultTimeBar.f18507b.right;
        if (progressLeft < i) {
            canvas.drawRect((float) progressLeft, (float) barTop, (float) i, (float) barBottom, defaultTimeBar.f18512g);
        }
        int bufferedLeft2 = Math.max(bufferedLeft, defaultTimeBar.f18509d.right);
        if (bufferedRight > bufferedLeft2) {
            canvas.drawRect((float) bufferedLeft2, (float) barTop, (float) bufferedRight, (float) barBottom, defaultTimeBar.f18511f);
        }
        if (defaultTimeBar.f18509d.width() > 0) {
            Rect rect3 = defaultTimeBar.f18509d;
            canvas.drawRect((float) rect3.left, (float) barTop, (float) rect3.right, (float) barBottom, defaultTimeBar.f18510e);
        }
        if (defaultTimeBar.f18503H != 0) {
            long[] jArr = defaultTimeBar.f18504I;
            C8514e.m20486a(jArr);
            long[] adGroupTimesMs = jArr;
            boolean[] zArr = defaultTimeBar.f18505J;
            C8514e.m20486a(zArr);
            boolean[] playedAdGroups = zArr;
            int adMarkerOffset = defaultTimeBar.f18519n / 2;
            int i2 = 0;
            while (i2 < defaultTimeBar.f18503H) {
                int bufferedRight2 = bufferedRight;
                int bufferedLeft3 = bufferedLeft2;
                int markerPositionOffset = ((int) ((((long) defaultTimeBar.f18507b.width()) * C8509F.m20467b(adGroupTimesMs[i2], 0, defaultTimeBar.f18500E)) / defaultTimeBar.f18500E)) - adMarkerOffset;
                Rect rect4 = defaultTimeBar.f18507b;
                int markerLeft = rect4.left + Math.min(rect4.width() - defaultTimeBar.f18519n, Math.max(0, markerPositionOffset));
                int progressBarHeight2 = progressBarHeight;
                canvas.drawRect((float) markerLeft, (float) barTop, (float) (defaultTimeBar.f18519n + markerLeft), (float) barBottom, playedAdGroups[i2] ? defaultTimeBar.f18514i : defaultTimeBar.f18513h);
                i2++;
                defaultTimeBar = this;
                bufferedRight = bufferedRight2;
                progressBarHeight = progressBarHeight2;
                bufferedLeft2 = bufferedLeft3;
            }
            int i3 = bufferedRight;
            int i4 = bufferedLeft2;
        }
    }

    /* renamed from: a */
    private void m20105a(Canvas canvas) {
        if (this.f18500E > 0) {
            Rect rect = this.f18509d;
            int playheadX = C8509F.m20433a(rect.right, rect.left, this.f18507b.right);
            int playheadY = this.f18509d.centerY();
            Drawable drawable = this.f18516k;
            if (drawable == null) {
                int scrubberSize = (this.f18498C || isFocused()) ? this.f18522q : isEnabled() ? this.f18520o : this.f18521p;
                canvas.drawCircle((float) playheadX, (float) playheadY, (float) (scrubberSize / 2), this.f18515j);
            } else {
                int scrubberDrawableWidth = drawable.getIntrinsicWidth();
                int scrubberDrawableHeight = this.f18516k.getIntrinsicHeight();
                this.f18516k.setBounds(playheadX - (scrubberDrawableWidth / 2), playheadY - (scrubberDrawableHeight / 2), (scrubberDrawableWidth / 2) + playheadX, (scrubberDrawableHeight / 2) + playheadY);
                this.f18516k.draw(canvas);
            }
        }
    }

    /* renamed from: e */
    private void m20118e() {
        Drawable drawable = this.f18516k;
        if (drawable != null && drawable.isStateful() && this.f18516k.setState(getDrawableState())) {
            invalidate();
        }
    }

    private String getProgressText() {
        return C8509F.m20446a(this.f18525t, this.f18526u, this.f18501F);
    }

    private long getPositionIncrement() {
        long j = this.f18496A;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = this.f18500E;
        if (j2 == -9223372036854775807L) {
            return 0;
        }
        return j2 / ((long) this.f18531z);
    }

    /* renamed from: a */
    private boolean m20108a(long positionChange) {
        if (this.f18500E <= 0) {
            return false;
        }
        long scrubberPosition = getScrubberPosition();
        this.f18499D = C8509F.m20467b(scrubberPosition + positionChange, 0, this.f18500E);
        if (this.f18499D == scrubberPosition) {
            return false;
        }
        if (!this.f18498C) {
            m20115c();
        }
        Iterator it = this.f18528w.iterator();
        while (it.hasNext()) {
            ((C8450a) it.next()).mo25914a(this, this.f18499D);
        }
        m20117d();
        return true;
    }

    /* renamed from: a */
    private boolean m20109a(Drawable drawable) {
        return C8509F.f18793a >= 23 && m20110a(drawable, getLayoutDirection());
    }

    /* renamed from: a */
    private static boolean m20110a(Drawable drawable, int layoutDirection) {
        return C8509F.f18793a >= 23 && drawable.setLayoutDirection(layoutDirection);
    }

    /* renamed from: c */
    public static int m20114c(int playedColor) {
        return -16777216 | playedColor;
    }

    /* renamed from: d */
    public static int m20116d(int playedColor) {
        return (16777215 & playedColor) | 855638016;
    }

    /* renamed from: a */
    public static int m20101a(int playedColor) {
        return (16777215 & playedColor) | -872415232;
    }

    /* renamed from: b */
    public static int m20111b(int adMarkerColor) {
        return (16777215 & adMarkerColor) | 855638016;
    }

    /* renamed from: a */
    private static int m20102a(DisplayMetrics displayMetrics, int dps) {
        return (int) ((((float) dps) * displayMetrics.density) + 0.5f);
    }
}
