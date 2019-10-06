package p002b.p003c.p051e.p052a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* renamed from: b.c.e.a.c */
/* compiled from: AnimatedVectorDrawableCompat */
class C1180c implements Callback {

    /* renamed from: a */
    final /* synthetic */ C1181d f3837a;

    C1180c(C1181d this$0) {
        this.f3837a = this$0;
    }

    public void invalidateDrawable(Drawable who) {
        this.f3837a.invalidateSelf();
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        this.f3837a.scheduleSelf(what, when);
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        this.f3837a.unscheduleSelf(what);
    }
}
