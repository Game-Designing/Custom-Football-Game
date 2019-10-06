package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.widget.rb */
/* compiled from: TintResources */
class C1109rb extends C0959Ma {

    /* renamed from: b */
    private final WeakReference<Context> f3688b;

    public C1109rb(Context context, Resources res) {
        super(res);
        this.f3688b = new WeakReference<>(context);
    }

    public Drawable getDrawable(int id) throws NotFoundException {
        Drawable d = super.getDrawable(id);
        Context context = (Context) this.f3688b.get();
        if (!(d == null || context == null)) {
            C1096p.m5420a();
            C1096p.m5426a(context, id, d);
        }
        return d;
    }
}
