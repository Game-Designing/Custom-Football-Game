package com.inmobi.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class NativeContainerLayout extends ViewGroup {

    /* renamed from: a */
    private static final String f31349a = NativeContainerLayout.class.getSimpleName();

    /* renamed from: com.inmobi.ads.NativeContainerLayout$a */
    public static class C10324a extends LayoutParams {

        /* renamed from: a */
        public int f31350a;

        /* renamed from: b */
        public int f31351b;

        public C10324a(int i, int i2) {
            super(i, i2);
        }

        public C10324a(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public NativeContainerLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        measureChildren(i, i2);
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C10324a aVar = (C10324a) childAt.getLayoutParams();
                int measuredWidth = aVar.f31350a + childAt.getMeasuredWidth();
                int measuredHeight = aVar.f31351b + childAt.getMeasuredHeight();
                i4 = Math.max(i4, measuredWidth);
                i3 = Math.max(i3, measuredHeight);
            }
        }
        setMeasuredDimension(ViewGroup.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), ViewGroup.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new C10324a(-2, -2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C10324a aVar = (C10324a) childAt.getLayoutParams();
                int i6 = aVar.f31350a;
                childAt.layout(i6, aVar.f31351b, childAt.getMeasuredWidth() + i6, aVar.f31351b + childAt.getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C10324a;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C10324a(layoutParams);
    }
}
