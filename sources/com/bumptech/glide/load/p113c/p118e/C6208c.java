package com.bumptech.glide.load.p113c.p118e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Gravity;
import com.bumptech.glide.C5926c;
import com.bumptech.glide.load.C6352n;
import com.bumptech.glide.load.p113c.p118e.C6213g.C6215b;
import com.bumptech.glide.p099b.C5920a;
import com.bumptech.glide.p107h.C6024i;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.c.e.c */
/* compiled from: GifDrawable */
public class C6208c extends Drawable implements C6215b, Animatable {

    /* renamed from: a */
    private final C6209a f10942a;

    /* renamed from: b */
    private boolean f10943b;

    /* renamed from: c */
    private boolean f10944c;

    /* renamed from: d */
    private boolean f10945d;

    /* renamed from: e */
    private boolean f10946e;

    /* renamed from: f */
    private int f10947f;

    /* renamed from: g */
    private int f10948g;

    /* renamed from: h */
    private boolean f10949h;

    /* renamed from: i */
    private Paint f10950i;

    /* renamed from: j */
    private Rect f10951j;

    /* renamed from: com.bumptech.glide.load.c.e.c$a */
    /* compiled from: GifDrawable */
    static final class C6209a extends ConstantState {

        /* renamed from: a */
        final C6213g f10952a;

        C6209a(C6213g frameLoader) {
            this.f10952a = frameLoader;
        }

        public Drawable newDrawable(Resources res) {
            return newDrawable();
        }

        public Drawable newDrawable() {
            return new C6208c(this);
        }

        public int getChangingConfigurations() {
            return 0;
        }
    }

    public C6208c(Context context, C5920a gifDecoder, C6352n<Bitmap> frameTransformation, int targetFrameWidth, int targetFrameHeight, Bitmap firstFrame) {
        C6213g gVar = new C6213g(C5926c.m10916a(context), gifDecoder, targetFrameWidth, targetFrameHeight, frameTransformation, firstFrame);
        this(new C6209a(gVar));
    }

    C6208c(C6209a state) {
        this.f10946e = true;
        this.f10948g = -1;
        C6024i.m11264a(state);
        this.f10942a = state;
    }

    /* renamed from: f */
    public int mo19051f() {
        return this.f10942a.f10952a.mo19079h();
    }

    /* renamed from: c */
    public Bitmap mo19047c() {
        return this.f10942a.f10952a.mo19076e();
    }

    /* renamed from: a */
    public void mo19045a(C6352n<Bitmap> frameTransformation, Bitmap firstFrame) {
        this.f10942a.f10952a.mo19071a(frameTransformation, firstFrame);
    }

    /* renamed from: b */
    public ByteBuffer mo19046b() {
        return this.f10942a.f10952a.mo19072b();
    }

    /* renamed from: d */
    public int mo19048d() {
        return this.f10942a.f10952a.mo19077f();
    }

    /* renamed from: e */
    public int mo19050e() {
        return this.f10942a.f10952a.mo19075d();
    }

    /* renamed from: k */
    private void m11812k() {
        this.f10947f = 0;
    }

    public void start() {
        this.f10944c = true;
        m11812k();
        if (this.f10946e) {
            m11813l();
        }
    }

    public void stop() {
        this.f10944c = false;
        m11814m();
    }

    /* renamed from: l */
    private void m11813l() {
        C6024i.m11268a(!this.f10945d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f10942a.f10952a.mo19077f() == 1) {
            invalidateSelf();
        } else if (!this.f10943b) {
            this.f10943b = true;
            this.f10942a.f10952a.mo19070a((C6215b) this);
            invalidateSelf();
        }
    }

    /* renamed from: m */
    private void m11814m() {
        this.f10943b = false;
        this.f10942a.f10952a.mo19073b(this);
    }

    public boolean setVisible(boolean visible, boolean restart) {
        C6024i.m11268a(!this.f10945d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f10946e = visible;
        if (!visible) {
            m11814m();
        } else if (this.f10944c) {
            m11813l();
        }
        return super.setVisible(visible, restart);
    }

    public int getIntrinsicWidth() {
        return this.f10942a.f10952a.mo19080i();
    }

    public int getIntrinsicHeight() {
        return this.f10942a.f10952a.mo19078g();
    }

    public boolean isRunning() {
        return this.f10943b;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        this.f10949h = true;
    }

    public void draw(Canvas canvas) {
        if (!this.f10945d) {
            if (this.f10949h) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), m11810i());
                this.f10949h = false;
            }
            canvas.drawBitmap(this.f10942a.f10952a.mo19074c(), null, m11810i(), m11811j());
        }
    }

    public void setAlpha(int i) {
        m11811j().setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        m11811j().setColorFilter(colorFilter);
    }

    /* renamed from: i */
    private Rect m11810i() {
        if (this.f10951j == null) {
            this.f10951j = new Rect();
        }
        return this.f10951j;
    }

    /* renamed from: j */
    private Paint m11811j() {
        if (this.f10950i == null) {
            this.f10950i = new Paint(2);
        }
        return this.f10950i;
    }

    public int getOpacity() {
        return -2;
    }

    /* renamed from: h */
    private Callback m11809h() {
        Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    /* renamed from: a */
    public void mo19044a() {
        if (m11809h() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (mo19050e() == mo19048d() - 1) {
            this.f10947f++;
        }
        int i = this.f10948g;
        if (i != -1 && this.f10947f >= i) {
            stop();
        }
    }

    public ConstantState getConstantState() {
        return this.f10942a;
    }

    /* renamed from: g */
    public void mo19052g() {
        this.f10945d = true;
        this.f10942a.f10952a.mo19068a();
    }
}
