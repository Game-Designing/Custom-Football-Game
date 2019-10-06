package android.support.p001v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.appcompat.C0793R;
import android.util.AttributeSet;
import android.widget.SeekBar;
import p002b.p003c.p053g.p054a.p055a.C1200a;

/* renamed from: android.support.v7.widget.y */
/* compiled from: AppCompatSeekBarHelper */
class C1134y extends C1127w {

    /* renamed from: d */
    private final SeekBar f3761d;

    /* renamed from: e */
    private Drawable f3762e;

    /* renamed from: f */
    private ColorStateList f3763f = null;

    /* renamed from: g */
    private Mode f3764g = null;

    /* renamed from: h */
    private boolean f3765h = false;

    /* renamed from: i */
    private boolean f3766i = false;

    C1134y(SeekBar view) {
        super(view);
        this.f3761d = view;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8716a(AttributeSet attrs, int defStyleAttr) {
        super.mo8716a(attrs, defStyleAttr);
        C1112sb a = C1112sb.m5456a(this.f3761d.getContext(), attrs, C0793R.styleable.AppCompatSeekBar, defStyleAttr, 0);
        Drawable drawable = a.mo8652c(C0793R.styleable.AppCompatSeekBar_android_thumb);
        if (drawable != null) {
            this.f3761d.setThumb(drawable);
        }
        mo8731a(a.mo8650b(C0793R.styleable.AppCompatSeekBar_tickMark));
        if (a.mo8660g(C0793R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.f3764g = C1052ea.m5227a(a.mo8653d(C0793R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f3764g);
            this.f3766i = true;
        }
        if (a.mo8660g(C0793R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f3763f = a.mo8645a(C0793R.styleable.AppCompatSeekBar_tickMarkTint);
            this.f3765h = true;
        }
        a.mo8647a();
        m5535d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8731a(Drawable tickMark) {
        Drawable drawable = this.f3762e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f3762e = tickMark;
        if (tickMark != null) {
            tickMark.setCallback(this.f3761d);
            C1200a.m5732a(tickMark, C0646w.m2974h(this.f3761d));
            if (tickMark.isStateful()) {
                tickMark.setState(this.f3761d.getDrawableState());
            }
            m5535d();
        }
        this.f3761d.invalidate();
    }

    /* renamed from: d */
    private void m5535d() {
        if (this.f3762e == null) {
            return;
        }
        if (this.f3765h || this.f3766i) {
            this.f3762e = C1200a.m5741i(this.f3762e.mutate());
            if (this.f3765h) {
                C1200a.m5726a(this.f3762e, this.f3763f);
            }
            if (this.f3766i) {
                C1200a.m5729a(this.f3762e, this.f3764g);
            }
            if (this.f3762e.isStateful()) {
                this.f3762e.setState(this.f3761d.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo8733c() {
        Drawable drawable = this.f3762e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8732b() {
        Drawable tickMark = this.f3762e;
        if (tickMark != null && tickMark.isStateful() && tickMark.setState(this.f3761d.getDrawableState())) {
            this.f3761d.invalidateDrawable(tickMark);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8730a(Canvas canvas) {
        if (this.f3762e != null) {
            int count = this.f3761d.getMax();
            int halfH = 1;
            if (count > 1) {
                int w = this.f3762e.getIntrinsicWidth();
                int h = this.f3762e.getIntrinsicHeight();
                int halfW = w >= 0 ? w / 2 : 1;
                if (h >= 0) {
                    halfH = h / 2;
                }
                this.f3762e.setBounds(-halfW, -halfH, halfW, halfH);
                float spacing = ((float) ((this.f3761d.getWidth() - this.f3761d.getPaddingLeft()) - this.f3761d.getPaddingRight())) / ((float) count);
                int saveCount = canvas.save();
                canvas.translate((float) this.f3761d.getPaddingLeft(), (float) (this.f3761d.getHeight() / 2));
                for (int i = 0; i <= count; i++) {
                    this.f3762e.draw(canvas);
                    canvas.translate(spacing, 0.0f);
                }
                canvas.restoreToCount(saveCount);
            }
        }
    }
}
