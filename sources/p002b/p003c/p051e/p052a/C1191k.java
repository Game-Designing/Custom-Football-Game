package p002b.p003c.p051e.p052a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.graphics.drawable.VectorDrawableCompat.VGroup;
import android.support.p000v4.content.p036a.C0509e;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p002b.p003c.p053g.p054a.C1210b;
import p002b.p003c.p053g.p054a.C1210b.C1212b;
import p002b.p003c.p053g.p054a.p055a.C1200a;
import p002b.p003c.p053g.p061f.C1253b;

/* renamed from: b.c.e.a.k */
/* compiled from: VectorDrawableCompat */
public class C1191k extends C1190j {

    /* renamed from: b */
    static final Mode f3855b = Mode.SRC_IN;

    /* renamed from: c */
    private C1197f f3856c;

    /* renamed from: d */
    private PorterDuffColorFilter f3857d;

    /* renamed from: e */
    private ColorFilter f3858e;

    /* renamed from: f */
    private boolean f3859f;

    /* renamed from: g */
    private boolean f3860g;

    /* renamed from: h */
    private ConstantState f3861h;

    /* renamed from: i */
    private final float[] f3862i;

    /* renamed from: j */
    private final Matrix f3863j;

    /* renamed from: k */
    private final Rect f3864k;

    /* renamed from: b.c.e.a.k$a */
    /* compiled from: VectorDrawableCompat */
    private static class C1192a extends C1195d {
        public C1192a() {
        }

        public C1192a(C1192a copy) {
            super(copy);
        }

        /* renamed from: a */
        public void mo8873a(Resources r, AttributeSet attrs, Theme theme, XmlPullParser parser) {
            if (C0509e.m2556a(parser, "pathData")) {
                TypedArray a = C0509e.m2551a(r, theme, attrs, C1178a.f3828d);
                m5687a(a);
                a.recycle();
            }
        }

        /* renamed from: a */
        private void m5687a(TypedArray a) {
            String pathName = a.getString(0);
            if (pathName != null) {
                this.f3892b = pathName;
            }
            String pathData = a.getString(1);
            if (pathData != null) {
                this.f3891a = C1210b.m5760a(pathData);
            }
        }

        /* renamed from: a */
        public boolean mo8874a() {
            return true;
        }
    }

    /* renamed from: b.c.e.a.k$b */
    /* compiled from: VectorDrawableCompat */
    private static class C1193b extends C1195d {

        /* renamed from: d */
        private int[] f3865d;

        /* renamed from: e */
        int f3866e = 0;

        /* renamed from: f */
        float f3867f = 0.0f;

        /* renamed from: g */
        int f3868g = 0;

        /* renamed from: h */
        float f3869h = 1.0f;

        /* renamed from: i */
        int f3870i = 0;

        /* renamed from: j */
        float f3871j = 1.0f;

        /* renamed from: k */
        float f3872k = 0.0f;

        /* renamed from: l */
        float f3873l = 1.0f;

        /* renamed from: m */
        float f3874m = 0.0f;

        /* renamed from: n */
        Cap f3875n = Cap.BUTT;

        /* renamed from: o */
        Join f3876o = Join.MITER;

        /* renamed from: p */
        float f3877p = 4.0f;

        public C1193b() {
        }

        public C1193b(C1193b copy) {
            super(copy);
            this.f3865d = copy.f3865d;
            this.f3866e = copy.f3866e;
            this.f3867f = copy.f3867f;
            this.f3869h = copy.f3869h;
            this.f3868g = copy.f3868g;
            this.f3870i = copy.f3870i;
            this.f3871j = copy.f3871j;
            this.f3872k = copy.f3872k;
            this.f3873l = copy.f3873l;
            this.f3874m = copy.f3874m;
            this.f3875n = copy.f3875n;
            this.f3876o = copy.f3876o;
            this.f3877p = copy.f3877p;
        }

        /* renamed from: a */
        private Cap m5690a(int id, Cap defValue) {
            if (id == 0) {
                return Cap.BUTT;
            }
            if (id == 1) {
                return Cap.ROUND;
            }
            if (id != 2) {
                return defValue;
            }
            return Cap.SQUARE;
        }

        /* renamed from: a */
        private Join m5691a(int id, Join defValue) {
            if (id == 0) {
                return Join.MITER;
            }
            if (id == 1) {
                return Join.ROUND;
            }
            if (id != 2) {
                return defValue;
            }
            return Join.BEVEL;
        }

        /* renamed from: a */
        public void mo8875a(Resources r, AttributeSet attrs, Theme theme, XmlPullParser parser) {
            TypedArray a = C0509e.m2551a(r, theme, attrs, C1178a.f3827c);
            m5692a(a, parser);
            a.recycle();
        }

        /* renamed from: a */
        private void m5692a(TypedArray a, XmlPullParser parser) {
            this.f3865d = null;
            if (C0509e.m2556a(parser, "pathData")) {
                String pathName = a.getString(0);
                if (pathName != null) {
                    this.f3892b = pathName;
                }
                String pathData = a.getString(2);
                if (pathData != null) {
                    this.f3891a = C1210b.m5760a(pathData);
                }
                this.f3868g = C0509e.m2550a(a, parser, "fillColor", 1, this.f3868g);
                this.f3871j = C0509e.m2547a(a, parser, "fillAlpha", 12, this.f3871j);
                this.f3875n = m5690a(C0509e.m2558b(a, parser, "strokeLineCap", 8, -1), this.f3875n);
                this.f3876o = m5691a(C0509e.m2558b(a, parser, "strokeLineJoin", 9, -1), this.f3876o);
                this.f3877p = C0509e.m2547a(a, parser, "strokeMiterLimit", 10, this.f3877p);
                this.f3866e = C0509e.m2550a(a, parser, "strokeColor", 3, this.f3866e);
                this.f3869h = C0509e.m2547a(a, parser, "strokeAlpha", 11, this.f3869h);
                this.f3867f = C0509e.m2547a(a, parser, "strokeWidth", 4, this.f3867f);
                this.f3873l = C0509e.m2547a(a, parser, "trimPathEnd", 6, this.f3873l);
                this.f3874m = C0509e.m2547a(a, parser, "trimPathOffset", 7, this.f3874m);
                this.f3872k = C0509e.m2547a(a, parser, "trimPathStart", 5, this.f3872k);
                this.f3870i = C0509e.m2558b(a, parser, "fillType", 13, this.f3870i);
            }
        }

        /* access modifiers changed from: 0000 */
        public int getStrokeColor() {
            return this.f3866e;
        }

        /* access modifiers changed from: 0000 */
        public void setStrokeColor(int strokeColor) {
            this.f3866e = strokeColor;
        }

        /* access modifiers changed from: 0000 */
        public float getStrokeWidth() {
            return this.f3867f;
        }

        /* access modifiers changed from: 0000 */
        public void setStrokeWidth(float strokeWidth) {
            this.f3867f = strokeWidth;
        }

        /* access modifiers changed from: 0000 */
        public float getStrokeAlpha() {
            return this.f3869h;
        }

        /* access modifiers changed from: 0000 */
        public void setStrokeAlpha(float strokeAlpha) {
            this.f3869h = strokeAlpha;
        }

        /* access modifiers changed from: 0000 */
        public int getFillColor() {
            return this.f3868g;
        }

        /* access modifiers changed from: 0000 */
        public void setFillColor(int fillColor) {
            this.f3868g = fillColor;
        }

        /* access modifiers changed from: 0000 */
        public float getFillAlpha() {
            return this.f3871j;
        }

        /* access modifiers changed from: 0000 */
        public void setFillAlpha(float fillAlpha) {
            this.f3871j = fillAlpha;
        }

        /* access modifiers changed from: 0000 */
        public float getTrimPathStart() {
            return this.f3872k;
        }

        /* access modifiers changed from: 0000 */
        public void setTrimPathStart(float trimPathStart) {
            this.f3872k = trimPathStart;
        }

        /* access modifiers changed from: 0000 */
        public float getTrimPathEnd() {
            return this.f3873l;
        }

        /* access modifiers changed from: 0000 */
        public void setTrimPathEnd(float trimPathEnd) {
            this.f3873l = trimPathEnd;
        }

        /* access modifiers changed from: 0000 */
        public float getTrimPathOffset() {
            return this.f3874m;
        }

        /* access modifiers changed from: 0000 */
        public void setTrimPathOffset(float trimPathOffset) {
            this.f3874m = trimPathOffset;
        }
    }

    /* renamed from: b.c.e.a.k$c */
    /* compiled from: VectorDrawableCompat */
    private static class C1194c {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Matrix f3878a = new Matrix();

        /* renamed from: b */
        final ArrayList<Object> f3879b = new ArrayList<>();

        /* renamed from: c */
        float f3880c = 0.0f;

        /* renamed from: d */
        private float f3881d = 0.0f;

        /* renamed from: e */
        private float f3882e = 0.0f;

        /* renamed from: f */
        private float f3883f = 1.0f;

        /* renamed from: g */
        private float f3884g = 1.0f;

        /* renamed from: h */
        private float f3885h = 0.0f;

        /* renamed from: i */
        private float f3886i = 0.0f;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public final Matrix f3887j = new Matrix();

        /* renamed from: k */
        int f3888k;

        /* renamed from: l */
        private int[] f3889l;

        /* renamed from: m */
        private String f3890m = null;

        public C1194c(C1194c copy, C1253b<String, Object> targetsMap) {
            C1195d newPath;
            this.f3880c = copy.f3880c;
            this.f3881d = copy.f3881d;
            this.f3882e = copy.f3882e;
            this.f3883f = copy.f3883f;
            this.f3884g = copy.f3884g;
            this.f3885h = copy.f3885h;
            this.f3886i = copy.f3886i;
            this.f3889l = copy.f3889l;
            this.f3890m = copy.f3890m;
            this.f3888k = copy.f3888k;
            String str = this.f3890m;
            if (str != null) {
                targetsMap.put(str, this);
            }
            this.f3887j.set(copy.f3887j);
            ArrayList<Object> children = copy.f3879b;
            for (int i = 0; i < children.size(); i++) {
                Object copyChild = children.get(i);
                if (copyChild instanceof C1194c) {
                    this.f3879b.add(new C1194c((C1194c) copyChild, targetsMap));
                } else {
                    if (copyChild instanceof C1193b) {
                        newPath = new C1193b((C1193b) copyChild);
                    } else if (copyChild instanceof C1192a) {
                        newPath = new C1192a((C1192a) copyChild);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f3879b.add(newPath);
                    String str2 = newPath.f3892b;
                    if (str2 != null) {
                        targetsMap.put(str2, newPath);
                    }
                }
            }
        }

        public C1194c() {
        }

        public String getGroupName() {
            return this.f3890m;
        }

        public Matrix getLocalMatrix() {
            return this.f3887j;
        }

        /* renamed from: a */
        public void mo8892a(Resources res, AttributeSet attrs, Theme theme, XmlPullParser parser) {
            TypedArray a = C0509e.m2551a(res, theme, attrs, C1178a.f3826b);
            m5696a(a, parser);
            a.recycle();
        }

        /* renamed from: a */
        private void m5696a(TypedArray a, XmlPullParser parser) {
            this.f3889l = null;
            this.f3880c = C0509e.m2547a(a, parser, "rotation", 5, this.f3880c);
            this.f3881d = a.getFloat(1, this.f3881d);
            this.f3882e = a.getFloat(2, this.f3882e);
            this.f3883f = C0509e.m2547a(a, parser, "scaleX", 3, this.f3883f);
            this.f3884g = C0509e.m2547a(a, parser, "scaleY", 4, this.f3884g);
            this.f3885h = C0509e.m2547a(a, parser, "translateX", 6, this.f3885h);
            this.f3886i = C0509e.m2547a(a, parser, "translateY", 7, this.f3886i);
            String groupName = a.getString(0);
            if (groupName != null) {
                this.f3890m = groupName;
            }
            m5695a();
        }

        /* renamed from: a */
        private void m5695a() {
            this.f3887j.reset();
            this.f3887j.postTranslate(-this.f3881d, -this.f3882e);
            this.f3887j.postScale(this.f3883f, this.f3884g);
            this.f3887j.postRotate(this.f3880c, 0.0f, 0.0f);
            this.f3887j.postTranslate(this.f3885h + this.f3881d, this.f3886i + this.f3882e);
        }

        public float getRotation() {
            return this.f3880c;
        }

        public void setRotation(float rotation) {
            if (rotation != this.f3880c) {
                this.f3880c = rotation;
                m5695a();
            }
        }

        public float getPivotX() {
            return this.f3881d;
        }

        public void setPivotX(float pivotX) {
            if (pivotX != this.f3881d) {
                this.f3881d = pivotX;
                m5695a();
            }
        }

        public float getPivotY() {
            return this.f3882e;
        }

        public void setPivotY(float pivotY) {
            if (pivotY != this.f3882e) {
                this.f3882e = pivotY;
                m5695a();
            }
        }

        public float getScaleX() {
            return this.f3883f;
        }

        public void setScaleX(float scaleX) {
            if (scaleX != this.f3883f) {
                this.f3883f = scaleX;
                m5695a();
            }
        }

        public float getScaleY() {
            return this.f3884g;
        }

        public void setScaleY(float scaleY) {
            if (scaleY != this.f3884g) {
                this.f3884g = scaleY;
                m5695a();
            }
        }

        public float getTranslateX() {
            return this.f3885h;
        }

        public void setTranslateX(float translateX) {
            if (translateX != this.f3885h) {
                this.f3885h = translateX;
                m5695a();
            }
        }

        public float getTranslateY() {
            return this.f3886i;
        }

        public void setTranslateY(float translateY) {
            if (translateY != this.f3886i) {
                this.f3886i = translateY;
                m5695a();
            }
        }
    }

    /* renamed from: b.c.e.a.k$d */
    /* compiled from: VectorDrawableCompat */
    private static class C1195d {

        /* renamed from: a */
        protected C1212b[] f3891a = null;

        /* renamed from: b */
        String f3892b;

        /* renamed from: c */
        int f3893c;

        public C1195d() {
        }

        public C1195d(C1195d copy) {
            this.f3892b = copy.f3892b;
            this.f3893c = copy.f3893c;
            this.f3891a = C1210b.m5761a(copy.f3891a);
        }

        /* renamed from: a */
        public void mo8909a(Path path) {
            path.reset();
            C1212b[] bVarArr = this.f3891a;
            if (bVarArr != null) {
                C1212b.m5768a(bVarArr, path);
            }
        }

        public String getPathName() {
            return this.f3892b;
        }

        /* renamed from: a */
        public boolean mo8874a() {
            return false;
        }

        public C1212b[] getPathData() {
            return this.f3891a;
        }

        public void setPathData(C1212b[] nodes) {
            if (!C1210b.m5758a(this.f3891a, nodes)) {
                this.f3891a = C1210b.m5761a(nodes);
            } else {
                C1210b.m5763b(this.f3891a, nodes);
            }
        }
    }

    /* renamed from: b.c.e.a.k$e */
    /* compiled from: VectorDrawableCompat */
    private static class C1196e {

        /* renamed from: a */
        private static final Matrix f3894a = new Matrix();

        /* renamed from: b */
        private final Path f3895b;

        /* renamed from: c */
        private final Path f3896c;

        /* renamed from: d */
        private final Matrix f3897d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public Paint f3898e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public Paint f3899f;

        /* renamed from: g */
        private PathMeasure f3900g;

        /* renamed from: h */
        private int f3901h;

        /* renamed from: i */
        final C1194c f3902i;

        /* renamed from: j */
        float f3903j;

        /* renamed from: k */
        float f3904k;

        /* renamed from: l */
        float f3905l;

        /* renamed from: m */
        float f3906m;

        /* renamed from: n */
        int f3907n;

        /* renamed from: o */
        String f3908o;

        /* renamed from: p */
        final C1253b<String, Object> f3909p;

        public C1196e() {
            this.f3897d = new Matrix();
            this.f3903j = 0.0f;
            this.f3904k = 0.0f;
            this.f3905l = 0.0f;
            this.f3906m = 0.0f;
            this.f3907n = 255;
            this.f3908o = null;
            this.f3909p = new C1253b<>();
            this.f3902i = new C1194c();
            this.f3895b = new Path();
            this.f3896c = new Path();
        }

        public void setRootAlpha(int alpha) {
            this.f3907n = alpha;
        }

        public int getRootAlpha() {
            return this.f3907n;
        }

        public void setAlpha(float alpha) {
            setRootAlpha((int) (255.0f * alpha));
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public C1196e(C1196e copy) {
            this.f3897d = new Matrix();
            this.f3903j = 0.0f;
            this.f3904k = 0.0f;
            this.f3905l = 0.0f;
            this.f3906m = 0.0f;
            this.f3907n = 255;
            this.f3908o = null;
            this.f3909p = new C1253b<>();
            this.f3902i = new C1194c(copy.f3902i, this.f3909p);
            this.f3895b = new Path(copy.f3895b);
            this.f3896c = new Path(copy.f3896c);
            this.f3903j = copy.f3903j;
            this.f3904k = copy.f3904k;
            this.f3905l = copy.f3905l;
            this.f3906m = copy.f3906m;
            this.f3901h = copy.f3901h;
            this.f3907n = copy.f3907n;
            this.f3908o = copy.f3908o;
            String str = copy.f3908o;
            if (str != null) {
                this.f3909p.put(str, this);
            }
        }

        /* renamed from: a */
        private void m5705a(C1194c currentGroup, Matrix currentMatrix, Canvas canvas, int w, int h, ColorFilter filter) {
            C1194c cVar = currentGroup;
            currentGroup.f3878a.set(currentMatrix);
            currentGroup.f3878a.preConcat(currentGroup.f3887j);
            canvas.save();
            for (int i = 0; i < cVar.f3879b.size(); i++) {
                Object child = cVar.f3879b.get(i);
                if (child instanceof C1194c) {
                    m5705a((C1194c) child, currentGroup.f3878a, canvas, w, h, filter);
                } else if (child instanceof C1195d) {
                    m5706a(currentGroup, (C1195d) child, canvas, w, h, filter);
                }
            }
            canvas.restore();
        }

        /* renamed from: a */
        public void mo8913a(Canvas canvas, int w, int h, ColorFilter filter) {
            m5705a(this.f3902i, f3894a, canvas, w, h, filter);
        }

        /* renamed from: a */
        private void m5706a(C1194c vGroup, C1195d vPath, Canvas canvas, int w, int h, ColorFilter filter) {
            float len;
            C1195d dVar = vPath;
            Canvas canvas2 = canvas;
            ColorFilter colorFilter = filter;
            float scaleX = ((float) w) / this.f3905l;
            float scaleY = ((float) h) / this.f3906m;
            float minScale = Math.min(scaleX, scaleY);
            Matrix groupStackedMatrix = vGroup.f3878a;
            this.f3897d.set(groupStackedMatrix);
            this.f3897d.postScale(scaleX, scaleY);
            float matrixScale = m5702a(groupStackedMatrix);
            if (matrixScale != 0.0f) {
                dVar.mo8909a(this.f3895b);
                Path path = this.f3895b;
                this.f3896c.reset();
                if (vPath.mo8874a()) {
                    this.f3896c.addPath(path, this.f3897d);
                    canvas2.clipPath(this.f3896c);
                } else {
                    C1193b fullPath = (C1193b) dVar;
                    if (!(fullPath.f3872k == 0.0f && fullPath.f3873l == 1.0f)) {
                        float f = fullPath.f3872k;
                        float f2 = fullPath.f3874m;
                        float start = (f + f2) % 1.0f;
                        float end = (fullPath.f3873l + f2) % 1.0f;
                        if (this.f3900g == null) {
                            this.f3900g = new PathMeasure();
                        }
                        this.f3900g.setPath(this.f3895b, false);
                        float len2 = this.f3900g.getLength();
                        float start2 = start * len2;
                        float end2 = end * len2;
                        path.reset();
                        if (start2 > end2) {
                            this.f3900g.getSegment(start2, len2, path, true);
                            float f3 = len2;
                            len = 0.0f;
                            this.f3900g.getSegment(0.0f, end2, path, true);
                        } else {
                            len = 0.0f;
                            this.f3900g.getSegment(start2, end2, path, true);
                        }
                        path.rLineTo(len, len);
                    }
                    this.f3896c.addPath(path, this.f3897d);
                    if (fullPath.f3868g != 0) {
                        if (this.f3899f == null) {
                            this.f3899f = new Paint();
                            this.f3899f.setStyle(Style.FILL);
                            this.f3899f.setAntiAlias(true);
                        }
                        Paint fillPaint = this.f3899f;
                        fillPaint.setColor(C1191k.m5678a(fullPath.f3868g, fullPath.f3871j));
                        fillPaint.setColorFilter(colorFilter);
                        this.f3896c.setFillType(fullPath.f3870i == 0 ? FillType.WINDING : FillType.EVEN_ODD);
                        canvas2.drawPath(this.f3896c, fillPaint);
                    }
                    if (fullPath.f3866e != 0) {
                        if (this.f3898e == null) {
                            this.f3898e = new Paint();
                            this.f3898e.setStyle(Style.STROKE);
                            this.f3898e.setAntiAlias(true);
                        }
                        Paint strokePaint = this.f3898e;
                        Join join = fullPath.f3876o;
                        if (join != null) {
                            strokePaint.setStrokeJoin(join);
                        }
                        Cap cap = fullPath.f3875n;
                        if (cap != null) {
                            strokePaint.setStrokeCap(cap);
                        }
                        strokePaint.setStrokeMiter(fullPath.f3877p);
                        strokePaint.setColor(C1191k.m5678a(fullPath.f3866e, fullPath.f3869h));
                        strokePaint.setColorFilter(colorFilter);
                        strokePaint.setStrokeWidth(fullPath.f3867f * minScale * matrixScale);
                        canvas2.drawPath(this.f3896c, strokePaint);
                    }
                }
            }
        }

        /* renamed from: a */
        private static float m5701a(float v1x, float v1y, float v2x, float v2y) {
            return (v1x * v2y) - (v1y * v2x);
        }

        /* renamed from: a */
        private float m5702a(Matrix groupStackedMatrix) {
            float[] unitVectors = {0.0f, 1.0f, 1.0f, 0.0f};
            groupStackedMatrix.mapVectors(unitVectors);
            float scaleX = (float) Math.hypot((double) unitVectors[0], (double) unitVectors[1]);
            float scaleY = (float) Math.hypot((double) unitVectors[2], (double) unitVectors[3]);
            float crossProduct = m5701a(unitVectors[0], unitVectors[1], unitVectors[2], unitVectors[3]);
            float maxScale = Math.max(scaleX, scaleY);
            if (maxScale > 0.0f) {
                return Math.abs(crossProduct) / maxScale;
            }
            return 0.0f;
        }
    }

    /* renamed from: b.c.e.a.k$f */
    /* compiled from: VectorDrawableCompat */
    private static class C1197f extends ConstantState {

        /* renamed from: a */
        int f3910a;

        /* renamed from: b */
        C1196e f3911b;

        /* renamed from: c */
        ColorStateList f3912c;

        /* renamed from: d */
        Mode f3913d;

        /* renamed from: e */
        boolean f3914e;

        /* renamed from: f */
        Bitmap f3915f;

        /* renamed from: g */
        ColorStateList f3916g;

        /* renamed from: h */
        Mode f3917h;

        /* renamed from: i */
        int f3918i;

        /* renamed from: j */
        boolean f3919j;

        /* renamed from: k */
        boolean f3920k;

        /* renamed from: l */
        Paint f3921l;

        public C1197f(C1197f copy) {
            this.f3912c = null;
            this.f3913d = C1191k.f3855b;
            if (copy != null) {
                this.f3910a = copy.f3910a;
                this.f3911b = new C1196e(copy.f3911b);
                if (copy.f3911b.f3899f != null) {
                    this.f3911b.f3899f = new Paint(copy.f3911b.f3899f);
                }
                if (copy.f3911b.f3898e != null) {
                    this.f3911b.f3898e = new Paint(copy.f3911b.f3898e);
                }
                this.f3912c = copy.f3912c;
                this.f3913d = copy.f3913d;
                this.f3914e = copy.f3914e;
            }
        }

        /* renamed from: a */
        public void mo8919a(Canvas canvas, ColorFilter filter, Rect originalBounds) {
            canvas.drawBitmap(this.f3915f, null, originalBounds, mo8918a(filter));
        }

        /* renamed from: b */
        public boolean mo8923b() {
            return this.f3911b.getRootAlpha() < 255;
        }

        /* renamed from: a */
        public Paint mo8918a(ColorFilter filter) {
            if (!mo8923b() && filter == null) {
                return null;
            }
            if (this.f3921l == null) {
                this.f3921l = new Paint();
                this.f3921l.setFilterBitmap(true);
            }
            this.f3921l.setAlpha(this.f3911b.getRootAlpha());
            this.f3921l.setColorFilter(filter);
            return this.f3921l;
        }

        /* renamed from: c */
        public void mo8925c(int width, int height) {
            this.f3915f.eraseColor(0);
            this.f3911b.mo8913a(new Canvas(this.f3915f), width, height, (ColorFilter) null);
        }

        /* renamed from: b */
        public void mo8922b(int width, int height) {
            if (this.f3915f == null || !mo8921a(width, height)) {
                this.f3915f = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                this.f3920k = true;
            }
        }

        /* renamed from: a */
        public boolean mo8921a(int width, int height) {
            if (width == this.f3915f.getWidth() && height == this.f3915f.getHeight()) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo8920a() {
            if (!this.f3920k && this.f3916g == this.f3912c && this.f3917h == this.f3913d && this.f3919j == this.f3914e && this.f3918i == this.f3911b.getRootAlpha()) {
                return true;
            }
            return false;
        }

        /* renamed from: c */
        public void mo8924c() {
            this.f3916g = this.f3912c;
            this.f3917h = this.f3913d;
            this.f3918i = this.f3911b.getRootAlpha();
            this.f3919j = this.f3914e;
            this.f3920k = false;
        }

        public C1197f() {
            this.f3912c = null;
            this.f3913d = C1191k.f3855b;
            this.f3911b = new C1196e();
        }

        public Drawable newDrawable() {
            return new C1191k(this);
        }

        public Drawable newDrawable(Resources res) {
            return new C1191k(this);
        }

        public int getChangingConfigurations() {
            return this.f3910a;
        }
    }

    /* renamed from: b.c.e.a.k$g */
    /* compiled from: VectorDrawableCompat */
    private static class C1198g extends ConstantState {

        /* renamed from: a */
        private final ConstantState f3922a;

        public C1198g(ConstantState state) {
            this.f3922a = state;
        }

        public Drawable newDrawable() {
            C1191k drawableCompat = new C1191k();
            drawableCompat.f3854a = (VectorDrawable) this.f3922a.newDrawable();
            return drawableCompat;
        }

        public Drawable newDrawable(Resources res) {
            C1191k drawableCompat = new C1191k();
            drawableCompat.f3854a = (VectorDrawable) this.f3922a.newDrawable(res);
            return drawableCompat;
        }

        public Drawable newDrawable(Resources res, Theme theme) {
            C1191k drawableCompat = new C1191k();
            drawableCompat.f3854a = (VectorDrawable) this.f3922a.newDrawable(res, theme);
            return drawableCompat;
        }

        public boolean canApplyTheme() {
            return this.f3922a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f3922a.getChangingConfigurations();
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    C1191k() {
        this.f3860g = true;
        this.f3862i = new float[9];
        this.f3863j = new Matrix();
        this.f3864k = new Rect();
        this.f3856c = new C1197f();
    }

    C1191k(C1197f state) {
        this.f3860g = true;
        this.f3862i = new float[9];
        this.f3863j = new Matrix();
        this.f3864k = new Rect();
        this.f3856c = state;
        this.f3857d = mo8848a(this.f3857d, state.f3912c, state.f3913d);
    }

    public Drawable mutate() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f3859f && super.mutate() == this) {
            this.f3856c = new C1197f(this.f3856c);
            this.f3859f = true;
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Object mo8849a(String name) {
        return this.f3856c.f3911b.f3909p.get(name);
    }

    public ConstantState getConstantState() {
        Drawable drawable = this.f3854a;
        if (drawable != null && VERSION.SDK_INT >= 24) {
            return new C1198g(drawable.getConstantState());
        }
        this.f3856c.f3910a = getChangingConfigurations();
        return this.f3856c;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f3864k);
        if (this.f3864k.width() > 0 && this.f3864k.height() > 0) {
            ColorFilter colorFilter = this.f3858e;
            if (colorFilter == null) {
                colorFilter = this.f3857d;
            }
            canvas.getMatrix(this.f3863j);
            this.f3863j.getValues(this.f3862i);
            float canvasScaleX = Math.abs(this.f3862i[0]);
            float canvasScaleY = Math.abs(this.f3862i[4]);
            float canvasSkewX = Math.abs(this.f3862i[1]);
            float canvasSkewY = Math.abs(this.f3862i[3]);
            if (!(canvasSkewX == 0.0f && canvasSkewY == 0.0f)) {
                canvasScaleX = 1.0f;
                canvasScaleY = 1.0f;
            }
            int scaledHeight = (int) (((float) this.f3864k.height()) * canvasScaleY);
            int scaledWidth = Math.min(Opcodes.ACC_STRICT, (int) (((float) this.f3864k.width()) * canvasScaleX));
            int scaledHeight2 = Math.min(Opcodes.ACC_STRICT, scaledHeight);
            if (scaledWidth > 0 && scaledHeight2 > 0) {
                int saveCount = canvas.save();
                Rect rect = this.f3864k;
                canvas.translate((float) rect.left, (float) rect.top);
                if (m5683a()) {
                    canvas.translate((float) this.f3864k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f3864k.offsetTo(0, 0);
                this.f3856c.mo8922b(scaledWidth, scaledHeight2);
                if (!this.f3860g) {
                    this.f3856c.mo8925c(scaledWidth, scaledHeight2);
                } else if (!this.f3856c.mo8920a()) {
                    this.f3856c.mo8925c(scaledWidth, scaledHeight2);
                    this.f3856c.mo8924c();
                }
                this.f3856c.mo8919a(canvas, colorFilter, this.f3864k);
                canvas.restoreToCount(saveCount);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return C1200a.m5735c(drawable);
        }
        return this.f3856c.f3911b.getRootAlpha();
    }

    public void setAlpha(int alpha) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            drawable.setAlpha(alpha);
            return;
        }
        if (this.f3856c.f3911b.getRootAlpha() != alpha) {
            this.f3856c.f3911b.setRootAlpha(alpha);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f3858e = colorFilter;
        invalidateSelf();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public PorterDuffColorFilter mo8848a(PorterDuffColorFilter tintFilter, ColorStateList tint, Mode tintMode) {
        if (tint == null || tintMode == null) {
            return null;
        }
        return new PorterDuffColorFilter(tint.getColorForState(getState(), 0), tintMode);
    }

    public void setTint(int tint) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            C1200a.m5734b(drawable, tint);
        } else {
            setTintList(ColorStateList.valueOf(tint));
        }
    }

    public void setTintList(ColorStateList tint) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            C1200a.m5726a(drawable, tint);
            return;
        }
        C1197f state = this.f3856c;
        if (state.f3912c != tint) {
            state.f3912c = tint;
            this.f3857d = mo8848a(this.f3857d, tint, state.f3913d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode tintMode) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            C1200a.m5729a(drawable, tintMode);
            return;
        }
        C1197f state = this.f3856c;
        if (state.f3913d != tintMode) {
            state.f3913d = tintMode;
            this.f3857d = mo8848a(this.f3857d, state.f3912c, tintMode);
            invalidateSelf();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r0.isStateful() != false) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r0 = r1.f3854a
            if (r0 == 0) goto L_0x0009
            boolean r0 = r0.isStateful()
            return r0
        L_0x0009:
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0020
            b.c.e.a.k$f r0 = r1.f3856c
            if (r0 == 0) goto L_0x001e
            android.content.res.ColorStateList r0 = r0.f3912c
            if (r0 == 0) goto L_0x001e
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            r0 = 0
            goto L_0x0021
        L_0x0020:
            r0 = 1
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p002b.p003c.p051e.p052a.C1191k.isStateful():boolean");
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] stateSet) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return drawable.setState(stateSet);
        }
        C1197f state = this.f3856c;
        ColorStateList colorStateList = state.f3912c;
        if (colorStateList != null) {
            Mode mode = state.f3913d;
            if (mode != null) {
                this.f3857d = mo8848a(this.f3857d, colorStateList, mode);
                invalidateSelf();
                return true;
            }
        }
        return false;
    }

    public int getOpacity() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f3856c.f3911b.f3903j;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f3856c.f3911b.f3904k;
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            C1200a.m5731a(drawable);
        }
        return false;
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return C1200a.m5738f(drawable);
        }
        return this.f3856c.f3914e;
    }

    public void setAutoMirrored(boolean mirrored) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            C1200a.m5730a(drawable, mirrored);
        } else {
            this.f3856c.f3914e = mirrored;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039 A[Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x0046 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e A[Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x0046 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p002b.p003c.p051e.p052a.C1191k m5680a(android.content.res.Resources r7, int r8, android.content.res.Resources.Theme r9) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0023
            b.c.e.a.k r0 = new b.c.e.a.k
            r0.<init>()
            android.graphics.drawable.Drawable r1 = android.support.p000v4.content.p036a.C0507d.m2542a(r7, r8, r9)
            r0.f3854a = r1
            b.c.e.a.k$g r1 = new b.c.e.a.k$g
            android.graphics.drawable.Drawable r2 = r0.f3854a
            android.graphics.drawable.Drawable$ConstantState r2 = r2.getConstantState()
            r1.<init>(r2)
            r0.f3861h = r1
            return r0
        L_0x0023:
            android.content.res.XmlResourceParser r2 = r7.getXml(r8)     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x0046 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r2)     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x0046 }
        L_0x002b:
            int r4 = r2.next()     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x0046 }
            r5 = r4
            r6 = 2
            if (r4 == r6) goto L_0x0037
            r4 = 1
            if (r5 == r4) goto L_0x0037
            goto L_0x002b
        L_0x0037:
            if (r5 != r6) goto L_0x003e
            b.c.e.a.k r0 = createFromXmlInner(r7, r2, r3, r9)     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x0046 }
            return r0
        L_0x003e:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x0046 }
            java.lang.String r6 = "No start tag found"
            r4.<init>(r6)     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x0046 }
            throw r4     // Catch:{ XmlPullParserException -> 0x004b, IOException -> 0x0046 }
        L_0x0046:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
            goto L_0x0050
        L_0x004b:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L_0x0050:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p002b.p003c.p051e.p052a.C1191k.m5680a(android.content.res.Resources, int, android.content.res.Resources$Theme):b.c.e.a.k");
    }

    public static C1191k createFromXmlInner(Resources r, XmlPullParser parser, AttributeSet attrs, Theme theme) throws XmlPullParserException, IOException {
        C1191k drawable = new C1191k();
        drawable.inflate(r, parser, attrs, theme);
        return drawable;
    }

    /* renamed from: a */
    static int m5678a(int color, float alpha) {
        return (color & 16777215) | (((int) (((float) Color.alpha(color)) * alpha)) << 24);
    }

    public void inflate(Resources res, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            drawable.inflate(res, parser, attrs);
        } else {
            inflate(res, parser, attrs, null);
        }
    }

    public void inflate(Resources res, XmlPullParser parser, AttributeSet attrs, Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            C1200a.m5728a(drawable, res, parser, attrs, theme);
            return;
        }
        C1197f state = this.f3856c;
        state.f3911b = new C1196e();
        TypedArray a = C0509e.m2551a(res, theme, attrs, C1178a.f3825a);
        m5682a(a, parser);
        a.recycle();
        state.f3910a = getChangingConfigurations();
        state.f3920k = true;
        m5681a(res, parser, attrs, theme);
        this.f3857d = mo8848a(this.f3857d, state.f3912c, state.f3913d);
    }

    /* renamed from: a */
    private static Mode m5679a(int value, Mode defaultMode) {
        if (value == 3) {
            return Mode.SRC_OVER;
        }
        if (value == 5) {
            return Mode.SRC_IN;
        }
        if (value == 9) {
            return Mode.SRC_ATOP;
        }
        switch (value) {
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return defaultMode;
        }
    }

    /* renamed from: a */
    private void m5682a(TypedArray a, XmlPullParser parser) throws XmlPullParserException {
        C1197f state = this.f3856c;
        C1196e pathRenderer = state.f3911b;
        state.f3913d = m5679a(C0509e.m2558b(a, parser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList tint = a.getColorStateList(1);
        if (tint != null) {
            state.f3912c = tint;
        }
        state.f3914e = C0509e.m2555a(a, parser, "autoMirrored", 5, state.f3914e);
        pathRenderer.f3905l = C0509e.m2547a(a, parser, "viewportWidth", 7, pathRenderer.f3905l);
        pathRenderer.f3906m = C0509e.m2547a(a, parser, "viewportHeight", 8, pathRenderer.f3906m);
        if (pathRenderer.f3905l <= 0.0f) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.getPositionDescription());
            sb.append("<vector> tag requires viewportWidth > 0");
            throw new XmlPullParserException(sb.toString());
        } else if (pathRenderer.f3906m > 0.0f) {
            pathRenderer.f3903j = a.getDimension(3, pathRenderer.f3903j);
            pathRenderer.f3904k = a.getDimension(2, pathRenderer.f3904k);
            if (pathRenderer.f3903j <= 0.0f) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(a.getPositionDescription());
                sb2.append("<vector> tag requires width > 0");
                throw new XmlPullParserException(sb2.toString());
            } else if (pathRenderer.f3904k > 0.0f) {
                pathRenderer.setAlpha(C0509e.m2547a(a, parser, "alpha", 4, pathRenderer.getAlpha()));
                String name = a.getString(0);
                if (name != null) {
                    pathRenderer.f3908o = name;
                    pathRenderer.f3909p.put(name, pathRenderer);
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(a.getPositionDescription());
                sb3.append("<vector> tag requires height > 0");
                throw new XmlPullParserException(sb3.toString());
            }
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(a.getPositionDescription());
            sb4.append("<vector> tag requires viewportHeight > 0");
            throw new XmlPullParserException(sb4.toString());
        }
    }

    /* renamed from: a */
    private void m5681a(Resources res, XmlPullParser parser, AttributeSet attrs, Theme theme) throws XmlPullParserException, IOException {
        Resources resources = res;
        XmlPullParser xmlPullParser = parser;
        AttributeSet attributeSet = attrs;
        Theme theme2 = theme;
        C1197f state = this.f3856c;
        C1196e pathRenderer = state.f3911b;
        boolean noPathTag = true;
        ArrayDeque<VGroup> groupStack = new ArrayDeque<>();
        groupStack.push(pathRenderer.f3902i);
        int eventType = parser.getEventType();
        int innerDepth = parser.getDepth() + 1;
        for (int i = 1; eventType != i && (parser.getDepth() >= innerDepth || eventType != 3); i = 1) {
            String str = "group";
            if (eventType == 2) {
                String tagName = parser.getName();
                C1194c currentGroup = (C1194c) groupStack.peek();
                if ("path".equals(tagName)) {
                    C1193b path = new C1193b();
                    path.mo8875a(resources, attributeSet, theme2, xmlPullParser);
                    currentGroup.f3879b.add(path);
                    if (path.getPathName() != null) {
                        pathRenderer.f3909p.put(path.getPathName(), path);
                    }
                    noPathTag = false;
                    state.f3910a |= path.f3893c;
                } else if ("clip-path".equals(tagName)) {
                    C1192a path2 = new C1192a();
                    path2.mo8873a(resources, attributeSet, theme2, xmlPullParser);
                    currentGroup.f3879b.add(path2);
                    if (path2.getPathName() != null) {
                        pathRenderer.f3909p.put(path2.getPathName(), path2);
                    }
                    state.f3910a |= path2.f3893c;
                } else if (str.equals(tagName)) {
                    C1194c newChildGroup = new C1194c();
                    newChildGroup.mo8892a(resources, attributeSet, theme2, xmlPullParser);
                    currentGroup.f3879b.add(newChildGroup);
                    groupStack.push(newChildGroup);
                    if (newChildGroup.getGroupName() != null) {
                        pathRenderer.f3909p.put(newChildGroup.getGroupName(), newChildGroup);
                    }
                    state.f3910a |= newChildGroup.f3888k;
                }
            } else if (eventType == 3 && str.equals(parser.getName())) {
                groupStack.pop();
            }
            eventType = parser.next();
        }
        if (noPathTag) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8850a(boolean allowCaching) {
        this.f3860g = allowCaching;
    }

    /* renamed from: a */
    private boolean m5683a() {
        boolean z = false;
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (isAutoMirrored() && C1200a.m5737e(this) == 1) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            drawable.setBounds(bounds);
        }
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f3856c.getChangingConfigurations();
    }

    public void invalidateSelf() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public void scheduleSelf(Runnable what, long when) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            drawable.scheduleSelf(what, when);
        } else {
            super.scheduleSelf(what, when);
        }
    }

    public boolean setVisible(boolean visible, boolean restart) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return drawable.setVisible(visible, restart);
        }
        return super.setVisible(visible, restart);
    }

    public void unscheduleSelf(Runnable what) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            drawable.unscheduleSelf(what);
        } else {
            super.unscheduleSelf(what);
        }
    }
}
