package p019d.p143b.p144a.p146b;

import android.content.Context;
import android.widget.VideoView;

/* renamed from: d.b.a.b.b */
public class C6990b extends VideoView implements C7023ra {

    /* renamed from: a */
    private int f12984a = 0;

    /* renamed from: b */
    private int f12985b = 0;

    /* renamed from: c */
    private float f12986c = 0.0f;

    public C6990b(Context context) {
        super(context, null, 0);
    }

    /* renamed from: a */
    public void mo22599a(int i, int i2) {
        this.f12984a = i;
        this.f12985b = i2;
        this.f12986c = ((float) this.f12984a) / ((float) this.f12985b);
        try {
            getHolder().setFixedSize(i, i2);
            requestLayout();
            invalidate();
        } catch (Exception e) {
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = this.f12984a;
        if (i3 <= 0 || this.f12985b <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        int defaultSize = VideoView.getDefaultSize(i3, i);
        int defaultSize2 = VideoView.getDefaultSize(this.f12985b, i2);
        int i4 = (int) (((float) defaultSize) / this.f12986c);
        if (defaultSize2 > i4) {
            defaultSize2 = i4;
        }
        int i5 = (int) (((float) defaultSize2) * this.f12986c);
        if (defaultSize > i5) {
            defaultSize = i5;
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }
}
