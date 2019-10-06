package com.airbnb.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.LottieDrawable.LazyCompositionTask;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.p088b.C5716a;
import com.airbnb.lottie.p088b.C5717b;
import com.airbnb.lottie.p089c.C5776e;
import com.airbnb.lottie.p089c.p092c.C5764e;
import com.airbnb.lottie.p094e.C5816t;
import com.airbnb.lottie.p095f.C5826c;
import com.airbnb.lottie.p095f.C5828e;
import com.airbnb.lottie.p096g.C5833c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.airbnb.lottie.x */
/* compiled from: LottieDrawable */
public class C5851x extends Drawable implements Callback, Animatable {

    /* renamed from: a */
    private static final String f10173a = C5851x.class.getSimpleName();

    /* renamed from: b */
    private final Matrix f10174b = new Matrix();

    /* renamed from: c */
    private C5830g f10175c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C5826c f10176d = new C5826c();

    /* renamed from: e */
    private float f10177e = 1.0f;

    /* renamed from: f */
    private final Set<Object> f10178f = new HashSet();

    /* renamed from: g */
    private final ArrayList<C5852a> f10179g = new ArrayList<>();

    /* renamed from: h */
    private C5717b f10180h;

    /* renamed from: i */
    private String f10181i;

    /* renamed from: j */
    private C5715b f10182j;

    /* renamed from: k */
    private C5716a f10183k;

    /* renamed from: l */
    C5674a f10184l;

    /* renamed from: m */
    C5673K f10185m;

    /* renamed from: n */
    private boolean f10186n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C5764e f10187o;

    /* renamed from: p */
    private int f10188p = 255;

    /* renamed from: q */
    private boolean f10189q;

    /* renamed from: com.airbnb.lottie.x$a */
    /* compiled from: LottieDrawable */
    private interface C5852a {
        /* renamed from: a */
        void mo18221a(C5830g gVar);
    }

    public C5851x() {
        this.f10176d.addUpdateListener(new C5845r(this));
    }

    /* renamed from: c */
    public boolean mo18242c() {
        return this.f10186n;
    }

    /* renamed from: a */
    public void mo18233a(boolean enable) {
        if (this.f10186n != enable) {
            if (VERSION.SDK_INT < 19) {
                Log.w(f10173a, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.f10186n = enable;
            if (this.f10175c != null) {
                m10598u();
            }
        }
    }

    /* renamed from: b */
    public void mo18238b(String imageAssetsFolder) {
        this.f10181i = imageAssetsFolder;
    }

    /* renamed from: g */
    public String mo18251g() {
        return this.f10181i;
    }

    /* renamed from: s */
    public void mo18270s() {
        C5717b bVar = this.f10180h;
        if (bVar != null) {
            bVar.mo17975a();
        }
    }

    /* renamed from: a */
    public boolean mo18234a(C5830g composition) {
        if (this.f10175c == composition) {
            return false;
        }
        mo18235b();
        this.f10175c = composition;
        m10598u();
        this.f10176d.mo18163a(composition);
        mo18240c(this.f10176d.getAnimatedFraction());
        mo18244d(this.f10177e);
        m10602y();
        Iterator<LazyCompositionTask> it = new ArrayList(this.f10179g).iterator();
        while (it.hasNext()) {
            ((C5852a) it.next()).mo18221a(composition);
            it.remove();
        }
        this.f10179g.clear();
        composition.mo18190a(this.f10189q);
        return true;
    }

    /* renamed from: b */
    public void mo18239b(boolean enabled) {
        this.f10189q = enabled;
        C5830g gVar = this.f10175c;
        if (gVar != null) {
            gVar.mo18190a(enabled);
        }
    }

    /* renamed from: j */
    public C5669H mo18261j() {
        C5830g gVar = this.f10175c;
        if (gVar != null) {
            return gVar.mo18200j();
        }
        return null;
    }

    /* renamed from: u */
    private void m10598u() {
        this.f10187o = new C5764e(this, C5816t.m10479a(this.f10175c), this.f10175c.mo18199i(), this.f10175c);
    }

    /* renamed from: b */
    public void mo18235b() {
        mo18270s();
        if (this.f10176d.isRunning()) {
            this.f10176d.cancel();
        }
        this.f10175c = null;
        this.f10187o = null;
        this.f10180h = null;
        this.f10176d.mo18168d();
        invalidateSelf();
    }

    public void invalidateSelf() {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void setAlpha(int alpha) {
        this.f10188p = alpha;
    }

    public int getAlpha() {
        return this.f10188p;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Log.w("LOTTIE", "Use addColorFilter instead.");
    }

    public int getOpacity() {
        return -3;
    }

    public void draw(Canvas canvas) {
        String str = "Drawable#draw";
        C5718c.m10176a(str);
        if (this.f10187o != null) {
            float scale = this.f10177e;
            float extraScale = 1.0f;
            float maxScale = m10595a(canvas);
            if (scale > maxScale) {
                scale = maxScale;
                extraScale = this.f10177e / scale;
            }
            if (extraScale > 1.0f) {
                canvas.save();
                float halfWidth = ((float) this.f10175c.mo18186a().width()) / 2.0f;
                float halfHeight = ((float) this.f10175c.mo18186a().height()) / 2.0f;
                float scaledHalfWidth = halfWidth * scale;
                float scaledHalfHeight = halfHeight * scale;
                canvas.translate((mo18265n() * halfWidth) - scaledHalfWidth, (mo18265n() * halfHeight) - scaledHalfHeight);
                canvas.scale(extraScale, extraScale, scaledHalfWidth, scaledHalfHeight);
            }
            this.f10174b.reset();
            this.f10174b.preScale(scale, scale);
            this.f10187o.mo17933a(canvas, this.f10174b, this.f10188p);
            C5718c.m10178c(str);
            if (extraScale > 1.0f) {
                canvas.restore();
            }
        }
    }

    public void start() {
        mo18269r();
    }

    public void stop() {
        mo18243d();
    }

    public boolean isRunning() {
        return mo18268q();
    }

    /* renamed from: r */
    public void mo18269r() {
        if (this.f10187o == null) {
            this.f10179g.add(new C5846s(this));
        } else {
            this.f10176d.mo18180p();
        }
    }

    /* renamed from: d */
    public void mo18243d() {
        this.f10179g.clear();
        this.f10176d.mo18173h();
    }

    /* renamed from: c */
    public void mo18241c(int minFrame) {
        if (this.f10175c == null) {
            this.f10179g.add(new C5847t(this, minFrame));
        } else {
            this.f10176d.mo18165c(minFrame);
        }
    }

    /* renamed from: i */
    public float mo18257i() {
        return this.f10176d.mo18178n();
    }

    /* renamed from: b */
    public void mo18236b(float minProgress) {
        C5830g gVar = this.f10175c;
        if (gVar == null) {
            this.f10179g.add(new C5848u(this, minProgress));
        } else {
            mo18241c((int) C5828e.m10533c(gVar.mo18201k(), this.f10175c.mo18195e(), minProgress));
        }
    }

    /* renamed from: b */
    public void mo18237b(int maxFrame) {
        if (this.f10175c == null) {
            this.f10179g.add(new C5849v(this, maxFrame));
        } else {
            this.f10176d.mo18164b(maxFrame);
        }
    }

    /* renamed from: h */
    public float mo18256h() {
        return this.f10176d.mo18177m();
    }

    /* renamed from: a */
    public void mo18227a(float maxProgress) {
        C5830g gVar = this.f10175c;
        if (gVar == null) {
            this.f10179g.add(new C5850w(this, maxProgress));
        } else {
            mo18237b((int) C5828e.m10533c(gVar.mo18201k(), this.f10175c.mo18195e(), maxProgress));
        }
    }

    /* renamed from: e */
    public void mo18248e(float speed) {
        this.f10176d.mo18160a(speed);
    }

    /* renamed from: o */
    public float mo18266o() {
        return this.f10176d.mo18179o();
    }

    /* renamed from: a */
    public void mo18228a(int frame) {
        if (this.f10175c == null) {
            this.f10179g.add(new C5842o(this, frame));
        } else {
            this.f10176d.mo18161a(frame);
        }
    }

    /* renamed from: f */
    public int mo18250f() {
        return (int) this.f10176d.mo18176l();
    }

    /* renamed from: c */
    public void mo18240c(float progress) {
        C5830g gVar = this.f10175c;
        if (gVar == null) {
            this.f10179g.add(new C5843p(this, progress));
        } else {
            mo18228a((int) C5828e.m10533c(gVar.mo18201k(), this.f10175c.mo18195e(), progress));
        }
    }

    /* renamed from: e */
    public void mo18249e(int mode) {
        this.f10176d.setRepeatMode(mode);
    }

    /* renamed from: m */
    public int mo18264m() {
        return this.f10176d.getRepeatMode();
    }

    /* renamed from: d */
    public void mo18245d(int count) {
        this.f10176d.setRepeatCount(count);
    }

    /* renamed from: l */
    public int mo18263l() {
        return this.f10176d.getRepeatCount();
    }

    /* renamed from: q */
    public boolean mo18268q() {
        return this.f10176d.isRunning();
    }

    /* renamed from: d */
    public void mo18244d(float scale) {
        this.f10177e = scale;
        m10602y();
    }

    /* renamed from: a */
    public void mo18231a(C5715b assetDelegate) {
        this.f10182j = assetDelegate;
        C5717b bVar = this.f10180h;
        if (bVar != null) {
            bVar.mo17976a(assetDelegate);
        }
    }

    /* renamed from: a */
    public void mo18230a(C5674a assetDelegate) {
        this.f10184l = assetDelegate;
        C5716a aVar = this.f10183k;
        if (aVar != null) {
            aVar.mo17973a(assetDelegate);
        }
    }

    /* renamed from: a */
    public void mo18229a(C5673K textDelegate) {
        this.f10185m = textDelegate;
    }

    /* renamed from: p */
    public C5673K mo18267p() {
        return this.f10185m;
    }

    /* renamed from: t */
    public boolean mo18276t() {
        return this.f10185m == null && this.f10175c.mo18191b().mo9174b() > 0;
    }

    /* renamed from: n */
    public float mo18265n() {
        return this.f10177e;
    }

    /* renamed from: e */
    public C5830g mo18247e() {
        return this.f10175c;
    }

    /* renamed from: y */
    private void m10602y() {
        if (this.f10175c != null) {
            float scale = mo18265n();
            setBounds(0, 0, (int) (((float) this.f10175c.mo18186a().width()) * scale), (int) (((float) this.f10175c.mo18186a().height()) * scale));
        }
    }

    /* renamed from: a */
    public void mo18226a() {
        this.f10179g.clear();
        this.f10176d.cancel();
    }

    /* renamed from: k */
    public float mo18262k() {
        return this.f10176d.mo18175k();
    }

    public int getIntrinsicWidth() {
        C5830g gVar = this.f10175c;
        if (gVar == null) {
            return -1;
        }
        return (int) (((float) gVar.mo18186a().width()) * mo18265n());
    }

    public int getIntrinsicHeight() {
        C5830g gVar = this.f10175c;
        if (gVar == null) {
            return -1;
        }
        return (int) (((float) gVar.mo18186a().height()) * mo18265n());
    }

    /* renamed from: a */
    public List<C5776e> mo18225a(C5776e keyPath) {
        if (this.f10187o == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        List<KeyPath> keyPaths = new ArrayList<>();
        this.f10187o.mo17935a(keyPath, 0, keyPaths, new C5776e(new String[0]));
        return keyPaths;
    }

    /* renamed from: a */
    public <T> void mo18232a(C5776e keyPath, T property, C5833c<T> callback) {
        boolean invalidate;
        if (this.f10187o == null) {
            this.f10179g.add(new C5844q(this, keyPath, property, callback));
            return;
        }
        if (keyPath.mo18120a() != null) {
            keyPath.mo18120a().mo17936a(property, callback);
            invalidate = true;
        } else {
            List<KeyPath> elements = mo18225a(keyPath);
            for (int i = 0; i < elements.size(); i++) {
                ((C5776e) elements.get(i)).mo18120a().mo17936a(property, callback);
            }
            invalidate = elements.isEmpty() ^ 1;
        }
        if (invalidate) {
            invalidateSelf();
            if (property == C5663B.f9617w) {
                mo18240c(mo18262k());
            }
        }
    }

    /* renamed from: a */
    public Bitmap mo18223a(String id) {
        C5717b bm = m10601x();
        if (bm != null) {
            return bm.mo17974a(id);
        }
        return null;
    }

    /* renamed from: x */
    private C5717b m10601x() {
        if (getCallback() == null) {
            return null;
        }
        C5717b bVar = this.f10180h;
        if (bVar != null && !bVar.mo17977a(m10599v())) {
            this.f10180h.mo17975a();
            this.f10180h = null;
        }
        if (this.f10180h == null) {
            this.f10180h = new C5717b(getCallback(), this.f10181i, this.f10182j, this.f10175c.mo18198h());
        }
        return this.f10180h;
    }

    /* renamed from: a */
    public Typeface mo18224a(String fontFamily, String style) {
        C5716a assetManager = m10600w();
        if (assetManager != null) {
            return assetManager.mo17972a(fontFamily, style);
        }
        return null;
    }

    /* renamed from: w */
    private C5716a m10600w() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f10183k == null) {
            this.f10183k = new C5716a(getCallback(), this.f10184l);
        }
        return this.f10183k;
    }

    /* renamed from: v */
    private Context m10599v() {
        Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public void invalidateDrawable(Drawable who) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, what, when);
        }
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, what);
        }
    }

    /* renamed from: a */
    private float m10595a(Canvas canvas) {
        return Math.min(((float) canvas.getWidth()) / ((float) this.f10175c.mo18186a().width()), ((float) canvas.getHeight()) / ((float) this.f10175c.mo18186a().height()));
    }
}
