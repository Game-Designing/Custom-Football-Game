package android.support.p001v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p001v7.preference.C0805H;
import android.support.p001v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

/* renamed from: android.support.v7.internal.widget.PreferenceImageView */
public class PreferenceImageView extends ImageView {

    /* renamed from: a */
    private int f2383a;

    /* renamed from: b */
    private int f2384b;

    public PreferenceImageView(Context context) {
        this(context, null);
    }

    public PreferenceImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PreferenceImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f2383a = MoPubClientPositioning.NO_REPEAT;
        this.f2384b = MoPubClientPositioning.NO_REPEAT;
        TypedArray a = context.obtainStyledAttributes(attrs, C0805H.PreferenceImageView, defStyleAttr, 0);
        setMaxWidth(a.getDimensionPixelSize(C0805H.PreferenceImageView_maxWidth, MoPubClientPositioning.NO_REPEAT));
        setMaxHeight(a.getDimensionPixelSize(C0805H.PreferenceImageView_maxHeight, MoPubClientPositioning.NO_REPEAT));
        a.recycle();
    }

    public void setMaxWidth(int maxWidth) {
        this.f2383a = maxWidth;
        super.setMaxWidth(maxWidth);
    }

    public int getMaxWidth() {
        return this.f2383a;
    }

    public void setMaxHeight(int maxHeight) {
        this.f2384b = maxHeight;
        super.setMaxHeight(maxHeight);
    }

    public int getMaxHeight() {
        return this.f2384b;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        if (widthMode == Integer.MIN_VALUE || widthMode == 0) {
            int widthSize = MeasureSpec.getSize(widthMeasureSpec);
            int maxWidth = getMaxWidth();
            if (maxWidth != Integer.MAX_VALUE && (maxWidth < widthSize || widthMode == 0)) {
                widthMeasureSpec = MeasureSpec.makeMeasureSpec(maxWidth, LinearLayoutManager.INVALID_OFFSET);
            }
        }
        int widthSize2 = MeasureSpec.getMode(heightMeasureSpec);
        if (widthSize2 == Integer.MIN_VALUE || widthSize2 == 0) {
            int heightSize = MeasureSpec.getSize(heightMeasureSpec);
            int maxHeight = getMaxHeight();
            if (maxHeight != Integer.MAX_VALUE && (maxHeight < heightSize || widthSize2 == 0)) {
                heightMeasureSpec = MeasureSpec.makeMeasureSpec(maxHeight, LinearLayoutManager.INVALID_OFFSET);
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
