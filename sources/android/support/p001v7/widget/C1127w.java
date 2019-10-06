package android.support.p001v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import p002b.p003c.p053g.p054a.p055a.C1202c;

/* renamed from: android.support.v7.widget.w */
/* compiled from: AppCompatProgressBarHelper */
class C1127w {

    /* renamed from: a */
    private static final int[] f3749a = {16843067, 16843068};

    /* renamed from: b */
    private final ProgressBar f3750b;

    /* renamed from: c */
    private Bitmap f3751c;

    C1127w(ProgressBar view) {
        this.f3750b = view;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8716a(AttributeSet attrs, int defStyleAttr) {
        C1112sb a = C1112sb.m5456a(this.f3750b.getContext(), attrs, f3749a, defStyleAttr, 0);
        Drawable drawable = a.mo8652c(0);
        if (drawable != null) {
            this.f3750b.setIndeterminateDrawable(mo8731a(drawable));
        }
        Drawable drawable2 = a.mo8652c(1);
        if (drawable2 != null) {
            this.f3750b.setProgressDrawable(m5520a(drawable2, false));
        }
        a.mo8647a();
    }

    /* renamed from: a */
    private Drawable m5520a(Drawable drawable, boolean clip) {
        if (drawable instanceof C1202c) {
            Drawable inner = ((C1202c) drawable).mo8934a();
            if (inner != null) {
                ((C1202c) drawable).mo8935a(m5520a(inner, clip));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable background = (LayerDrawable) drawable;
            int N = background.getNumberOfLayers();
            Drawable[] outDrawables = new Drawable[N];
            for (int i = 0; i < N; i++) {
                int id = background.getId(i);
                outDrawables[i] = m5520a(background.getDrawable(i), id == 16908301 || id == 16908303);
            }
            LayerDrawable newBg = new LayerDrawable(outDrawables);
            for (int i2 = 0; i2 < N; i2++) {
                newBg.setId(i2, background.getId(i2));
            }
            return newBg;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap tileBitmap = bitmapDrawable.getBitmap();
            if (this.f3751c == null) {
                this.f3751c = tileBitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(mo8732b());
            shapeDrawable.getPaint().setShader(new BitmapShader(tileBitmap, TileMode.REPEAT, TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return clip ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }

    /* renamed from: a */
    private Drawable mo8731a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable background = (AnimationDrawable) drawable;
        int N = background.getNumberOfFrames();
        AnimationDrawable newBg = new AnimationDrawable();
        newBg.setOneShot(background.isOneShot());
        for (int i = 0; i < N; i++) {
            Drawable frame = m5520a(background.getFrame(i), true);
            frame.setLevel(10000);
            newBg.addFrame(frame, background.getDuration(i));
        }
        newBg.setLevel(10000);
        return newBg;
    }

    /* renamed from: b */
    private Shape mo8732b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Bitmap mo8715a() {
        return this.f3751c;
    }
}
