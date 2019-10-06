package android.support.p000v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* renamed from: android.support.v4.widget.ContentLoadingProgressBar */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a */
    long f1879a;

    /* renamed from: b */
    boolean f1880b;

    /* renamed from: c */
    boolean f1881c;

    /* renamed from: d */
    boolean f1882d;

    /* renamed from: e */
    private final Runnable f1883e;

    /* renamed from: f */
    private final Runnable f1884f;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        this.f1879a = -1;
        this.f1880b = false;
        this.f1881c = false;
        this.f1882d = false;
        this.f1883e = new C0698h(this);
        this.f1884f = new C0699i(this);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m3114a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3114a();
    }

    /* renamed from: a */
    private void m3114a() {
        removeCallbacks(this.f1883e);
        removeCallbacks(this.f1884f);
    }
}
