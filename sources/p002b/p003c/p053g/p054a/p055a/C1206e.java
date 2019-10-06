package p002b.p003c.p053g.p054a.p055a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* renamed from: b.c.g.a.a.e */
/* compiled from: WrappedDrawableApi19 */
class C1206e extends C1203d {

    /* renamed from: b.c.g.a.a.e$a */
    /* compiled from: WrappedDrawableApi19 */
    private static class C1207a extends C1204a {
        C1207a(C1204a orig, Resources res) {
            super(orig, res);
        }

        public Drawable newDrawable(Resources res) {
            return new C1206e(this, res);
        }
    }

    C1206e(Drawable drawable) {
        super(drawable);
    }

    C1206e(C1204a state, Resources resources) {
        super(state, resources);
    }

    public void setAutoMirrored(boolean mirrored) {
        this.f3934g.setAutoMirrored(mirrored);
    }

    public boolean isAutoMirrored() {
        return this.f3934g.isAutoMirrored();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C1204a mo8937c() {
        return new C1207a(this.f3932e, null);
    }
}
