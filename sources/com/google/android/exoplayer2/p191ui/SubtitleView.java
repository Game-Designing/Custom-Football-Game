package com.google.android.exoplayer2.p191ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.text.C8415a;
import com.google.android.exoplayer2.text.C8418b;
import com.google.android.exoplayer2.text.C8419c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.ui.SubtitleView */
public final class SubtitleView extends View implements C8419c {

    /* renamed from: a */
    private final List<C8448g> f18532a;

    /* renamed from: b */
    private List<C8418b> f18533b;

    /* renamed from: c */
    private int f18534c;

    /* renamed from: d */
    private float f18535d;

    /* renamed from: e */
    private boolean f18536e;

    /* renamed from: f */
    private boolean f18537f;

    /* renamed from: g */
    private C8415a f18538g;

    /* renamed from: h */
    private float f18539h;

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f18532a = new ArrayList();
        this.f18534c = 0;
        this.f18535d = 0.0533f;
        this.f18536e = true;
        this.f18537f = true;
        this.f18538g = C8415a.f18378a;
        this.f18539h = 0.08f;
    }

    public void setCues(List<C8418b> cues) {
        if (this.f18533b != cues) {
            this.f18533b = cues;
            int cueCount = cues == null ? 0 : cues.size();
            while (this.f18532a.size() < cueCount) {
                this.f18532a.add(new C8448g(getContext()));
            }
            invalidate();
        }
    }

    public void setFractionalTextSize(float fractionOfHeight) {
        mo25899a(fractionOfHeight, false);
    }

    /* renamed from: a */
    public void mo25899a(float fractionOfHeight, boolean ignorePadding) {
        m20122a((int) ignorePadding, fractionOfHeight);
    }

    /* renamed from: a */
    private void m20122a(int textSizeType, float textSize) {
        if (this.f18534c != textSizeType || this.f18535d != textSize) {
            this.f18534c = textSizeType;
            this.f18535d = textSize;
            invalidate();
        }
    }

    public void setApplyEmbeddedStyles(boolean applyEmbeddedStyles) {
        if (this.f18536e != applyEmbeddedStyles || this.f18537f != applyEmbeddedStyles) {
            this.f18536e = applyEmbeddedStyles;
            this.f18537f = applyEmbeddedStyles;
            invalidate();
        }
    }

    public void setApplyEmbeddedFontSizes(boolean applyEmbeddedFontSizes) {
        if (this.f18537f != applyEmbeddedFontSizes) {
            this.f18537f = applyEmbeddedFontSizes;
            invalidate();
        }
    }

    public void setStyle(C8415a style) {
        if (this.f18538g != style) {
            this.f18538g = style;
            invalidate();
        }
    }

    public void setBottomPaddingFraction(float bottomPaddingFraction) {
        if (this.f18539h != bottomPaddingFraction) {
            this.f18539h = bottomPaddingFraction;
            invalidate();
        }
    }

    public void dispatchDraw(Canvas canvas) {
        List<C8418b> list = this.f18533b;
        int cueCount = list == null ? 0 : list.size();
        int rawViewHeight = getHeight();
        int left = getPaddingLeft();
        int top = getPaddingTop();
        int right = getWidth() - getPaddingRight();
        int bottom = rawViewHeight - getPaddingBottom();
        if (bottom <= top) {
            int i = right;
            int i2 = top;
            int i3 = left;
        } else if (right <= left) {
            int i4 = bottom;
            int i5 = right;
            int i6 = top;
            int i7 = left;
        } else {
            int viewHeightMinusPadding = bottom - top;
            float defaultViewTextSizePx = m20120a(this.f18534c, this.f18535d, rawViewHeight, viewHeightMinusPadding);
            if (defaultViewTextSizePx > 0.0f) {
                int i8 = 0;
                while (i8 < cueCount) {
                    C8418b cue = (C8418b) this.f18533b.get(i8);
                    float cueTextSizePx = m20121a(cue, rawViewHeight, viewHeightMinusPadding);
                    C8418b bVar = cue;
                    int i9 = i8;
                    int viewHeightMinusPadding2 = viewHeightMinusPadding;
                    int bottom2 = bottom;
                    int right2 = right;
                    int top2 = top;
                    int left2 = left;
                    ((C8448g) this.f18532a.get(i8)).mo25913a(cue, this.f18536e, this.f18537f, this.f18538g, defaultViewTextSizePx, cueTextSizePx, this.f18539h, canvas, left, top, right2, bottom2);
                    i8 = i9 + 1;
                    viewHeightMinusPadding = viewHeightMinusPadding2;
                    bottom = bottom2;
                    right = right2;
                    top = top2;
                    left = left2;
                }
                int i10 = i8;
                int i11 = viewHeightMinusPadding;
                int i12 = bottom;
                int i13 = right;
                int i14 = top;
                int i15 = left;
            }
        }
    }

    /* renamed from: a */
    private float m20121a(C8418b cue, int rawViewHeight, int viewHeightMinusPadding) {
        int i = cue.f18398m;
        if (i != Integer.MIN_VALUE) {
            float f = cue.f18399n;
            if (f != Float.MIN_VALUE) {
                return Math.max(m20120a(i, f, rawViewHeight, viewHeightMinusPadding), 0.0f);
            }
        }
        return 0.0f;
    }

    /* renamed from: a */
    private float m20120a(int textSizeType, float textSize, int rawViewHeight, int viewHeightMinusPadding) {
        if (textSizeType == 0) {
            return ((float) viewHeightMinusPadding) * textSize;
        }
        if (textSizeType == 1) {
            return ((float) rawViewHeight) * textSize;
        }
        if (textSizeType != 2) {
            return Float.MIN_VALUE;
        }
        return textSize;
    }

    @TargetApi(19)
    private float getUserCaptionFontScaleV19() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale();
    }

    @TargetApi(19)
    private C8415a getUserCaptionStyleV19() {
        return C8415a.m20007a(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle());
    }
}
