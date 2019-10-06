package android.support.p001v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.p001v7.appcompat.C0793R;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* renamed from: android.support.v7.widget.x */
/* compiled from: AppCompatSeekBar */
public class C1130x extends SeekBar {

    /* renamed from: a */
    private final C1134y f3752a;

    public C1130x(Context context, AttributeSet attrs) {
        this(context, attrs, C0793R.attr.seekBarStyle);
    }

    public C1130x(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f3752a = new C1134y(this);
        this.f3752a.mo8716a(attrs, defStyleAttr);
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f3752a.mo8730a(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f3752a.mo8732b();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f3752a.mo8733c();
    }
}
