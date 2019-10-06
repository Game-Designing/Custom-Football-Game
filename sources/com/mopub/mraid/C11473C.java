package com.mopub.mraid;

import android.content.Context;
import android.graphics.Rect;
import com.mopub.common.util.Dips;

/* renamed from: com.mopub.mraid.C */
/* compiled from: MraidScreenMetrics */
class C11473C {

    /* renamed from: a */
    private final Context f35464a;

    /* renamed from: b */
    private final Rect f35465b = new Rect();

    /* renamed from: c */
    private final Rect f35466c = new Rect();

    /* renamed from: d */
    private final Rect f35467d = new Rect();

    /* renamed from: e */
    private final Rect f35468e = new Rect();

    /* renamed from: f */
    private final Rect f35469f = new Rect();

    /* renamed from: g */
    private final Rect f35470g = new Rect();

    /* renamed from: h */
    private final Rect f35471h = new Rect();

    /* renamed from: i */
    private final Rect f35472i = new Rect();

    /* renamed from: j */
    private final float f35473j;

    C11473C(Context context, float density) {
        this.f35464a = context.getApplicationContext();
        this.f35473j = density;
    }

    /* renamed from: a */
    private void m37933a(Rect sourceRect, Rect outRect) {
        outRect.set(Dips.pixelsToIntDips((float) sourceRect.left, this.f35464a), Dips.pixelsToIntDips((float) sourceRect.top, this.f35464a), Dips.pixelsToIntDips((float) sourceRect.right, this.f35464a), Dips.pixelsToIntDips((float) sourceRect.bottom, this.f35464a));
    }

    public float getDensity() {
        return this.f35473j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37586a(int width, int height) {
        this.f35465b.set(0, 0, width, height);
        m37933a(this.f35465b, this.f35466c);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public Rect mo37594f() {
        return this.f35466c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo37591c(int x, int y, int width, int height) {
        this.f35467d.set(x, y, x + width, y + height);
        m37933a(this.f35467d, this.f35468e);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public Rect mo37592d() {
        return this.f35467d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public Rect mo37593e() {
        return this.f35468e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37587a(int x, int y, int width, int height) {
        this.f35469f.set(x, y, x + width, y + height);
        m37933a(this.f35469f, this.f35470g);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Rect mo37585a() {
        return this.f35470g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37589b(int x, int y, int width, int height) {
        this.f35471h.set(x, y, x + width, y + height);
        m37933a(this.f35471h, this.f35472i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Rect mo37588b() {
        return this.f35471h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Rect mo37590c() {
        return this.f35472i;
    }
}
