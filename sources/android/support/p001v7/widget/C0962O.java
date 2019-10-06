package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;

/* renamed from: android.support.v7.widget.O */
/* compiled from: CardViewBaseImpl */
class C0962O implements C0967Q {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final RectF f3062a = new RectF();

    C0962O() {
    }

    /* renamed from: a */
    public void mo7348a() {
        C0963Oa.f3064b = new C0960N(this);
    }

    /* renamed from: a */
    public void mo7417a(C0965P cardView, Context context, ColorStateList backgroundColor, float radius, float elevation, float maxElevation) {
        C0963Oa background = m4629a(context, backgroundColor, radius, elevation, maxElevation);
        background.mo7494a(cardView.mo7342c());
        cardView.mo7339a(background);
        mo7489i(cardView);
    }

    /* renamed from: a */
    private C0963Oa m4629a(Context context, ColorStateList backgroundColor, float radius, float elevation, float maxElevation) {
        C0963Oa oa = new C0963Oa(context.getResources(), backgroundColor, radius, elevation, maxElevation);
        return oa;
    }

    /* renamed from: i */
    public void mo7489i(C0965P cardView) {
        Rect shadowPadding = new Rect();
        m4630j(cardView).mo7493a(shadowPadding);
        cardView.mo7337a((int) Math.ceil((double) mo7421c(cardView)), (int) Math.ceil((double) mo7415a(cardView)));
        cardView.mo7338a(shadowPadding.left, shadowPadding.top, shadowPadding.right, shadowPadding.bottom);
    }

    /* renamed from: h */
    public void mo7427h(C0965P cardView) {
    }

    /* renamed from: b */
    public void mo7419b(C0965P cardView) {
        m4630j(cardView).mo7494a(cardView.mo7342c());
        mo7489i(cardView);
    }

    /* renamed from: a */
    public void mo7418a(C0965P cardView, ColorStateList color) {
        m4630j(cardView).mo7492a(color);
    }

    /* renamed from: f */
    public ColorStateList mo7425f(C0965P cardView) {
        return m4630j(cardView).mo7490a();
    }

    /* renamed from: c */
    public void mo7422c(C0965P cardView, float radius) {
        m4630j(cardView).mo7491a(radius);
        mo7489i(cardView);
    }

    /* renamed from: g */
    public float mo7426g(C0965P cardView) {
        return m4630j(cardView).mo7495b();
    }

    /* renamed from: a */
    public void mo7416a(C0965P cardView, float elevation) {
        m4630j(cardView).mo7498c(elevation);
    }

    /* renamed from: e */
    public float mo7424e(C0965P cardView) {
        return m4630j(cardView).mo7502f();
    }

    /* renamed from: b */
    public void mo7420b(C0965P cardView, float maxElevation) {
        m4630j(cardView).mo7496b(maxElevation);
        mo7489i(cardView);
    }

    /* renamed from: d */
    public float mo7423d(C0965P cardView) {
        return m4630j(cardView).mo7497c();
    }

    /* renamed from: c */
    public float mo7421c(C0965P cardView) {
        return m4630j(cardView).mo7501e();
    }

    /* renamed from: a */
    public float mo7415a(C0965P cardView) {
        return m4630j(cardView).mo7499d();
    }

    /* renamed from: j */
    private C0963Oa m4630j(C0965P cardView) {
        return (C0963Oa) cardView.mo7341b();
    }
}
