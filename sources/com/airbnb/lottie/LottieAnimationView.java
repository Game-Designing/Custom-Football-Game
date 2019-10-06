package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p001v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.Log;
import android.view.View.BaseSavedState;
import com.airbnb.lottie.p089c.C5776e;
import com.airbnb.lottie.p096g.C5833c;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

public class LottieAnimationView extends AppCompatImageView {

    /* renamed from: c */
    private static final String f9637c = LottieAnimationView.class.getSimpleName();

    /* renamed from: d */
    private final C5854z<C5830g> f9638d = new C5780d(this);

    /* renamed from: e */
    private final C5854z<Throwable> f9639e = new C5785e(this);

    /* renamed from: f */
    private final C5851x f9640f = new C5851x();

    /* renamed from: g */
    private String f9641g;

    /* renamed from: h */
    private int f9642h;

    /* renamed from: i */
    private boolean f9643i = false;

    /* renamed from: j */
    private boolean f9644j = false;

    /* renamed from: k */
    private boolean f9645k = false;

    /* renamed from: l */
    private Set<C5662A> f9646l = new HashSet();

    /* renamed from: m */
    private C5667F<C5830g> f9647m;

    /* renamed from: n */
    private C5830g f9648n;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C5823f();

        /* renamed from: a */
        String f9649a;

        /* renamed from: b */
        int f9650b;

        /* renamed from: c */
        float f9651c;

        /* renamed from: d */
        boolean f9652d;

        /* renamed from: e */
        String f9653e;

        /* renamed from: f */
        int f9654f;

        /* renamed from: g */
        int f9655g;

        /* synthetic */ SavedState(Parcel x0, C5780d x1) {
            this(x0);
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.f9649a = in.readString();
            this.f9651c = in.readFloat();
            boolean z = true;
            if (in.readInt() != 1) {
                z = false;
            }
            this.f9652d = z;
            this.f9653e = in.readString();
            this.f9654f = in.readInt();
            this.f9655g = in.readInt();
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeString(this.f9649a);
            out.writeFloat(this.f9651c);
            out.writeInt(this.f9652d ? 1 : 0);
            out.writeString(this.f9653e);
            out.writeInt(this.f9654f);
            out.writeInt(this.f9655g);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        m10014a((AttributeSet) null);
    }

    /* renamed from: a */
    private void m10014a(AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, C5671I.LottieAnimationView);
        if (!isInEditMode()) {
            boolean hasRawRes = ta.hasValue(C5671I.LottieAnimationView_lottie_rawRes);
            boolean hasFileName = ta.hasValue(C5671I.LottieAnimationView_lottie_fileName);
            boolean hasUrl = ta.hasValue(C5671I.LottieAnimationView_lottie_url);
            if (hasRawRes && hasFileName) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            } else if (hasRawRes) {
                int rawResId = ta.getResourceId(C5671I.LottieAnimationView_lottie_rawRes, 0);
                if (rawResId != 0) {
                    setAnimation(rawResId);
                }
            } else if (hasFileName) {
                String fileName = ta.getString(C5671I.LottieAnimationView_lottie_fileName);
                if (fileName != null) {
                    setAnimation(fileName);
                }
            } else if (hasUrl) {
                String url = ta.getString(C5671I.LottieAnimationView_lottie_url);
                if (url != null) {
                    setAnimationFromUrl(url);
                }
            }
        }
        if (ta.getBoolean(C5671I.LottieAnimationView_lottie_autoPlay, false)) {
            this.f9643i = true;
            this.f9644j = true;
        }
        if (ta.getBoolean(C5671I.LottieAnimationView_lottie_loop, false)) {
            this.f9640f.mo18245d(-1);
        }
        if (ta.hasValue(C5671I.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(ta.getInt(C5671I.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (ta.hasValue(C5671I.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(ta.getInt(C5671I.LottieAnimationView_lottie_repeatCount, -1));
        }
        setImageAssetsFolder(ta.getString(C5671I.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(ta.getFloat(C5671I.LottieAnimationView_lottie_progress, 0.0f));
        mo17886a(ta.getBoolean(C5671I.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (ta.hasValue(C5671I.LottieAnimationView_lottie_colorFilter)) {
            C5672J filter = new C5672J(ta.getColor(C5671I.LottieAnimationView_lottie_colorFilter, 0));
            mo17884a(new C5776e("**"), C5663B.f9618x, new C5833c<>(filter));
        }
        if (ta.hasValue(C5671I.LottieAnimationView_lottie_scale)) {
            this.f9640f.mo18244d(ta.getFloat(C5671I.LottieAnimationView_lottie_scale, 1.0f));
        }
        ta.recycle();
        m10017g();
    }

    public void setImageResource(int resId) {
        mo17890d();
        m10015e();
        super.setImageResource(resId);
    }

    public void setImageDrawable(Drawable drawable) {
        m10013a(drawable, true);
    }

    /* renamed from: a */
    private void m10013a(Drawable drawable, boolean recycle) {
        if (recycle && drawable != this.f9640f) {
            mo17890d();
        }
        m10015e();
        super.setImageDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bm) {
        mo17890d();
        m10015e();
        super.setImageBitmap(bm);
    }

    public void invalidateDrawable(Drawable dr) {
        Drawable drawable = getDrawable();
        C5851x xVar = this.f9640f;
        if (drawable == xVar) {
            super.invalidateDrawable(xVar);
        } else {
            super.invalidateDrawable(dr);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        ss.f9649a = this.f9641g;
        ss.f9650b = this.f9642h;
        ss.f9651c = this.f9640f.mo18262k();
        ss.f9652d = this.f9640f.mo18268q();
        ss.f9653e = this.f9640f.mo18251g();
        ss.f9654f = this.f9640f.mo18264m();
        ss.f9655g = this.f9640f.mo18263l();
        return ss;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        this.f9641g = ss.f9649a;
        if (!TextUtils.isEmpty(this.f9641g)) {
            setAnimation(this.f9641g);
        }
        this.f9642h = ss.f9650b;
        int i = this.f9642h;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(ss.f9651c);
        if (ss.f9652d) {
            mo17889c();
        }
        this.f9640f.mo18238b(ss.f9653e);
        setRepeatMode(ss.f9654f);
        setRepeatCount(ss.f9655g);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f9644j && this.f9643i) {
            mo17889c();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (mo17888b()) {
            mo17882a();
            this.f9643i = true;
        }
        mo17890d();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo17890d() {
        this.f9640f.mo18270s();
    }

    /* renamed from: a */
    public void mo17886a(boolean enable) {
        this.f9640f.mo18233a(enable);
    }

    public boolean getUseHardwareAcceleration() {
        return this.f9645k;
    }

    public void setAnimation(int rawRes) {
        this.f9642h = rawRes;
        this.f9641g = null;
        setCompositionTask(C5841n.m10575a(getContext(), rawRes));
    }

    public void setAnimation(String assetName) {
        this.f9641g = assetName;
        this.f9642h = 0;
        setCompositionTask(C5841n.m10576a(getContext(), assetName));
    }

    @Deprecated
    public void setAnimationFromJson(String jsonString) {
        mo17885a(jsonString, (String) null);
    }

    /* renamed from: a */
    public void mo17885a(String jsonString, String cacheKey) {
        mo17883a(new JsonReader(new StringReader(jsonString)), cacheKey);
    }

    /* renamed from: a */
    public void mo17883a(JsonReader reader, String cacheKey) {
        setCompositionTask(C5841n.m10577a(reader, cacheKey));
    }

    public void setAnimationFromUrl(String url) {
        setCompositionTask(C5841n.m10586c(getContext(), url));
    }

    private void setCompositionTask(C5667F<C5830g> compositionTask) {
        m10016f();
        m10015e();
        compositionTask.mo17873b(this.f9638d);
        compositionTask.mo17872a(this.f9639e);
        this.f9647m = compositionTask;
    }

    /* renamed from: e */
    private void m10015e() {
        C5667F<C5830g> f = this.f9647m;
        if (f != null) {
            f.mo17875d(this.f9638d);
            this.f9647m.mo17874c(this.f9639e);
        }
    }

    public void setComposition(C5830g composition) {
        if (C5718c.f9819a) {
            String str = f9637c;
            StringBuilder sb = new StringBuilder();
            sb.append("Set Composition \n");
            sb.append(composition);
            Log.v(str, sb.toString());
        }
        this.f9640f.setCallback(this);
        this.f9648n = composition;
        boolean isNewComposition = this.f9640f.mo18234a(composition);
        m10017g();
        if (getDrawable() != this.f9640f || isNewComposition) {
            setImageDrawable(null);
            setImageDrawable(this.f9640f);
            requestLayout();
            for (C5662A lottieOnCompositionLoadedListener : this.f9646l) {
                lottieOnCompositionLoadedListener.mo17865a(composition);
            }
        }
    }

    public C5830g getComposition() {
        return this.f9648n;
    }

    /* renamed from: c */
    public void mo17889c() {
        this.f9640f.mo18269r();
        m10017g();
    }

    public void setMinFrame(int startFrame) {
        this.f9640f.mo18241c(startFrame);
    }

    public float getMinFrame() {
        return this.f9640f.mo18257i();
    }

    public void setMinProgress(float startProgress) {
        this.f9640f.mo18236b(startProgress);
    }

    public void setMaxFrame(int endFrame) {
        this.f9640f.mo18237b(endFrame);
    }

    public float getMaxFrame() {
        return this.f9640f.mo18256h();
    }

    public void setMaxProgress(float endProgress) {
        this.f9640f.mo18227a(endProgress);
    }

    public void setSpeed(float speed) {
        this.f9640f.mo18248e(speed);
    }

    public float getSpeed() {
        return this.f9640f.mo18266o();
    }

    @Deprecated
    /* renamed from: b */
    public void mo17887b(boolean loop) {
        this.f9640f.mo18245d(loop ? -1 : 0);
    }

    public void setRepeatMode(int mode) {
        this.f9640f.mo18249e(mode);
    }

    public int getRepeatMode() {
        return this.f9640f.mo18264m();
    }

    public void setRepeatCount(int count) {
        this.f9640f.mo18245d(count);
    }

    public int getRepeatCount() {
        return this.f9640f.mo18263l();
    }

    /* renamed from: b */
    public boolean mo17888b() {
        return this.f9640f.mo18268q();
    }

    public void setImageAssetsFolder(String imageAssetsFolder) {
        this.f9640f.mo18238b(imageAssetsFolder);
    }

    public String getImageAssetsFolder() {
        return this.f9640f.mo18251g();
    }

    public void setImageAssetDelegate(C5715b assetDelegate) {
        this.f9640f.mo18231a(assetDelegate);
    }

    public void setFontAssetDelegate(C5674a assetDelegate) {
        this.f9640f.mo18230a(assetDelegate);
    }

    public void setTextDelegate(C5673K textDelegate) {
        this.f9640f.mo18229a(textDelegate);
    }

    /* renamed from: a */
    public <T> void mo17884a(C5776e keyPath, T property, C5833c<T> callback) {
        this.f9640f.mo18232a(keyPath, property, callback);
    }

    public void setScale(float scale) {
        this.f9640f.mo18244d(scale);
        if (getDrawable() == this.f9640f) {
            m10013a((Drawable) null, false);
            m10013a((Drawable) this.f9640f, false);
        }
    }

    public float getScale() {
        return this.f9640f.mo18265n();
    }

    /* renamed from: a */
    public void mo17882a() {
        this.f9640f.mo18226a();
        m10017g();
    }

    public void setFrame(int frame) {
        this.f9640f.mo18228a(frame);
    }

    public int getFrame() {
        return this.f9640f.mo18250f();
    }

    public void setProgress(float progress) {
        this.f9640f.mo18240c(progress);
    }

    public float getProgress() {
        return this.f9640f.mo18262k();
    }

    public long getDuration() {
        C5830g gVar = this.f9648n;
        if (gVar != null) {
            return (long) gVar.mo18193c();
        }
        return 0;
    }

    public void setPerformanceTrackingEnabled(boolean enabled) {
        this.f9640f.mo18239b(enabled);
    }

    public C5669H getPerformanceTracker() {
        return this.f9640f.mo18261j();
    }

    /* renamed from: f */
    private void m10016f() {
        this.f9648n = null;
        this.f9640f.mo18235b();
    }

    /* renamed from: g */
    private void m10017g() {
        int i = 1;
        if (this.f9645k && this.f9640f.mo18268q()) {
            i = 2;
        }
        setLayerType(i, null);
    }
}
