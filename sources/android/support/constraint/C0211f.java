package android.support.constraint;

import android.content.Context;
import android.graphics.Canvas;
import android.support.constraint.ConstraintLayout.C0166a;
import android.view.View;

/* renamed from: android.support.constraint.f */
/* compiled from: Guideline */
public class C0211f extends View {
    public C0211f(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public void setVisibility(int visibility) {
    }

    public void draw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int margin) {
        C0166a params = (C0166a) getLayoutParams();
        params.f276a = margin;
        setLayoutParams(params);
    }

    public void setGuidelineEnd(int margin) {
        C0166a params = (C0166a) getLayoutParams();
        params.f278b = margin;
        setLayoutParams(params);
    }

    public void setGuidelinePercent(float ratio) {
        C0166a params = (C0166a) getLayoutParams();
        params.f280c = ratio;
        setLayoutParams(params);
    }
}
