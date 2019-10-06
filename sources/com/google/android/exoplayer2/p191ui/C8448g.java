package com.google.android.exoplayer2.p191ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.C8415a;
import com.google.android.exoplayer2.text.C8418b;
import com.google.android.exoplayer2.util.C8509F;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;

/* renamed from: com.google.android.exoplayer2.ui.g */
/* compiled from: SubtitlePainter */
final class C8448g {

    /* renamed from: A */
    private float f18557A;

    /* renamed from: B */
    private int f18558B;

    /* renamed from: C */
    private int f18559C;

    /* renamed from: D */
    private int f18560D;

    /* renamed from: E */
    private int f18561E;

    /* renamed from: F */
    private StaticLayout f18562F;

    /* renamed from: G */
    private int f18563G;

    /* renamed from: H */
    private int f18564H;

    /* renamed from: I */
    private int f18565I;

    /* renamed from: J */
    private Rect f18566J;

    /* renamed from: a */
    private final float f18567a;

    /* renamed from: b */
    private final float f18568b;

    /* renamed from: c */
    private final float f18569c;

    /* renamed from: d */
    private final float f18570d;

    /* renamed from: e */
    private final float f18571e;

    /* renamed from: f */
    private final TextPaint f18572f = new TextPaint();

    /* renamed from: g */
    private final Paint f18573g;

    /* renamed from: h */
    private CharSequence f18574h;

    /* renamed from: i */
    private Alignment f18575i;

    /* renamed from: j */
    private Bitmap f18576j;

    /* renamed from: k */
    private float f18577k;

    /* renamed from: l */
    private int f18578l;

    /* renamed from: m */
    private int f18579m;

    /* renamed from: n */
    private float f18580n;

    /* renamed from: o */
    private int f18581o;

    /* renamed from: p */
    private float f18582p;

    /* renamed from: q */
    private float f18583q;

    /* renamed from: r */
    private boolean f18584r;

    /* renamed from: s */
    private boolean f18585s;

    /* renamed from: t */
    private int f18586t;

    /* renamed from: u */
    private int f18587u;

    /* renamed from: v */
    private int f18588v;

    /* renamed from: w */
    private int f18589w;

    /* renamed from: x */
    private int f18590x;

    /* renamed from: y */
    private float f18591y;

    /* renamed from: z */
    private float f18592z;

    public C8448g(Context context) {
        TypedArray styledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.f18571e = (float) styledAttributes.getDimensionPixelSize(0, 0);
        this.f18570d = styledAttributes.getFloat(1, 1.0f);
        styledAttributes.recycle();
        int twoDpInPx = Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * 2.0f) / 160.0f);
        this.f18567a = (float) twoDpInPx;
        this.f18568b = (float) twoDpInPx;
        this.f18569c = (float) twoDpInPx;
        this.f18572f.setAntiAlias(true);
        this.f18572f.setSubpixelText(true);
        this.f18573g = new Paint();
        this.f18573g.setAntiAlias(true);
        this.f18573g.setStyle(Style.FILL);
    }

    /* renamed from: a */
    public void mo25913a(C8418b cue, boolean applyEmbeddedStyles, boolean applyEmbeddedFontSizes, C8415a style, float defaultTextSizePx, float cueTextSizePx, float bottomPaddingFraction, Canvas canvas, int cueBoxLeft, int cueBoxTop, int cueBoxRight, int cueBoxBottom) {
        Canvas canvas2;
        C8418b bVar = cue;
        boolean z = applyEmbeddedStyles;
        boolean z2 = applyEmbeddedFontSizes;
        C8415a aVar = style;
        float f = defaultTextSizePx;
        float f2 = cueTextSizePx;
        float f3 = bottomPaddingFraction;
        Canvas canvas3 = canvas;
        int i = cueBoxLeft;
        int i2 = cueBoxTop;
        int i3 = cueBoxRight;
        int i4 = cueBoxBottom;
        boolean isTextCue = bVar.f18388c == null;
        int windowColor = CtaButton.BACKGROUND_COLOR;
        if (isTextCue) {
            if (!TextUtils.isEmpty(bVar.f18386a)) {
                windowColor = (!bVar.f18396k || !z) ? aVar.f18381d : bVar.f18397l;
            } else {
                return;
            }
        }
        if (!m20145a(this.f18574h, bVar.f18386a)) {
            canvas2 = canvas;
        } else if (!C8509F.m20455a((Object) this.f18575i, (Object) bVar.f18387b) || this.f18576j != bVar.f18388c || this.f18577k != bVar.f18389d || this.f18578l != bVar.f18390e) {
            canvas2 = canvas;
        } else if (!C8509F.m20455a((Object) Integer.valueOf(this.f18579m), (Object) Integer.valueOf(bVar.f18391f)) || this.f18580n != bVar.f18392g) {
            canvas2 = canvas;
        } else if (!C8509F.m20455a((Object) Integer.valueOf(this.f18581o), (Object) Integer.valueOf(bVar.f18393h)) || this.f18582p != bVar.f18394i || this.f18583q != bVar.f18395j || this.f18584r != z || this.f18585s != z2 || this.f18586t != aVar.f18379b || this.f18587u != aVar.f18380c || this.f18588v != windowColor || this.f18590x != aVar.f18382e || this.f18589w != aVar.f18383f) {
            canvas2 = canvas;
        } else if (C8509F.m20455a((Object) this.f18572f.getTypeface(), (Object) aVar.f18384g) && this.f18591y == f && this.f18592z == f2 && this.f18557A == f3 && this.f18558B == i && this.f18559C == i2 && this.f18560D == i3 && this.f18561E == i4) {
            m20144a(canvas, isTextCue);
            return;
        } else {
            canvas2 = canvas;
        }
        this.f18574h = bVar.f18386a;
        this.f18575i = bVar.f18387b;
        this.f18576j = bVar.f18388c;
        this.f18577k = bVar.f18389d;
        this.f18578l = bVar.f18390e;
        this.f18579m = bVar.f18391f;
        this.f18580n = bVar.f18392g;
        this.f18581o = bVar.f18393h;
        this.f18582p = bVar.f18394i;
        this.f18583q = bVar.f18395j;
        this.f18584r = z;
        this.f18585s = z2;
        this.f18586t = aVar.f18379b;
        this.f18587u = aVar.f18380c;
        this.f18588v = windowColor;
        this.f18590x = aVar.f18382e;
        this.f18589w = aVar.f18383f;
        this.f18572f.setTypeface(aVar.f18384g);
        this.f18591y = f;
        this.f18592z = f2;
        this.f18557A = f3;
        this.f18558B = i;
        this.f18559C = i2;
        this.f18560D = i3;
        this.f18561E = i4;
        if (isTextCue) {
            m20146b();
        } else {
            m20142a();
        }
        m20144a(canvas2, isTextCue);
    }

    /* JADX WARNING: type inference failed for: r7v2, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r8v1, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r24v0 */
    /* JADX WARNING: type inference failed for: r17v1, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r6v31 */
    /* JADX WARNING: type inference failed for: r6v41 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m20146b() {
        /*
            r25 = this;
            r0 = r25
            int r1 = r0.f18560D
            int r2 = r0.f18558B
            int r1 = r1 - r2
            int r2 = r0.f18561E
            int r3 = r0.f18559C
            int r2 = r2 - r3
            android.text.TextPaint r3 = r0.f18572f
            float r4 = r0.f18591y
            r3.setTextSize(r4)
            float r3 = r0.f18591y
            r4 = 1040187392(0x3e000000, float:0.125)
            float r3 = r3 * r4
            r4 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r4
            int r3 = (int) r3
            int r4 = r3 * 2
            int r4 = r1 - r4
            float r5 = r0.f18582p
            r6 = 1
            int r7 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r7 == 0) goto L_0x002c
            float r7 = (float) r4
            float r7 = r7 * r5
            int r4 = (int) r7
        L_0x002c:
            java.lang.String r5 = "SubtitlePainter"
            if (r4 > 0) goto L_0x0036
            java.lang.String r6 = "Skipped drawing subtitle cue (insufficient space)"
            com.google.android.exoplayer2.util.C8526n.m20534d(r5, r6)
            return
        L_0x0036:
            java.lang.CharSequence r7 = r0.f18574h
            boolean r8 = r0.f18584r
            r15 = 0
            r14 = 0
            if (r8 != 0) goto L_0x0043
            java.lang.String r7 = r7.toString()
            goto L_0x0097
        L_0x0043:
            boolean r8 = r0.f18585s
            if (r8 != 0) goto L_0x007a
            android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder
            r8.<init>(r7)
            int r10 = r8.length()
            java.lang.Class<android.text.style.AbsoluteSizeSpan> r11 = android.text.style.AbsoluteSizeSpan.class
            java.lang.Object[] r11 = r8.getSpans(r14, r10, r11)
            android.text.style.AbsoluteSizeSpan[] r11 = (android.text.style.AbsoluteSizeSpan[]) r11
            java.lang.Class<android.text.style.RelativeSizeSpan> r12 = android.text.style.RelativeSizeSpan.class
            java.lang.Object[] r12 = r8.getSpans(r14, r10, r12)
            android.text.style.RelativeSizeSpan[] r12 = (android.text.style.RelativeSizeSpan[]) r12
            int r13 = r11.length
            r6 = 0
        L_0x0062:
            if (r6 >= r13) goto L_0x006c
            r9 = r11[r6]
            r8.removeSpan(r9)
            int r6 = r6 + 1
            goto L_0x0062
        L_0x006c:
            int r6 = r12.length
            r9 = 0
        L_0x006e:
            if (r9 >= r6) goto L_0x0078
            r13 = r12[r9]
            r8.removeSpan(r13)
            int r9 = r9 + 1
            goto L_0x006e
        L_0x0078:
            r7 = r8
            goto L_0x0097
        L_0x007a:
            float r6 = r0.f18592z
            int r6 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r6 <= 0) goto L_0x0097
            android.text.SpannableStringBuilder r6 = new android.text.SpannableStringBuilder
            r6.<init>(r7)
            android.text.style.AbsoluteSizeSpan r8 = new android.text.style.AbsoluteSizeSpan
            float r9 = r0.f18592z
            int r9 = (int) r9
            r8.<init>(r9)
            int r9 = r6.length()
            r10 = 16711680(0xff0000, float:2.3418052E-38)
            r6.setSpan(r8, r14, r9, r10)
            r7 = r6
        L_0x0097:
            int r6 = r0.f18587u
            int r6 = android.graphics.Color.alpha(r6)
            if (r6 <= 0) goto L_0x00b6
            android.text.SpannableStringBuilder r6 = new android.text.SpannableStringBuilder
            r6.<init>(r7)
            android.text.style.BackgroundColorSpan r8 = new android.text.style.BackgroundColorSpan
            int r9 = r0.f18587u
            r8.<init>(r9)
            int r9 = r6.length()
            r10 = 16711680(0xff0000, float:2.3418052E-38)
            r6.setSpan(r8, r14, r9, r10)
            r7 = r6
            goto L_0x00b7
        L_0x00b6:
            r6 = r7
        L_0x00b7:
            android.text.Layout$Alignment r7 = r0.f18575i
            if (r7 != 0) goto L_0x00bd
            android.text.Layout$Alignment r7 = android.text.Layout.Alignment.ALIGN_CENTER
        L_0x00bd:
            r11 = r7
            android.text.StaticLayout r13 = new android.text.StaticLayout
            android.text.TextPaint r9 = r0.f18572f
            float r12 = r0.f18570d
            float r10 = r0.f18571e
            r16 = 1
            r7 = r13
            r8 = r6
            r17 = r10
            r10 = r4
            r15 = r13
            r13 = r17
            r24 = r6
            r6 = 0
            r14 = r16
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            r0.f18562F = r15
            android.text.StaticLayout r7 = r0.f18562F
            int r7 = r7.getHeight()
            r8 = 0
            android.text.StaticLayout r9 = r0.f18562F
            int r9 = r9.getLineCount()
            r10 = 0
        L_0x00e8:
            if (r10 >= r9) goto L_0x00fd
            android.text.StaticLayout r12 = r0.f18562F
            float r12 = r12.getLineWidth(r10)
            double r12 = (double) r12
            double r12 = java.lang.Math.ceil(r12)
            int r12 = (int) r12
            int r8 = java.lang.Math.max(r12, r8)
            int r10 = r10 + 1
            goto L_0x00e8
        L_0x00fd:
            float r10 = r0.f18582p
            r12 = 1
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L_0x0107
            if (r8 >= r4) goto L_0x0107
            r8 = r4
        L_0x0107:
            int r10 = r3 * 2
            int r8 = r8 + r10
            float r10 = r0.f18580n
            r12 = 1
            r13 = 2
            r14 = 1
            int r15 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r15 == 0) goto L_0x013b
            float r14 = (float) r1
            float r14 = r14 * r10
            int r10 = java.lang.Math.round(r14)
            int r14 = r0.f18558B
            int r10 = r10 + r14
            int r14 = r0.f18581o
            if (r14 != r13) goto L_0x0124
            int r14 = r10 - r8
            goto L_0x012c
        L_0x0124:
            if (r14 != r12) goto L_0x012b
            int r14 = r10 * 2
            int r14 = r14 - r8
            int r14 = r14 / r13
            goto L_0x012c
        L_0x012b:
            r14 = r10
        L_0x012c:
            int r15 = r0.f18558B
            int r14 = java.lang.Math.max(r14, r15)
            int r15 = r14 + r8
            int r12 = r0.f18560D
            int r10 = java.lang.Math.min(r15, r12)
            goto L_0x0144
        L_0x013b:
            int r10 = r1 - r8
            int r10 = r10 / r13
            int r12 = r0.f18558B
            int r14 = r10 + r12
            int r10 = r14 + r8
        L_0x0144:
            int r8 = r10 - r14
            if (r8 > 0) goto L_0x014e
            java.lang.String r6 = "Skipped drawing subtitle cue (invalid horizontal positioning)"
            com.google.android.exoplayer2.util.C8526n.m20534d(r5, r6)
            return
        L_0x014e:
            float r5 = r0.f18577k
            r12 = 1
            int r12 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r12 == 0) goto L_0x01b2
            int r12 = r0.f18578l
            if (r12 != 0) goto L_0x0164
            float r6 = (float) r2
            float r6 = r6 * r5
            int r5 = java.lang.Math.round(r6)
            int r6 = r0.f18559C
            int r5 = r5 + r6
            goto L_0x0192
        L_0x0164:
            android.text.StaticLayout r5 = r0.f18562F
            int r5 = r5.getLineBottom(r6)
            android.text.StaticLayout r12 = r0.f18562F
            int r6 = r12.getLineTop(r6)
            int r5 = r5 - r6
            float r6 = r0.f18577k
            r12 = 0
            int r12 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r12 < 0) goto L_0x0184
            float r12 = (float) r5
            float r6 = r6 * r12
            int r6 = java.lang.Math.round(r6)
            int r12 = r0.f18559C
            int r6 = r6 + r12
            r5 = r6
            goto L_0x0192
        L_0x0184:
            r12 = 1065353216(0x3f800000, float:1.0)
            float r6 = r6 + r12
            float r12 = (float) r5
            float r6 = r6 * r12
            int r6 = java.lang.Math.round(r6)
            int r12 = r0.f18561E
            int r5 = r6 + r12
        L_0x0192:
            int r6 = r0.f18579m
            if (r6 != r13) goto L_0x0199
            int r6 = r5 - r7
            goto L_0x01a2
        L_0x0199:
            r12 = 1
            if (r6 != r12) goto L_0x01a1
            int r6 = r5 * 2
            int r6 = r6 - r7
            int r6 = r6 / r13
            goto L_0x01a2
        L_0x01a1:
            r6 = r5
        L_0x01a2:
            int r12 = r6 + r7
            int r13 = r0.f18561E
            if (r12 <= r13) goto L_0x01ab
            int r6 = r13 - r7
            goto L_0x01b1
        L_0x01ab:
            int r12 = r0.f18559C
            if (r6 >= r12) goto L_0x01b1
            int r6 = r0.f18559C
        L_0x01b1:
            goto L_0x01bd
        L_0x01b2:
            int r5 = r0.f18561E
            int r5 = r5 - r7
            float r6 = (float) r2
            float r12 = r0.f18557A
            float r6 = r6 * r12
            int r6 = (int) r6
            int r6 = r5 - r6
        L_0x01bd:
            android.text.StaticLayout r5 = new android.text.StaticLayout
            android.text.TextPaint r12 = r0.f18572f
            float r13 = r0.f18570d
            float r15 = r0.f18571e
            r23 = 1
            r16 = r5
            r17 = r24
            r18 = r12
            r19 = r8
            r20 = r11
            r21 = r13
            r22 = r15
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)
            r0.f18562F = r5
            r0.f18563G = r14
            r0.f18564H = r6
            r0.f18565I = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p191ui.C8448g.m20146b():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0064  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m20142a() {
        /*
            r11 = this;
            int r0 = r11.f18560D
            int r1 = r11.f18558B
            int r0 = r0 - r1
            int r2 = r11.f18561E
            int r3 = r11.f18559C
            int r2 = r2 - r3
            float r1 = (float) r1
            float r4 = (float) r0
            float r5 = r11.f18580n
            float r4 = r4 * r5
            float r1 = r1 + r4
            float r3 = (float) r3
            float r4 = (float) r2
            float r5 = r11.f18577k
            float r4 = r4 * r5
            float r3 = r3 + r4
            float r4 = (float) r0
            float r5 = r11.f18582p
            float r4 = r4 * r5
            int r4 = java.lang.Math.round(r4)
            float r5 = r11.f18583q
            r6 = 1
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0030
            float r6 = (float) r2
            float r6 = r6 * r5
            int r5 = java.lang.Math.round(r6)
            goto L_0x0046
        L_0x0030:
            float r5 = (float) r4
            android.graphics.Bitmap r6 = r11.f18576j
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.graphics.Bitmap r7 = r11.f18576j
            int r7 = r7.getWidth()
            float r7 = (float) r7
            float r6 = r6 / r7
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
        L_0x0046:
            int r6 = r11.f18579m
            r7 = 1
            r8 = 2
            if (r6 != r8) goto L_0x0051
            float r6 = (float) r4
        L_0x004e:
            float r6 = r1 - r6
            goto L_0x0058
        L_0x0051:
            if (r6 != r7) goto L_0x0057
            int r6 = r4 / 2
            float r6 = (float) r6
            goto L_0x004e
        L_0x0057:
            r6 = r1
        L_0x0058:
            int r6 = java.lang.Math.round(r6)
            int r9 = r11.f18581o
            if (r9 != r8) goto L_0x0064
            float r7 = (float) r5
        L_0x0061:
            float r7 = r3 - r7
            goto L_0x006b
        L_0x0064:
            if (r9 != r7) goto L_0x006a
            int r7 = r5 / 2
            float r7 = (float) r7
            goto L_0x0061
        L_0x006a:
            r7 = r3
        L_0x006b:
            int r7 = java.lang.Math.round(r7)
            android.graphics.Rect r8 = new android.graphics.Rect
            int r9 = r6 + r4
            int r10 = r7 + r5
            r8.<init>(r6, r7, r9, r10)
            r11.f18566J = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p191ui.C8448g.m20142a():void");
    }

    /* renamed from: a */
    private void m20144a(Canvas canvas, boolean isTextCue) {
        if (isTextCue) {
            m20147b(canvas);
        } else {
            m20143a(canvas);
        }
    }

    /* renamed from: b */
    private void m20147b(Canvas canvas) {
        StaticLayout layout = this.f18562F;
        if (layout != null) {
            int saveCount = canvas.save();
            canvas.translate((float) this.f18563G, (float) this.f18564H);
            if (Color.alpha(this.f18588v) > 0) {
                this.f18573g.setColor(this.f18588v);
                canvas.drawRect((float) (-this.f18565I), 0.0f, (float) (layout.getWidth() + this.f18565I), (float) layout.getHeight(), this.f18573g);
            }
            int i = this.f18590x;
            boolean z = true;
            if (i == 1) {
                this.f18572f.setStrokeJoin(Join.ROUND);
                this.f18572f.setStrokeWidth(this.f18567a);
                this.f18572f.setColor(this.f18589w);
                this.f18572f.setStyle(Style.FILL_AND_STROKE);
                layout.draw(canvas);
            } else if (i == 2) {
                TextPaint textPaint = this.f18572f;
                float f = this.f18568b;
                float f2 = this.f18569c;
                textPaint.setShadowLayer(f, f2, f2, this.f18589w);
            } else if (i == 3 || i == 4) {
                if (this.f18590x != 3) {
                    z = false;
                }
                boolean raised = z;
                int colorDown = -1;
                int colorUp = raised ? -1 : this.f18589w;
                if (raised) {
                    colorDown = this.f18589w;
                }
                float offset = this.f18568b / 2.0f;
                this.f18572f.setColor(this.f18586t);
                this.f18572f.setStyle(Style.FILL);
                this.f18572f.setShadowLayer(this.f18568b, -offset, -offset, colorUp);
                layout.draw(canvas);
                this.f18572f.setShadowLayer(this.f18568b, offset, offset, colorDown);
            }
            this.f18572f.setColor(this.f18586t);
            this.f18572f.setStyle(Style.FILL);
            layout.draw(canvas);
            this.f18572f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(saveCount);
        }
    }

    /* renamed from: a */
    private void m20143a(Canvas canvas) {
        canvas.drawBitmap(this.f18576j, null, this.f18566J, null);
    }

    /* renamed from: a */
    private static boolean m20145a(CharSequence first, CharSequence second) {
        return first == second || (first != null && first.equals(second));
    }
}
