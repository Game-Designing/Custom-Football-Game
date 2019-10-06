package com.google.android.exoplayer2.p191ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

/* renamed from: com.google.android.exoplayer2.ui.AspectRatioFrameLayout */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: a */
    private final C8440b f18487a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C8439a f18488b;

    /* renamed from: c */
    private float f18489c;

    /* renamed from: d */
    private int f18490d;

    /* renamed from: com.google.android.exoplayer2.ui.AspectRatioFrameLayout$a */
    public interface C8439a {
        /* renamed from: a */
        void mo25872a(float f, float f2, boolean z);
    }

    /* renamed from: com.google.android.exoplayer2.ui.AspectRatioFrameLayout$b */
    private final class C8440b implements Runnable {

        /* renamed from: a */
        private float f18491a;

        /* renamed from: b */
        private float f18492b;

        /* renamed from: c */
        private boolean f18493c;

        /* renamed from: d */
        private boolean f18494d;

        private C8440b() {
        }

        /* renamed from: a */
        public void mo25873a(float targetAspectRatio, float naturalAspectRatio, boolean aspectRatioMismatch) {
            this.f18491a = targetAspectRatio;
            this.f18492b = naturalAspectRatio;
            this.f18493c = aspectRatioMismatch;
            if (!this.f18494d) {
                this.f18494d = true;
                AspectRatioFrameLayout.this.post(this);
            }
        }

        public void run() {
            this.f18494d = false;
            if (AspectRatioFrameLayout.this.f18488b != null) {
                AspectRatioFrameLayout.this.f18488b.mo25872a(this.f18491a, this.f18492b, this.f18493c);
            }
        }
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f18490d = 0;
        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, C8447f.AspectRatioFrameLayout, 0, 0);
            try {
                this.f18490d = a.getInt(C8447f.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                a.recycle();
            }
        }
        this.f18487a = new C8440b();
    }

    public void setAspectRatio(float widthHeightRatio) {
        if (this.f18489c != widthHeightRatio) {
            this.f18489c = widthHeightRatio;
            requestLayout();
        }
    }

    public void setAspectRatioListener(C8439a listener) {
        this.f18488b = listener;
    }

    public int getResizeMode() {
        return this.f18490d;
    }

    public void setResizeMode(int resizeMode) {
        if (this.f18490d != resizeMode) {
            this.f18490d = resizeMode;
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.f18489c > 0.0f) {
            int width = getMeasuredWidth();
            int height = getMeasuredHeight();
            float viewAspectRatio = ((float) width) / ((float) height);
            float aspectDeformation = (this.f18489c / viewAspectRatio) - 1.0f;
            if (Math.abs(aspectDeformation) <= 0.01f) {
                this.f18487a.mo25873a(this.f18489c, viewAspectRatio, false);
                return;
            }
            int i = this.f18490d;
            if (i != 0) {
                if (i == 1) {
                    height = (int) (((float) width) / this.f18489c);
                } else if (i == 2) {
                    width = (int) (((float) height) * this.f18489c);
                } else if (i == 4) {
                    if (aspectDeformation > 0.0f) {
                        width = (int) (((float) height) * this.f18489c);
                    } else {
                        height = (int) (((float) width) / this.f18489c);
                    }
                }
            } else if (aspectDeformation > 0.0f) {
                height = (int) (((float) width) / this.f18489c);
            } else {
                width = (int) (((float) height) * this.f18489c);
            }
            this.f18487a.mo25873a(this.f18489c, viewAspectRatio, true);
            super.onMeasure(MeasureSpec.makeMeasureSpec(width, 1073741824), MeasureSpec.makeMeasureSpec(height, 1073741824));
        }
    }
}
