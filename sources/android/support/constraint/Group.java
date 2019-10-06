package android.support.constraint;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.constraint.ConstraintLayout.C0166a;
import android.util.AttributeSet;
import android.view.View;

public class Group extends C0205b {
    public Group(Context context) {
        super(context);
    }

    public Group(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Group(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3808a(AttributeSet attrs) {
        super.mo3808a(attrs);
        this.f611e = false;
    }

    /* renamed from: c */
    public void mo3809c(ConstraintLayout container) {
        int visibility = getVisibility();
        float elevation = 0.0f;
        if (VERSION.SDK_INT >= 21) {
            elevation = getElevation();
        }
        for (int i = 0; i < this.f608b; i++) {
            View view = container.mo3776a(this.f607a[i]);
            if (view != null) {
                view.setVisibility(visibility);
                if (elevation > 0.0f && VERSION.SDK_INT >= 21) {
                    view.setElevation(elevation);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3807a(ConstraintLayout container) {
        C0166a params = (C0166a) getLayoutParams();
        params.f299la.mo3913o(0);
        params.f299la.mo3897g(0);
    }
}
