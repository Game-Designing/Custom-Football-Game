package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.p000v4.view.C0645v;
import android.support.p000v4.widget.C0674E;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: android.support.v7.widget.AppCompatImageView */
public class AppCompatImageView extends ImageView implements C0645v, C0674E {

    /* renamed from: a */
    private final C1079l f2914a;

    /* renamed from: b */
    private final C1113t f2915b;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    public AppCompatImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(C1103pb.m5450a(context), attrs, defStyleAttr);
        this.f2914a = new C1079l(this);
        this.f2914a.mo8511a(attrs, defStyleAttr);
        this.f2915b = new C1113t(this);
        this.f2915b.mo8665a(attrs, defStyleAttr);
    }

    public void setImageResource(int resId) {
        C1113t tVar = this.f2915b;
        if (tVar != null) {
            tVar.mo8662a(resId);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        C1113t tVar = this.f2915b;
        if (tVar != null) {
            tVar.mo8661a();
        }
    }

    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        C1113t tVar = this.f2915b;
        if (tVar != null) {
            tVar.mo8661a();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C1113t tVar = this.f2915b;
        if (tVar != null) {
            tVar.mo8661a();
        }
    }

    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        C1079l lVar = this.f2914a;
        if (lVar != null) {
            lVar.mo8507a(resId);
        }
    }

    public void setBackgroundDrawable(Drawable background) {
        super.setBackgroundDrawable(background);
        C1079l lVar = this.f2914a;
        if (lVar != null) {
            lVar.mo8510a(background);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList tint) {
        C1079l lVar = this.f2914a;
        if (lVar != null) {
            lVar.mo8513b(tint);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1079l lVar = this.f2914a;
        if (lVar != null) {
            return lVar.mo8512b();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(Mode tintMode) {
        C1079l lVar = this.f2914a;
        if (lVar != null) {
            lVar.mo8509a(tintMode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        C1079l lVar = this.f2914a;
        if (lVar != null) {
            return lVar.mo8514c();
        }
        return null;
    }

    public void setSupportImageTintList(ColorStateList tint) {
        C1113t tVar = this.f2915b;
        if (tVar != null) {
            tVar.mo8663a(tint);
        }
    }

    public ColorStateList getSupportImageTintList() {
        C1113t tVar = this.f2915b;
        if (tVar != null) {
            return tVar.mo8666b();
        }
        return null;
    }

    public void setSupportImageTintMode(Mode tintMode) {
        C1113t tVar = this.f2915b;
        if (tVar != null) {
            tVar.mo8664a(tintMode);
        }
    }

    public Mode getSupportImageTintMode() {
        C1113t tVar = this.f2915b;
        if (tVar != null) {
            return tVar.mo8667c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1079l lVar = this.f2914a;
        if (lVar != null) {
            lVar.mo8506a();
        }
        C1113t tVar = this.f2915b;
        if (tVar != null) {
            tVar.mo8661a();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.f2915b.mo8668d() && super.hasOverlappingRendering();
    }
}
