package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p001v7.app.C0776p;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.widget.Fb */
/* compiled from: VectorEnabledTintResources */
public class C0930Fb extends Resources {

    /* renamed from: a */
    private final WeakReference<Context> f2980a;

    /* renamed from: a */
    public static boolean m4471a() {
        return C0776p.m3638h() && VERSION.SDK_INT <= 20;
    }

    public C0930Fb(Context context, Resources res) {
        super(res.getAssets(), res.getDisplayMetrics(), res.getConfiguration());
        this.f2980a = new WeakReference<>(context);
    }

    public Drawable getDrawable(int id) throws NotFoundException {
        Context context = (Context) this.f2980a.get();
        if (context != null) {
            return C1096p.m5420a().mo8567a(context, this, id);
        }
        return super.getDrawable(id);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Drawable mo7217a(int id) {
        return super.getDrawable(id);
    }
}
