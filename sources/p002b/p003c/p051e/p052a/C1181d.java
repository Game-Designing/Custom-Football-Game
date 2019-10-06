package p002b.p003c.p051e.p052a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.p000v4.content.p036a.C0509e;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p002b.p003c.p053g.p054a.p055a.C1200a;
import p002b.p003c.p053g.p061f.C1253b;

/* renamed from: b.c.e.a.d */
/* compiled from: AnimatedVectorDrawableCompat */
public class C1181d extends C1190j implements C1179b {

    /* renamed from: b */
    private C1182a f3838b;

    /* renamed from: c */
    private Context f3839c;

    /* renamed from: d */
    private ArgbEvaluator f3840d;

    /* renamed from: e */
    private AnimatorListener f3841e;

    /* renamed from: f */
    private ArrayList<Object> f3842f;

    /* renamed from: g */
    final Callback f3843g;

    /* renamed from: b.c.e.a.d$a */
    /* compiled from: AnimatedVectorDrawableCompat */
    private static class C1182a extends ConstantState {

        /* renamed from: a */
        int f3844a;

        /* renamed from: b */
        C1191k f3845b;

        /* renamed from: c */
        AnimatorSet f3846c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public ArrayList<Animator> f3847d;

        /* renamed from: e */
        C1253b<Animator, String> f3848e;

        public C1182a(Context context, C1182a copy, Callback owner, Resources res) {
            if (copy != null) {
                this.f3844a = copy.f3844a;
                C1191k kVar = copy.f3845b;
                if (kVar != null) {
                    ConstantState cs = kVar.getConstantState();
                    if (res != null) {
                        this.f3845b = (C1191k) cs.newDrawable(res);
                    } else {
                        this.f3845b = (C1191k) cs.newDrawable();
                    }
                    C1191k kVar2 = this.f3845b;
                    kVar2.mutate();
                    this.f3845b = kVar2;
                    this.f3845b.setCallback(owner);
                    this.f3845b.setBounds(copy.f3845b.getBounds());
                    this.f3845b.mo8850a(false);
                }
                ArrayList<Animator> arrayList = copy.f3847d;
                if (arrayList != null) {
                    int numAnimators = arrayList.size();
                    this.f3847d = new ArrayList<>(numAnimators);
                    this.f3848e = new C1253b<>(numAnimators);
                    for (int i = 0; i < numAnimators; i++) {
                        Animator anim = (Animator) copy.f3847d.get(i);
                        Animator animClone = anim.clone();
                        String targetName = (String) copy.f3848e.get(anim);
                        animClone.setTarget(this.f3845b.mo8849a(targetName));
                        this.f3847d.add(animClone);
                        this.f3848e.put(animClone, targetName);
                    }
                    mo8835a();
                }
            }
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources res) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public int getChangingConfigurations() {
            return this.f3844a;
        }

        /* renamed from: a */
        public void mo8835a() {
            if (this.f3846c == null) {
                this.f3846c = new AnimatorSet();
            }
            this.f3846c.playTogether(this.f3847d);
        }
    }

    /* renamed from: b.c.e.a.d$b */
    /* compiled from: AnimatedVectorDrawableCompat */
    private static class C1183b extends ConstantState {

        /* renamed from: a */
        private final ConstantState f3849a;

        public C1183b(ConstantState state) {
            this.f3849a = state;
        }

        public Drawable newDrawable() {
            C1181d drawableCompat = new C1181d();
            drawableCompat.f3854a = this.f3849a.newDrawable();
            drawableCompat.f3854a.setCallback(drawableCompat.f3843g);
            return drawableCompat;
        }

        public Drawable newDrawable(Resources res) {
            C1181d drawableCompat = new C1181d();
            drawableCompat.f3854a = this.f3849a.newDrawable(res);
            drawableCompat.f3854a.setCallback(drawableCompat.f3843g);
            return drawableCompat;
        }

        public Drawable newDrawable(Resources res, Theme theme) {
            C1181d drawableCompat = new C1181d();
            drawableCompat.f3854a = this.f3849a.newDrawable(res, theme);
            drawableCompat.f3854a.setCallback(drawableCompat.f3843g);
            return drawableCompat;
        }

        public boolean canApplyTheme() {
            return this.f3849a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f3849a.getChangingConfigurations();
        }
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

    public /* bridge */ /* synthetic */ boolean getPadding(Rect x0) {
        return super.getPadding(x0);
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

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int x0) {
        super.setChangingConfigurations(x0);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int x0, Mode x1) {
        super.setColorFilter(x0, x1);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean x0) {
        super.setFilterBitmap(x0);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float x0, float x1) {
        super.setHotspot(x0, x1);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int x0, int x1, int x2, int x3) {
        super.setHotspotBounds(x0, x1, x2, x3);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] x0) {
        return super.setState(x0);
    }

    C1181d() {
        this(null, null, null);
    }

    private C1181d(Context context) {
        this(context, null, null);
    }

    private C1181d(Context context, C1182a state, Resources res) {
        this.f3840d = null;
        this.f3841e = null;
        this.f3842f = null;
        this.f3843g = new C1180c(this);
        this.f3839c = context;
        if (state != null) {
            this.f3838b = state;
        } else {
            this.f3838b = new C1182a(context, state, this.f3843g, res);
        }
    }

    public Drawable mutate() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* renamed from: a */
    public static C1181d m5645a(Context context, Resources r, XmlPullParser parser, AttributeSet attrs, Theme theme) throws XmlPullParserException, IOException {
        C1181d drawable = new C1181d(context);
        drawable.inflate(r, parser, attrs, theme);
        return drawable;
    }

    public ConstantState getConstantState() {
        Drawable drawable = this.f3854a;
        if (drawable == null || VERSION.SDK_INT < 24) {
            return null;
        }
        return new C1183b(drawable.getConstantState());
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f3838b.f3844a;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f3838b.f3845b.draw(canvas);
        if (this.f3838b.f3846c.isStarted()) {
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            drawable.setBounds(bounds);
        } else {
            this.f3838b.f3845b.setBounds(bounds);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] state) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return drawable.setState(state);
        }
        return this.f3838b.f3845b.setState(state);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int level) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return drawable.setLevel(level);
        }
        return this.f3838b.f3845b.setLevel(level);
    }

    public int getAlpha() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return C1200a.m5735c(drawable);
        }
        return this.f3838b.f3845b.getAlpha();
    }

    public void setAlpha(int alpha) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            drawable.setAlpha(alpha);
        } else {
            this.f3838b.f3845b.setAlpha(alpha);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f3838b.f3845b.setColorFilter(colorFilter);
        }
    }

    public void setTint(int tint) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            C1200a.m5734b(drawable, tint);
        } else {
            this.f3838b.f3845b.setTint(tint);
        }
    }

    public void setTintList(ColorStateList tint) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            C1200a.m5726a(drawable, tint);
        } else {
            this.f3838b.f3845b.setTintList(tint);
        }
    }

    public void setTintMode(Mode tintMode) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            C1200a.m5729a(drawable, tintMode);
        } else {
            this.f3838b.f3845b.setTintMode(tintMode);
        }
    }

    public boolean setVisible(boolean visible, boolean restart) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return drawable.setVisible(visible, restart);
        }
        this.f3838b.f3845b.setVisible(visible, restart);
        return super.setVisible(visible, restart);
    }

    public boolean isStateful() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f3838b.f3845b.isStateful();
    }

    public int getOpacity() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f3838b.f3845b.getOpacity();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f3838b.f3845b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f3838b.f3845b.getIntrinsicHeight();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return C1200a.m5738f(drawable);
        }
        return this.f3838b.f3845b.isAutoMirrored();
    }

    public void setAutoMirrored(boolean mirrored) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            C1200a.m5730a(drawable, mirrored);
        } else {
            this.f3838b.f3845b.setAutoMirrored(mirrored);
        }
    }

    public void inflate(Resources res, XmlPullParser parser, AttributeSet attrs, Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            C1200a.m5728a(drawable, res, parser, attrs, theme);
            return;
        }
        int eventType = parser.getEventType();
        int innerDepth = parser.getDepth() + 1;
        while (eventType != 1 && (parser.getDepth() >= innerDepth || eventType != 3)) {
            if (eventType == 2) {
                String tagName = parser.getName();
                if ("animated-vector".equals(tagName)) {
                    TypedArray a = C0509e.m2551a(res, theme, attrs, C1178a.f3829e);
                    int drawableRes = a.getResourceId(0, 0);
                    if (drawableRes != 0) {
                        C1191k vectorDrawable = C1191k.m5680a(res, drawableRes, theme);
                        vectorDrawable.mo8850a(false);
                        vectorDrawable.setCallback(this.f3843g);
                        C1191k kVar = this.f3838b.f3845b;
                        if (kVar != null) {
                            kVar.setCallback(null);
                        }
                        this.f3838b.f3845b = vectorDrawable;
                    }
                    a.recycle();
                } else if ("target".equals(tagName)) {
                    TypedArray a2 = res.obtainAttributes(attrs, C1178a.f3830f);
                    String target = a2.getString(0);
                    int id = a2.getResourceId(1, 0);
                    if (id != 0) {
                        Context context = this.f3839c;
                        if (context != null) {
                            m5647a(target, C1186g.m5655a(context, id));
                        } else {
                            a2.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    a2.recycle();
                } else {
                    continue;
                }
            }
            eventType = parser.next();
        }
        this.f3838b.mo8835a();
    }

    public void inflate(Resources res, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        inflate(res, parser, attrs, null);
    }

    public void applyTheme(Theme t) {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            C1200a.m5727a(drawable, t);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return C1200a.m5731a(drawable);
        }
        return false;
    }

    /* renamed from: a */
    private void m5646a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List<Animator> childAnimators = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimators != null) {
                for (int i = 0; i < childAnimators.size(); i++) {
                    m5646a((Animator) childAnimators.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnim = (ObjectAnimator) animator;
            String propertyName = objectAnim.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f3840d == null) {
                    this.f3840d = new ArgbEvaluator();
                }
                objectAnim.setEvaluator(this.f3840d);
            }
        }
    }

    /* renamed from: a */
    private void m5647a(String name, Animator animator) {
        animator.setTarget(this.f3838b.f3845b.mo8849a(name));
        if (VERSION.SDK_INT < 21) {
            m5646a(animator);
        }
        if (this.f3838b.f3847d == null) {
            this.f3838b.f3847d = new ArrayList();
            this.f3838b.f3848e = new C1253b<>();
        }
        this.f3838b.f3847d.add(animator);
        this.f3838b.f3848e.put(animator, name);
    }

    public boolean isRunning() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f3838b.f3846c.isRunning();
    }

    public void start() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.f3838b.f3846c.isStarted()) {
            this.f3838b.f3846c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f3854a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f3838b.f3846c.end();
        }
    }
}
